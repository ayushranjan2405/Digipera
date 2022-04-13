package com.digipera.services;

import android.util.Log;

import com.digipera.dto.HorizontalCard;
import com.digipera.mockdata.FitnessActivityData;

import java.util.List;

public class FitnessService {
    public static List<HorizontalCard> getDailyFitnessActivities(String personName) {
        Log.i("FITNESS: ", personName);
        FitnessActivityData fitnessActivityData = new FitnessActivityData();
        return fitnessActivityData.getDailyData(personName);
    }

//    public static List<HorizontalCard> getMonthlyFitnessActivities(String personName) {
//        Log.i("FITNESS: ", personName);
//        FitnessActivityData fitnessActivityData = new FitnessActivityData();
//        return fitnessActivityData.getDailyData(personName);
//    }

    public static List<String> getCategories(){
        return FitnessActivityData.getCategories();
    }

    public static List<Integer> getFirstBarData() {
        return FitnessActivityData.getFirstBarData();
    }

//    public static List<Integer> getSecondBarData() {
//        return FitnessActivityData.getSecondBarData();
//    }
}
