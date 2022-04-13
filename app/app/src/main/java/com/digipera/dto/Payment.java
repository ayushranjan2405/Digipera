package com.digipera.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Payment implements Parcelable {

    private String merchantName;
    private String merchantPhoneNumber;
    private String merchantAccount;
    private String amount;
    private String availableBalance;
    private String payerName;

    public Payment(String merchantName, String merchantPhoneNumber, String merchantAccount, String amount, String availableBalance, String payerName) {
        this.merchantName = merchantName;
        this.merchantPhoneNumber = merchantPhoneNumber;
        this.merchantAccount = merchantAccount;
        this.amount = amount;
        this.availableBalance = availableBalance;
        this.payerName = payerName;
    }

    protected Payment(Parcel in) {
        merchantName = in.readString();
        merchantPhoneNumber = in.readString();
        merchantAccount = in.readString();
        amount = in.readString();
        availableBalance = in.readString();
        payerName = in.readString();
    }

    public static final Creator<Payment> CREATOR = new Creator<>() {
        @Override
        public Payment createFromParcel(Parcel in) {
            return new Payment(in);
        }

        @Override
        public Payment[] newArray(int size) {
            return new Payment[size];
        }
    };

    public String getMerchantName() {
        return merchantName;
    }

    public String getMerchantPhoneNumber() {
        return merchantPhoneNumber;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public String getAmount() {
        return amount;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setMerchantPhoneNumber(String merchantPhoneNumber) {
        this.merchantPhoneNumber = merchantPhoneNumber;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "merchantName='" + merchantName + '\'' +
                ", merchantPhoneNumber='" + merchantPhoneNumber + '\'' +
                ", merchantAccount='" + merchantAccount + '\'' +
                ", amount='" + amount + '\'' +
                ", availableBalance='" + availableBalance + '\'' +
                ", payerName='" + payerName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(merchantName);
        parcel.writeString(merchantPhoneNumber);
        parcel.writeString(merchantAccount);
        parcel.writeString(amount);
        parcel.writeString(availableBalance);
        parcel.writeString(payerName);
    }
}
