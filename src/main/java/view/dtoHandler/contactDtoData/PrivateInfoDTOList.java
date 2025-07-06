package view.dtoHandler.contactDtoData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Private info dto list.
 */
public class PrivateInfoDTOList {
    private List<PrivateInfoDTO> privateInfoDTOList;

    /**
     * Instantiates a new Private info dto list.
     */
    public PrivateInfoDTOList() {
        privateInfoDTOList = new ArrayList<PrivateInfoDTO>();
    }

    /**
     * Gets private info dto list.
     *
     * @return the private info dto list
     */
    public List<PrivateInfoDTO> getPrivateInfoDTOList() {
        return privateInfoDTOList;
    }

    /**
     * Sets private info dto list.
     *
     * @param privateInfoDTOList the private info dto list
     */
    public void setPrivateInfoDTOList(List<PrivateInfoDTO> privateInfoDTOList) {
        this.privateInfoDTOList = privateInfoDTOList;
    }

    /**
     * Gets private info dto.
     *
     * @param id the id
     * @return the private info dto
     */
    public PrivateInfoDTO getPrivateInfoDto(UUID id) {
        for (PrivateInfoDTO privateInfoDTO : privateInfoDTOList) {
            if (privateInfoDTO.getId().equals(id)) {
                return privateInfoDTO;
            }
        }
        return null;
    }

    /**
     * Sets private info dto.
     *
     * @param privateInfoDTO the private info dto
     */
    public void setPrivateInfoDto(PrivateInfoDTO privateInfoDTO) {
        for (int i = 0; i < privateInfoDTOList.size(); i++) {
            if (privateInfoDTOList.get(i).getId().equals(privateInfoDTO.getId())) {
                privateInfoDTOList.set(i, privateInfoDTO);
            }
        }
    }

    /**
     * Does private info dto exist boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean doesPrivateInfoDTOExist(UUID id) {
        for (PrivateInfoDTO privateInfoDTO : privateInfoDTOList) {
            if (privateInfoDTO.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Replace private info dto.
     *
     * @param id             the id
     * @param privateInfoDTO the private info dto
     */
    public void replacePrivateInfoDTO(UUID id, PrivateInfoDTO privateInfoDTO) {
        for (int i = 0; i < privateInfoDTOList.size(); i++) {
            if (privateInfoDTOList.get(i).getId().equals(id)) {
                privateInfoDTOList.set(i, privateInfoDTO);
            }
        }
    }
}
