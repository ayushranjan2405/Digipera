package com.digipera.dto;

public class Seller {

    private final String name;
    private final String phoneNo;
    private final String accNum;

    public Seller(String name, String phoneNo, String accNum) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.accNum = accNum;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAccNum() {
        return accNum;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", accNum='" + accNum + '\'' +
                '}';
    }
}
