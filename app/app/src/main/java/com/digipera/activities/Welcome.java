package com.digipera.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.digipera.R;
import com.digipera.services.AccountService;
import com.digipera.services.NotificationService;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final Button button = (Button) findViewById(R.id.signin);

        button.setOnClickListener(view -> {
            loadData();
            Intent i = new Intent(getApplicationContext(), Signin.class);
            startActivity(i);
        });
    }

    private void loadData() {
        new AccountService(this).initialLoad();
        new NotificationService(this).initialLoad();
    }
}