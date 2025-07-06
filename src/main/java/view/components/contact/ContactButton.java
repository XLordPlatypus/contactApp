package view.components.contact;

import view.dtoHandler.contactDto.ContactDTO;
import view.MainView;
import view.components.dialogues.ContactDialog;
import view.constants.ViewConstants;

import javax.swing.*;
import java.util.UUID;

/**
 * The type Contact button.
 */
public class ContactButton extends JButton {
    private final UUID id;

    /**
     * Instantiates a new Contact button.
     *
     * @param contactDTO the contact dto
     * @param mainView   the main view
     */
    public ContactButton(ContactDTO contactDTO, MainView mainView) {
        this.id = contactDTO.getId();
        this.setText("<html>" + contactDTO.getBaseInfoDTO().getFirstName() + " " + contactDTO.getBaseInfoDTO().getLastName() + "<br>"
                + contactDTO.getBaseInfoDTO().getBirthDate());

        this.addActionListener(e -> {
            if (mainView.getContactDialog() != null) {
                mainView.getContactDialog().setVisible(false);
                mainView.getContactDialog().setEnabled(false);
            }
            mainView.setContactDialog(new ContactDialog(id, ViewConstants.DIALOG_WIDTH, ViewConstants.DIALOG_HEIGHT, mainView));
            mainView.getDisplayPanel().add(mainView.getContactDialog());
            mainView.getDisplayPanel().repaint();
            mainView.getDisplayPanel().revalidate();
        });
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }
}
