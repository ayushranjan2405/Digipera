package com.digipera.services;

import com.digipera.dto.User;
import com.digipera.mockdata.UserData;

public class UserService {

    public static User authenticate(String username) {

        if (isUserValid(username)) {
            return getUser(username);
        } else {
            return null;
        }

    }

    private static boolean isUserValid(String username) {
        return !username.isEmpty();
    }

    private static User getUser(String username) {
        UserData userData = new UserData();
        return userData.getUser(username.toLowerCase());
    }

}
