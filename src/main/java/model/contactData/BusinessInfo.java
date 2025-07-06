package model.contactData;

import model.adress.Address;

import java.util.UUID;

/**
 * The type Business info.
 */
public class BusinessInfo {
    private final UUID id;
    private String companyName;
    private String jobTitle;
    private String email;
    private String phone;
    private Address address;

    /**
     * Instantiates a new Business info.
     *
     * @param companyName the company name
     * @param jobTitle    the job title
     * @param email       the email
     * @param phone       the phone
     * @param address     the address
     */
    public BusinessInfo(String companyName, String jobTitle, String email, String phone, Address address) {
        this.id = UUID.randomUUID();
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Instantiates a new Business info.
     *
     * @param id          the id
     * @param companyName the company name
     * @param jobTitle    the job title
     * @param email       the email
     * @param phone       the phone
     * @param address     the address
     */
    public BusinessInfo(UUID id, String companyName, String jobTitle, String email, String phone, Address address) {
        this.id = id;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Instantiates a new Business info.
     */
    public BusinessInfo() {
        this.id = UUID.randomUUID();
    }

    /**
     * Instantiates a new Business info.
     *
     * @param id the id
     */
    public BusinessInfo(UUID id) {
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
     * Gets company name.
     *
     * @return the company name
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * Sets company name.
     *
     * @param companyName the company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets job title.
     *
     * @return the job title
     */
    public String getJobTitle() {
        return this.jobTitle;
    }

    /**
     * Sets job title.
     *
     * @param jobTitle the job title
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
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
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return this.address;
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
