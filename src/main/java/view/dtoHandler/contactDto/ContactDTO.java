package view.dtoHandler.contactDto;

import view.dtoHandler.contactDtoData.BaseInfoDTO;
import view.dtoHandler.contactDtoData.BusinessInfoDTOList;
import view.dtoHandler.contactDtoData.PrivateInfoDTOList;
import view.dtoHandler.contactDtoData.SocialMediaDTOList;

import java.util.UUID;

/**
 * The type Contact dto.
 */
public class ContactDTO {
    private UUID id;
    private BaseInfoDTO baseInfoDTO;
    private PrivateInfoDTOList privateInfoDTOList;
    private BusinessInfoDTOList businessInfoDTOList;
    private SocialMediaDTOList socialMediaDTOList;

    /**
     * Instantiates a new Contact dto.
     */
    public ContactDTO() {
        baseInfoDTO = new BaseInfoDTO();
        privateInfoDTOList = new PrivateInfoDTOList();
        businessInfoDTOList = new BusinessInfoDTOList();
        socialMediaDTOList = new SocialMediaDTOList();
    }

    /**
     * Instantiates a new Contact dto.
     *
     * @param id the id
     */
    public ContactDTO(UUID id) {
        this.id = id;
        baseInfoDTO = new BaseInfoDTO();
        privateInfoDTOList = new PrivateInfoDTOList();
        businessInfoDTOList = new BusinessInfoDTOList();
        socialMediaDTOList = new SocialMediaDTOList();
    }

    /**
     * Instantiates a new Contact dto.
     *
     * @param id                  the id
     * @param baseInfoDTO         the base info dto
     * @param privateInfoDTOList  the private info dto list
     * @param businessInfoDTOList the business info dto list
     * @param socialMediaDTOList  the social media dto list
     */
    public ContactDTO(UUID id, BaseInfoDTO baseInfoDTO, PrivateInfoDTOList privateInfoDTOList, BusinessInfoDTOList businessInfoDTOList, SocialMediaDTOList socialMediaDTOList) {
        this.id = id;
        this.baseInfoDTO = baseInfoDTO;
        this.privateInfoDTOList = privateInfoDTOList;
        this.businessInfoDTOList = businessInfoDTOList;
        this.socialMediaDTOList = socialMediaDTOList;
    }

    /**
     * Instantiates a new Contact dto.
     *
     * @param baseInfoDTO         the base info dto
     * @param privateInfoDTOList  the private info dto list
     * @param businessInfoDTOList the business info dto list
     * @param socialMediaDTOList  the social media dto list
     */
    public ContactDTO(BaseInfoDTO baseInfoDTO, PrivateInfoDTOList privateInfoDTOList, BusinessInfoDTOList businessInfoDTOList, SocialMediaDTOList socialMediaDTOList) {
        this.baseInfoDTO = baseInfoDTO;
        this.privateInfoDTOList = privateInfoDTOList;
        this.businessInfoDTOList = businessInfoDTOList;
        this.socialMediaDTOList = socialMediaDTOList;
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets base info dto.
     *
     * @return the base info dto
     */
    public BaseInfoDTO getBaseInfoDTO() {
        return baseInfoDTO;
    }

    /**
     * Sets base info dto.
     *
     * @param baseInfoDTO the base info dto
     */
    public void setBaseInfoDTO(BaseInfoDTO baseInfoDTO) {
        this.baseInfoDTO = baseInfoDTO;
    }

    /**
     * Gets private info dto list.
     *
     * @return the private info dto list
     */
    public PrivateInfoDTOList getPrivateInfoDTOList() {
        return privateInfoDTOList;
    }

    /**
     * Sets private info dto list.
     *
     * @param privateInfoDTOList the private info dto list
     */
    public void setPrivateInfoDTOList(PrivateInfoDTOList privateInfoDTOList) {
        this.privateInfoDTOList = privateInfoDTOList;
    }

    /**
     * Gets business info dto list.
     *
     * @return the business info dto list
     */
    public BusinessInfoDTOList getBusinessInfoDTOList() {
        return businessInfoDTOList;
    }

    /**
     * Sets business info dto list.
     *
     * @param businessInfoDTOList the business info dto list
     */
    public void setBusinessInfoDTOList(BusinessInfoDTOList businessInfoDTOList) {
        this.businessInfoDTOList = businessInfoDTOList;
    }

    /**
     * Gets social media dto list.
     *
     * @return the social media dto list
     */
    public SocialMediaDTOList getSocialMediaDTOList() {
        return socialMediaDTOList;
    }

    /**
     * Sets social media dto list.
     *
     * @param socialMediaDTOList the social media dto list
     */
    public void setSocialMediaDTOList(SocialMediaDTOList socialMediaDTOList) {
        this.socialMediaDTOList = socialMediaDTOList;
    }
}
