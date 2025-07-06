package model.contactData;

import java.util.UUID;

/**
 * The type Social media info.
 */
public class SocialMediaInfo {
    private final UUID id;
    private String platformName;
    private String userName;
    private String url;

    /**
     * Instantiates a new Social media info.
     *
     * @param platformName the platform name
     * @param userName     the user name
     * @param url          the url
     */
    public SocialMediaInfo(String platformName, String userName, String url) {
        this.id = UUID.randomUUID();
        this.platformName = platformName;
        this.userName = userName;
        this.url = url;
    }

    /**
     * Instantiates a new Social media info.
     *
     * @param id           the id
     * @param platformName the platform name
     * @param userName     the user name
     * @param url          the url
     */
    public SocialMediaInfo(UUID id, String platformName, String userName, String url) {
        this.id = id;
        this.platformName = platformName;
        this.userName = userName;
        this.url = url;
    }

    /**
     * Instantiates a new Social media info.
     */
    public SocialMediaInfo() {
        this.id = UUID.randomUUID();
    }

    /**
     * Instantiates a new Social media info.
     *
     * @param id the id
     */
    public SocialMediaInfo(UUID id) {
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
        return this.platformName;
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
        return this.userName;
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
        return this.url;
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
