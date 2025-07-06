package controller;

import view.dtoHandler.DTOConverter;
import view.dtoHandler.contactDto.ContactDTO;
import view.dtoHandler.contactDto.ContactDTOList;
import model.constants.ModelConstants;
import model.contact.Contact;
import model.contactData.BaseInfo;
import model.contactData.BusinessInfoList;
import model.contactData.PrivateInfoList;
import model.contactData.SocialMediaInfoList;
import model.fileOperations.*;
import model.observer.contactCreated.ContactCreatedObserver;
import model.observer.contactCreated.IContactCreatedNotifier;
import model.observer.contactUpdated.ContactUpdatedNotifier;
import model.observer.contactUpdated.IContactUpdatedNotifier;
import model.search.ISearchStrategy;
import model.search.SearchStrategyList;
import model.search.strategies.NameStrategy;

import java.io.File;
import java.util.UUID;

/**
 * The type Main controller.
 */
public class MainController {

    private static MainController instance;
    private final DTOConverter converter = new DTOConverter();
    private final IContactCreatedNotifier contactCreatedNotifier;
    private final IContactUpdatedNotifier contactUpdatedNotifier;

    private MainController() {
        File file = new File(ModelConstants.DATA_PATH);
        if (!file.isDirectory() && !file.exists()) {
            file.mkdir();
        }
        contactCreatedNotifier = new ContactCreatedObserver();
        contactUpdatedNotifier = new ContactUpdatedNotifier();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    /**
     * Create contact.
     */
    public void createContact() {
        ContactSaver saver = new ContactSaver();
        Contact newContact = new Contact(new BaseInfo(), new SocialMediaInfoList(), new PrivateInfoList(), new BusinessInfoList());
        saver.saveContact(newContact, contactCreatedNotifier);
    }

    /**
     * Delete contact.
     *
     * @param contactId the contact id
     */
    public void deleteContact(UUID contactId) {
        ContactDeleter deletion = new ContactDeleter();
        deletion.deleteContact(contactId);
    }

    /**
     * Update contact.
     *
     * @param contactDataToUpdate the contact data to update
     */
    public void updateContact(ContactDTO contactDataToUpdate) {
        ContactUpdater updater = new ContactUpdater();
        updater.updateContact(converter.convertToContact(contactDataToUpdate), contactUpdatedNotifier);
    }

    /**
     * Gets contact.
     *
     * @param contactId the contact id
     * @return the contact
     */
    public ContactDTO getContact(UUID contactId) {
        ContactReader reader = new ContactReader();
        return converter.convertToDTO(reader.readContact(contactId));
    }

    /**
     * Gets all contacts.
     *
     * @return the all contacts
     */
    public ContactDTOList getAllContacts() {
        ContactReader reader = new ContactReader();
        ContactDTOList list = new ContactDTOList();
        for (Contact contact : reader.readAllContacts().getContacts()) {
            list.getContactDTOS().add(converter.convertToDTO(contact));
        }
        return list;
    }

    /**
     * Search contact contact dto list.
     *
     * @param value the value
     * @return the contact dto list
     */
    public ContactDTOList searchContact(String value) {
        ContactDTOList searchData = new ContactDTOList();
        SearchStrategyList searchStrategyList = new SearchStrategyList();
        // TODO: there has to be a better way than this:
        new NameStrategy(searchStrategyList);
        for (ISearchStrategy strategy : searchStrategyList.getStrategies()) {
            searchData.getContactDTOS().removeAll(strategy.searchContacts(value).getContactDTOS());
            searchData.getContactDTOS().addAll(strategy.searchContacts(value).getContactDTOS());
        }
        return searchData;
    }

    /**
     * Gets contact created notifier.
     *
     * @return the contact created notifier
     */
    public IContactCreatedNotifier getContactCreatedNotifier() {
        return contactCreatedNotifier;
    }

    /**
     * Gets contact updated notifier.
     *
     * @return the contact updated notifier
     */
    public IContactUpdatedNotifier getContactUpdatedNotifier() {
        return contactUpdatedNotifier;
    }
}
