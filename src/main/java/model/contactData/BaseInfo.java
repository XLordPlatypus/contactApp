package model.contactData;

/**
 * The type Base info.
 */
public class BaseInfo {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String profilePictureBase64;

    /**
     * Instantiates a new Base info.
     *
     * @param firstName      the first name
     * @param lastName       the last name
     * @param birthDate      the birth date
     * @param profilePicture the profile picture
     */
    public BaseInfo(String firstName, String lastName, String birthDate, String profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.profilePictureBase64 = profilePicture;
    }

    /**
     * Instantiates a new Base info.
     */
    public BaseInfo() {
        super();
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public String  getBirthDate() {
        return birthDate;
    }

    /**
     * Sets birth date.
     *
     * @param birthDate the birth date
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets profile picture.
     *
     * @return the profile picture
     */
    public String getProfilePicture() {
        return this.profilePictureBase64;
    }

    /**
     * Sets profile picture.
     *
     * @param profilePicture the profile picture
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePictureBase64 = profilePicture;
    }
}
