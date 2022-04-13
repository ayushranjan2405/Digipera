package com.digipera.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.dto.Dependent;
import com.digipera.dto.Seller;
import com.digipera.dto.Payment;
import com.digipera.dto.Person;
import com.digipera.dto.User;
import com.digipera.services.SellerService;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeScan extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;
    private Payment payment;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scan);
//        scannerView = new ZXingScannerView(this);
//        setContentView(R.layout.activity_qrcode_scan);
        scannerView = findViewById(R.id.scanView);
        //setContentView(scannerView);

        TextView phoneNumber = (TextView) findViewById(R.id.phoneNumber);
        final Button button = (Button) findViewById(R.id.submit);

        person = getSuppliedDependent();

        button.setOnClickListener(view -> {
            initiatePayment(phoneNumber.getText().toString());
//            Seller merchant = SellerService.getMerchant(phoneNumber.getText().toString());
//            if (merchant != null){
//                payment = new Payment(merchant.getName(), merchant.getPhoneNo(), merchant.getAccNum(), "0", "0", person.getUsername());
//                Toast.makeText(QRCodeScan.this, "Payment SUCCESSFUL", Toast.LENGTH_LONG).show();
//                nextScreen(payment);
//            } else{
//                Toast.makeText(QRCodeScan.this, "Unable to find Seller. Please complete Seller on-boarding.", Toast.LENGTH_LONG).show();
//            }

        });

        Dexter.withContext(getApplicationContext())
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }

    private Person getSuppliedDependent() {
        Bundle data = getIntent().getExtras();
        Parcelable suppliedObj = data.getParcelable(Constants.PERSON);
        if (suppliedObj instanceof Dependent){
            Dependent dependent =  (Dependent) suppliedObj;
            return new Person(null, dependent.getFirstname(), dependent.getLastname(), Constants.DEPENDENT);
        } else {
            User user =  (User) suppliedObj;
            return new Person(user.getUsername(), user.getFirstname(), user.getLastname(), Constants.SELF);
        }
    }

    @Override
    public void handleResult(Result rawResult) {
        //MainActivity.scantext.setText(rawResult.getText());
        String textToToast = String.format("QR SCAN Success. Data read: %s", rawResult.getText());
        Toast.makeText(QRCodeScan.this, textToToast, Toast.LENGTH_LONG).show();
        initiatePayment(rawResult.getText().trim());
        onBackPressed();
    }

    private void initiatePayment(String sellerPhoneNo) {
        Seller seller = SellerService.getMerchant(sellerPhoneNo);
        if (seller != null){
            payment = new Payment(seller.getName(), seller.getPhoneNo(), seller.getAccNum(), "0", "0", person.getUsername());
            nextScreen(payment);
        } else{
            Toast.makeText(QRCodeScan.this, "Unable to find Seller. Please complete Seller on-boarding.", Toast.LENGTH_LONG).show();
            nextScreen(null);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("OnResume: ", "");
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    private void nextScreen(Payment payment){
        Intent intent;
        if (payment!=null) {
            intent = new Intent(getApplicationContext(), PaymentConfirm.class);
            intent.putExtra(Constants.PAYMENT, payment);
        } else {
            intent = new Intent(getApplicationContext(), PaymentFailure.class);
        }
        startActivity(intent);
    }

}