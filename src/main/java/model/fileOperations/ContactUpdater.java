package model.fileOperations;

import model.constants.ModelConstants;
import model.contact.Contact;
import model.contactHandler.ContactHandler;
import model.observer.contactUpdated.IContactUpdatedNotifier;

/**
 * The type Contact updater.
 */
public class ContactUpdater {

    /**
     * Updates a contact
     *
     * @param newContactInfo      The updated contact info
     * @param dataChangedNotifier the notifier to notify any observers
     */
    public void updateContact(Contact newContactInfo, IContactUpdatedNotifier dataChangedNotifier) {
        ContactHandler handler = new ContactHandler();
        Contact contactToUpdate = handler.importContact(
                ModelConstants.DATA_PATH +
                        newContactInfo.getId() + ".json"
        );
        contactToUpdate.setBaseInfo(newContactInfo.getBaseInfo());
        contactToUpdate.setBusinessInfoList(newContactInfo.getBusinessInfoList());
        contactToUpdate.setPrivateInfoList(newContactInfo.getPrivateInfoList());
        contactToUpdate.setSocialMediaInfoList(newContactInfo.getSocialMediaInfoList());

    handler.exportContact(contactToUpdate,
        ModelConstants.DATA_PATH +
                newContactInfo.getId() + ".json"
    );
        dataChangedNotifier.notifyObservers();
    }
}
