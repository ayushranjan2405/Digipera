package com.digipera.mockdata;

import com.digipera.dto.HorizontalCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ScreenTimeData {

    private final Map<String, List<HorizontalCard>> screenTimeTable;

    public ScreenTimeData() {
        screenTimeTable = new HashMap<>();
        screenTimeTable.put("shilpi", getShilpiData());
        screenTimeTable.put("ishita", getIshitaData());
        screenTimeTable.put("rohan", getRohanData());
    }

    public List<HorizontalCard> getDailyData(String dependent) {
        return screenTimeTable.get(dependent);
    }

    private List<HorizontalCard> getRohanData() {
        List<HorizontalCard> activities = new ArrayList<>();
        activities.add(new HorizontalCard("Tuesday, April 19", "", "2h 12m", "Ave: 2h 12m"));
        activities.add(new HorizontalCard("Monday, April 18", "", "1h 56m", "Ave: 2h 04m"));
        activities.add(new HorizontalCard("Sunday, April 17", "", "1h 50m", "Ave: 1h 59m"));
        activities.add(new HorizontalCard("Saturday, April 16", "", "1h 40m", "Ave: 1h 54m"));
        activities.add(new HorizontalCard("Friday, April 15", "", "2h 49m", "Ave: 2h 04m"));
        activities.add(new HorizontalCard("Thursday, April 14", "", "1h 42m", "Ave: 2h 02m"));
        activities.add(new HorizontalCard("Wednesday, April 13", "", "2h 45m", "Ave: 2h 10m"));
        return activities;
    }

    private List<HorizontalCard> getIshitaData() {
        List<HorizontalCard> activities = new ArrayList<>();
        activities.add(new HorizontalCard("Tuesday, April 19", "", "2h 14m", "Ave: 2h 14m"));
        activities.add(new HorizontalCard("Monday, April 18", "", "2h 21m", "Ave: 2h 17m"));
        activities.add(new HorizontalCard("Sunday, April 17", "", "2h 33m", "Ave: 2h 22m"));
        activities.add(new HorizontalCard("Saturday, April 16", "", "2h 44m", "Ave: 2h 24m"));
        activities.add(new HorizontalCard("Friday, April 15", "", "2h 30m", "Ave: 2h 23m"));
        activities.add(new HorizontalCard("Thursday, April 14", "", "1h 40m", "Ave: 2h 05m"));
        activities.add(new HorizontalCard("Wednesday, April 13", "", "2h 0m", "Ave: 2h 04m"));
        return activities;
    }

    private List<HorizontalCard> getShilpiData() {
        List<HorizontalCard> activities = new ArrayList<>();
        activities.add(new HorizontalCard("Tuesday, April 19", "", "2h 14m", ""));
        activities.add(new HorizontalCard("Monday, April 18", "", "2h 21m", ""));
        activities.add(new HorizontalCard("Sunday, April 17", "", "2h 33m", ""));
        activities.add(new HorizontalCard("Saturday, April 16", "", "2h 44m", ""));
        activities.add(new HorizontalCard("Friday, April 15", "", "2h 30m", ""));
        activities.add(new HorizontalCard("Thursday, April 14", "", "1h 40m", ""));
        activities.add(new HorizontalCard("Wednesday, April 13", "", "2h 4m", ""));
        return activities;
    }

    public static List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Nov,21");
        categories.add("Dec,21");
        categories.add("Jan,22");
        categories.add("Feb,22");
        categories.add("Mar,22");
        categories.add("Apr,22");
        return categories;
    }

    public static List<Integer> getFirstBarData() {
        return getRandomValues(160, 30);
    }

    public static List<Integer> getSecondBarData() {
        return getRandomValues(160, 30);
    }

    private static List<Integer> getRandomValues(int max, int min){
        Random rand = new Random();
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<getCategories().size(); i++){
            values.add(rand.nextInt(max - min  ) + min);
        }
        return values;
    }
}
