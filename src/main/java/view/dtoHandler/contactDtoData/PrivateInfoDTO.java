package view.dtoHandler.contactDtoData;

import model.adress.Address;

import java.util.UUID;

/**
 * The type Private info dto.
 */
public class PrivateInfoDTO {
    private final UUID id;
    private String phone;
    private String email;
    private Address address;

    /**
     * Instantiates a new Private info dto.
     */
    public PrivateInfoDTO() {
        this.id = UUID.randomUUID();
    }

    /**
     * Instantiates a new Private info dto.
     *
     * @param id the id
     */
    public PrivateInfoDTO(UUID id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
