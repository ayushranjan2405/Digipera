package com.digipera.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.commons.Formatter;
import com.digipera.dto.ChartData;
import com.digipera.dto.Dependent;
import com.digipera.dto.HorizontalCard;
import com.digipera.dto.Person;
import com.digipera.dto.User;
import com.digipera.services.FitnessService;
import com.digipera.views.BarChartView;
import com.digipera.views.HorizontalCardView;
import com.github.mikephil.charting.charts.BarChart;

import java.util.List;

public class Fitness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);

        Person person = getSuppliedDependent();

        addScreenTitle(person);
        addBarChartView();
        addHorizontalCardView(person.getFirstname());
    }

    private void addBarChartView() {
        BarChart chart = (BarChart) findViewById(R.id.fitness_bar_chart);
        List<String> categories = FitnessService.getCategories();
        List<Integer> firstBarData = FitnessService.getFirstBarData();
        //List<Integer> secondBarData = FitnessService.getSecondBarData();

        ChartData chartData = new ChartData(categories,
                firstBarData,
                null,
                Color.rgb(226,135,67),
                0,
                Constants.FITNESS_UNIT);
        BarChartView.getBarChartView(chart, chartData );
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

    private void addScreenTitle(Person person) {
        TextView title = (TextView) findViewById(R.id.title);
        title.setText(Formatter.getScreenTitle(person, Constants.FITNESS));
    }

    private void addHorizontalCardView(String dependentNameAsKey) {
        //Get the linear layout for notifications
        LinearLayout horizontalCardsLayout = findViewById(R.id.horizontal_cards);
        List<HorizontalCard> fitnessActivities = FitnessService.getDailyFitnessActivities(dependentNameAsKey.toLowerCase());
        List<View> views = HorizontalCardView.getViews(this, horizontalCardsLayout, fitnessActivities);
        views.forEach(horizontalCardsLayout::addView);
    }
}