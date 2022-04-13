package com.digipera.services;

import android.util.Log;

import com.digipera.dto.HorizontalCard;
import com.digipera.mockdata.ScreenTimeData;

import java.util.List;

public class ScreenTimeService {

    public static List<HorizontalCard> getDailyScreenTime(String personName) {
        Log.i("FITNESS: ", personName);
        ScreenTimeData screenTimeData = new ScreenTimeData();
        return screenTimeData.getDailyData(personName);
    }

//    public static List<HorizontalCard> getMonthlyScreenTime(String personName) {
//        Log.i("FITNESS: ", personName);
//        ScreenTimeData screenTimeData = new ScreenTimeData();
//        return screenTimeData.getDailyData(personName);
//    }

    public static List<String> getCategories(){
        return ScreenTimeData.getCategories();
    }

    public static List<Integer> getFirstBarData() {
        return ScreenTimeData.getFirstBarData();
    }

//    public static List<Integer> getSecondBarData() {
//        return ScreenTimeData.getSecondBarData();
//    }
}
