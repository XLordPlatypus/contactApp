package model.contactData;

import model.adress.Address;

import java.util.UUID;

/**
 * The type Private info.
 */
public class PrivateInfo {
    private final UUID id;
    private String phone;
    private String email;
    private Address address;

    /**
     * Instantiates a new Private info.
     *
     * @param privatePhone the private phone
     * @param privateEmail the private email
     * @param address      the address
     */
    public PrivateInfo(String privatePhone, String privateEmail, Address address) {
        this.id = UUID.randomUUID();
        this.phone = privatePhone;
        this.email = privateEmail;
        this.address = address;
    }

    /**
     * Instantiates a new Private info.
     *
     * @param id      the id
     * @param phone   the phone
     * @param email   the email
     * @param address the address
     */
    public PrivateInfo(UUID id, String phone, String email, Address address) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    /**
     * Instantiates a new Private info.
     */
    public PrivateInfo() {
        this.id = UUID.randomUUID();
    }

    /**
     * Instantiates a new Private info.
     *
     * @param id the id
     */
    public PrivateInfo(UUID id) {
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
        return this.phone;
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
     * Gets adress.
     *
     * @return the adress
     */
    public Address getAdress() {
        return address;
    }

    /**
     * Sets adress.
     *
     * @param address the address
     */
    public void setAdress(Address address) {
        this.address = address;
    }
}
