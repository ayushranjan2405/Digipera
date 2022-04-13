package com.digipera.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.commons.Message;
import com.digipera.dto.User;
import com.digipera.services.UserService;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        handleSubmit();
    }

    private void handleSubmit() {

        final TextView username = (TextView) findViewById(R.id.username);
        //final TextView password = (TextView) findViewById(R.id.password);
        final Button button = (Button) findViewById(R.id.submit);

        button.setOnClickListener(view -> {
            String usernameStr = username.getText().toString();
           // String passwordStr = password.getText().toString();
            User user = UserService.authenticate(usernameStr);

            if (user != null) {
                nextScreen(user);
            } else {
                Message.message(Signin.this, "Signin FAILED !!! username Shilpi, Ishita, Rohan");
            }
        });
    }

    private void nextScreen(User user) {
        Toast.makeText(Signin.this, "Signin SUCCESSFUL", Toast.LENGTH_SHORT).show();
        Intent intent = null;

        if (user.getRelation().equalsIgnoreCase(Constants.PARENT)) {
            intent = new Intent(getApplicationContext(), Dashboard.class);
        } else if (user.getRelation().equalsIgnoreCase(Constants.DEPENDENT)) {
            intent = new Intent(getApplicationContext(), DependentDashboard.class);
        }

        intent.putExtra("user", user);
        startActivity(intent);
    }

}