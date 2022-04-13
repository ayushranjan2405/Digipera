package com.digipera.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Dependent implements Parcelable {

    private final String firstname;
    private final String lastname;
    private final float balance;
    private final int rewardPoints;

    public Dependent(String firstname, String lastname, float balance, int rewardPoints) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.balance = balance;
        this.rewardPoints = rewardPoints;
    }

    protected Dependent(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        balance = in.readFloat();
        rewardPoints = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeFloat(balance);
        dest.writeInt(rewardPoints);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Dependent> CREATOR = new Creator<>() {
        @Override
        public Dependent createFromParcel(Parcel in) {
            return new Dependent(in);
        }

        @Override
        public Dependent[] newArray(int size) {
            return new Dependent[size];
        }
    };

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public float getBalance() {
        return balance;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

}

