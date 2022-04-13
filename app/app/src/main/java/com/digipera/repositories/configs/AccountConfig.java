package com.digipera.repositories.configs;

import java.util.List;

public class AccountConfig extends BasicConfig {
    public static final String TABLE_NAME = "account";   // Table Name
    public static final String HOLDER_NAME = "holder_name";    //Column I (Primary Key)
    public static final String BALANCE = "balance";    //Column II
    public static final String REWARD_POINTS = "reward_points";    //Column III
    public static final String DAILY_SCREEN_TIME = "daily_screen_time_mins";    //Column IV
    public static final String DAILY_ACTIVITY_TIME = "daily_activity_time_mins";    //Column V
    public static final String USER_TYPE = "user_type";    //Column VI
    public static final String CREATE_TABLE_COLUMNS = String.format("%s VARCHAR(255) PRIMARY KEY, %s DECIMAL(10,2), %s INTEGER, %s INTEGER, %s INTEGER, %s VARCHAR(25)", HOLDER_NAME, BALANCE, REWARD_POINTS, DAILY_SCREEN_TIME, DAILY_ACTIVITY_TIME, USER_TYPE);
    public static final String CREATE_TABLE = String.format("CREATE TABLE %s ( %s);", TABLE_NAME, CREATE_TABLE_COLUMNS);
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    @Override
    protected void registerCreateTableList() {
        BasicConfig.createTableList.add(CREATE_TABLE);
    }

    @Override
    protected void registerDropTableList() {
        BasicConfig.dropTableList.add(DROP_TABLE);
    }
}
