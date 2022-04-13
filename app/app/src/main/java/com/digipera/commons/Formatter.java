package com.digipera.commons;

import com.digipera.dto.Dependent;
import com.digipera.dto.Person;
import com.digipera.dto.User;

public class Formatter {

    public static String getWelcomeMessage(String firstname) {
        return String.format(Constants.WELCOME_MESSAGE, firstname);
    }

    public static String getDependentMessage(String firstname) {
        return String.format(Constants.DEPENDENT_MESSAGE, firstname);
    }

    public static String toFirstCharUpperCase(String name) {
        //To be safe 1st changing all characters to lowercase
        // and then changing 1st character to uppercase
        String toLowerCase = name.toLowerCase();
        return toLowerCase.substring(0, 1).toUpperCase() + toLowerCase.substring(1);
    }


//    public static String getInitials(Person person) {
//        return person.getFirstname().substring(0, 1) + person.getLastname().substring(0, 1);
//    }

    public static String getInitials(User user) {
        return "" + user.getFirstname().charAt(0) + user.getLastname().charAt(0);
    }

    public static String getInitials(Dependent dependent) {
        return "" + dependent.getFirstname().charAt(0) + dependent.getLastname().charAt(0);
    }

    public static String getBalance(String balance) {
        return Constants.BALANCE_TEXT + balance;
    }

    public static String getBalance(float balance) {
        return Constants.BALANCE_TEXT + balance;
    }
    public static String getRewards(String rewardPoints) {
        return Constants.REWARD_TEXT + rewardPoints;
    }

    public static String getRewards(int rewardPoints) {
        return Constants.REWARD_TEXT + rewardPoints;
    }

//    public static String getNamePlate(Person person) {
//        if (person.getRelation().equalsIgnoreCase(Constants.DEPENDENT)){
//            return getDependentMessage(person.getFirstname());
//        } else {
//            return getWelcomeMessage(person.getFirstname());
//        }
//    }

    public static String getScreenTitle(Person person, String screen) {
        if (person.getRelation().equalsIgnoreCase(Constants.DEPENDENT)){
            return String.format(Constants.TITLE_SUMMARY, person.getFirstname(), screen);
        } else {
            return String.format(Constants.TITLE_MY_SUMMARY, screen);
        }
    }


    public static String buildViewText(String prefix, String text) {
        return prefix + toFirstCharUpperCase(text);
    }
}
