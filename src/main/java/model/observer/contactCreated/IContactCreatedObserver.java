package model.observer.contactCreated;

import java.util.UUID;

/**
 * The interface Contact created observer.
 */
public interface IContactCreatedObserver {
    /**
     * On contact created.
     *
     * @param contactId the contact id
     */
    void onContactCreated(UUID contactId);
}
