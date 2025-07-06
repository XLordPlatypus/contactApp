package view.dtoHandler.contactDtoData;

import java.util.UUID;

/**
 * The type Social media dto.
 */
public class SocialMediaDTO {
    private final UUID id;
    private String platformName;
    private String userName;
    private String url;

    /**
     * Instantiates a new Social media dto.
     */
    public SocialMediaDTO() {
        this.id = UUID.randomUUID();
    }

    /**
     * Instantiates a new Social media dto.
     *
     * @param id the id
     */
    public SocialMediaDTO(UUID id) {
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
     * Gets platform name.
     *
     * @return the platform name
     */
    public String getPlatformName() {
        return platformName;
    }

    /**
     * Sets platform name.
     *
     * @param platformName the platform name
     */
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
