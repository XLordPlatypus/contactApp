package main.test.java.model.contactTransfer;


import com.fasterxml.jackson.databind.ObjectMapper;
import main.test.TestHelper;
import model.contact.Contact;
import model.contact.ContactList;
import model.contactHandler.ContactHandler;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

import static org.junit.Assert.*;

/**
 * The type Contact handler test.
 */
public class ContactHandlerTest {
    /**
     * The Contact handler.
     */
    ContactHandler contactHandler = new ContactHandler();

    /**
     * Test importing contact from json file.
     */
    @Test
    public void testImportingContactFromJsonFile() {
        Contact methodImport = contactHandler.importContact(TestHelper.JSON_TEST_FILE1_PATH);
        Contact manualImport;
        try {
            File file = new File(TestHelper.JSON_TEST_FILE1_PATH);
            InputStream inputStream = new FileInputStream(file);
            ObjectMapper mapper = new ObjectMapper();
            manualImport = mapper.readValue(inputStream, Contact.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(manualImport);
        assertNotNull(methodImport);
        assertEquals(manualImport.getId(), methodImport.getId());
    }

    /**
     * Test importing contact with null.
     */
    @Test(expected = NullPointerException.class)
    public void testImportingContactWithNull() {
        assertNull(contactHandler.importContact(null));
    }

    /**
     * Test import contacts from json files.
     */
    @Test
    public void testImportContactsFromJsonFiles() {
        ContactList list = contactHandler.importContacts(TestHelper.JSON_TEST_IMPORT_PATH);
        assertNotNull(list);
        assertEquals(2, list.getContacts().size());
        assertNotEquals(list.getContacts().get(0).getId(), list.getContacts().get(1).getId());
    }

    /**
     * Test import contacts when null.
     */
    @Test(expected = NullPointerException.class)
    public void testImportContactsWhenNull() {
        assertNull(contactHandler.importContacts(null));
    }

    /**
     * Test export contact to json.
     */
    @Test
    public void testExportContactToJson() {
        Contact testContact = TestHelper.getTestContact();
        contactHandler.exportContact(testContact, TestHelper.JSON_TEST_EXPORT_PATH + testContact.getId() + ".json");

        File newContactJson = new File(TestHelper.JSON_TEST_EXPORT_PATH + testContact.getId() + ".json");
        assertTrue(newContactJson.exists());

        newContactJson.delete();
    }

    /**
     * Test export contact to json when path null.
     */
    @Test(expected = NullPointerException.class)
    public void testExportContactToJsonWhenPathNull() {
        Contact testContact = TestHelper.getTestContact();
        contactHandler.exportContact(testContact, null);

        File newContactJson = new File(TestHelper.JSON_TEST_IMPORT_PATH + testContact.getId() + ".json");
        assertFalse(newContactJson.exists());
    }

    /**
     * Test export contact to json when contact null.
     */
    @Test
    public void testExportContactToJsonWhenContactNull() {
        Contact testContact = TestHelper.getTestContact();
        contactHandler.exportContact(null, TestHelper.JSON_TEST_EXPORT_PATH + testContact.getId() + ".json");

        File newContactJson = new File(TestHelper.JSON_TEST_EXPORT_PATH + testContact.getId() + ".json");
        assertTrue(newContactJson.exists());

        newContactJson.delete();
    }

    /**
     * Test export multiple contacts to json.
     */
    @Test
    public void testExportMultipleContactsToJson() {
        Contact testContact1 = TestHelper.getTestContact();
        Contact testContact2 = TestHelper.getTestContact();

        ContactList list = new ContactList();
        list.getContacts().add(testContact1);
        list.getContacts().add(testContact2);

        contactHandler.exportMultipleContacs(list, TestHelper.JSON_TEST_EXPORT_PATH);

        File newContactJson1 = new File(TestHelper.JSON_TEST_EXPORT_PATH + testContact1.getId() + ".json");
        File newContactJson2 = new File(TestHelper.JSON_TEST_EXPORT_PATH + testContact2.getId() + ".json");

        assertTrue(newContactJson1.exists());
        assertTrue(newContactJson1.exists());

        newContactJson1.delete();
        newContactJson2.delete();
    }

    /**
     * Test delete contact.
     */
    @Test
    public void testDeleteContact() {
        Contact testContact = TestHelper.getTestContact();
        File file = new File(TestHelper.JSON_TEST_EXPORT_PATH + testContact.getId() + ".json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, testContact);
            contactHandler.deleteContact(TestHelper.JSON_TEST_EXPORT_PATH + testContact.getId() + ".json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertFalse(file.exists());
    }

    /**
     * Test import image.
     */
    @Test
    public void testImportImage() {
        BufferedImage image = contactHandler.importImage(TestHelper.IMG_TEST_IMPORT_PATH + "TestImage.png");
        assertNotNull(image);
    }

    /**
     * Image converter.
     */
    @Test
    public void imageConverter() {
        File image = new File(TestHelper.IMG_TEST_IMPORT_PATH + "TestImage.png");
        String base64Image;
        BufferedImage bufferedImage;
        try {
            base64Image = contactHandler.convertImage(ImageIO.read(image));
            bufferedImage = contactHandler.convertImage(base64Image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(bufferedImage);
        assertNotNull(base64Image);
    }
}
