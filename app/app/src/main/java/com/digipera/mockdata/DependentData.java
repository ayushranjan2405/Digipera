package com.digipera.mockdata;

import com.digipera.commons.Constants;
import com.digipera.dto.Account;
import com.digipera.dto.Dependent;
import com.digipera.services.AccountService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DependentData {

    private final Map<String, Dependent> dependents;
    private final AccountService accountService;

    public DependentData(AccountService accountService) {
        dependents = new HashMap<>();
        this.accountService = accountService;
        dependents.put(Constants.ISHITA_USERNAME, getDependent(Constants.ISHITA_USERNAME, Constants.ISHITA_FIRSTNAME, Constants.ISHITA_LASTNAME));
        dependents.put(Constants.ROHAN_USERNAME, getDependent(Constants.ROHAN_USERNAME, Constants.ROHAN_FIRSTNAME, Constants.ROHAN_LASTNAME));
    }

    public List<Dependent> getDependents() {
        return new ArrayList<>(dependents.values());
    }

    public List<String> getDependentNames() {

        return dependents.values()
                .stream()
                .map(Dependent::getFirstname)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Dependent getDependent(String username, String firstName, String lastName) {
        Account account = accountService.getAccount(username);
        return new Dependent(firstName, lastName, account.getBalance(), account.getRewardPoints());
    }
}
