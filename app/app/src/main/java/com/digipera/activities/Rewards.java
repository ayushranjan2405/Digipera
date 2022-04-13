package com.digipera.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.commons.Formatter;
import com.digipera.dto.Dependent;
import com.digipera.dto.Person;
import com.digipera.dto.User;
import com.digipera.services.RewardService;
import com.digipera.views.PieChartView;
import com.github.mikephil.charting.charts.PieChart;

import java.util.Map;

public class Rewards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        Person person = getSuppliedDependent();

        addScreenTitle(person);
        addPieChartView();
        //addHorizontalCardView(person.getFirstname());
    }

    private void addPieChartView() {
        PieChart chart = findViewById(R.id.rewards_pie_chart);
        Map<String, Integer> pieChartInfo = RewardService.getPieChartData();
        PieChartView.getPieChartView(chart, pieChartInfo);
    }

    private Person getSuppliedDependent() {
        Bundle data = getIntent().getExtras();
        Parcelable suppliedObj = data.getParcelable(Constants.PERSON);
        if (suppliedObj instanceof Dependent) {
            Dependent dependent = (Dependent) suppliedObj;
            return new Person(null, dependent.getFirstname(), dependent.getLastname(), Constants.DEPENDENT);
        } else {
            User user = (User) suppliedObj;
            return new Person(user.getUsername(), user.getFirstname(), user.getLastname(), Constants.SELF);
        }
    }

    private void addScreenTitle(Person person) {
        TextView title = (TextView) findViewById(R.id.title);
        title.setText(Formatter.getScreenTitle(person, Constants.REWARDS));
    }

//    private void addHorizontalCardView(String dependentNameAsKey) {
//        //Get the linear layout for notifications
//        LinearLayout horizontalCardsLayout = findViewById(R.id.horizontal_cards);
//        List<HorizontalCard> fitnessActivities = FitnessService.getDailyFitnessActivities(dependentNameAsKey.toLowerCase());
//        List<View> views = HorizontalCardView.getViews(this, horizontalCardsLayout, fitnessActivities);
//        views.forEach(horizontalCardsLayout::addView);
//    }
}