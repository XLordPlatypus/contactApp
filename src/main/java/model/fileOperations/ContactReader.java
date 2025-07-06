package model.fileOperations;

import model.constants.ModelConstants;
import model.contact.Contact;
import model.contact.ContactList;
import model.contactHandler.ContactHandler;

import java.util.UUID;

import static java.lang.String.valueOf;

/**
 * The type Contact reader.
 */
public class ContactReader {
    private final ContactHandler handler = new ContactHandler();

    /**
     * Reads a contact
     *
     * @param contactId The id of the contact to read
     * @return The read contact data
     */
    public Contact readContact(UUID contactId) {
        return handler.importContact(
                ModelConstants.DATA_PATH +
                        contactId + ".json"
        );
    }

    /**
     * Read all contacts contact list.
     *
     * @return the contact list
     */
    public ContactList readAllContacts() {
        return handler.importContacts(
                ModelConstants.DATA_PATH
        );
    }
}
