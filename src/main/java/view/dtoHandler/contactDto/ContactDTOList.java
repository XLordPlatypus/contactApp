package view.dtoHandler.contactDto;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Contact dto list.
 */
public class ContactDTOList {
    private List<ContactDTO> contactDTOS;

    /**
     * Instantiates a new Contact dto list.
     */
    public ContactDTOList() {
        this.contactDTOS = new ArrayList<ContactDTO>();
    }

    /**
     * Gets contact dtos.
     *
     * @return the contact dtos
     */
    public List<ContactDTO> getContactDTOS() {
        return contactDTOS;
    }

    /**
     * Sets contact dtos.
     *
     * @param contactDTOS the contact dtos
     */
    public void setContactDTOS(List<ContactDTO> contactDTOS) {
        this.contactDTOS = contactDTOS;
    }
}
