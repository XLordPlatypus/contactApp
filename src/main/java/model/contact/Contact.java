package model.contact;

import model.contactData.BaseInfo;
import model.contactData.BusinessInfoList;
import model.contactData.PrivateInfoList;
import model.contactData.SocialMediaInfoList;

import java.util.UUID;

/**
 * The type Contact.
 */
public class Contact {
    private final UUID id;
    private BaseInfo baseInfo;
    private SocialMediaInfoList socialMediaInfoList;
    private PrivateInfoList privateInfoList;
    private BusinessInfoList businessInfoList;

    /**
     * Instantiates a new Contact.
     */
    public Contact() {
        super();
        this.id = UUID.randomUUID();
    }

    /**
     * Instantiates a new Contact.
     *
     * @param baseInfo            the base info
     * @param socialMediaInfoList the social media info list
     * @param privateInfoList     the private info list
     * @param businessInfoList    the business info list
     */
    public Contact(BaseInfo baseInfo, SocialMediaInfoList socialMediaInfoList, PrivateInfoList privateInfoList, BusinessInfoList businessInfoList) {
        this.id = UUID.randomUUID();
        this.baseInfo = baseInfo;
        this.socialMediaInfoList = socialMediaInfoList;
        this.privateInfoList = privateInfoList;
        this.businessInfoList = businessInfoList;
    }

    /**
     * Instantiates a new Contact.
     *
     * @param id                  the id
     * @param baseInfo            the base info
     * @param socialMediaInfoList the social media info list
     * @param privateInfoList     the private info list
     * @param businessInfoList    the business info list
     */
    public Contact(UUID id, BaseInfo baseInfo, SocialMediaInfoList socialMediaInfoList, PrivateInfoList privateInfoList, BusinessInfoList businessInfoList) {
        this.id = id;
        this.baseInfo = baseInfo;
        this.socialMediaInfoList = socialMediaInfoList;
        this.privateInfoList = privateInfoList;
        this.businessInfoList = businessInfoList;
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
     * Gets base info.
     *
     * @return the base info
     */
    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    /**
     * Sets base info.
     *
     * @param baseInfo the base info
     */
    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    /**
     * Gets social media info list.
     *
     * @return the social media info list
     */
    public SocialMediaInfoList getSocialMediaInfoList() {
        return socialMediaInfoList;
    }

    /**
     * Sets social media info list.
     *
     * @param socialMediaInfoList the social media info list
     */
    public void setSocialMediaInfoList(SocialMediaInfoList socialMediaInfoList) {
        this.socialMediaInfoList = socialMediaInfoList;
    }

    /**
     * Gets private info list.
     *
     * @return the private info list
     */
    public PrivateInfoList getPrivateInfoList() {
        return privateInfoList;
    }

    /**
     * Sets private info list.
     *
     * @param privateInfoList the private info list
     */
    public void setPrivateInfoList(PrivateInfoList privateInfoList) {
        this.privateInfoList = privateInfoList;
    }

    /**
     * Gets business info list.
     *
     * @return the business info list
     */
    public BusinessInfoList getBusinessInfoList() {
        return businessInfoList;
    }

    /**
     * Sets business info list.
     *
     * @param businessInfoList the business info list
     */
    public void setBusinessInfoList(BusinessInfoList businessInfoList) {
        this.businessInfoList = businessInfoList;
    }
}
