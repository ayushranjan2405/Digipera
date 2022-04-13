package com.digipera.views;

import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PieChartView {

    public static void getPieChartView(PieChart pieChart, Map<String, Integer> pieChartInfo){
        new PieChartView().loadPieChart(pieChart, pieChartInfo);
    }
    private void loadPieChart(PieChart pieChart, Map<String, Integer> pieChartInfo){
        //an array to store the pie slices entry
        List<PieEntry> pieEntries = new ArrayList<>();

        for ( Map.Entry<String, Integer> entrySet: pieChartInfo.entrySet()){
            pieEntries.add(new PieEntry((float)entrySet.getValue(), entrySet.getKey()));
        }

        //assigning color to each slices
        List<Integer> pieShades = new ArrayList<>();
        pieShades.add(Color.parseColor("#1e81b0"));
        pieShades.add(Color.parseColor("#e28743"));
        pieShades.add(Color.parseColor("#a214d2"));
        pieShades.add(Color.parseColor("#ffc34d"));

//        pieShades.add(R.color.yellow);
//        pieShades.add(R.color.orange);
//        pieShades.add(R.color.blue);
//        pieShades.add(R.color.dark_blue);

        //add values to the pie dataset and passing them to the constructor
        PieDataSet ourSet = new PieDataSet(pieEntries, "");
        PieData pieData = new PieData(ourSet);

        //setting the slices divider width
        ourSet.setSliceSpace(1f);

        //populating the colors and data
        ourSet.setColors(pieShades);
        pieChart.setData(pieData);
        //setting color and size of text
        pieData.setValueTextColor(Color.WHITE);
        pieData.setValueTextSize(15f);

        //add an animation when rendering the pie chart
        pieChart.animateY(1400, Easing.EaseInOutQuad);
        //disabling center hole
        //pieChart.setDrawHoleEnabled(false);
        //do not show description text
        pieChart.setHoleColor(Color.TRANSPARENT);
        pieChart.setHoleRadius(40f);
        pieChart.setCenterText("April, 2022");
        pieChart.setCenterTextColor(Color.WHITE);
        pieChart.setCenterTextSize(15f);
        pieChart.getDescription().setEnabled(false);
        //legend enabled and its various appearance settings
        Legend legend = pieChart.getLegend();
        legend.setEnabled( true);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setWordWrapEnabled(true);
        legend.setTextColor(Color.WHITE);
        legend.setTextSize(14f);

        //dont show the text values on slices e.g Antelope, impala etc
        pieChart.setDrawEntryLabels(false);
        //refreshing the chart
        pieChart.invalidate();
    }
}
