package com.digipera.dao;

public class Account {
    private final String holderName;
    private final float balance;
    private final int rewardPoints;
    private final int dailyScreenTimeInMinutes;
    private final int dailyActivityTimeInMinutes;
    private final String userType;

    public Account(String holderName, float balance, int rewardPoints, int dailyScreenTimeInMinutes, int dailyActivityTimeInMinutes, String userType) {
        this.holderName = holderName;
        this.balance = balance;
        this.rewardPoints = rewardPoints;
        this.dailyScreenTimeInMinutes = dailyScreenTimeInMinutes;
        this.dailyActivityTimeInMinutes = dailyActivityTimeInMinutes;
        this.userType = userType;
    }

    public String getHolderName() {
        return holderName;
    }

    public float getBalance() {
        return balance;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public int getDailyScreenTimeInMinutes() {
        return dailyScreenTimeInMinutes;
    }

    public int getDailyActivityTimeInMinutes() {
        return dailyActivityTimeInMinutes;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "holderName='" + holderName + '\'' +
                ", balance=" + balance +
                ", rewardPoints=" + rewardPoints +
                ", dailyScreenTimeInMinutes=" + dailyScreenTimeInMinutes +
                ", dailyActivityTimeInMinutes=" + dailyActivityTimeInMinutes +
                ", userType='" + userType + '\'' +
                '}';
    }
}
