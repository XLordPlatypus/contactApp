package model.adress;

import java.util.ArrayList;

/**
 * The type Address list.
 */
public class AddressList {
    private ArrayList<Address> addresses;

    /**
     * Instantiates a new Address list.
     */
    public AddressList() {
        this.addresses = new ArrayList<>();
    }

    /**
     * Gets adress list.
     *
     * @return the adress list
     */
    public ArrayList<Address> getAdressList() {
        return this.addresses;
    }

    /**
     * Sets adress list.
     *
     * @param addressList the address list
     */
    public void setAdressList(ArrayList<Address> addressList) {
        this.addresses = addressList;
    }
}
