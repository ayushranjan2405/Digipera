package com.digipera.mockdata;

import java.util.HashMap;
import java.util.Map;

public class RewardsData {

    Map<String, Integer> pieChartInfo;

    public RewardsData(){
        pieChartInfo = new HashMap<>();
        pieChartInfo.put("Quiz", 30);
        pieChartInfo.put("ScreenTime", 40);
        pieChartInfo.put("Fitness", 10);
        pieChartInfo.put("Spending", 20);
    }

    public  Map<String, Integer> getPieChartData() {
        return pieChartInfo;
    }

}
