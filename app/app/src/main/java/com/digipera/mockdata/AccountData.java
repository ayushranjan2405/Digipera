package com.digipera.mockdata;

import com.digipera.dto.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountData {

    private final Map<String, Account> accountsTable;

    public AccountData() {
        accountsTable = new HashMap<>();
        accountsTable.put("shilpi",
                new Account("shilpi", 5000.00f, 0, 0, 0, "parent"));
        accountsTable.put("ishita",
                new Account("ishita", 3000.00f, 70, 115, 60, "dependent"));
        accountsTable.put("rohan",
                new Account("rohan",2000.00f, 60, 135, 61, "dependent"));
    }

//    public Account getAccount(String key) {
//        return accountsTable.get(key);
//    }

    public List<Account> getAccounts() {
        return new ArrayList<>(accountsTable.values());
    }
}
