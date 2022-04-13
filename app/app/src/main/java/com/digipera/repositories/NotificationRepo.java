package com.digipera.repositories;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.digipera.dao.BasicNotification;
import com.digipera.repositories.configs.NotificationConfig;

import java.util.ArrayList;
import java.util.List;

public class NotificationRepo extends BasicRepository<BasicNotification, String> {

    public NotificationRepo(Context context) {
        super(context, new NotificationConfig(), NotificationConfig.CREATE_TABLE, NotificationConfig.DROP_TABLE);
    }

    @Override
    public void insert(BasicNotification notification) {
        SQLiteDatabase dbb = factory.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationConfig.UID, notification.getUid());
        contentValues.put(NotificationConfig.USERNAME, notification.getForUser());
        contentValues.put(NotificationConfig.LINE1_LEFT, notification.getLine1Left());
        contentValues.put(NotificationConfig.LINE1_RIGHT, notification.getLine1Right());
        contentValues.put(NotificationConfig.LINE2_LEFT, notification.getLine2Left());
        contentValues.put(NotificationConfig.TYPE, notification.getType());
        dbb.insert(NotificationConfig.TABLE_NAME, null, contentValues);
    }

    @Override
    public void insertAll(List<BasicNotification> object) {

    }

    @Override
    public void update(BasicNotification object, String key) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public BasicNotification get(String key) {
        return null;
    }

    @Override
    public List<BasicNotification> getAll(String key) {

        SQLiteDatabase db = factory.getWritableDatabase();
        List<BasicNotification> notifications = new ArrayList<>();

        String[] columns = {
                NotificationConfig.UID,
                NotificationConfig.USERNAME,
                NotificationConfig.LINE1_LEFT,
                NotificationConfig.LINE1_RIGHT,
                NotificationConfig.LINE2_LEFT,
                NotificationConfig.LINE2_RIGHT,
                NotificationConfig.CREATED_ON,
                NotificationConfig.TYPE
        };

        String[] whereArgs = {key};

        Cursor cursor = db.query(
                NotificationConfig.TABLE_NAME,
                columns, NotificationConfig.USERNAME + "=?", whereArgs, null, null,
                NotificationConfig.CREATED_ON + " DESC");

        while (cursor.moveToNext()) {
            @SuppressLint("Range") long uid = cursor.getLong(cursor.getColumnIndex(NotificationConfig.UID));
            @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex(NotificationConfig.USERNAME));
            @SuppressLint("Range") String line1Left = cursor.getString(cursor.getColumnIndex(NotificationConfig.LINE1_LEFT));
            @SuppressLint("Range") String line1Right = cursor.getString(cursor.getColumnIndex(NotificationConfig.LINE1_RIGHT));
            @SuppressLint("Range") String line2Left = cursor.getString(cursor.getColumnIndex(NotificationConfig.LINE2_LEFT));
            @SuppressLint("Range") String line2Right = cursor.getString(cursor.getColumnIndex(NotificationConfig.LINE2_RIGHT));
            @SuppressLint("Range") String createdOn = cursor.getString(cursor.getColumnIndex(NotificationConfig.CREATED_ON));
            @SuppressLint("Range") String type = cursor.getString(cursor.getColumnIndex(NotificationConfig.TYPE));
            notifications.add(new BasicNotification(uid, username, line1Left, line1Right, line2Left, line2Right, createdOn, type));
        }
        cursor.close();
        return notifications;
    }

    public List<BasicNotification> getAllFundTransferNotifications(String key, String notificationType) {

        SQLiteDatabase db = factory.getWritableDatabase();
        List<BasicNotification> notifications = new ArrayList<>();

        String[] columns = {
                NotificationConfig.UID,
                NotificationConfig.USERNAME,
                NotificationConfig.LINE1_LEFT,
                NotificationConfig.LINE1_RIGHT,
                NotificationConfig.LINE2_LEFT,
                NotificationConfig.LINE2_RIGHT,
                NotificationConfig.CREATED_ON,
                NotificationConfig.TYPE
        };

        String[] whereArgs = {key, notificationType};
        String selection = String.format("%s = ? AND %s = ?", NotificationConfig.USERNAME, NotificationConfig.TYPE );

        Cursor cursor = db.query(
                NotificationConfig.TABLE_NAME,
                columns, selection, whereArgs, null, null,
                NotificationConfig.CREATED_ON + " DESC");

        while (cursor.moveToNext()) {
            @SuppressLint("Range") long uid = cursor.getLong(cursor.getColumnIndex(NotificationConfig.UID));
            @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex(NotificationConfig.USERNAME));
            @SuppressLint("Range") String line1Left = cursor.getString(cursor.getColumnIndex(NotificationConfig.LINE1_LEFT));
            @SuppressLint("Range") String line1Right = cursor.getString(cursor.getColumnIndex(NotificationConfig.LINE1_RIGHT));
            @SuppressLint("Range") String line2Left = cursor.getString(cursor.getColumnIndex(NotificationConfig.LINE2_LEFT));
            @SuppressLint("Range") String line2Right = cursor.getString(cursor.getColumnIndex(NotificationConfig.LINE2_RIGHT));
            @SuppressLint("Range") String createdOn = cursor.getString(cursor.getColumnIndex(NotificationConfig.CREATED_ON));
            @SuppressLint("Range") String type = cursor.getString(cursor.getColumnIndex(NotificationConfig.TYPE));
            notifications.add(new BasicNotification(uid, username, line1Left, line1Right, line2Left, line2Right, createdOn, type));
        }
        cursor.close();
        return notifications;
    }
}