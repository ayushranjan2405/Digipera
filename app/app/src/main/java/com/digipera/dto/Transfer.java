package com.digipera.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Transfer implements Parcelable {

    private final String receiverName;
    private final float amount;
    private final float currentBalance;

    public Transfer(String receiverName, float amount, float currentBalance) {
        this.receiverName = receiverName;
        this.amount = amount;
        this.currentBalance = currentBalance;
    }

    protected Transfer(Parcel in) {
        receiverName = in.readString();
        amount = in.readFloat();
        currentBalance = in.readFloat();
    }

    public static final Creator<Transfer> CREATOR = new Creator<>() {
        @Override
        public Transfer createFromParcel(Parcel in) {
            return new Transfer(in);
        }

        @Override
        public Transfer[] newArray(int size) {
            return new Transfer[size];
        }
    };

    public String getReceiverName() {
        return receiverName;
    }

    public float getAmount() {
        return amount;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "receiverName='" + receiverName + '\'' +
                ", amount=" + amount +
                ", currentBalance=" + currentBalance +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(receiverName);
        parcel.writeFloat(amount);
        parcel.writeFloat(currentBalance);
    }
}
