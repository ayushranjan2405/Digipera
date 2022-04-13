package com.digipera.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.dto.Notification;
import com.digipera.services.NotificationService;
import com.digipera.views.NotificationView;

import java.util.List;

public class WalletHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_history);

        String accHolderName = getSuppliedName();
        addHorizontalCardView(accHolderName);
    }

    private String getSuppliedName() {
        Bundle data = getIntent().getExtras();
        return data.getString("name");
    }

    private void addHorizontalCardView(String dependentNameAsKey) {
        //Get the linear layout for notifications
        LinearLayout horizontalCardsLayout = findViewById(R.id.horizontal_cards);
        List<Notification> notifications = new NotificationService(WalletHistory.this).getAllFundTransferNotifications(dependentNameAsKey, Constants.FUND_TRANSFER);
        List<View> views = NotificationView.getNotificationViews(this, horizontalCardsLayout, notifications);
        views.forEach(horizontalCardsLayout::addView);
    }
}