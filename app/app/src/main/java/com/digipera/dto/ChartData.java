package com.digipera.dto;

import java.util.List;

public class ChartData {

    private final List<String> categories;
    private final List<Integer> firstBar;
    private final List<Integer> secondBar;
    private final int firstBarColor;
    private final int secondBarColor;
    private final String label;

    public ChartData(List<String> categories, List<Integer> firstBar, List<Integer> secondBar, int firstBarColor, int secondBarColor, String label) {
        this.categories = categories;
        this.firstBar = firstBar;
        this.secondBar = secondBar;
        this.firstBarColor = firstBarColor;
        this.secondBarColor = secondBarColor;
        this.label = label;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<Integer> getFirstBar() {
        return firstBar;
    }

    public List<Integer> getSecondBar() {
        return secondBar;
    }

    public int getFirstBarColor() {
        return firstBarColor;
    }

    public int getSecondBarColor() {
        return secondBarColor;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "categories=" + categories +
                ", firstBar=" + firstBar +
                ", secondBar=" + secondBar +
                ", firstBarColor=" + firstBarColor +
                ", secondBarColor=" + secondBarColor +
                ", label='" + label + '\'' +
                '}';
    }
}
