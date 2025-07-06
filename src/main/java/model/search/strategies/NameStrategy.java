package model.search.strategies;

import view.dtoHandler.DTOConverter;
import view.dtoHandler.contactDto.ContactDTOList;
import model.contact.Contact;
import model.contact.ContactList;
import model.fileOperations.ContactReader;
import model.search.ISearchStrategy;
import model.search.SearchStrategyList;

/**
 * NameStrategy
 * Searches based on first and lastname
 * More strategies could be added in the same package
 */
public class NameStrategy implements ISearchStrategy {

    /**
     * Instantiates a new Name strategy.
     *
     * @param searchStrategyList the search strategy list
     */
    public NameStrategy(SearchStrategyList searchStrategyList) {
        searchStrategyList.getStrategies().add(this);
    }

    /**
     * Searches based on first and lastname
     * @param name the searched Contact name
     * @return matching Contacts
     */
    @Override
    public ContactDTOList searchContacts(String name) {
        ContactReader reader = new ContactReader();
        ContactList contactList = reader.readAllContacts();
        DTOConverter converter = new DTOConverter();
        ContactDTOList contactDTOList = new ContactDTOList();
        for (Contact contact : contactList.getContacts()) {
            if (!contact.getBaseInfo().getFirstName().isEmpty() && !contact.getBaseInfo().getLastName().isEmpty()) {
                if (contact.getBaseInfo().getFirstName().toLowerCase().contains(name.toLowerCase())) {
                    contactDTOList.getContactDTOS().add(converter.convertToDTO(contact));
                } else if (contact.getBaseInfo().getLastName().toLowerCase().contains(name.toLowerCase())) {
                    contactDTOList.getContactDTOS().add(converter.convertToDTO(contact));
                }
            }
        }
        return contactDTOList;
    }
}
