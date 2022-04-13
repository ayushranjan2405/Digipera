package com.digipera.services;

import android.content.Context;
import android.util.Log;

import com.digipera.commons.Constants;
import com.digipera.commons.Formatter;
import com.digipera.dao.BasicNotification;
import com.digipera.dto.Notification;
import com.digipera.mockdata.NotificationData;
import com.digipera.repositories.NotificationRepo;
import com.digipera.utils.DateTimeUtil;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class NotificationService extends BasicService {

    private final NotificationRepo repo;

    public NotificationService(Context context) {
        super(context);
        //this.repo = (NotificationRepo) new RepoFactory().getRepo(context, Constants.NOTIFICATION_REPO);
        this.repo = new NotificationRepo(context);
    }

    @Override
    public void initialLoad() {
        Log.i("TABLE_LOAD_NOTIFICATION", "initialLoad");
        NotificationData.initialLoadData().forEach(this.repo::insert);
    }

//    public static List<Notification> getNotifications(String username) {
//        Log.i("Username_notification: ", username.toLowerCase());
//        NotificationData notificationData = new NotificationData();
//        return notificationData.getNotifications(username.toLowerCase());
//    }

    public List<Notification> getAll(String username) {
        Log.i("Username_notification", username.toLowerCase());
        List<BasicNotification> notificationDaoList = this.repo.getAll(username.toLowerCase());

        List<Notification> notificationDtoList = new ArrayList<>();
        notificationDaoList.forEach(notificationDao -> {
            Log.i("NOTIFICATION_DAO: ", notificationDao.toString());
            Notification notificationDto = new Notification(
                    notificationDao.getLine1Left(),
                    notificationDao.getLine1Right(),
                    notificationDao.getLine2Left(),
                    DateTimeUtil.toDateString(notificationDao.getCreatedOn()));
            notificationDtoList.add(notificationDto);
        });

        return notificationDtoList;
    }

    public List<Notification> getAllFundTransferNotifications(String username, String type) {
        Log.i("Username_notification: ", username.toLowerCase());
        List<BasicNotification> notificationDaoList = this.repo.getAllFundTransferNotifications(username.toLowerCase(), type);

        List<Notification> notificationDtoList = new ArrayList<>();
        notificationDaoList.forEach(notificationDao -> {
            Log.i("NOTIFICATION_DAO: ", notificationDao.toString());
            Notification notificationDto = new Notification(
                    notificationDao.getLine1Left(),
                    notificationDao.getLine1Right(),
                    notificationDao.getLine2Left(),
                    DateTimeUtil.toDateString(notificationDao.getCreatedOn()));
            notificationDtoList.add(notificationDto);
        });

        return notificationDtoList;
    }

    public void addFundTransferNotification(String from, String to, String forUser, String amount, String transType) {

        BasicNotification notification;
        if (transType.equalsIgnoreCase(Constants.CREDIT)){
            notification = new BasicNotification(Instant.now().toEpochMilli(), forUser.toLowerCase(),
                    "Credited to " + Formatter.toFirstCharUpperCase(to),
                    "Rs. " + amount,
                    "By: " + Formatter.toFirstCharUpperCase(from),
                    null, null, Constants.FUND_TRANSFER);

        } else{
            notification = new BasicNotification(Instant.now().toEpochMilli(), forUser.toLowerCase(),
                    "Transferred to " + Formatter.toFirstCharUpperCase(to),
                    "Rs. " + amount,
                    "By: " + Formatter.toFirstCharUpperCase(from),
                    null, null, Constants.FUND_TRANSFER);

        }

        repo.insert(notification);
    }

    public void addPaymentNotification(String from, String to, String forUser, String amount) {
        BasicNotification notification = new BasicNotification(Instant.now().toEpochMilli(), forUser.toLowerCase(),
                "Paid to " + Formatter.toFirstCharUpperCase(to),
                "Rs. " + amount,
                "Debited From: " + Formatter.toFirstCharUpperCase(from),
                null, null, Constants.FUND_TRANSFER);
        repo.insert(notification);
    }

}

