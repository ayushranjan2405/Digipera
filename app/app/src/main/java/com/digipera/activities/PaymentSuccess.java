package com.digipera.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.dto.Payment;
import com.digipera.utils.DateTimeUtil;

public class PaymentSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);

        Bundle data = getIntent().getExtras();
        Payment payment = data.getParcelable(Constants.PAYMENT);

        addPaymentDetails(payment);
    }

    private void addPaymentDetails(Payment payment) {

        TextView merchantName = findViewById(R.id.paidTo);
        merchantName.setText(Constants.TO + payment.getMerchantName());

        TextView amount = findViewById(R.id.paidAmount);
        amount.setText(Constants.AMOUNT + payment.getAmount());

        TextView transactionId = findViewById(R.id.transactionId);
        transactionId.setText(Constants.TRX + "9871165924372");

        TextView time = findViewById(R.id.transaction_time);
        time.setText(Constants.TIME +DateTimeUtil.getSystemDate());
    }

}