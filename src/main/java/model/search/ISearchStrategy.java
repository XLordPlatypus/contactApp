package model.search;

import view.dtoHandler.contactDto.ContactDTOList;

/**
 * The interface Search strategy.
 */
public interface ISearchStrategy {
    /**
     * Search contacts contact dto list.
     *
     * @param value the value
     * @return the contact dto list
     */
    ContactDTOList searchContacts(String value);
}
