package view.components.dialogues;

import controller.MainController;
import view.dtoHandler.contactDto.ContactDTO;
import view.dtoHandler.contactDtoData.BusinessInfoDTO;
import view.dtoHandler.contactDtoData.PrivateInfoDTO;
import view.dtoHandler.contactDtoData.SocialMediaDTO;
import model.observer.contactCreated.IContactCreatedObserver;

import model.observer.contactUpdated.IContactUpdatedObserver;
import view.MainView;
import view.components.tabs.*;
import view.constants.ViewConstants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Contact dialog.
 */
public class ContactDialog extends JTabbedPane implements IContactCreatedObserver, IContactUpdatedObserver {
    private UUID contactId;
    /**
     * The Main view.
     */
    MainView mainView;
    private List<JPanel> tabs = new ArrayList<>();

    /**
     * Instantiates a new Contact dialog.
     *
     * @param mainView the main view
     */
    public ContactDialog(MainView mainView) {
        MainController.getInstance().getContactCreatedNotifier().addObserver(this);
        MainController.getInstance().getContactUpdatedNotifier().addObserver(this);
        this.mainView = mainView;

        this.setForeground(Color.WHITE);
        this.revalidate();
        this.repaint();
    }

    /**
     * Instantiates a new Contact dialog.
     *
     * @param id       the id
     * @param width    the width
     * @param height   the height
     * @param mainView the main view
     */
    public ContactDialog(UUID id, int width, int height, MainView mainView) {
        this.contactId = id;
        this.mainView = mainView;
        this.setForeground(Color.WHITE);
        MainController.getInstance().getContactUpdatedNotifier().addObserver(this);

        SettingsTab settingsTab = new SettingsTab(this);
        this.tabs.add(settingsTab);
        this.addTab(ViewConstants.SETTINGS_TAB_TITLE, settingsTab);

        ContactDTO contact = MainController.getInstance().getContact(id);
        updateDialog(contact, width, height);
    }

    /**
     * Gets contact id.
     *
     * @return the contact id
     */
    public UUID getContactId() {
        return contactId;
    }

    /**
     * Gets tabs.
     *
     * @return the tabs
     */
    public List<JPanel> getTabs() {
        return tabs;
    }

    @Override
    public void onContactCreated(UUID contactId) {
        this.contactId = contactId;
        MainController.getInstance().getContactCreatedNotifier().removeObserver(this);
    }

    @Override
    public void onDataChanged() {
        ContactDTO contact = MainController.getInstance().getContact(this.contactId);
        updateDialog(contact, this.getWidth(), this.getHeight());
    }

    /**
     * Create delete button.
     *
     * @param parent the parent
     */
    public void createDeleteButton(JPanel parent) {
        JButton deleteButton = new JButton(ViewConstants.TRASH_ICON);
        deleteButton.setPreferredSize(new Dimension(ViewConstants.DISPLAY_BUTTON_WIDTH, ViewConstants.DISPLAY_BUTTON_HEIGHT));
        deleteButton.addActionListener(e -> {
            MainController.getInstance().deleteContact(this.contactId);
            this.mainView.updateContactButtons(MainController.getInstance().getAllContacts());
            try {
                this.updateDialog(null, ViewConstants.DIALOG_WIDTH, ViewConstants.DIALOG_HEIGHT);
            } catch (Exception ignored) {}
        });
        parent.add(deleteButton);
        parent.repaint();
        parent.revalidate();
    }

    /**
     * Create tab delete button.
     *
     * @param parent the parent
     * @param tabId  the tab id
     */
    public void createTabDeleteButton(JPanel parent, UUID tabId) {
        JButton tabDeleteButton = new JButton(ViewConstants.CLOSE_TAB_ICON);
        tabDeleteButton.setPreferredSize(new Dimension(ViewConstants.DISPLAY_BUTTON_WIDTH, ViewConstants.DISPLAY_BUTTON_HEIGHT));
        tabDeleteButton.addActionListener(e -> {
            ContactDTO dto = MainController.getInstance().getContact(this.contactId);

            if (dto.getSocialMediaDTOList().doesSocialMediaDTOExist(tabId)) {
                SocialMediaDTO socialMediaDTO = dto.getSocialMediaDTOList().getSocialMediaDTO(tabId);
                dto.getSocialMediaDTOList().getSocialMediaDTOList().remove(socialMediaDTO);
            } else if (dto.getPrivateInfoDTOList().doesPrivateInfoDTOExist(tabId)) {
                PrivateInfoDTO privateInfoDTO = dto.getPrivateInfoDTOList().getPrivateInfoDto(tabId);
                dto.getPrivateInfoDTOList().getPrivateInfoDTOList().remove(privateInfoDTO);
            } else if (dto.getBusinessInfoDTOList().doesBusinessInfoDTOExist(tabId)) {
                BusinessInfoDTO businessInfoDTO = dto.getBusinessInfoDTOList().getBusinessInfoDTO(tabId);
                dto.getBusinessInfoDTOList().getBusinessInfoDTOList().remove(businessInfoDTO);
            }
            MainController.getInstance().updateContact(dto);
        });
        parent.add(tabDeleteButton);
        parent.repaint();
        parent.revalidate();
    }

    /**
     * Create update button.
     *
     * @param parent      the parent
     * @param editableTab the editable tab
     */
    public void createUpdateButton(JPanel parent, IEditableTab editableTab) {
        JButton editButton = new JButton(ViewConstants.PENCIL_ICON);
        editButton.setPreferredSize(new Dimension(ViewConstants.DISPLAY_BUTTON_WIDTH, ViewConstants.DISPLAY_BUTTON_HEIGHT));
        editButton.addActionListener(e -> {
            editableTab.setIsEditing(true);
            editableTab.updateOnEdit();
        });
        parent.add(editButton);
        parent.repaint();
        parent.revalidate();
    }

    /**
     * Create cancel edit button.
     *
     * @param parent      the parent
     * @param editableTab the editable tab
     */
    public void createCancelEditButton(JPanel parent, IEditableTab editableTab) {
        JButton cancelButton = new JButton();
        cancelButton.setPreferredSize(new Dimension(ViewConstants.DISPLAY_BUTTON_WIDTH, ViewConstants.DISPLAY_BUTTON_HEIGHT));
        cancelButton.setIcon(ViewConstants.CANCEL_ICON);
        cancelButton.addActionListener(e -> {
            editableTab.setIsEditing(false);
            editableTab.updateOnCancel();
            editableTab.updateOnEdit();
        });
        parent.add(cancelButton);
        parent.repaint();
        parent.revalidate();
    }

    /**
     * Update dialog.
     *
     * @param contact the contact
     * @param width   the width
     * @param height  the height
     */
    public void updateDialog(ContactDTO contact, int width, int height) {
        this.removeAll();
        this.tabs.clear();

        BaseInfoTab baseInfoTab = new BaseInfoTab(width, height, this);
        baseInfoTab.getFirstnameTextArea().setText(contact.getBaseInfoDTO().getFirstName());
        baseInfoTab.getFirstNameLabel().setText(contact.getBaseInfoDTO().getFirstName());
        baseInfoTab.getLastNameTextArea().setText(contact.getBaseInfoDTO().getLastName());
        baseInfoTab.getLastNameLabel().setText(contact.getBaseInfoDTO().getLastName());
        baseInfoTab.getPicker().setText(contact.getBaseInfoDTO().getBirthDate());
        baseInfoTab.getBirthDateLabel().setText(contact.getBaseInfoDTO().getBirthDate());
        baseInfoTab.setImage(contact.getBaseInfoDTO().getProfilePicture());
        if (contact.getBaseInfoDTO().getProfilePicture() != null) {
            baseInfoTab.getImageContainer().setIcon(new ImageIcon(contact.getBaseInfoDTO().getProfilePicture()));
        }
        tabs.add(baseInfoTab);
        this.addTab(ViewConstants.BASE_INFO_TAB_TITLE, baseInfoTab);

        for (PrivateInfoDTO privateInfoDTO : contact.getPrivateInfoDTOList().getPrivateInfoDTOList()) {
            PrivateInfoTab privateInfoTab = new PrivateInfoTab(privateInfoDTO.getId(), width, height, this);
            privateInfoTab.getEmailLabel().setText(privateInfoDTO.getEmail());
            privateInfoTab.getEmailTextArea().setText(privateInfoDTO.getEmail());
            privateInfoTab.getPhoneLabel().setText(privateInfoDTO.getPhone());
            privateInfoTab.getPhoneTextArea().setText(privateInfoDTO.getPhone());
            privateInfoTab.getCityLabel().setText(privateInfoDTO.getAddress().getCity());
            privateInfoTab.getCityTextArea().setText(privateInfoDTO.getAddress().getCity());
            privateInfoTab.getStreetLabel().setText(privateInfoDTO.getAddress().getStreet());
            privateInfoTab.getStreetTextArea().setText(privateInfoDTO.getAddress().getStreet());
            privateInfoTab.getZipCodeLabel().setText(privateInfoDTO.getAddress().getZipCode());
            privateInfoTab.getZipCodeTextArea().setText(privateInfoDTO.getAddress().getZipCode());
            privateInfoTab.getHouseNumberLabel().setText(privateInfoDTO.getAddress().getHouseNumber());
            privateInfoTab.getHouseNumberTextArea().setText(privateInfoDTO.getAddress().getHouseNumber());
            privateInfoTab.getHouseNumberAddonLabel().setText(privateInfoDTO.getAddress().getHouseNumberAddon());
            privateInfoTab.getHouseNumberAddonTextArea().setText(privateInfoDTO.getAddress().getHouseNumberAddon());
            tabs.add(privateInfoTab);
            this.addTab(ViewConstants.PRIVATE_INFO_TAB_TITLE, privateInfoTab);
        }

        for (BusinessInfoDTO businessInfoDTO : contact.getBusinessInfoDTOList().getBusinessInfoDTOList()) {
            BusinessInfoTab businessInfoTab = new BusinessInfoTab(businessInfoDTO.getId(), width, height, this);
            businessInfoTab.getJobTitleTextField().setText(businessInfoDTO.getJobTitle());
            businessInfoTab.getJobTitleLabel().setText(businessInfoDTO.getJobTitle());
            businessInfoTab.getCompanyNameTextField().setText(businessInfoDTO.getCompanyName());
            businessInfoTab.getCompanyNameLabel().setText(businessInfoDTO.getCompanyName());
            businessInfoTab.getEmailTextField().setText(businessInfoDTO.getBusinessEmail());
            businessInfoTab.getEmailLabel().setText(businessInfoDTO.getBusinessEmail());
            businessInfoTab.getPhoneTextField().setText(businessInfoDTO.getBusinessPhone());
            businessInfoTab.getPhoneLabel().setText(businessInfoDTO.getBusinessPhone());
            businessInfoTab.getCityTextArea().setText(businessInfoDTO.getAddress().getCity());
            businessInfoTab.getCityLabel().setText(businessInfoDTO.getAddress().getCity());
            businessInfoTab.getStreetTextArea().setText(businessInfoDTO.getAddress().getStreet());
            businessInfoTab.getStreetLabel().setText(businessInfoDTO.getAddress().getStreet());
            businessInfoTab.getZipCodeTextArea().setText(businessInfoDTO.getAddress().getZipCode());
            businessInfoTab.getZipCodeLabel().setText(businessInfoDTO.getAddress().getZipCode());
            businessInfoTab.getHouseNumberTextArea().setText(businessInfoDTO.getAddress().getHouseNumber());
            businessInfoTab.getHouseNumberLabel().setText(businessInfoDTO.getAddress().getHouseNumber());
            businessInfoTab.getHouseNumberAddonTextArea().setText(businessInfoDTO.getAddress().getHouseNumberAddon());
            businessInfoTab.getHouseNumberAddonLabel().setText(businessInfoDTO.getAddress().getHouseNumberAddon());
            tabs.add(businessInfoTab);
            this.addTab(ViewConstants.BUSINESS_INFO_TAB_TITLE, businessInfoTab);
        }

        for (SocialMediaDTO socialMediaDTO : contact.getSocialMediaDTOList().getSocialMediaDTOList()) {
            SocialMediaTab socialMediaTab = new SocialMediaTab(socialMediaDTO.getId(), width, height, this);
            socialMediaTab.getPlatformNameTextField().setText(socialMediaDTO.getPlatformName());
            socialMediaTab.getPlatformNameLabel().setText(socialMediaDTO.getPlatformName());
            socialMediaTab.getUserNameTextField().setText(socialMediaDTO.getUserName());
            socialMediaTab.getUserNameLabel().setText(socialMediaDTO.getUserName());
            socialMediaTab.getUrlTextField().setText(socialMediaDTO.getUrl());
            socialMediaTab.getUrlLabel().setText(socialMediaDTO.getUrl());
            tabs.add(socialMediaTab);
            this.addTab(ViewConstants.SOCIAL_INFO_TAB_TITLE, socialMediaTab);
        }

        SettingsTab settingsTab = new SettingsTab(this);
        this.tabs.add(settingsTab);
        this.addTab(ViewConstants.SETTINGS_TAB_TITLE, settingsTab);

        this.revalidate();
        this.repaint();
    }
}
