package com.digipera.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.dto.Transfer;
import com.digipera.utils.DateTimeUtil;

public class TransferSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_success);

        Bundle data = getIntent().getExtras();
        Transfer transfer = data.getParcelable(Constants.TRANSFER);
        addTransferDetails(transfer);

        //handleGoBack();
    }

    private void addTransferDetails(Transfer transfer) {

        TextView receiverName = findViewById(R.id.receiver_name);
        receiverName.setText(Constants.TO + transfer.getReceiverName());

        TextView amount = findViewById(R.id.transferred_amount);
        amount.setText(Constants.AMOUNT + transfer.getAmount());

        TextView transactionId = findViewById(R.id.transactionId);
        transactionId.setText(Constants.TRX + "767817387");

        TextView time = findViewById(R.id.transaction_time);
        time.setText(Constants.TIME + DateTimeUtil.getSystemDate());
    }

//    private void handleGoBack() {
//        findViewById(R.id.go_back).setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
//            //  intent.putExtra(Constants.ACCOUNT, account);
//            User user = new User( "shilpi", "Shilpi", "Singh", "41", "parent");
//            intent.putExtra("user", user);
//            startActivity(intent);
//        });
//    }

}