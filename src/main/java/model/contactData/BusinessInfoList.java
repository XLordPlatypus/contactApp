package model.contactData;

import java.util.ArrayList;

/**
 * The type Business info list.
 */
public class BusinessInfoList {
    private ArrayList<BusinessInfo> businessInfos;

    /**
     * Instantiates a new Business info list.
     */
    public BusinessInfoList() {
        businessInfos = new ArrayList<>();
    }

    /**
     * Gets business infos.
     *
     * @return the business infos
     */
    public ArrayList<BusinessInfo> getBusinessInfos() {
        return this.businessInfos;
    }

    /**
     * Sets business info list.
     *
     * @param businessInfoList the business info list
     */
    public void setBusinessInfoList(ArrayList<BusinessInfo> businessInfoList) {
        this.businessInfos = businessInfoList;
    }
}
