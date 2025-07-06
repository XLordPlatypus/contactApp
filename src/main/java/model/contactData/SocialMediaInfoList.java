package model.contactData;

import java.util.ArrayList;

/**
 * The type Social media info list.
 */
public class SocialMediaInfoList {
    private ArrayList<SocialMediaInfo> socialMediaInfos;

    /**
     * Instantiates a new Social media info list.
     */
    public SocialMediaInfoList() {
        this.socialMediaInfos = new ArrayList<>();
    }

    /**
     * Gets social media infos.
     *
     * @return the social media infos
     */
    public ArrayList<SocialMediaInfo> getSocialMediaInfos() {
        return this.socialMediaInfos;
    }

    /**
     * Sets social media infos.
     *
     * @param socialMediaInfos the social media infos
     */
    public void setSocialMediaInfos(ArrayList<SocialMediaInfo> socialMediaInfos) {
        this.socialMediaInfos = socialMediaInfos;
    }
}
