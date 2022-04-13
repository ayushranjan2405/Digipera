package com.digipera.services;

import android.content.Context;
import android.util.Log;

import com.digipera.dto.Account;
import com.digipera.mockdata.AccountData;
import com.digipera.repositories.AccountRepo;

import java.util.List;

public class AccountService extends BasicService{

    private final AccountRepo repo;

    public AccountService(Context context){
        super(context);
        this.repo= new AccountRepo(context);
    }

    public Account getAccount(String username){
        Log.i("Account_Service: ", username.toLowerCase());
        com.digipera.dao.Account account = repo.get(username.toLowerCase());
        return new Account(
                account.getHolderName(),
                account.getBalance(),
                account.getRewardPoints(),
                account.getDailyScreenTimeInMinutes(),
                account.getDailyActivityTimeInMinutes(),
                account.getUserType());
    }

    @Override
    public void initialLoad() {
        Log.i("TABLE_LOAD_ACCOUNT", "initialLoad");
        List<Account> accounts = new AccountData().getAccounts();
        accounts.forEach(account -> repo.insert(new com.digipera.dao.Account(
                account.getHolderName(),
                account.getBalance(),
                account.getRewardPoints(),
                account.getDailyScreenTimeInMinutes(),
                account.getDailyActivityTimeInMinutes(),
                account.getUserType())));
    }

    public void updateAccountBalance(String accountHolder, float balance) {
        com.digipera.dao.Account account = new com.digipera.dao.Account(
                accountHolder, balance, 0,
                0, 0, null);
        repo.update(account, accountHolder);
    }

}
