package view.dtoHandler.contactDtoData;

import model.adress.Address;

import java.util.UUID;

/**
 * The type Business info dto.
 */
public class BusinessInfoDTO {
    private final UUID id;
    private String companyName;
    private String jobTitle;
    private String businessEmail;
    private String businessPhone;
    private Address address;

    /**
     * Instantiates a new Business info dto.
     */
    public BusinessInfoDTO() {
        id = UUID.randomUUID();
    }

    /**
     * Instantiates a new Business info dto.
     *
     * @param id the id
     */
    public BusinessInfoDTO(UUID id) {
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
        return companyName;
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
        return jobTitle;
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
     * Gets business email.
     *
     * @return the business email
     */
    public String getBusinessEmail() {
        return businessEmail;
    }

    /**
     * Sets business email.
     *
     * @param businessEmail the business email
     */
    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    /**
     * Gets business phone.
     *
     * @return the business phone
     */
    public String getBusinessPhone() {
        return businessPhone;
    }

    /**
     * Sets business phone.
     *
     * @param businessPhone the business phone
     */
    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
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
