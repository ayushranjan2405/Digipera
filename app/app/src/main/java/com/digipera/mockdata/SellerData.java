package com.digipera.mockdata;

import com.digipera.dto.Seller;

import java.util.HashMap;
import java.util.Map;

public class SellerData {

    Map<String, Seller> merchantTable;

    public SellerData(){
        this.merchantTable = new HashMap<>();
        merchantTable.put("9999999999", new Seller("Book shop", "9999999999","SHDS888989"));

    }
    public Seller getData(String phoneNumber) {
        return merchantTable.get(phoneNumber);
    }
}
