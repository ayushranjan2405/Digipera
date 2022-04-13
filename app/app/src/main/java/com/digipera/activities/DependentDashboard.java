package com.digipera.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.commons.Formatter;
import com.digipera.dto.Account;
import com.digipera.dto.User;
import com.digipera.dto.Widget;
import com.digipera.services.AccountService;
import com.digipera.services.WidgetsService;
import com.digipera.services.NotificationService;
import com.digipera.dto.Notification;
import com.digipera.utils.DateTimeUtil;
import com.digipera.views.NotificationView;
import com.digipera.views.WidgetView;

import java.util.List;

public class DependentDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependent_dashboard);

        User user = getSuppliedUser();
        addWelcomeView(user);
        addTimeView();
        addAccountView(user);
        addWidgetView();
        addNotificationView(user);
        handleWidgetClick();
        handleWidgetClick(findViewById(R.id.w_account_history), WalletHistory.class, user.getUsername());
        handleWidgetClick(findViewById(R.id.w_scan_n_pay), QRCodeScan.class, user);
        handleWidgetClick(findViewById(R.id.w_spending_habit), SpendingHabit.class, user);
        handleWidgetClick(findViewById(R.id.w_activity), Fitness.class, user);
        handleWidgetClick(findViewById(R.id.w_screen_activity), ScreenTime.class, user);
        handleWidgetClick(findViewById(R.id.w_rewards), Rewards.class, user);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void handleWidgetClick(ImageView imageView, Class<?> nextActivityClass, User user) {
        imageView.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    Log.i("IMAGE_TAP", "action_down");
                    Intent intent = new Intent(getApplicationContext(), nextActivityClass);
                    intent.putExtra(Constants.PERSON, user);
                    startActivity(intent);
                    break;
                }
                case MotionEvent.ACTION_CANCEL: {
                    Log.i("IMAGE_TAP", "action_cancel");
                    break;
                }
            }
            return true;
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void handleWidgetClick(ImageView imageView, Class<?> nextActivityClass, String username) {
        imageView.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    Log.i("IMAGE_TAP", "action_down");
                    Intent intent = new Intent(getApplicationContext(), nextActivityClass);
                    intent.putExtra("name", username);
                    startActivity(intent);
                    break;
                }
                case MotionEvent.ACTION_CANCEL: {
                    Log.i("IMAGE_TAP", "action_cancel");
                    break;
                }
            }
            return true;
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void handleWidgetClick() {
        final ImageView v = (ImageView) findViewById(R.id.w_scan_n_pay);
        v.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    Log.i("IMAGE_TAP", "action_down");
                    Intent intent = new Intent(getApplicationContext(), QRCodeScan.class);
                    //intent.putExtra("user", user);
                    startActivity(intent);
                    break;
                }
                case MotionEvent.ACTION_CANCEL:{
                    Log.i("IMAGE_TAP", "action_cancel");
                    break;
                }
            }
            return true;
        });
    }

    private User getSuppliedUser() {
        Bundle data = getIntent().getExtras();
        return (User) data.getParcelable("user");
    }

    private void addWelcomeView(User user) {
        TextView initials = (TextView) findViewById(R.id.initials);
        initials.setText(Formatter.getInitials(user));
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);
        welcomeMessage.setText(Formatter.getWelcomeMessage(user.getFirstname()));
    }

    private void addTimeView() {
        TextView time = (TextView) findViewById(R.id.time);
        time.setText(DateTimeUtil.getSystemDate());
    }

    private void addAccountView(User user) {
        //Balance
        Account account = new AccountService(this).getAccount(user.getUsername());
        TextView balance = (TextView) findViewById(R.id.balance);
        balance.setText(Formatter.getBalance(account.getBalance()));

        //Rewards
        TextView rewards = (TextView) findViewById(R.id.reward);
        rewards.setText(Formatter.getRewards(account.getRewardPoints()));
    }

    private void addWidgetView() {

        List<Widget> widgets = WidgetsService.getWidgets(Constants.DEPENDENT_DASHBOARD);

        //Get the linear layout for widgets
        LinearLayout widgetsLayout = findViewById(R.id.widgets);
        List<View> widgetViews = WidgetView.getWidgetViews(this, widgetsLayout, widgets.subList(0,4));
        widgetViews.forEach(widgetsLayout::addView);

        LinearLayout widgetsLayout2 = findViewById(R.id.widgets2);
        List<View> widgetViews2 = WidgetView.getWidgetViews(this, widgetsLayout2, widgets.subList(4,7));
        widgetViews2.forEach(widgetsLayout2::addView);
    }

    private void addNotificationView(User user) {
        //Get the linear layout for notifications
        LinearLayout notificationsLayout = findViewById(R.id.notifications);
        List<Notification> notifications = new NotificationService(DependentDashboard.this).getAll(user.getUsername());
        if(notifications!=null){
            List<View> views = NotificationView.getNotificationViews(this, notificationsLayout, notifications);
            views.forEach(notificationsLayout::addView);
        }
    }
}