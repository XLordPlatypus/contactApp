package view.dtoHandler.contactDtoData;

import java.awt.image.BufferedImage;

/**
 * The type Base info dto.
 */
public class BaseInfoDTO {
    private String firstName;
    private String lastName;
    private String birthDate;
    private BufferedImage profilePicture;

    /**
     * Instantiates a new Base info dto.
     */
    public BaseInfoDTO() {}

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
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
    public String getBirthDate() {
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
    public BufferedImage getProfilePicture() {
        return profilePicture;
    }

    /**
     * Sets profile picture.
     *
     * @param profilePicture the profile picture
     */
    public void setProfilePicture(BufferedImage profilePicture) {
        this.profilePicture = profilePicture;
    }
}
