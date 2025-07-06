package model.contact;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Contact list.
 */
public class ContactList {
    private List<Contact> contacts;

    /**
     * Instantiates a new Contact list.
     */
    public ContactList() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Gets contacts.
     *
     * @return the contacts
     */
    public List<Contact> getContacts() {
        return this.contacts;
    }

    /**
     * Sets contacts.
     *
     * @param contacts the contacts
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
