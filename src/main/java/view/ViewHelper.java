package view;

import controller.MainController;
import view.dtoHandler.contactDto.ContactDTO;
import view.dtoHandler.contactDtoData.BaseInfoDTO;

import java.util.UUID;

/**
 * The type View helper.
 */
public class ViewHelper {
    /**
     * Check contact.
     *
     * @param mainView the main view
     */
    public static void checkContact(MainView mainView) {
        if (mainView.getContactDialog() != null) {
            UUID id = mainView.getContactDialog().getContactId();
            BaseInfoDTO dto = MainController.getInstance().getContact(id).getBaseInfoDTO();
            if (dto.getFirstName() == null && dto.getLastName() == null && dto.getBirthDate() == null) {
                MainController.getInstance().deleteContact(id);
            }
        }
    }

    /**
     * Cleanup empty contacts.
     */
    public static void cleanupEmptyContacts() {
        for (ContactDTO dto : MainController.getInstance().getAllContacts().getContactDTOS()) {
            BaseInfoDTO baseInfoDto = MainController.getInstance().getContact(dto.getId()).getBaseInfoDTO();
            if (baseInfoDto.getFirstName() == null && baseInfoDto.getLastName() == null && baseInfoDto.getBirthDate() == null) {
                MainController.getInstance().deleteContact(dto.getId());
            }
        }
    }
}
