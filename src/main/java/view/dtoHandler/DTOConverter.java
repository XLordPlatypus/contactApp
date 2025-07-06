package view.dtoHandler;

import view.dtoHandler.contactDto.ContactDTO;

import model.contact.Contact;

import model.contactData.*;
import model.contactHandler.ContactHandler;
import view.dtoHandler.contactDtoData.*;

/**
 * The type Dto converter.
 */
public class DTOConverter {
    /**
     * Convert to contact.
     *
     * @param dto the dto
     * @return the contact
     */
    public Contact convertToContact(ContactDTO dto) {
        ContactHandler handler = new ContactHandler();

        BaseInfo baseInfo = new BaseInfo();
        PrivateInfoList privateInfoList = new PrivateInfoList();
        BusinessInfoList businessInfoList = new BusinessInfoList();
        SocialMediaInfoList socialMediaInfoList = new SocialMediaInfoList();

        baseInfo.setFirstName(dto.getBaseInfoDTO().getFirstName());
        baseInfo.setLastName(dto.getBaseInfoDTO().getLastName());
        baseInfo.setBirthDate(dto.getBaseInfoDTO().getBirthDate());
        if (dto.getBaseInfoDTO().getProfilePicture() != null) {
            baseInfo.setProfilePicture(handler.convertImage(dto.getBaseInfoDTO().getProfilePicture()));
        }

        for (PrivateInfoDTO privateInfoDTO : dto.getPrivateInfoDTOList().getPrivateInfoDTOList()) {
            PrivateInfo privateInfo = new PrivateInfo(privateInfoDTO.getId());
            privateInfo.setEmail(privateInfoDTO.getEmail());
            privateInfo.setPhone(privateInfoDTO.getPhone());
            privateInfo.setAdress(privateInfoDTO.getAddress());
            privateInfoList.getPrivateInfos().add(privateInfo);
        }

        for (BusinessInfoDTO businessInfoDTO : dto.getBusinessInfoDTOList().getBusinessInfoDTOList()) {
            BusinessInfo businessInfo = new BusinessInfo(businessInfoDTO.getId());
            businessInfo.setCompanyName(businessInfoDTO.getCompanyName());
            businessInfo.setAddress(businessInfoDTO.getAddress());
            businessInfo.setEmail(businessInfoDTO.getBusinessEmail());
            businessInfo.setPhone(businessInfoDTO.getBusinessPhone());
            businessInfo.setJobTitle(businessInfoDTO.getJobTitle());
            businessInfoList.getBusinessInfos().add(businessInfo);
        }

        for (SocialMediaDTO socialMediaDTO : dto.getSocialMediaDTOList().getSocialMediaDTOList()) {
            SocialMediaInfo socialMediaInfo = new SocialMediaInfo(socialMediaDTO.getId());
            socialMediaInfo.setUserName(socialMediaDTO.getUserName());
            socialMediaInfo.setPlatformName(socialMediaDTO.getPlatformName());
            socialMediaInfo.setUrl(socialMediaDTO.getUrl());
            socialMediaInfoList.getSocialMediaInfos().add(socialMediaInfo);
        }
        return new Contact(dto.getId(), baseInfo, socialMediaInfoList, privateInfoList, businessInfoList);
    }

    /**
     * Convert to dto contact dto.
     *
     * @param contact the contact
     * @return the contact dto
     */
    public ContactDTO convertToDTO(Contact contact) {
        ContactHandler handler = new ContactHandler();

        BaseInfoDTO baseInfoDTO = new BaseInfoDTO();
        PrivateInfoDTOList privateInfoDTOList = new PrivateInfoDTOList();
        BusinessInfoDTOList businessInfoDTOList = new BusinessInfoDTOList();
        SocialMediaDTOList socialMediaInfoDTOList = new SocialMediaDTOList();

        baseInfoDTO.setFirstName(contact.getBaseInfo().getFirstName());
        baseInfoDTO.setLastName(contact.getBaseInfo().getLastName());
        baseInfoDTO.setBirthDate(contact.getBaseInfo().getBirthDate());
        if (contact.getBaseInfo().getProfilePicture() != null) {
            baseInfoDTO.setProfilePicture(handler.convertImage(contact.getBaseInfo().getProfilePicture()));
        }

        for (PrivateInfo privateInfo : contact.getPrivateInfoList().getPrivateInfos()) {
            PrivateInfoDTO privateInfoDTO = new PrivateInfoDTO(privateInfo.getId());
            privateInfoDTO.setEmail(privateInfo.getEmail());
            privateInfoDTO.setPhone(privateInfo.getPhone());
            privateInfoDTO.setAddress(privateInfo.getAdress());
            privateInfoDTOList.getPrivateInfoDTOList().add(privateInfoDTO);
        }

        for (BusinessInfo businessInfo : contact.getBusinessInfoList().getBusinessInfos()) {
            BusinessInfoDTO businessInfoDTO = new BusinessInfoDTO(businessInfo.getId());
            businessInfoDTO.setCompanyName(businessInfo.getCompanyName());
            businessInfoDTO.setAddress(businessInfo.getAddress());
            businessInfoDTO.setBusinessEmail(businessInfo.getEmail());
            businessInfoDTO.setBusinessPhone(businessInfo.getPhone());
            businessInfoDTO.setJobTitle(businessInfo.getJobTitle());
            businessInfoDTOList.getBusinessInfoDTOList().add(businessInfoDTO);
        }

        for (SocialMediaInfo socialMediaInfo : contact.getSocialMediaInfoList().getSocialMediaInfos()) {
            SocialMediaDTO socialMediaInfoDTO = new SocialMediaDTO(socialMediaInfo.getId());
            socialMediaInfoDTO.setUserName(socialMediaInfo.getUserName());
            socialMediaInfoDTO.setPlatformName(socialMediaInfo.getPlatformName());
            socialMediaInfoDTO.setUrl(socialMediaInfo.getUrl());
            socialMediaInfoDTOList.getSocialMediaDTOList().add(socialMediaInfoDTO);
        }
        return new ContactDTO(contact.getId(), baseInfoDTO, privateInfoDTOList, businessInfoDTOList, socialMediaInfoDTOList);
    }
}
