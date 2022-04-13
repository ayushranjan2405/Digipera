package com.digipera.services;

import com.digipera.dto.Seller;
import com.digipera.mockdata.SellerData;

public class SellerService {
    public static Seller getMerchant(String phoneNumber) {
        return new SellerData().getData(phoneNumber);
    }
}
