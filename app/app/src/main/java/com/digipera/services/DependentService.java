package com.digipera.services;

import android.content.Context;

import com.digipera.dto.Dependent;
import com.digipera.mockdata.DependentData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DependentService {

//    public static List<Dependent> getDependents() {
//        DependentData dependentData = new DependentData();
//        return dependentData.getDependents(accountService);
//    }

    public static List<Dependent> getInflatedDependents(Context context) {

        AccountService accountService = new AccountService(context);
        DependentData dependentData = new DependentData(accountService);

        List<Dependent> dependents = dependentData.getDependents();
        //addDependentAccountDetails(context, dependentData.getDependents(accountService));
        return inflateDependentList(dependents);
    }

    private static List<Dependent> inflateDependentList(List<Dependent> dependents) {
        List<Dependent> dependentList = new ArrayList<>();
        //Creating duplicate dependents to keep cards coming
        int counter = 10;
        for (int i = 0; i < counter; i++) {
            dependentList.addAll(dependents);
        }
        return dependentList;
    }

//    private static void addDependentAccountDetails(Context context, List<Dependent> dependents) {
//        AccountService accountService = new AccountService(context);
//        dependents.forEach(dependent -> {
//           Account account =  accountService.getAccount(dependent.getFirstname().toLowerCase());
//           dependent.setBalance(account.getBalance());
//           dependent.setRewardPoints(account.getRewardPoints());
//        });
//    }


    public static List<String> getDependentNames(Context context) {
        AccountService accountService = new AccountService(context);
        DependentData dependentData = new DependentData(accountService);
        return dependentData.getDependentNames();
    }
}
