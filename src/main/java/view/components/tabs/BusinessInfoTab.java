package view.components.tabs;

import controller.MainController;
import view.dtoHandler.contactDto.ContactDTO;
import view.dtoHandler.contactDtoData.BusinessInfoDTO;
import model.observer.contactUpdated.IContactUpdatedObserver;
import model.adress.Address;
import view.components.dialogues.ContactDialog;
import view.constants.ViewConstants;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

/**
 * The type Business info tab.
 */
public class BusinessInfoTab extends JPanel implements IContactUpdatedObserver, IEditableTab {
    private boolean isEditing = false;
    private final UUID businessId;
    private ContactDialog dialog;
    private JPanel infoPanel;
    private JPanel addressPanel;
    private JPanel actionPanel;
    private JTextField companyNameTextField;
    private JLabel companyNameLabel;
    private JTextField jobTitleTextField;
    private JLabel jobTitleLabel;
    private JTextField emailTextField;
    private JLabel emailLabel;
    private JTextField phoneTextField;
    private JLabel phoneLabel;
    private JTextField streetTextArea;
    private JLabel streetLabel;
    private JTextField houseNumberTextArea;
    private JLabel houseNumberLabel;
    private JTextField houseNumberAddonTextArea;
    private JLabel houseNumberAddonLabel;
    private JTextField zipCodeTextArea;
    private JLabel zipCodeLabel;
    private JTextField cityTextArea;
    private JLabel cityLabel;

    /**
     * Instantiates a new Business info tab.
     *
     * @param id     the id
     * @param width  the width
     * @param height the height
     * @param dialog the dialog
     */
    public BusinessInfoTab(UUID id, int width, int height, ContactDialog dialog) {
        this.businessId = id;
        this.dialog = dialog;
        this.setBackground(ViewConstants.DARK_COLOR_LAYER_7);
        this.setPreferredSize(new Dimension(width, height));
        this.setSize(new Dimension(width, height));
        MainController.getInstance().getContactUpdatedNotifier().addObserver(this);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        /* info panel */
        this.infoPanel = new JPanel(layout);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.infoPanel.setPreferredSize(new Dimension(500, 600));
        this.infoPanel.setBackground(ViewConstants.DARK_COLOR_LAYER_7);
        this.infoPanel.setForeground(Color.WHITE);
        this.infoPanel.setLayout(new GridBagLayout());
        this.add(infoPanel, gbc);

        companyNameLabel = new JLabel();
        companyNameLabel.setForeground(Color.WHITE);

        companyNameTextField = new JTextField(20);

        jobTitleLabel = new JLabel();
        jobTitleLabel.setForeground(Color.WHITE);

        jobTitleTextField = new JTextField(20);

        emailLabel = new JLabel();
        emailLabel.setForeground(Color.WHITE);

        emailTextField = new JTextField(20);

        phoneLabel = new JLabel();
        phoneLabel.setForeground(Color.WHITE);

        phoneTextField = new JTextField(20);

        /* address info */
        this.addressPanel = new JPanel(layout);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.addressPanel.setPreferredSize(new Dimension(500, 600));
        this.addressPanel.setBackground(ViewConstants.DARK_COLOR_LAYER_7);
        this.addressPanel.setForeground(Color.WHITE);
        this.addressPanel.setLayout(new GridBagLayout());
        this.add(addressPanel, gbc);

        streetLabel = new JLabel();
        streetLabel.setForeground(Color.WHITE);

        streetTextArea = new JTextField(20);

        houseNumberLabel = new JLabel();
        houseNumberLabel.setForeground(Color.WHITE);

        houseNumberTextArea = new JTextField(20);

        houseNumberAddonLabel = new JLabel();
        houseNumberAddonLabel.setForeground(Color.WHITE);

        houseNumberAddonTextArea = new JTextField(20);

        zipCodeLabel = new JLabel();
        zipCodeLabel.setForeground(Color.WHITE);

        zipCodeTextArea = new JTextField(20);

        cityLabel = new JLabel();
        cityLabel.setForeground(Color.WHITE);

        cityTextArea = new JTextField(20);

        /* action panel */
        this.actionPanel = new JPanel(layout);
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.actionPanel.setPreferredSize(new Dimension(500, 300));
        this.actionPanel.setBackground(ViewConstants.DARK_COLOR_LAYER_7);
        this.actionPanel.setForeground(Color.WHITE);
        this.add(actionPanel, gbc);

        updateOnEdit();
    }

    @Override
    public void onDataChanged() {
        ContactDTO newData = MainController.getInstance().getContact(dialog.getContactId());
        for (BusinessInfoDTO businessInfoDTO : newData.getBusinessInfoDTOList().getBusinessInfoDTOList()) {
            this.companyNameTextField.setText(businessInfoDTO.getCompanyName());
            this.jobTitleTextField.setText(businessInfoDTO.getJobTitle());
            this.streetTextArea.setText(businessInfoDTO.getAddress().getStreet());
            this.houseNumberTextArea.setText(businessInfoDTO.getAddress().getHouseNumber());
            this.houseNumberAddonTextArea.setText(businessInfoDTO.getAddress().getHouseNumberAddon());
            this.zipCodeTextArea.setText(businessInfoDTO.getAddress().getZipCode());
            this.cityTextArea.setText(businessInfoDTO.getAddress().getCity());
            this.emailTextField.setText(businessInfoDTO.getBusinessEmail());
            this.phoneTextField.setText(businessInfoDTO.getBusinessPhone());
        }
    }

    @Override
    public boolean getIsEditing() {
        return this.isEditing;
    }

    @Override
    public void setIsEditing(boolean isEditing) {
        this.isEditing = isEditing;
    }

    @Override
    public void updateOnEdit() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        this.infoPanel.removeAll();
        this.addressPanel.removeAll();
        this.actionPanel.removeAll();

        JLabel companyName = new JLabel("Company Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        companyName.setForeground(Color.WHITE);
        this.infoPanel.add(companyName, gbc);

        JLabel jobTitle = new JLabel("Job Title:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        jobTitle.setForeground(Color.WHITE);
        this.infoPanel.add(jobTitle, gbc);

        JLabel email = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        email.setForeground(Color.WHITE);
        this.infoPanel.add(email, gbc);

        JLabel phone = new JLabel("Phone:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        phone.setForeground(Color.WHITE);
        this.infoPanel.add(phone, gbc);

        JLabel street = new JLabel("Street:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        street.setForeground(Color.WHITE);
        this.addressPanel.add(street, gbc);

        JLabel houseNumber = new JLabel("House Number:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        houseNumber.setForeground(Color.WHITE);
        this.addressPanel.add(houseNumber, gbc);

        JLabel houseNumberAddon = new JLabel("House Number addon:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        houseNumberAddon.setForeground(Color.WHITE);
        this.addressPanel.add(houseNumberAddon, gbc);

        JLabel zipCode = new JLabel("Zip Code:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        zipCode.setForeground(Color.WHITE);
        this.addressPanel.add(zipCode, gbc);

        JLabel city = new JLabel("City:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        city.setForeground(Color.WHITE);
        this.addressPanel.add(city, gbc);

        if (this.isEditing) {
            JButton saveButton = new JButton(ViewConstants.SAVE_ICON);
            saveButton.setPreferredSize(new Dimension(ViewConstants.DISPLAY_BUTTON_WIDTH, ViewConstants.DISPLAY_BUTTON_HEIGHT));
            this.actionPanel.add(saveButton);

            saveButton.addActionListener(e -> {
                ContactDTO newData = MainController.getInstance().getContact(dialog.getContactId());
                BusinessInfoDTO dto;
                if (newData.getBusinessInfoDTOList().doesBusinessInfoDTOExist(this.businessId)) {
                    dto = new BusinessInfoDTO(this.businessId);
                    dto.setCompanyName(companyNameTextField.getText());
                    dto.setJobTitle(jobTitleTextField.getText());
                    dto.setAddress(new Address(streetTextArea.getText(), houseNumberTextArea.getText(), houseNumberAddonTextArea.getText(), zipCodeTextArea.getText(), cityTextArea.getText()));
                    dto.setBusinessEmail(emailTextField.getText());
                    dto.setBusinessPhone(phoneTextField.getText());
                    newData.getBusinessInfoDTOList().replaceBusinessInfoDTO(dto.getId(), dto);
                } else {
                    dto = new BusinessInfoDTO();
                    dto.setCompanyName(companyNameTextField.getText());
                    dto.setJobTitle(jobTitleTextField.getText());
                    dto.setAddress(new Address(streetTextArea.getText(), houseNumberTextArea.getText(), houseNumberAddonTextArea.getText(), zipCodeTextArea.getText(), cityTextArea.getText()));
                    dto.setBusinessEmail(emailTextField.getText());
                    dto.setBusinessPhone(phoneTextField.getText());
                    newData.getBusinessInfoDTOList().getBusinessInfoDTOList().add(dto);
                }
                MainController.getInstance().updateContact(newData);
            });
            dialog.createCancelEditButton(this.actionPanel, this);

            companyNameTextField.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            companyNameTextField.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 0;
            this.infoPanel.add(companyNameTextField, gbc);

            jobTitleTextField.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            jobTitleTextField.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 1;
            this.infoPanel.add(jobTitleTextField, gbc);

            emailTextField.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            emailTextField.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 2;
            this.infoPanel.add(emailTextField, gbc);

            phoneTextField.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            phoneTextField.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 3;
            this.infoPanel.add(phoneTextField, gbc);

            streetTextArea.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            streetTextArea.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 0;
            this.addressPanel.add(streetTextArea, gbc);

            houseNumberTextArea.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            houseNumberTextArea.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 1;
            this.addressPanel.add(houseNumberTextArea, gbc);

            houseNumberAddonTextArea.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            houseNumberAddonTextArea.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 2;
            this.addressPanel.add(houseNumberAddonTextArea, gbc);

            zipCodeTextArea.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            zipCodeTextArea.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 3;
            this.addressPanel.add(zipCodeTextArea, gbc);

            cityTextArea.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            cityTextArea.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 4;
            this.addressPanel.add(cityTextArea, gbc);

        } else {
            dialog.createTabDeleteButton(this.actionPanel, this.businessId);
            dialog.createUpdateButton(this.actionPanel, this);

            gbc.gridx = 1;
            gbc.gridy = 0;
            this.infoPanel.add(companyNameLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            this.infoPanel.add(jobTitleLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            this.infoPanel.add(emailLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 3;
            this.infoPanel.add(phoneLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            this.addressPanel.add(streetLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            this.addressPanel.add(houseNumberLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            this.addressPanel.add(houseNumberAddonLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 3;
            this.addressPanel.add(zipCodeLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 4;
            this.addressPanel.add(cityLabel, gbc);
        }
        this.infoPanel.revalidate();
        this.infoPanel.repaint();
        this.addressPanel.revalidate();
        this.addressPanel.repaint();
        this.actionPanel.revalidate();
        this.actionPanel.repaint();
    }

    @Override
    public void updateOnCancel() {
        ContactDTO dto = MainController.getInstance().getContact(this.dialog.getContactId());
        BusinessInfoDTO businessInfoDTO = dto.getBusinessInfoDTOList().getBusinessInfoDTO(this.businessId);
        if (businessInfoDTO != null) {
            this.companyNameTextField.setText(businessInfoDTO.getCompanyName());
            this.zipCodeTextArea.setText(businessInfoDTO.getAddress().getZipCode());
            this.jobTitleTextField.setText(businessInfoDTO.getJobTitle());
            this.streetTextArea.setText(businessInfoDTO.getAddress().getStreet());
            this.houseNumberTextArea.setText(businessInfoDTO.getAddress().getHouseNumber());
            this.houseNumberAddonTextArea.setText(businessInfoDTO.getAddress().getHouseNumberAddon());
            this.emailTextField.setText(businessInfoDTO.getBusinessEmail());
            this.phoneTextField.setText(businessInfoDTO.getBusinessPhone());
        }
    }

    /**
     * Gets business id.
     *
     * @return the business id
     */
    public UUID getBusinessId() {
        return businessId;
    }

    /**
     * Gets dialog.
     *
     * @return the dialog
     */
    public ContactDialog getDialog() {
        return dialog;
    }

    /**
     * Sets dialog.
     *
     * @param dialog the dialog
     */
    public void setDialog(ContactDialog dialog) {
        this.dialog = dialog;
    }

    /**
     * Gets company name text field.
     *
     * @return the company name text field
     */
    public JTextField getCompanyNameTextField() {
        return companyNameTextField;
    }

    /**
     * Sets company name text field.
     *
     * @param companyNameTextField the company name text field
     */
    public void setCompanyNameTextField(JTextField companyNameTextField) {
        this.companyNameTextField = companyNameTextField;
    }

    /**
     * Gets job title text field.
     *
     * @return the job title text field
     */
    public JTextField getJobTitleTextField() {
        return jobTitleTextField;
    }

    /**
     * Sets job title text field.
     *
     * @param jobTitleTextField the job title text field
     */
    public void setJobTitleTextField(JTextField jobTitleTextField) {
        this.jobTitleTextField = jobTitleTextField;
    }

    /**
     * Gets email text field.
     *
     * @return the email text field
     */
    public JTextField getEmailTextField() {
        return emailTextField;
    }

    /**
     * Sets email text field.
     *
     * @param emailTextField the email text field
     */
    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    /**
     * Gets phone text field.
     *
     * @return the phone text field
     */
    public JTextField getPhoneTextField() {
        return phoneTextField;
    }

    /**
     * Sets phone text field.
     *
     * @param phoneTextField the phone text field
     */
    public void setPhoneTextField(JTextField phoneTextField) {
        this.phoneTextField = phoneTextField;
    }

    /**
     * Gets street text area.
     *
     * @return the street text area
     */
    public JTextField getStreetTextArea() {
        return streetTextArea;
    }

    /**
     * Sets street text area.
     *
     * @param streetTextArea the street text area
     */
    public void setStreetTextArea(JTextField streetTextArea) {
        this.streetTextArea = streetTextArea;
    }

    /**
     * Gets house number text area.
     *
     * @return the house number text area
     */
    public JTextField getHouseNumberTextArea() {
        return houseNumberTextArea;
    }

    /**
     * Sets house number text area.
     *
     * @param houseNumberTextArea the house number text area
     */
    public void setHouseNumberTextArea(JTextField houseNumberTextArea) {
        this.houseNumberTextArea = houseNumberTextArea;
    }

    /**
     * Gets house number addon text area.
     *
     * @return the house number addon text area
     */
    public JTextField getHouseNumberAddonTextArea() {
        return houseNumberAddonTextArea;
    }

    /**
     * Sets house number addon text area.
     *
     * @param houseNumberAddonTextArea the house number addon text area
     */
    public void setHouseNumberAddonTextArea(JTextField houseNumberAddonTextArea) {
        this.houseNumberAddonTextArea = houseNumberAddonTextArea;
    }

    /**
     * Gets zip code text area.
     *
     * @return the zip code text area
     */
    public JTextField getZipCodeTextArea() {
        return zipCodeTextArea;
    }

    /**
     * Sets zip code text area.
     *
     * @param zipCodeTextArea the zip code text area
     */
    public void setZipCodeTextArea(JTextField zipCodeTextArea) {
        this.zipCodeTextArea = zipCodeTextArea;
    }

    /**
     * Gets city text area.
     *
     * @return the city text area
     */
    public JTextField getCityTextArea() {
        return cityTextArea;
    }

    /**
     * Sets city text area.
     *
     * @param cityTextArea the city text area
     */
    public void setCityTextArea(JTextField cityTextArea) {
        this.cityTextArea = cityTextArea;
    }

    /**
     * Gets info panel.
     *
     * @return the info panel
     */
    public JPanel getInfoPanel() {
        return infoPanel;
    }

    /**
     * Sets info panel.
     *
     * @param infoPanel the info panel
     */
    public void setInfoPanel(JPanel infoPanel) {
        this.infoPanel = infoPanel;
    }

    /**
     * Gets address panel.
     *
     * @return the address panel
     */
    public JPanel getAddressPanel() {
        return addressPanel;
    }

    /**
     * Sets address panel.
     *
     * @param addressPanel the address panel
     */
    public void setAddressPanel(JPanel addressPanel) {
        this.addressPanel = addressPanel;
    }

    /**
     * Gets action panel.
     *
     * @return the action panel
     */
    public JPanel getActionPanel() {
        return actionPanel;
    }

    /**
     * Sets action panel.
     *
     * @param actionPanel the action panel
     */
    public void setActionPanel(JPanel actionPanel) {
        this.actionPanel = actionPanel;
    }

    /**
     * Gets company name label.
     *
     * @return the company name label
     */
    public JLabel getCompanyNameLabel() {
        return companyNameLabel;
    }

    /**
     * Sets company name label.
     *
     * @param companyNameLabel the company name label
     */
    public void setCompanyNameLabel(JLabel companyNameLabel) {
        this.companyNameLabel = companyNameLabel;
    }

    /**
     * Gets job title label.
     *
     * @return the job title label
     */
    public JLabel getJobTitleLabel() {
        return jobTitleLabel;
    }

    /**
     * Sets job title label.
     *
     * @param jobTitleLabel the job title label
     */
    public void setJobTitleLabel(JLabel jobTitleLabel) {
        this.jobTitleLabel = jobTitleLabel;
    }

    /**
     * Gets email label.
     *
     * @return the email label
     */
    public JLabel getEmailLabel() {
        return emailLabel;
    }

    /**
     * Sets email label.
     *
     * @param emailLabel the email label
     */
    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    /**
     * Gets phone label.
     *
     * @return the phone label
     */
    public JLabel getPhoneLabel() {
        return phoneLabel;
    }

    /**
     * Sets phone label.
     *
     * @param phoneLabel the phone label
     */
    public void setPhoneLabel(JLabel phoneLabel) {
        this.phoneLabel = phoneLabel;
    }

    /**
     * Gets street label.
     *
     * @return the street label
     */
    public JLabel getStreetLabel() {
        return streetLabel;
    }

    /**
     * Sets street label.
     *
     * @param streetLabel the street label
     */
    public void setStreetLabel(JLabel streetLabel) {
        this.streetLabel = streetLabel;
    }

    /**
     * Gets house number label.
     *
     * @return the house number label
     */
    public JLabel getHouseNumberLabel() {
        return houseNumberLabel;
    }

    /**
     * Sets house number label.
     *
     * @param houseNumberLabel the house number label
     */
    public void setHouseNumberLabel(JLabel houseNumberLabel) {
        this.houseNumberLabel = houseNumberLabel;
    }

    /**
     * Gets house number addon label.
     *
     * @return the house number addon label
     */
    public JLabel getHouseNumberAddonLabel() {
        return houseNumberAddonLabel;
    }

    /**
     * Sets house number addon label.
     *
     * @param houseNumberAddonLabel the house number addon label
     */
    public void setHouseNumberAddonLabel(JLabel houseNumberAddonLabel) {
        this.houseNumberAddonLabel = houseNumberAddonLabel;
    }

    /**
     * Gets zip code label.
     *
     * @return the zip code label
     */
    public JLabel getZipCodeLabel() {
        return zipCodeLabel;
    }

    /**
     * Sets zip code label.
     *
     * @param zipCodeLabel the zip code label
     */
    public void setZipCodeLabel(JLabel zipCodeLabel) {
        this.zipCodeLabel = zipCodeLabel;
    }

    /**
     * Gets city label.
     *
     * @return the city label
     */
    public JLabel getCityLabel() {
        return cityLabel;
    }

    /**
     * Sets city label.
     *
     * @param cityLabel the city label
     */
    public void setCityLabel(JLabel cityLabel) {
        this.cityLabel = cityLabel;
    }
}
