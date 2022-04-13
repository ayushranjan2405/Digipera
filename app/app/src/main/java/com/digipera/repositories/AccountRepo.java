package com.digipera.repositories;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.digipera.dao.Account;
import com.digipera.repositories.configs.AccountConfig;

import java.util.List;

public class AccountRepo extends BasicRepository<Account, String> {

    public AccountRepo(Context context) {
        super(context, new AccountConfig(), AccountConfig.CREATE_TABLE, AccountConfig.DROP_TABLE);
    }

    @Override
    public void insert(Account account) {
        SQLiteDatabase dbb = factory.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AccountConfig.HOLDER_NAME, account.getHolderName());
        contentValues.put(AccountConfig.BALANCE, account.getBalance());
        contentValues.put(AccountConfig.REWARD_POINTS, account.getRewardPoints());
        contentValues.put(AccountConfig.DAILY_ACTIVITY_TIME, account.getDailyActivityTimeInMinutes());
        contentValues.put(AccountConfig.DAILY_SCREEN_TIME, account.getDailyScreenTimeInMinutes());
        contentValues.put(AccountConfig.USER_TYPE, account.getUserType());
        dbb.insert(AccountConfig.TABLE_NAME, null, contentValues);
    }

    @Override
    public void insertAll(List<Account> object) {

    }

    @Override
    public void update(Account account, String accountHolderName) {
        Log.i("UPDATE_ACCOUNT_HOLDER_NAME", accountHolderName);
        Log.i("UPDATE_ACCOUNT_BALANCE", Float.toString(account.getBalance()));
        SQLiteDatabase db = factory.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AccountConfig.BALANCE, account.getBalance());
        String[] whereArgs = {accountHolderName.toLowerCase()};
        db.update(AccountConfig.TABLE_NAME, contentValues, AccountConfig.HOLDER_NAME + " = ?", whereArgs);
    }

    @Override
    public void delete(String accountHolderName) {
        SQLiteDatabase db = factory.getWritableDatabase();
        String[] whereArgs = {accountHolderName};
        db.delete(AccountConfig.TABLE_NAME, AccountConfig.HOLDER_NAME + " = ?", whereArgs);
    }

    @Override
    public Account get(String accountHolderName) {
        Log.i("GET_ACCOUNT_FOR", accountHolderName);
        SQLiteDatabase db = factory.getWritableDatabase();
        Account account = null;

        String[] columns = {
                AccountConfig.HOLDER_NAME,
                AccountConfig.BALANCE,
                AccountConfig.REWARD_POINTS,
                AccountConfig.DAILY_SCREEN_TIME,
                AccountConfig.DAILY_ACTIVITY_TIME,
                AccountConfig.USER_TYPE
        };

        String[] whereArgs = {accountHolderName};
        Cursor cursor = db.query(AccountConfig.TABLE_NAME, columns, AccountConfig.HOLDER_NAME + "=?", whereArgs, null, null, null);
        Log.i("GET_ACCOUNT_CURSOR", Integer.toString(cursor.getCount()));
        cursor.moveToFirst();
        if (!cursor.isNull(0)) {
            @SuppressLint("Range") String holderName = cursor.getString(cursor.getColumnIndex(AccountConfig.HOLDER_NAME));
            @SuppressLint("Range") float balance = cursor.getFloat(cursor.getColumnIndex(AccountConfig.BALANCE));
            @SuppressLint("Range") int rewardPoints = cursor.getInt(cursor.getColumnIndex(AccountConfig.REWARD_POINTS));
            @SuppressLint("Range") int screenTime = cursor.getInt(cursor.getColumnIndex(AccountConfig.DAILY_SCREEN_TIME));
            @SuppressLint("Range") int activityTime = cursor.getInt(cursor.getColumnIndex(AccountConfig.DAILY_ACTIVITY_TIME));
            @SuppressLint("Range") String userType = cursor.getString(cursor.getColumnIndex(AccountConfig.USER_TYPE));
            account = new Account(holderName, balance, rewardPoints, screenTime, activityTime, userType);
        }
        Log.i("GET_ACCOUNT", account.toString());
        cursor.close();
        return account;
    }

    @Override
    public List<Account> getAll(String key) {
        return null;
    }


//    public List<Account> getAccounts() {
//
//        SQLiteDatabase db = factory.getWritableDatabase();
//        List<Account> accounts = new ArrayList<>();
//
//        String[] columns = {
//                AccountConfig.HOLDER_NAME,
//                AccountConfig.BALANCE,
//                AccountConfig.REWARD_POINTS,
//                AccountConfig.DAILY_SCREEN_TIME,
//                AccountConfig.DAILY_ACTIVITY_TIME
//        };
//        Cursor cursor = db.query(AccountConfig.TABLE_NAME, columns, null, null, null, null, null);
//        while (cursor.moveToNext()) {
//            @SuppressLint("Range") String holderName = cursor.getString(cursor.getColumnIndex(AccountConfig.HOLDER_NAME));
//            @SuppressLint("Range") float balance = cursor.getFloat(cursor.getColumnIndex(AccountConfig.BALANCE));
//            @SuppressLint("Range") int rewardPoints = cursor.getInt(cursor.getColumnIndex(AccountConfig.REWARD_POINTS));
//            @SuppressLint("Range") int screenTime = cursor.getInt(cursor.getColumnIndex(AccountConfig.DAILY_SCREEN_TIME));
//            @SuppressLint("Range") int activityTime = cursor.getInt(cursor.getColumnIndex(AccountConfig.DAILY_ACTIVITY_TIME));
//            @SuppressLint("Range") String userType = cursor.getString(cursor.getColumnIndex(AccountConfig.USER_TYPE));
//            accounts.add(new Account(holderName, balance, rewardPoints, screenTime, activityTime, userType));
//        }
//        cursor.close();
//        return accounts;
//    }

//    public Account getAccount(String accountHolderName) {
//
//        Log.i("GET_ACCOUNT_FOR", accountHolderName);
//        SQLiteDatabase db = factory.getWritableDatabase();
//        Account account = null;
//
//        String[] columns = {
//                AccountConfig.HOLDER_NAME,
//                AccountConfig.BALANCE,
//                AccountConfig.REWARD_POINTS,
//                AccountConfig.DAILY_SCREEN_TIME,
//                AccountConfig.DAILY_ACTIVITY_TIME,
//                AccountConfig.USER_TYPE
//        };
//
//        String[] whereArgs = {accountHolderName};
//
//        Cursor cursor = db.query(AccountConfig.TABLE_NAME, columns, AccountConfig.HOLDER_NAME + "=?", whereArgs, null, null, null);
//
//        Log.i("GET_ACCOUNT_CURSOR", Integer.toString(cursor.getCount()));
//        while (cursor.moveToNext()) {
//            @SuppressLint("Range") String holderName = cursor.getString(cursor.getColumnIndex(AccountConfig.HOLDER_NAME));
//            @SuppressLint("Range") float balance = cursor.getFloat(cursor.getColumnIndex(AccountConfig.BALANCE));
//            @SuppressLint("Range") int rewardPoints = cursor.getInt(cursor.getColumnIndex(AccountConfig.REWARD_POINTS));
//            @SuppressLint("Range") int screenTime = cursor.getInt(cursor.getColumnIndex(AccountConfig.DAILY_SCREEN_TIME));
//            @SuppressLint("Range") int activityTime = cursor.getInt(cursor.getColumnIndex(AccountConfig.DAILY_ACTIVITY_TIME));
//            @SuppressLint("Range") String userType = cursor.getString(cursor.getColumnIndex(AccountConfig.USER_TYPE));
//
//            account = new Account(holderName, balance, rewardPoints, screenTime, activityTime, userType);
//            Log.i("GET_ACCOUNT", account.toString());
//        }
//        cursor.close();
//        return account;
//    }

//    public int deleteAccountData(String holderName) {
//        SQLiteDatabase db = factory.getWritableDatabase();
//        String[] whereArgs = {holderName};
//        return db.delete(AccountConfig.TABLE_NAME, AccountConfig.HOLDER_NAME + " = ?", whereArgs);
//    }
//
//    public long insertAccountData(String holderName, String balance) {
//        SQLiteDatabase dbb = factory.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(AccountConfig.HOLDER_NAME, holderName);
//        contentValues.put(AccountConfig.BALANCE, balance);
//        return dbb.insert(AccountConfig.TABLE_NAME, null, contentValues);
//    }

//    public int updateAccountBalance(String holderName, float balance) {
//        Log.i("UPDATE_ACCOUNT_HOLDER_NAME", holderName);
//        Log.i("UPDATE_ACCOUNT_BALANCE", Float.toString(balance));
//        SQLiteDatabase db = factory.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(AccountConfig.BALANCE, balance);
//        String[] whereArgs = {holderName.toLowerCase()};
//        return db.update(AccountConfig.TABLE_NAME, contentValues, AccountConfig.HOLDER_NAME + " = ?", whereArgs);
//    }
//
//    public long insertAccountData(Account account) {
//        SQLiteDatabase dbb = factory.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(AccountConfig.HOLDER_NAME, account.getHolderName());
//        contentValues.put(AccountConfig.BALANCE, account.getBalance());
//        contentValues.put(AccountConfig.REWARD_POINTS, account.getRewardPoints());
//        contentValues.put(AccountConfig.DAILY_ACTIVITY_TIME, account.getDailyActivityTimeInMinutes());
//        contentValues.put(AccountConfig.DAILY_SCREEN_TIME, account.getDailyScreenTimeInMinutes());
//        contentValues.put(AccountConfig.USER_TYPE, account.getUserType());
//        return dbb.insert(AccountConfig.TABLE_NAME, null, contentValues);
//    }
}
