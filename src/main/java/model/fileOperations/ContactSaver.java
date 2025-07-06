package model.fileOperations;

import model.constants.ModelConstants;
import model.contact.Contact;
import model.contactHandler.ContactHandler;
import model.observer.contactCreated.IContactCreatedNotifier;

/**
 * The type Contact saver.
 */
public class ContactSaver {
    /**
     * Save contact.
     *
     * @param newContact             the new contact
     * @param contactCreatedNotifier the contact created notifier
     */
    public void saveContact(Contact newContact, IContactCreatedNotifier contactCreatedNotifier) {
        ContactHandler handler = new ContactHandler();

        /**
         * Exports a contact to disk
         */
        handler.exportContact(newContact,
                ModelConstants.DATA_PATH +
                        newContact.getId() + ".json"
        );
        contactCreatedNotifier.notifyObservers(newContact.getId());
    }
}
