package com.digipera.services;

import com.digipera.mockdata.RewardsData;

import java.util.Map;

public class RewardService {

    public static Map<String, Integer> getPieChartData() {
        RewardsData rewardsData = new RewardsData();
        return rewardsData.getPieChartData();
    }

}
