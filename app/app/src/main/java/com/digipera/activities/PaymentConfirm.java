package com.digipera.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.dto.Account;
import com.digipera.dto.Payment;
import com.digipera.services.AccountService;
import com.digipera.services.NotificationService;


public class PaymentConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_confirm);

        Bundle data = getIntent().getExtras();
        Payment payment = data.getParcelable("payment");

        addPaymentInfo(payment);
        handlePaymentConfirm(payment);

    }

    private void handlePaymentConfirm(Payment payment) {
        TextView amount = findViewById(R.id.amount);
        final Button button = findViewById(R.id.confirm);
        button.setOnClickListener(view -> {
            //  credit(fromAccHolderName, selectedText.getText().toString(), Float.toString(formAccount.getBalance()), amount.getText().toString());
            Account account = new AccountService(PaymentConfirm.this).getAccount(payment.getPayerName());
            debit(payment.getPayerName(), payment.getMerchantName(), Float.toString(account.getBalance()), amount.getText().toString());
            payment.setAmount(amount.getText().toString());
            nextScreen(payment);
        });
    }

    private void debit(String from, String to, String currentBalance, String delta) {
        float newBalance = Float.parseFloat(currentBalance) + Float.parseFloat(delta);
        updateBalance(from, newBalance);
        createNotification(from, to, from, delta);
    }

//    private void credit(String from, String to, String currentBalance, String delta) {
//        float newBalance = Float.valueOf(currentBalance) - Float.valueOf(delta);
//        updateBalance(to, newBalance);
//        createNotification(from, to, to, delta);
//    }

    private void updateBalance(String accountHolder, float balance) {
        AccountService accountService = new AccountService(PaymentConfirm.this);
        accountService.updateAccountBalance(accountHolder, balance);
    }

    private void createNotification(String from, String to, String forUser, String delta) {
        NotificationService notificationService = new NotificationService(PaymentConfirm.this);
        notificationService.addPaymentNotification(from, to, forUser, delta);
    }

    private void addPaymentInfo(Payment payment) {
        TextView merchantName = findViewById(R.id.merchantName);
        merchantName.setText(Constants.TO + payment.getMerchantName());

        TextView merchantMobile = findViewById(R.id.merchantMobile);
        merchantMobile.setText(Constants.PHONE_NUMBER + payment.getMerchantPhoneNumber());
    }

    private void nextScreen(Payment payment) {
        Intent intent = new Intent(getApplicationContext(), PaymentSuccess.class);
        intent.putExtra(Constants.PAYMENT, payment);
        startActivity(intent);
    }
}