package com.digipera.mockdata;

import com.digipera.dto.Seller;

import java.util.HashMap;
import java.util.Map;

public class SellerData {

    Map<String, Seller> merchantTable;

    public SellerData(){
        this.merchantTable = new HashMap<>();
        merchantTable.put("9945800388", new Seller("Sapna Book Shop", "9945800388","SHDS888989"));

    }
    public Seller getData(String phoneNumber) {
        return merchantTable.get(phoneNumber);
    }
}
