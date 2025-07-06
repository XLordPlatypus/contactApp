package model.adress;

/**
 * The type Address.
 */
public class Address {
    private String street;
    private String houseNumber;
    private String houseNumberAddon;
    private String zipCode;
    private String city;

    /**
     * Instantiates a new Address.
     *
     * @param street           the street
     * @param houseNumber      the house number
     * @param houseNumberAddon the house number addon
     * @param zipCode          the zip code
     * @param city             the city
     */
    public Address(String street, String houseNumber, String houseNumberAddon, String zipCode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.houseNumberAddon = houseNumberAddon;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     * Instantiates a new Address.
     */
    public Address() {
        super();
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * Sets street.
     *
     * @param street the street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets house number.
     *
     * @return the house number
     */
    public String getHouseNumber() {
        return this.houseNumber;
    }

    /**
     * Sets house number.
     *
     * @param houseNumber the house number
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Gets house number addon.
     *
     * @return the house number addon
     */
    public String getHouseNumberAddon() {
        return this.houseNumberAddon;
    }

    /**
     * Sets house number addon.
     *
     * @param houseNumberAddon the house number addon
     */
    public void setHouseNumberAddon(String houseNumberAddon) {
        this.houseNumberAddon = houseNumberAddon;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }
}
