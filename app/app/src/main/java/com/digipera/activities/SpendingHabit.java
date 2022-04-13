package com.digipera.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.commons.Formatter;
import com.digipera.dto.ChartData;
import com.digipera.dto.Dependent;
import com.digipera.dto.Person;
import com.digipera.dto.User;
import com.digipera.services.SpendingHabitService;
import com.digipera.views.DualBarChartView;
import com.github.mikephil.charting.charts.BarChart;

public class SpendingHabit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending_habit);

        Person person = getSuppliedDependent();
        addScreenTitle(person);
        addBarChartView();
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
        TextView title = findViewById(R.id.title);
        title.setText(Formatter.getScreenTitle(person, Constants.SPENDING));
    }

    private void addBarChartView() {
        BarChart chart = findViewById(R.id.spending_chart);
        com.digipera.dto.SpendingHabit spendingHabitData = SpendingHabitService.getSpendingHabit();

        ChartData chartData = new ChartData(spendingHabitData.getCategory(),
                spendingHabitData.getPreviousMonth(),
                spendingHabitData.getCurrentMonth(),
                Color.rgb(30,129,176),
                Color.rgb(22, 96, 131),
                Constants.SPENDING_HABIT_UNIT);
        DualBarChartView.getBarChartView(chart, chartData);

    }
}