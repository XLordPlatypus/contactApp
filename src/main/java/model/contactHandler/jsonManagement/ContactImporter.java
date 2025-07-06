package model.contactHandler.jsonManagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.contact.Contact;
import model.contact.ContactList;

import java.io.*;

/**
 * The type Contact importer.
 */
public class ContactImporter {
    private ObjectMapper mapper;

    /**
     * Instantiates a new Contact importer.
     */
    public ContactImporter() {
        this.mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        this.mapper.registerModule(javaTimeModule);
    }

    /**
     * Import contact as json contact.
     *
     * @param pathWithFile the path with file
     * @return the contact
     * @throws IOException the io exception
     */
    public Contact importContactAsJson(String pathWithFile) throws IOException {
        File file = new File(pathWithFile);
        InputStream inputStream = new FileInputStream(file);
        return this.mapper.readValue(inputStream, Contact.class);
    }

    /**
     * Import multiple contacts as json contact list.
     *
     * @param path the path
     * @return the contact list
     * @throws IOException the io exception
     */
    public ContactList importMultipleContactsAsJson(String path) throws IOException {
        File[] files = new File(path).listFiles();
        ContactList list = new ContactList();
        for (File file : files) {
            list.getContacts().add(importContactAsJson(file.getPath()));
        }
        return list;
    }
}