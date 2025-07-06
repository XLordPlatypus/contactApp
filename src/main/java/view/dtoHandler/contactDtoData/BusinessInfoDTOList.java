package view.dtoHandler.contactDtoData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Business info dto list.
 */
public class BusinessInfoDTOList {
    private List<BusinessInfoDTO> businessInfoDTOList;

    /**
     * Instantiates a new Business info dto list.
     */
    public BusinessInfoDTOList() {
        this.businessInfoDTOList = new ArrayList<>();
    }

    /**
     * Gets business info dto list.
     *
     * @return the business info dto list
     */
    public List<BusinessInfoDTO> getBusinessInfoDTOList() {
        return businessInfoDTOList;
    }

    /**
     * Sets business info dto list.
     *
     * @param businessInfoDTOList the business info dto list
     */
    public void setBusinessInfoDTOList(List<BusinessInfoDTO> businessInfoDTOList) {
        this.businessInfoDTOList = businessInfoDTOList;
    }

    /**
     * Gets business info dto.
     *
     * @param id the id
     * @return the business info dto
     */
    public BusinessInfoDTO getBusinessInfoDTO(UUID id) {
        for (BusinessInfoDTO businessInfoDTO : businessInfoDTOList) {
            if (businessInfoDTO.getId().equals(id)) {
                return businessInfoDTO;
            }
        }
        return null;
    }

    /**
     * Sets business info dto.
     *
     * @param businessInfoDTO the business info dto
     */
    public void setBusinessInfoDto(BusinessInfoDTO businessInfoDTO) {
        for (int i = 0; i < businessInfoDTOList.size(); i++) {
            if (businessInfoDTOList.get(i).getId().equals(businessInfoDTO.getId())) {
                businessInfoDTOList.set(i, businessInfoDTO);
            }
        }
    }

    /**
     * Does business info dto exist boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean doesBusinessInfoDTOExist(UUID id) {
        for (BusinessInfoDTO businessInfoDTO : businessInfoDTOList) {
            if (businessInfoDTO.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Replace business info dto.
     *
     * @param id              the id
     * @param businessInfoDTO the business info dto
     */
    public void replaceBusinessInfoDTO(UUID id, BusinessInfoDTO businessInfoDTO) {
        for (int i = 0; i < businessInfoDTOList.size(); i++) {
            if (businessInfoDTOList.get(i).getId().equals(id)) {
                businessInfoDTOList.set(i, businessInfoDTO);
            }
        }
    }
}
