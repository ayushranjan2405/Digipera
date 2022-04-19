package com.digipera.repositories.configs;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicConfig {
    public final static String DATABASE_NAME = "digipera.db";    // Database Name
    public final static int DATABASE_VERSION = 17;    // Database Version
    public final static List<String> createTableList = new ArrayList<>();
    public final static List<String> dropTableList = new ArrayList<>();

    protected abstract void registerCreateTableList();
//    {
//        List<String> list = new ArrayList<>();
//        list.add(AccountConfig.CREATE_TABLE);
//        list.add(NotificationConfig.CREATE_TABLE);
//        return list;
//    }

    protected abstract void registerDropTableList();
//    {
//        List<String> list = new ArrayList<>();
//        list.add(AccountConfig.DROP_TABLE);
//        list.add(NotificationConfig.DROP_TABLE);
//        return list;
//    }

}
