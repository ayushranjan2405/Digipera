package com.digipera.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {

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

    protected Account(Parcel in) {
        holderName = in.readString();
        balance = in.readFloat();
        rewardPoints = in.readInt();
        dailyScreenTimeInMinutes = in.readInt();
        dailyActivityTimeInMinutes = in.readInt();
        userType = in.readString();
    }

    public static final Creator<Account> CREATOR = new Creator<>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(holderName);
        parcel.writeFloat(balance);
        parcel.writeInt(rewardPoints);
        parcel.writeInt(dailyScreenTimeInMinutes);
        parcel.writeInt(dailyActivityTimeInMinutes);
        parcel.writeString(userType);
    }
}
