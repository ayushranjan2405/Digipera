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
import android.widget.Toast;

import com.daprlabs.cardstack.SwipeDeck;
import com.digipera.commons.Constants;
import com.digipera.commons.Formatter;
import com.digipera.dto.Account;
import com.digipera.dto.Notification;
import com.digipera.dto.User;
import com.digipera.dto.Widget;
import com.digipera.services.AccountService;
import com.digipera.services.WidgetsService;
import com.digipera.utils.DateTimeUtil;
import com.digipera.utils.DeckAdapter;
import com.digipera.R;
import com.digipera.services.DependentService;
import com.digipera.services.NotificationService;
import com.digipera.dto.Dependent;
import com.digipera.views.NotificationView;
import com.digipera.views.WidgetView;

import java.util.List;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        User user = getSuppliedUser();
        Account account = new AccountService(this).getAccount(user.getUsername());
        addWelcomeView(user);
        addTimeView();
        addAccountView(account);
        addCardView();
        addWidgetView();
        addNotificationView(user);
        handleWidgetClick(findViewById(R.id.w_transfer_money), Transfer.class, account);
        handleWidgetClick(findViewById(R.id.w_account_history), WalletHistory.class, account.getHolderName());
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
    private void handleWidgetClick(ImageView imageView, Class<?> nextActivityClass, Account account) {
        imageView.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    Log.i("IMAGE_TAP", "action_down");
                    Intent intent = new Intent(getApplicationContext(), nextActivityClass);
                    intent.putExtra(Constants.ACCOUNT, account);
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
    private void handleWidgetClick(ImageView imageView, Class<?> nextActivityClass, String name) {
        imageView.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    Log.i("IMAGE_TAP", "action_down");
                    Intent intent = new Intent(getApplicationContext(), nextActivityClass);
                    intent.putExtra("name", name);
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

    private void addWelcomeView(User user) {
        TextView initials = findViewById(R.id.initials);
        initials.setText(Formatter.getInitials(user));

        TextView welcomeMessage = findViewById(R.id.welcomeMessage);
        welcomeMessage.setText(Formatter.getWelcomeMessage(user.getFirstname()));
    }

    private void addTimeView() {
        TextView time = findViewById(R.id.time);
        time.setText(DateTimeUtil.getSystemDate());
    }

    private void addAccountView(Account account) {
        //Balance
        TextView balance = findViewById(R.id.balance);
        balance.setText(Formatter.getBalance(account.getBalance()));
    }

    private void addCardView() {

        SwipeDeck cardStack;
        List<Dependent> dependentList;
        // on below line we are initializing our array list and swipe deck.
        cardStack = findViewById(R.id.swipe_deck);

        // on below line we are adding data to our array list.
        dependentList = DependentService.getInflatedDependents(Dashboard.this);

        // on below line we are creating a variable for our adapter class and passing array list to it.
        final DeckAdapter adapter = new DeckAdapter(dependentList);

        // on below line we are setting adapter to our card stack.
        cardStack.setAdapter(adapter);
        setEventCallback2CardStack(cardStack, dependentList);
    }

    private void addWidgetView() {

        List<Widget> widgets = WidgetsService.getWidgets(Constants.PARENT);

        //Get the linear layout for widgets
        LinearLayout widgetsLayout = findViewById(R.id.widgets);
        List<View> widgetViews = WidgetView.getWidgetViews(this, widgetsLayout, widgets.subList(0,4));
        widgetViews.forEach(widgetsLayout::addView);
    }

    private void addNotificationView(User user) {
        //Get the linear layout for notifications
        LinearLayout notificationsLayout = findViewById(R.id.notifications);
        List<Notification> notifications = new NotificationService(Dashboard.this).getAll(user.getUsername());
        List<View> views = NotificationView.getNotificationViews(this, notificationsLayout, notifications);
        views.forEach(notificationsLayout::addView);
    }

    private User getSuppliedUser() {
        Bundle data = getIntent().getExtras();
        return data.getParcelable("user");
    }

    private void setEventCallback2CardStack(SwipeDeck cardStack, List<Dependent> dependentList) {
        // on below line we are setting event callback to our card stack.
        cardStack.setEventCallback(new SwipeDeck.SwipeEventCallback() {
            @Override
            public void cardSwipedLeft(int position) {
                // on card swipe left we are displaying a toast message.
                Toast.makeText(Dashboard.this, "Card Swiped Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void cardSwipedRight(int position) {
                // on card swiped to right we are displaying a toast message.
                TextView dependentName = findViewById(R.id.dependentName);
                //TextView password = findViewById(R.id.password);
                Log.i("NAME", position + dependentName.getText().toString());
                Intent intent = new Intent(getApplicationContext(), DependentDetails.class);
                intent.putExtra("dependent", dependentList.get(position));
                startActivity(intent);
                Toast.makeText(
                        Dashboard.this,
                        "Card Swiped Right for dependent: " + dependentName.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void cardsDepleted() {
                // this method is called when no card is present
                Toast.makeText(Dashboard.this, "No more courses present", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void cardActionDown() {
                // this method is called when card is swiped down.
                Log.i("TAG", "CARDS MOVED DOWN");
            }

            @Override
            public void cardActionUp() {
                // this method is called when card is moved up.
                Log.i("TAG", "CARDS MOVED UP");
            }
        });
    }
}