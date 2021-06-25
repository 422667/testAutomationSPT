package com.sc.sym.constants;

public class ClientListingConstants {
    static Integer NumOfRowClientList;

    public static Integer getNumOfRowClientList() {
        return NumOfRowClientList;
    }

    public static void setNumOfRowClientList(Integer number) {
        NumOfRowClientList = number;
    }

	public static final String FILTER_CASH_BALANCE = "CASH_BALANCE";
	public static final String FILTER_FUND_AUM = "FUND_AUM";
	public static final String FILTER_BOND_AUM = "BOND_AUM";
}
