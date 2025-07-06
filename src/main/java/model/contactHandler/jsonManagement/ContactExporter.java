package model.contactHandler.jsonManagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.contact.Contact;
import model.contact.ContactList;

import java.io.File;
import java.io.IOException;

/**
 * The type Contact exporter.
 */
public class ContactExporter {

    private final ObjectMapper mapper;

    /**
     * Instantiates a new Contact exporter.
     */
    public ContactExporter() {
        this.mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        this.mapper.registerModule(javaTimeModule);
    }

    /**
     * Export contact as json.
     *
     * @param object the object
     * @param path   the path
     * @throws IOException the io exception
     */
    public void exportContactAsJson(Contact object, String path) throws IOException {
        File file = new File(path);
        this.mapper.writerWithDefaultPrettyPrinter().writeValue(file, object);
    }

    /**
     * Export multiple contact as json.
     *
     * @param contacts the contacts
     * @param path     the path
     * @throws IOException the io exception
     */
    public void exportMultipleContactAsJson(ContactList contacts, String path) throws IOException {
        File folderToPutJsonFilesIn = new File(path);
        for (Contact contact : contacts.getContacts()) {
            exportContactAsJson(contact, folderToPutJsonFilesIn.getPath() + "\\" + contact.getId() + ".json");
        }
    }
}
