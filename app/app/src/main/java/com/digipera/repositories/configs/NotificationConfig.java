package com.digipera.repositories.configs;

public class NotificationConfig extends BasicConfig {
    public static final String TABLE_NAME = "notification";   // Table Name
    public static final String UID="_id";     // Column I (Primary Key)
    public static final String USERNAME = "username";
    public static final String CREATED_ON = "created_on";
    public static final String TYPE = "type";
    public static final String LINE1_LEFT = "line1_left";
    public static final String LINE1_RIGHT = "line1_right";
    public static final String LINE2_LEFT = "line2_left";
    public static final String LINE2_RIGHT = "line2_right";


    public static final String CREATE_TABLE_COLUMNS = String.format("%s INTEGER PRIMARY KEY NOT NULL, %s VARCHAR(55) NOT NULL, %s datetime default current_timestamp, %s VARCHAR(20) NOT NULL, %s VARCHAR(255), %s VARCHAR(255), %s VARCHAR(255), %s VARCHAR(25)", UID, USERNAME, CREATED_ON, TYPE, LINE1_LEFT, LINE1_RIGHT, LINE2_LEFT, LINE2_RIGHT);
    public static final String CREATE_TABLE = String.format("CREATE TABLE %s ( %s);", TABLE_NAME, CREATE_TABLE_COLUMNS);
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    //public static final String UID="_id";     // Column I (Primary Key)
    //    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
//            " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+PERSON_NAME+" VARCHAR(255) ,"+ BALANCE+" DECIMAL(10.2));";


    @Override
    protected void registerCreateTableList() {
        BasicConfig.createTableList.add(CREATE_TABLE);
    }

    @Override
    protected void registerDropTableList() {
        BasicConfig.dropTableList.add(DROP_TABLE);
    }
}
