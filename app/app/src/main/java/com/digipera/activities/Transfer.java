package com.digipera.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.commons.Formatter;
import com.digipera.dto.Account;
import com.digipera.services.AccountService;
import com.digipera.services.DependentService;
import com.digipera.services.NotificationService;

import java.util.List;

public class Transfer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        Account account = getSuppliedAccount();
        addAccountHolderName(account.getHolderName());
        addAvailableBalance(account.getBalance());
        addDependentDropdown();
        handleTransfer(account);

    }

    private void addAccountHolderName(String name) {
        TextView accHolderName = findViewById(R.id.account_holder_name);
        accHolderName.setText(Formatter.buildViewText(Constants.FROM, name));
    }

    private void addAvailableBalance(float balance) {
        TextView availableBalance = findViewById(R.id.available_balance);
        availableBalance.setText(Formatter.buildViewText(Constants.AVAILABLE_BALANCE, Float.toString(balance)));
    }

    private Account getSuppliedAccount() {
        Bundle data = getIntent().getExtras();
        return data.getParcelable("account");
    }

    private void addDependentDropdown() {
        // get reference to the string array that we just created
        List<String> dependentNames = DependentService.getDependentNames(Transfer.this);
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.dropdown_item, dependentNames);
        // get reference to the autocomplete text view
        AutoCompleteTextView autocompleteTV = findViewById(R.id.dependent_selected);
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter);
    }

    private void handleTransfer(Account account) {

        AutoCompleteTextView selectedText = findViewById(R.id.dependent_selected);
        TextView amount = findViewById(R.id.transfer_amount);
        //String toAccHolderName = selectedText.getText().toString();
        String fromAccHolderName = account.getHolderName();
        //button click event registration
        findViewById(R.id.transfer).setOnClickListener(view -> {
            String message = String.format("Transferred Rs. %s to %s.", amount.getText().toString(), selectedText.getText().toString());
            Toast.makeText(Transfer.this, message, Toast.LENGTH_SHORT).show();
            //AccountService accountService = new AccountService(AppRepo.getAppRepo(Transfer.this));
            //Account formAccount = account;
            Account toAccount = new AccountService(Transfer.this).getAccount(selectedText.getText().toString());
            credit(fromAccHolderName, selectedText.getText().toString(), Float.toString(account.getBalance()), amount.getText().toString());
            debit(fromAccHolderName, selectedText.getText().toString(), Float.toString(toAccount.getBalance()), amount.getText().toString());
            nextScreen(selectedText.getText().toString(), Float.parseFloat(amount.getText().toString()), account.getBalance());
        });
    }

    private void debit(String from, String to, String currentBalance, String delta) {
        float newBalance = Float.parseFloat(currentBalance) + Float.parseFloat(delta);
        updateBalance(from, newBalance);
        createNotification(from, to, from, delta, Constants.DEBIT);
    }

    private void credit(String from, String to, String currentBalance, String delta) {
        float newBalance = Float.parseFloat(currentBalance) - Float.parseFloat(delta);
        updateBalance(to, newBalance);
        createNotification(from, to, to, delta, Constants.CREDIT);
    }

    private void updateBalance(String accountHolder, float balance) {
        AccountService accountService = new AccountService(Transfer.this);
        accountService.updateAccountBalance(accountHolder, balance);
    }

    private void createNotification(String from, String to, String forUser, String delta, String transType) {
        NotificationService notificationService = new NotificationService(Transfer.this);
        notificationService.addFundTransferNotification(from, to, forUser, delta, transType);
    }

    private void nextScreen(String receiverName, float amount, float availableBalance) {

        //Toast.makeText(PaymentConfirm.this, "Payment SUCCESSFUL", Toast.LENGTH_LONG).show();
        com.digipera.dto.Transfer transfer = new com.digipera.dto.Transfer(receiverName, amount, availableBalance-amount);
        Intent intent = new Intent(getApplicationContext(), TransferSuccess.class);
        intent.putExtra(Constants.TRANSFER, transfer);
        startActivity(intent);

    }


}