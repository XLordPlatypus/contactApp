package view.components.tabs;

import controller.MainController;
import view.dtoHandler.contactDto.ContactDTO;
import view.dtoHandler.contactDtoData.SocialMediaDTO;
import model.observer.contactUpdated.IContactUpdatedObserver;
import view.components.dialogues.ContactDialog;
import view.constants.ViewConstants;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

/**
 * The type Social media tab.
 */
public class SocialMediaTab extends JPanel implements IContactUpdatedObserver, IEditableTab {
    private boolean isEditing = false;
    private JPanel infoPanel;
    private JPanel actionPanel;
    private final UUID socialMediaId;
    private ContactDialog dialog;
    private JLabel platformNameLabel;
    private JTextField platformNameTextField;
    private JLabel userNameLabel;
    private JTextField userNameTextField;
    private JLabel urlLabel;
    private JTextField urlTextField;

    /**
     * Instantiates a new Social media tab.
     *
     * @param id     the id
     * @param width  the width
     * @param height the height
     * @param dialog the dialog
     */
    public SocialMediaTab(UUID id, int width, int height, ContactDialog dialog) {
        this.socialMediaId = id;
        this.dialog = dialog;
        this.setBackground(ViewConstants.DARK_COLOR_LAYER_7);
        this.setForeground(Color.WHITE);
        this.setPreferredSize(new Dimension(width, height));
        this.setSize(new Dimension(width, height));
        this.setEnabled(true);

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

        platformNameLabel = new JLabel();
        platformNameLabel.setForeground(Color.WHITE);

        platformNameTextField = new JTextField(20);

        userNameLabel = new JLabel();
        userNameLabel.setForeground(Color.WHITE);

        userNameTextField = new JTextField(20);

        urlLabel = new JLabel();
        urlLabel.setForeground(Color.WHITE);

        urlTextField = new JTextField(20);

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
        for (SocialMediaDTO socialMediaDTO : newData.getSocialMediaDTOList().getSocialMediaDTOList()) {
            socialMediaDTO.setUserName(userNameTextField.getText());
            socialMediaDTO.setUrl(urlTextField.getText());
            socialMediaDTO.setPlatformName(platformNameTextField.getText());
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
        actionPanel.removeAll();
        infoPanel.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        userLabel.setForeground(Color.WHITE);
        this.infoPanel.add(userLabel, gbc);

        JLabel platformLabel = new JLabel("Platform name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        platformLabel.setForeground(Color.WHITE);
        this.infoPanel.add(platformLabel, gbc);

        JLabel urlLabel2 = new JLabel("Url:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        urlLabel2.setForeground(Color.WHITE);
        this.infoPanel.add(urlLabel2, gbc);

        if (isEditing) {
            platformNameTextField.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            platformNameTextField.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 0;
            this.infoPanel.add(platformNameTextField, gbc);

            userNameTextField.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            userNameTextField.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 1;
            this.infoPanel.add(userNameTextField, gbc);

            urlTextField.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            urlTextField.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 2;
            this.infoPanel.add(urlTextField, gbc);

            JButton saveButton = new JButton(ViewConstants.SAVE_ICON);
            saveButton.setPreferredSize(new Dimension(ViewConstants.DISPLAY_BUTTON_WIDTH, ViewConstants.DISPLAY_BUTTON_HEIGHT));
            this.actionPanel.add(saveButton);

            saveButton.addActionListener(e -> {
                ContactDTO newData = MainController.getInstance().getContact(dialog.getContactId());
                if (newData.getSocialMediaDTOList().doesSocialMediaDTOExist(this.socialMediaId)) {
                    SocialMediaDTO socialMediaDTO = new SocialMediaDTO(this.socialMediaId);
                    socialMediaDTO.setUserName(userNameTextField.getText());
                    socialMediaDTO.setUrl(urlTextField.getText());
                    socialMediaDTO.setPlatformName(platformNameTextField.getText());
                    newData.getSocialMediaDTOList().replaceSocialMediaDTO(this.socialMediaId, socialMediaDTO);
                } else {
                    SocialMediaDTO socialMediaDTO = new SocialMediaDTO();
                    socialMediaDTO.setUserName(userNameTextField.getText());
                    socialMediaDTO.setUrl(urlTextField.getText());
                    socialMediaDTO.setPlatformName(platformNameTextField.getText());
                    newData.getSocialMediaDTOList().getSocialMediaDTOList().add(socialMediaDTO);
                }
                MainController.getInstance().updateContact(newData);
            });
            dialog.createCancelEditButton(this.actionPanel, this);
        } else {
            dialog.createTabDeleteButton(this.actionPanel, this.socialMediaId);
            dialog.createUpdateButton(this.actionPanel, this);

            gbc.gridx = 1;
            gbc.gridy = 0;
            this.infoPanel.add(platformNameLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            this.infoPanel.add(userNameLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            this.infoPanel.add(urlLabel, gbc);
        }
        this.infoPanel.revalidate();
        this.infoPanel.repaint();
        this.actionPanel.revalidate();
        this.actionPanel.repaint();
    }

    @Override
    public void updateOnCancel() {
        ContactDTO dto = MainController.getInstance().getContact(dialog.getContactId());
        SocialMediaDTO socialMediaDTO = dto.getSocialMediaDTOList().getSocialMediaDTO(this.socialMediaId);
        if (socialMediaDTO != null) {
            this.userNameLabel.setText(socialMediaDTO.getUserName());
            this.platformNameLabel.setText(socialMediaDTO.getPlatformName());
            this.urlLabel.setText(socialMediaDTO.getUrl());
            this.platformNameTextField.setText(socialMediaDTO.getPlatformName());
        }
    }

    /**
     * Gets social media id.
     *
     * @return the social media id
     */
    public UUID getSocialMediaId() {
        return socialMediaId;
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
     * Gets platform name text field.
     *
     * @return the platform name text field
     */
    public JTextField getPlatformNameTextField() {
        return platformNameTextField;
    }

    /**
     * Sets platform name text field.
     *
     * @param platformNameTextField the platform name text field
     */
    public void setPlatformNameTextField(JTextField platformNameTextField) {
        this.platformNameTextField = platformNameTextField;
    }

    /**
     * Gets user name text field.
     *
     * @return the user name text field
     */
    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    /**
     * Sets user name text field.
     *
     * @param userNameTextField the user name text field
     */
    public void setUserNameTextField(JTextField userNameTextField) {
        this.userNameTextField = userNameTextField;
    }

    /**
     * Gets url text field.
     *
     * @return the url text field
     */
    public JTextField getUrlTextField() {
        return urlTextField;
    }

    /**
     * Sets url text field.
     *
     * @param urlTextField the url text field
     */
    public void setUrlTextField(JTextField urlTextField) {
        this.urlTextField = urlTextField;
    }

    /**
     * Gets url label.
     *
     * @return the url label
     */
    public JLabel getUrlLabel() {
        return urlLabel;
    }

    /**
     * Sets url label.
     *
     * @param urlLabel the url label
     */
    public void setUrlLabel(JLabel urlLabel) {
        this.urlLabel = urlLabel;
    }

    /**
     * Gets user name label.
     *
     * @return the user name label
     */
    public JLabel getUserNameLabel() {
        return userNameLabel;
    }

    /**
     * Sets user name label.
     *
     * @param userNameLabel the user name label
     */
    public void setUserNameLabel(JLabel userNameLabel) {
        this.userNameLabel = userNameLabel;
    }

    /**
     * Gets platform name label.
     *
     * @return the platform name label
     */
    public JLabel getPlatformNameLabel() {
        return platformNameLabel;
    }

    /**
     * Sets platform name label.
     *
     * @param platformNameLabel the platform name label
     */
    public void setPlatformNameLabel(JLabel platformNameLabel) {
        this.platformNameLabel = platformNameLabel;
    }
}
