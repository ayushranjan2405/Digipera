package com.digipera.mockdata;

import com.digipera.dto.HorizontalCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FitnessActivityData {

    private final Map<String, List<HorizontalCard>> fitnessActivityTable;

    public FitnessActivityData() {
        fitnessActivityTable = new HashMap<>();
        fitnessActivityTable.put("shilpi", getShilpiData());
        fitnessActivityTable.put("ishita", getIshitaData());
        fitnessActivityTable.put("rohan", getRohanData());
    }


    public List<HorizontalCard> getDailyData(String dependent) {
        return fitnessActivityTable.get(dependent);
    }
    private List<HorizontalCard> getRohanData() {
        List<HorizontalCard> activities = new ArrayList<>();
        activities.add(new HorizontalCard("Tuesday, April 19", "", "Steps: 9600", "Heart points: 49"));
        activities.add(new HorizontalCard("Monday, April 18", "", "Steps: 8500", "Heart points: 45"));
        activities.add(new HorizontalCard("Sunday, April 17", "", "Steps: 9900", "Heart points: 50"));
        activities.add(new HorizontalCard("Saturday, April 16", "", "Steps: 8040", "Heart points: 40"));
        activities.add(new HorizontalCard("Friday, April 15", "", "Steps: 9100", "Heart points: 43"));
        activities.add(new HorizontalCard("Thursday, April 14", "", "Steps: 8400", "Heart points: 41"));
        activities.add(new HorizontalCard("Wednesday, April 13", "", "Steps: 8000", "Heart points: 40"));
        return activities;
    }

    private List<HorizontalCard> getIshitaData() {
        List<HorizontalCard> activities = new ArrayList<>();
        activities.add(new HorizontalCard("Tuesday, April 19", "", "Steps: 8600", "Heart points: 44"));
        activities.add(new HorizontalCard("Monday, April 18", "", "Steps: 8500", "Heart points: 45"));
        activities.add(new HorizontalCard("Sunday, April 17", "", "Steps: 9800", "Heart points: 50"));
        activities.add(new HorizontalCard("Saturday, April 16", "", "Steps: 8040", "Heart points: 40"));
        activities.add(new HorizontalCard("Friday, April 15", "", "Steps: 8100", "Heart points: 45"));
        activities.add(new HorizontalCard("Thursday, April 14", "", "Steps: 7400", "Heart points: 31"));
        activities.add(new HorizontalCard("Wednesday, April 13", "", "Steps: 9000", "Heart points: 48"));
        return activities;
    }

    private List<HorizontalCard> getShilpiData() {
        List<HorizontalCard> activities = new ArrayList<>();
        activities.add(new HorizontalCard("Tuesday, April 19", "", "Steps: 3600", "Heart points: 44"));
        activities.add(new HorizontalCard("Monday, April 18", "", "Steps: 3500", "Heart points: 45"));
        activities.add(new HorizontalCard("Sunday, April 17", "", "Steps: 2900", "Heart points: 38"));
        activities.add(new HorizontalCard("Saturday, April 16", "", "Steps: 3040", "Heart points: 40"));
        activities.add(new HorizontalCard("Friday, April 15", "", "Steps: 3100", "Heart points: 38"));
        activities.add(new HorizontalCard("Thursday, April 14", "", "Steps: 3400", "Heart points: 41"));
        activities.add(new HorizontalCard("Wednesday, April 13", "", "Steps: 3000", "Heart points: 40"));
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
        return getRandomValues(10000, 4000);
    }

    public static List<Integer> getSecondBarData() {
        return getRandomValues(10000, 4000);
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
