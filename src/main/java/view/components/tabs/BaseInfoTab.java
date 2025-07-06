package view.components.tabs;

import com.github.lgooddatepicker.components.DatePicker;
import controller.MainController;
import view.dtoHandler.contactDto.ContactDTO;
import view.dtoHandler.contactDtoData.BaseInfoDTO;
import model.observer.contactUpdated.IContactUpdatedObserver;
import view.components.dialogues.ContactDialog;
import view.constants.ViewConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The type Base info tab.
 */
public class BaseInfoTab extends JPanel implements IContactUpdatedObserver, IEditableTab {
    private boolean isEditing = false;
    private JPanel infoPanel;
    private JPanel imagePanel;
    private JPanel actionPanel;

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel birthDateLabel;
    private JLabel imageContainer;

    private JTextField firstnameTextArea;
    private JTextField lastNameTextArea;
    private DatePicker picker;
    private JButton selectImageButton;
    private BufferedImage image;
    private ContactDialog dialog;

    /**
     * Instantiates a new Base info tab.
     *
     * @param width  the width
     * @param height the height
     * @param dialog the dialog
     */
    public BaseInfoTab(int width, int height, ContactDialog dialog) {


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

        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setBackground(ViewConstants.DARK_COLOR_LAYER_8);

        lastNameLabel = new JLabel("Surname:");
        lastNameLabel.setForeground(Color.WHITE);
        lastNameLabel.setBackground(ViewConstants.DARK_COLOR_LAYER_8);

        birthDateLabel = new JLabel("Birthdate:");
        birthDateLabel.setForeground(Color.WHITE);
        birthDateLabel.setBackground(ViewConstants.DARK_COLOR_LAYER_8);

        firstnameTextArea = new JTextField(20);
        lastNameTextArea = new JTextField(20);
        picker = new DatePicker();
        picker.setPreferredSize(new Dimension(100, 20));
        picker.setBackground(ViewConstants.DARK_COLOR_LAYER_7);
        picker.setForeground(Color.WHITE);

        /* image panel */
        this.imagePanel = new JPanel(layout);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.imagePanel.setPreferredSize(new Dimension(500, 500));
        this.imagePanel.setBackground(ViewConstants.DARK_COLOR_LAYER_7);
        this.imagePanel.setForeground(Color.WHITE);
        this.add(this.imagePanel, gbc);

        imageContainer = new JLabel();
        imageContainer.setPreferredSize(new Dimension(300, 300));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        this.imagePanel.add(imageContainer, gbc);

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
    public void updateOnEdit() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.infoPanel.removeAll();
        this.actionPanel.removeAll();

        JLabel firstname = new JLabel("Firstname:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        firstname.setForeground(Color.WHITE);
        this.infoPanel.add(firstname, gbc);

        JLabel lastname = new JLabel("Lastname:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        lastname.setForeground(Color.WHITE);
        this.infoPanel.add(lastname, gbc);

        JLabel birthdate = new JLabel("Birthdate:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        birthdate.setForeground(Color.WHITE);
        this.infoPanel.add(birthdate, gbc);

        if (this.isEditing) {
            createSelectImageButton(gbc);
            JButton saveButton = new JButton(ViewConstants.SAVE_ICON);
            saveButton.setPreferredSize(new Dimension(ViewConstants.DISPLAY_BUTTON_WIDTH, ViewConstants.DISPLAY_BUTTON_HEIGHT));

            this.actionPanel.add(saveButton);
            saveButton.addActionListener(e -> {
                BaseInfoDTO baseInfoDTO = new BaseInfoDTO();

                if (firstnameTextArea.getText().isEmpty() || lastNameTextArea.getText().isEmpty() || picker.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Error! Please enter all the information about the first name, lastname and birthdate");
                } else {
                    baseInfoDTO.setFirstName(firstnameTextArea.getText());
                    baseInfoDTO.setLastName(lastNameTextArea.getText());
                    baseInfoDTO.setBirthDate(picker.getText());
                    try {
                        baseInfoDTO.setProfilePicture(image);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(dialog, "Error! Please select valid image.");
                    }

                    ContactDTO contactToUpdate = MainController.getInstance().getContact(dialog.getContactId());
                    contactToUpdate.setBaseInfoDTO(baseInfoDTO);
                    MainController.getInstance().updateContact(contactToUpdate);

                    firstnameTextArea.setText(contactToUpdate.getBaseInfoDTO().getFirstName());
                    lastNameTextArea.setText(contactToUpdate.getBaseInfoDTO().getLastName());
                    picker.setText(contactToUpdate.getBaseInfoDTO().getBirthDate());
                    image = contactToUpdate.getBaseInfoDTO().getProfilePicture();
                    try {
                        imageContainer.setIcon(new ImageIcon(contactToUpdate.getBaseInfoDTO().getProfilePicture()));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(dialog, "Error! Please select valid image.");
                    }
                }
            });

            dialog.createCancelEditButton(actionPanel, this);

            firstnameTextArea.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            firstnameTextArea.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 0;
            this.infoPanel.add(firstnameTextArea, gbc);

            lastNameTextArea.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
            lastNameTextArea.setForeground(Color.WHITE);
            gbc.gridx = 1;
            gbc.gridy = 1;
            this.infoPanel.add(lastNameTextArea, gbc);

            gbc.gridy = 2;
            this.infoPanel.add(picker, gbc);

        } else {
            if (this.selectImageButton != null) {
                this.imagePanel.remove(this.selectImageButton);
            }
            dialog.createUpdateButton(actionPanel, this);
            BaseInfoDTO dto = MainController.getInstance().getContact(this.dialog.getContactId()).getBaseInfoDTO();
            firstNameLabel.setText(dto.getFirstName());
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 10;
            this.infoPanel.add(firstNameLabel, gbc);

            lastNameLabel.setText(dto.getLastName());
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 10;
            this.infoPanel.add(lastNameLabel, gbc);

            birthDateLabel.setText(dto.getBirthDate());
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.gridwidth = 10;
            this.infoPanel.add(birthDateLabel, gbc);
        }
        this.infoPanel.repaint();
        this.infoPanel.revalidate();
        this.imagePanel.repaint();
        this.imagePanel.revalidate();
        this.actionPanel.repaint();
        this.actionPanel.revalidate();
    }

    private void createSelectImageButton(GridBagConstraints gbc) {
        selectImageButton = new JButton("Select Image");
        selectImageButton.setBackground(ViewConstants.DARK_COLOR_LAYER_8);
        selectImageButton.setForeground(Color.WHITE);
        gbc.gridy = 1;
        this.imagePanel.add(selectImageButton, gbc);
        this.selectImageButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setDialogTitle("Select Image");
            chooser.showOpenDialog(this);
            try {
                this.image = ImageIO.read(chooser.getSelectedFile());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.selectImageButton.repaint();
        });
    }

    @Override
    public void updateOnCancel() {
        ContactDTO dto = MainController.getInstance().getContact(this.dialog.getContactId());
        this.firstnameTextArea.setText(dto.getBaseInfoDTO().getFirstName());
        this.lastNameTextArea.setText(dto.getBaseInfoDTO().getLastName());
        this.picker.setText(dto.getBaseInfoDTO().getBirthDate());
    }

    @Override
    public void onDataChanged() {
        ContactDTO newData = MainController.getInstance().getContact(dialog.getContactId());
        this.firstnameTextArea.setText(newData.getBaseInfoDTO().getFirstName());
        this.lastNameTextArea.setText(newData.getBaseInfoDTO().getLastName());
        this.picker.setText(newData.getBaseInfoDTO().getBirthDate());
        this.image = newData.getBaseInfoDTO().getProfilePicture();
        if (newData.getBaseInfoDTO().getProfilePicture() != null) {
            this.imageContainer.setIcon(new ImageIcon(newData.getBaseInfoDTO().getProfilePicture()));
            this.imageContainer.repaint();
        }
    }

    /**
     * Gets firstname text area.
     *
     * @return the firstname text area
     */
    public JTextField getFirstnameTextArea() {
        return firstnameTextArea;
    }

    /**
     * Sets firstname text area.
     *
     * @param firstnameTextArea the firstname text area
     */
    public void setFirstnameTextArea(JTextField firstnameTextArea) {
        this.firstnameTextArea = firstnameTextArea;
    }

    /**
     * Gets last name text area.
     *
     * @return the last name text area
     */
    public JTextField getLastNameTextArea() {
        return lastNameTextArea;
    }

    /**
     * Sets last name text area.
     *
     * @param lastNameTextArea the last name text area
     */
    public void setLastNameTextArea(JTextField lastNameTextArea) {
        this.lastNameTextArea = lastNameTextArea;
    }

    /**
     * Gets image container.
     *
     * @return the image container
     */
    public JLabel getImageContainer() {
        return imageContainer;
    }

    /**
     * Sets image container.
     *
     * @param imageContainer the image container
     */
    public void setImageContainer(JLabel imageContainer) {
        this.imageContainer = imageContainer;
    }

    /**
     * Gets select image button.
     *
     * @return the select image button
     */
    public JButton getSelectImageButton() {
        return selectImageButton;
    }

    /**
     * Sets select image button.
     *
     * @param selectImageButton the select image button
     */
    public void setSelectImageButton(JButton selectImageButton) {
        this.selectImageButton = selectImageButton;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
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

    @Override
    public boolean getIsEditing() {
        return this.isEditing;
    }

    @Override
    public void setIsEditing(boolean isEditing) {
        this.isEditing = isEditing;
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
     * Gets image panel.
     *
     * @return the image panel
     */
    public JPanel getImagePanel() {
        return imagePanel;
    }

    /**
     * Sets image panel.
     *
     * @param imagePanel the image panel
     */
    public void setImagePanel(JPanel imagePanel) {
        this.imagePanel = imagePanel;
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
     * Gets first name label.
     *
     * @return the first name label
     */
    public JLabel getFirstNameLabel() {
        return firstNameLabel;
    }

    /**
     * Sets first name label.
     *
     * @param firstNameLabel the first name label
     */
    public void setFirstNameLabel(JLabel firstNameLabel) {
        this.firstNameLabel = firstNameLabel;
    }

    /**
     * Gets last name label.
     *
     * @return the last name label
     */
    public JLabel getLastNameLabel() {
        return lastNameLabel;
    }

    /**
     * Sets last name label.
     *
     * @param lastNameLabel the last name label
     */
    public void setLastNameLabel(JLabel lastNameLabel) {
        this.lastNameLabel = lastNameLabel;
    }

    /**
     * Gets picker.
     *
     * @return the picker
     */
    public DatePicker getPicker() {
        return picker;
    }

    /**
     * Sets picker.
     *
     * @param picker the picker
     */
    public void setPicker(DatePicker picker) {
        this.picker = picker;
    }

    /**
     * Gets birth date label.
     *
     * @return the birth date label
     */
    public JLabel getBirthDateLabel() {
        return birthDateLabel;
    }

    /**
     * Sets birth date label.
     *
     * @param birthDateLabel the birth date label
     */
    public void setBirthDateLabel(JLabel birthDateLabel) {
        this.birthDateLabel = birthDateLabel;
    }
}
