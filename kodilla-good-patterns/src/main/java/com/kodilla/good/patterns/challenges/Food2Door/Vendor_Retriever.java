package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;

public class Vendor_Retriever {

    public ArrayList<Vendor> vendorList = new ArrayList<>();

    public ArrayList<Vendor> initializeVendorList() {

        Vendor vendor1 = new Vendor(
                "V_0001",
                "Extra Food Shop",
                "extrafoodshop@wp.pl",
                "123-456-789",
                "Magnuszew, ul. Mazowiecka 15",
                3);

        Vendor vendor2 = new Vendor(
                "V_0002",
                "Gluten Free Shop",
                "glutenfreeshop@gmail.com",
                "982-457-444",
                "Rawa Mazowiecka, ul. Szeroka 11",
                5);

        Vendor vendor3 = new Vendor(
                "V_0003",
                "Healthy Shop",
                "healthyshop@onet.pl",
                "308-720-591",
                "Warka, ul. Armii Krajowej 3",
                1);

        vendorList.add(vendor1);
        vendorList.add(vendor2);
        vendorList.add(vendor3);

        return vendorList;
    }

    public Vendor retrieveVendorByID (String searchID) {

        Vendor foundVendor = new Vendor();
        initializeVendorList();

        for (Vendor vendor : vendorList) {
            if (vendor.getVendorID() == searchID) {
                foundVendor = vendor;
                break;
            }
        }
        return foundVendor;
    }

    public Vendor retrieveVendorByName (String searchName) {

        Vendor foundVendor = new Vendor();
        initializeVendorList();

        for (Vendor vendor : vendorList) {
            if (vendor.getVendorName() == searchName) {
                foundVendor = vendor;
                break;
            }
        }
        return foundVendor;
    }


}
