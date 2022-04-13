package com.digipera.mockdata;

import com.digipera.commons.Constants;
import com.digipera.dao.BasicNotification;

import java.util.ArrayList;
import java.util.List;

public class NotificationData {

 //   private Map<String, List<Notification>> notificationTable;

//    public NotificationData() {
//        notificationTable = new HashMap<>();
//        notificationTable.put("shilpi", getShilpiNotifications());
//        notificationTable.put("ishita", getIshitaNotifications());
//        notificationTable.put("rohan", getRohanNotifications());
//    }

//    public List<Notification> getNotifications(String username) {
//        return notificationTable.get(username);
//    }

    public static List<BasicNotification> initialLoadData(){
        List<BasicNotification> list = new ArrayList<>();

        list.add(new BasicNotification(
                1, "shilpi",
                Constants.EARNED_REWARD_SCREEN_TIME,
                "Points: 20", "By: Ishita",
                null, null, Constants.REWARDS));
        list.add(new BasicNotification(
                2, "ishita",
                Constants.EARNED_REWARD_SCREEN_TIME,
                "Points: 20", "",
                null, null, Constants.REWARDS));
        list.add(new BasicNotification(
                3, "rohan",
                Constants.EARNED_REWARD_SCREEN_TIME,
                "Points: 30", "",
                null, null, Constants.REWARDS));
        list.add(new BasicNotification(
                4, "shilpi",
                Constants.EARNED_REWARD_FITNESS,
                "Points: 40", "By: Ishita",
                null, null, Constants.REWARDS));
        list.add(new BasicNotification(
                5, "ishita",
                Constants.EARNED_REWARD_FITNESS,
                "Points: 40", "",
                null, null, Constants.REWARDS));

        return list;
    }

//    private List<Notification> getShilpiNotifications() {
//        List<Notification> notifications = new ArrayList<>();
//
//        notifications.add(new Notification("Credited to Rohan", "Rs. 1000", "Debited From: Shilpi", "April 13, 2022"));
//        notifications.add(new Notification("Paid to School Canteen", "Rs. 85", "By: Ishita", "April 12, 2022"));
//        notifications.add(new Notification("Quiz on Sports finished", "Score: 80", "By: Ishita", "April 11, 2022"));
//        notifications.add(new Notification("Paid to School Canteen", "Rs. 75", "By: Rohan", "April 11, 2022"));
//        notifications.add(new Notification("Quiz completed on Maths", "Score: 60", "By: Rohan", "April 10, 2022"));
//        notifications.add(new Notification("Paid to Book store", "Rs. 345", "By: Ishita", "April 10, 2022"));
//        return notifications;
//    }


//    private List<Notification> getIshitaNotifications() {
//        List<Notification> notifications = new ArrayList<>();
//        notifications.add(new Notification("Screen time crossed daily average", "2 h 15 mins", "Daily average: 2 hours", "April 13, 2022"));
//        notifications.add(new Notification("Paid to School Canteen", "Rs. 85", "Debited from: Ishita", "April 12, 2022"));
//        notifications.add(new Notification("Quiz completed", "Score: 80", "Topic: Sports", "April 11, 2022"));
//        notifications.add(new Notification("Paid to Book store", "Rs. 345", "By: Ishita", "April 10, 2022"));
//        notifications.add(new Notification("Received money", "Rs. 2000", "From: Shilpi", "April 09, 2022"));
//        notifications.add(new Notification("Quiz completed", "Score: 90", "Topic: Science", "April 08, 2022"));
//        notifications.add(new Notification("Paid to Ola Cab", "Rs. 105", "By: Ishita", "April 07, 2022"));
//
//        return notifications;
//    }

//    private List<Notification> getRohanNotifications() {
//        List<Notification> notifications = new ArrayList<>();
//        notifications.add(new Notification("Received money", "Rs. 1000", "From: Shilpi", "April 13, 2022"));
//        notifications.add(new Notification("Screen time crossed daily average", "2 h 15 mins", "Daily average: 2 hours", "April 12, 2022"));
//        notifications.add(new Notification("Paid to School Canteen", "Rs. 85", "Debited from: Rohan", "April 11, 2022"));
//        notifications.add(new Notification("Quiz completed", "Score: 60", "Topic: Maths", "April 10, 2022"));
//        notifications.add(new Notification("Paid to Book store", "Rs. 345", "By: Rohan", "April 09, 2022"));
//        notifications.add(new Notification("Paid to School Canteen", "Rs. 60", "Debited from: Rohan", "April 08, 2022"));
//        notifications.add(new Notification("Received Rewards", "Rs. 100", "From: Shilpi", "April 01, 2022"));
//
//        return notifications;
//    }
}
