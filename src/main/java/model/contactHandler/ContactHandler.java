package model.contactHandler;

import model.contact.Contact;
import model.contact.ContactList;
import model.contactHandler.imageManagement.ImageConverter;
import model.contactHandler.imageManagement.ImageImporter;
import model.contactHandler.jsonManagement.ContactExporter;
import model.contactHandler.jsonManagement.ContactImporter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ContactHandler handles all contact transfer operations with json
 */
public class ContactHandler {
    private final ImageImporter imageImporter;
    private final ContactImporter jsonImporter;
    private final ContactExporter jsonExporter;
    private final ImageConverter imageConverter;

    /**
     * Instantiates a new Contact handler.
     */
    public ContactHandler() {
        this.imageImporter = new ImageImporter();
        this.jsonImporter = new ContactImporter();
        this.jsonExporter = new ContactExporter();
        this.imageConverter = new ImageConverter();
    }

    /**
     * Imports one contact from Json and handles related errors
     *
     * @param fullPath represents the path including filename and file extension
     * @return imported Contact
     */
    public Contact importContact(String fullPath) {
        try {
            return this.jsonImporter.importContactAsJson(fullPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Imports multiple contacts from json and handles related errors
     *
     * @param fullPath represents the path including filename and file extension
     * @return multiple imported contacts
     */
    public ContactList importContacts(String fullPath) {
        try {
            return this.jsonImporter.importMultipleContactsAsJson(fullPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Exports one Contact to Json and handles related errors
     *
     * @param contact  represents the contact that is being exported
     * @param fullPath represents the path including filename and file extension
     */
    public void exportContact(Contact contact, String fullPath) {
        try {
            this.jsonExporter.exportContactAsJson(contact, fullPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Exports multiple Contact to Json and handles related errors
     *
     * @param contacts represents the ContactList that is being exported
     * @param fullPath represents the path to the directory where the contacts will be exported to
     */
    public void exportMultipleContacs(ContactList contacts, String fullPath) {
        try {
            this.jsonExporter.exportMultipleContactAsJson(contacts, fullPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes one contact file and handles related errors
     *
     * @param fullPath represents the path including filename and file extension
     */
    public void deleteContact(String fullPath) {
        try {
            File file = new File(fullPath);
            if (!file.delete()) {
                throw new RuntimeException("Failed to delete file: " + file.getAbsolutePath());
            }
        } catch (RuntimeException ignored) {}
    }

    /**
     * Imports one image and handles related errors
     *
     * @param fullPath represents the path including filename and file extension
     * @return returns the imported image as a BufferedImage
     */
    public BufferedImage importImage(String fullPath) {
        try {
            return this.imageImporter.importImage(fullPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a BufferedImage to base64 encoding and handles related errors
     *
     * @param image buffered image that will be converted
     * @return returns a base64 String data of the
     */
    public String convertImage(BufferedImage image) {
        try {
            return this.imageConverter.convertImageToBinary(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a base64 string to a Buffered Image and handles related errors
     *
     * @param image string containing base64 data of the image
     * @return the converted BufferedImage
     */
    public BufferedImage convertImage(String image) {
        try {
            return this.imageConverter.convertBinaryToImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
