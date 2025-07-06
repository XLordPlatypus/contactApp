package view.dtoHandler.contactDtoData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Social media dto list.
 */
public class SocialMediaDTOList {
    private List<SocialMediaDTO> socialMediaDTOList;

    /**
     * Instantiates a new Social media dto list.
     */
    public SocialMediaDTOList() {
        this.socialMediaDTOList = new ArrayList<>();
    }

    /**
     * Gets social media dto list.
     *
     * @return the social media dto list
     */
    public List<SocialMediaDTO> getSocialMediaDTOList() {
        return socialMediaDTOList;
    }

    /**
     * Sets social media dto list.
     *
     * @param socialMediaDTOList the social media dto list
     */
    public void setSocialMediaDTOList(List<SocialMediaDTO> socialMediaDTOList) {
        this.socialMediaDTOList = socialMediaDTOList;
    }

    /**
     * Gets social media dto.
     *
     * @param id the id
     * @return the social media dto
     */
    public SocialMediaDTO getSocialMediaDTO(UUID id) {
        for (SocialMediaDTO socialMediaDTO : socialMediaDTOList) {
            if (socialMediaDTO.getId().equals(id)) {
                return socialMediaDTO;
            }
        }
        return null;
    }

    /**
     * Does social media dto exist boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean doesSocialMediaDTOExist(UUID id) {
        for (SocialMediaDTO socialMediaDTO : socialMediaDTOList) {
            if (socialMediaDTO.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Replace social media dto.
     *
     * @param id             the id
     * @param socialMediaDTO the social media dto
     */
    public void replaceSocialMediaDTO(UUID id, SocialMediaDTO socialMediaDTO) {
        for (int i = 0; i < socialMediaDTOList.size(); i++) {
            if (socialMediaDTOList.get(i).getId().equals(id)) {
                socialMediaDTOList.set(i, socialMediaDTO);
            }
        }
    }
}
