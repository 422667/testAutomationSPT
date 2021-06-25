package com.sc.sym.utility;

import java.util.Map;

public class Staff_Customer_Portal {
    private static Map<String, Staff_Customer_Data> credentials;
    private static Map<String, SKU_Data> details;

    public static void loadCredentials(Map<String, Staff_Customer_Data> mapOfCredentials) {
        credentials = mapOfCredentials;
    }
    public static Staff_Customer_Data getData(String id) { return credentials.get(id); }
    
    public static void loaddetails(Map<String, SKU_Data> mapOfCredentials1) {
    	details = mapOfCredentials1;
    }
    
    public static SKU_Data getData1(String id) { return details.get(id); }
}
