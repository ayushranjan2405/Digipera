package com.digipera.repositories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.digipera.commons.Message;
import com.digipera.repositories.configs.AccountConfig;
import com.digipera.repositories.configs.BasicConfig;
import com.digipera.repositories.configs.NotificationConfig;

public class DBFactory extends SQLiteOpenHelper {

    private final Context context;
    private final BasicConfig config;
    private final String createTable;
    private final String dropTable;

//    public DBFactory(Context context, BasicConfig config) {
//        super(context, config.DATABASE_NAME, null, config.DATABASE_VERSION);
//        this.context = context;
//        this.config = config;
//    }

    public DBFactory(Context context, BasicConfig config, String createTable, String dropTable) {
        super(context, config.DATABASE_NAME, null, config.DATABASE_VERSION);
        this.context = context;
        this.config = config;
        this.createTable = createTable;
        this.dropTable = dropTable;
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            Log.i("CREATE_TABLE", createTable);
//            db.execSQL(createTable);
//            config.createTableList.forEach(db::execSQL);
//            for (int i = 0; i < BasicConfig.createTableList.size(); i++) {
//                db.execSQL(BasicConfig.createTableList.get(i));
//            }
            db.execSQL(AccountConfig.CREATE_TABLE);
            db.execSQL(NotificationConfig.CREATE_TABLE);
        } catch (Exception e) {
            Message.message(context, "" + e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Message.message(context, "OnUpgrade");
//            db.execSQL(dropTable);
//            config.dropTableList.forEach(db::execSQL);
//            for (int i = 0; i < BasicConfig.dropTableList.size(); i++) {
//                db.execSQL(BasicConfig.dropTableList.get(i));
//            }
            db.execSQL(AccountConfig.DROP_TABLE);
            db.execSQL(NotificationConfig.DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Message.message(context, "" + e);
        }
    }
}
