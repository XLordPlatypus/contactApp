package model.contactData;

import java.util.ArrayList;

/**
 * The type Private info list.
 */
public class PrivateInfoList {
    private ArrayList<PrivateInfo> privateInfos;

    /**
     * Instantiates a new Private info list.
     */
    public PrivateInfoList() {
        this.privateInfos = new ArrayList<>();
    }

    /**
     * Gets private infos.
     *
     * @return the private infos
     */
    public ArrayList<PrivateInfo> getPrivateInfos() {
        return this.privateInfos;
    }

    /**
     * Sets private info list.
     *
     * @param privateInfoList the private info list
     */
    public void setPrivateInfoList(ArrayList<PrivateInfo> privateInfoList) {
        this.privateInfos = privateInfoList;
    }
}
