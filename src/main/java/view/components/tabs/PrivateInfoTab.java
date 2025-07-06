package view.components.tabs;

import controller.MainController;
import view.dtoHandler.contactDto.ContactDTO;
import view.dtoHandler.contactDtoData.PrivateInfoDTO;
import model.adress.Address;
import model.observer.contactUpdated.IContactUpdatedObserver;
import view.components.dialogues.ContactDialog;
import view.constants.ViewConstants;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

/**
 * The type Private info tab.
 */
public class PrivateInfoTab extends JPanel implements IContactUpdatedObserver, IEditableTab {
    private boolean isEditing = false;
    private JPanel infoPanel;
    private JPanel addressPanel;
    private JPanel actionPanel;
    private final UUID privateInfoId;
    private ContactDialog dialog;
    private JLabel phoneLabel;
    private JTextField phoneTextArea;
    private JLabel emailLabel;
    private JTextField emailTextArea;
    private JLabel streetLabel;
    private JTextField streetTextArea;
    private JLabel houseNumberLabel;
    private JTextField houseNumberTextArea;
    private JLabel houseNumberAddonLabel;
    private JTextField houseNumberAddonTextArea;
    private JLabel zipCodeLabel;
    private JTextField zipCodeTextArea;
    private JLabel cityLabel;
    private JTextField cityTextArea;
    private JButton saveButton;

    /**
     * Instantiates a new Private info tab.
     *
     * @param id     the id
     * @param width  the width
     * @param height the height
     * @param dialog the dialog
     */
    public PrivateInfoTab(UUID id, int width, int height, ContactDialog dialog) {
        this.privateInfoId = id;
        this.dialog = dialog;
        this.setBackground(ViewConstants.DARK_COLOR_LAYER_7);
        this.setForeground(Color.WHITE);
        this.setPreferredSize(new Dimension(width, height));
        this.setSize(new Dimension(width, height));
        this.setEnabled(true);
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
        this.add(infoPanel, gbc);

        phoneLabel = new JLabel();
        phoneLabel.setForeground(Color.WHITE);

        phoneTextArea = new JTextField(20);

        emailLabel = new JLabel();
        emailLabel.setForeground(Color.WHITE);

        emailTextArea = new JTextField(20);

        /* address info */
        this.addressPanel = new JPanel(layout);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.addressPanel.setPreferredSize(new Dimension(500, 600));
        this.addressPanel.setBackground(ViewConstants.DARK_COLOR_LAYER_7);
        this.addressPanel.setForeground(Color.WHITE);
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
        ContactDTO newData = new ContactDTO();
        for (PrivateInfoDTO privateInfoDTO : newData.getPrivateInfoDTOList().getPrivateInfoDTOList()) {
            this.phoneTextArea.setText(privateInfoDTO.getPhone());
            this.emailTextArea.setText(privateInfoDTO.getEmail());
            this.streetTextArea.setText(privateInfoDTO.getAddress().getStreet());
            this.houseNumberTextArea.setText(privateInfoDTO.getAddress().getHouseNumber());
            this.houseNumberAddonTextArea.setText(privateInfoDTO.getAddress().getHouseNumberAddon());
            this.zipCodeTextArea.setText(privateInfoDTO.getAddress().getZipCode());
            this.cityTextArea.setText(privateInfoDTO.getAddress().getCity());
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

        JLabel phone = new JLabel("Phone:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        phone.setForeground(Color.WHITE);
        this.infoPanel.add(phone, gbc);

        JLabel email = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        email.setForeground(Color.WHITE);
        this.infoPanel.add(email, gbc);

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

        JLabel houseNumberAddon = new JLabel("House Number Addon:");
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
            saveButton = new JButton(ViewConstants.SAVE_ICON);
            saveButton.setPreferredSize(new Dimension(ViewConstants.DISPLAY_BUTTON_WIDTH, ViewConstants.DISPLAY_BUTTON_HEIGHT));
            this.actionPanel.add(saveButton);

            saveButton.addActionListener(e -> {
                ContactDTO newData = MainController.getInstance().getContact(dialog.getContactId());
                PrivateInfoDTO privateInfoDTO;
                if (newData.getPrivateInfoDTOList().doesPrivateInfoDTOExist(this.privateInfoId)) {
                    privateInfoDTO = new PrivateInfoDTO(this.privateInfoId);
                    privateInfoDTO.setAddress(new Address(this.streetTextArea.getText(), this.houseNumberTextArea.getText(), this.houseNumberAddonTextArea.getText(), this.zipCodeTextArea.getText(), this.cityTextArea.getText()));
                    privateInfoDTO.setEmail(this.emailTextArea.getText());
                    privateInfoDTO.setPhone(this.phoneTextArea.getText());
                    newData.getPrivateInfoDTOList().replacePrivateInfoDTO(this.privateInfoId, privateInfoDTO);
                } else {
                    privateInfoDTO = new PrivateInfoDTO();
                    privateInfoDTO.setAddress(new Address(this.streetTextArea.getText(), this.houseNumberTextArea.getText(), this.houseNumberAddonTextArea.getText(), this.zipCodeTextArea.getText(), this.cityTextArea.getText()));
                    privateInfoDTO.setEmail(this.emailTextArea.getText());
                    privateInfoDTO.setPhone(this.phoneTextArea.getText());
                    newData.getPrivateInfoDTOList().getPrivateInfoDTOList().add(privateInfoDTO);
                }
                MainController.getInstance().updateContact(newData);
            });
            dialog.createCancelEditButton(this.actionPanel, this);

            phoneTextArea.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            phoneTextArea.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 0;
            this.infoPanel.add(phoneTextArea, gbc);

            emailTextArea.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            emailTextArea.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 1;
            this.infoPanel.add(emailTextArea, gbc);

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
            dialog.createTabDeleteButton(this.actionPanel, this.privateInfoId);
            dialog.createUpdateButton(this.actionPanel, this);

            gbc.gridx = 1;
            gbc.gridy = 0;
            this.infoPanel.add(phoneLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            this.infoPanel.add(emailLabel, gbc);

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
        PrivateInfoDTO privateInfoDTO = dto.getPrivateInfoDTOList().getPrivateInfoDto(this.privateInfoId);
        if (privateInfoDTO != null) {
            this.emailTextArea.setText(privateInfoDTO.getEmail());
            this.phoneTextArea.setText(privateInfoDTO.getPhone());
            this.streetTextArea.setText(privateInfoDTO.getAddress().getStreet());
            this.houseNumberTextArea.setText(privateInfoDTO.getAddress().getHouseNumber());
            this.houseNumberAddonTextArea.setText(privateInfoDTO.getAddress().getHouseNumberAddon());
            this.zipCodeTextArea.setText(privateInfoDTO.getAddress().getZipCode());
            this.cityTextArea.setText(privateInfoDTO.getAddress().getCity());
        }
    }

    /**
     * Gets private info id.
     *
     * @return the private info id
     */
    public UUID getPrivateInfoId() {
        return privateInfoId;
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
     * Gets phone text area.
     *
     * @return the phone text area
     */
    public JTextField getPhoneTextArea() {
        return phoneTextArea;
    }

    /**
     * Sets phone text area.
     *
     * @param phoneTextArea the phone text area
     */
    public void setPhoneTextArea(JTextField phoneTextArea) {
        this.phoneTextArea = phoneTextArea;
    }

    /**
     * Gets email text area.
     *
     * @return the email text area
     */
    public JTextField getEmailTextArea() {
        return emailTextArea;
    }

    /**
     * Sets email text area.
     *
     * @param emailTextArea the email text area
     */
    public void setEmailTextArea(JTextField emailTextArea) {
        this.emailTextArea = emailTextArea;
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
     * Gets submit button.
     *
     * @return the submit button
     */
    public JButton getSubmitButton() {
        return saveButton;
    }

    /**
     * Sets submit button.
     *
     * @param submitButton the submit button
     */
    public void setSubmitButton(JButton submitButton) {
        this.saveButton = submitButton;
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
