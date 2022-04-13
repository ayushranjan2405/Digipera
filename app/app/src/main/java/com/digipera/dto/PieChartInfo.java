package com.digipera.dto;

import java.util.List;

public class PieChartInfo {
    private final List<String> labels;
    private final List<String> values;

    public PieChartInfo(List<String> labels, List<String> values) {
        this.labels = labels;
        this.values = values;
    }

    public List<String> getLabels() {
        return labels;
    }

    public List<String> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "PieChartData{" +
                "labels=" + labels +
                ", values=" + values +
                '}';
    }
}