package main.test;

import model.adress.Address;
import model.contact.Contact;
import model.contactData.*;

/**
 * The type Test helper.
 */
public class TestHelper {
    /**
     * The constant JSON_TEST_FILE1_PATH.
     */
    public static final String JSON_TEST_FILE1_PATH = "src/main/test/resources/imports/c0a6c666-2466-45ae-86e0-8cbc23d254cb.json";
    /**
     * The constant JSON_TEST_FILE2_PATH.
     */
    public static final String JSON_TEST_FILE2_PATH = "src/main/test/resources/imports/a0a6c666-2466-46ae-96e0-8dbb23d254cb.json";
    /**
     * The constant JSON_TEST_IMPORT_PATH.
     */
    public static final String JSON_TEST_IMPORT_PATH = "src/main/test/resources/imports/";
    /**
     * The constant JSON_TEST_EXPORT_PATH.
     */
    public static final String JSON_TEST_EXPORT_PATH = "src/main/test/resources/exports/";
    /**
     * The constant IMG_TEST_IMPORT_PATH.
     */
    public static final String IMG_TEST_IMPORT_PATH = "src/main/test/resources/img/";

    /**
     * Gets test contact.
     *
     * @return the test contact
     */
    public static Contact getTestContact() {
        Contact contact = new Contact(
                new BaseInfo("Ciaphas", "Cain", "10-02-2007", ""),
                new SocialMediaInfoList(),
                new PrivateInfoList(),
                new BusinessInfoList()
        );
        contact.getSocialMediaInfoList().getSocialMediaInfos().add(
                new SocialMediaInfo("Instagramm", "Cain", "https://example.com")
        );

        contact.getPrivateInfoList().getPrivateInfos().add(
                new PrivateInfo("+41 000 000", "081 111 111",
                new Address("Baumstrasse", "23", "", "9000", "St.Gallen"))
        );
        contact.getBusinessInfoList().getBusinessInfos().add(
                new BusinessInfo("", "", "", "",
                new Address("Gürterlstrasse", "14", "", "7000", "Chur"))
        );
        return contact;
    }
}
