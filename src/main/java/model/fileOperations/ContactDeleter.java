package model.fileOperations;

import model.constants.ModelConstants;
import model.contactHandler.ContactHandler;

import java.util.UUID;

/**
 * The type Contact deleter.
 */
public class ContactDeleter {

    /**
     * Deletes an contact
     *
     * @param contactId the id of the Contact that will be deleted
     */
    public void deleteContact(UUID contactId) {
        ContactHandler handler = new ContactHandler();
        handler.deleteContact(
                ModelConstants.DATA_PATH +
                        contactId + ".json"
        );
    }
}
