package com.digipera.mockdata;

import com.digipera.commons.Constants;
import com.digipera.dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    private final Map<String, User> users;

    public UserData() {
        users = new HashMap<>();
        users.put(Constants.SHILPI_USERNAME,
                new User(Constants.SHILPI_USERNAME, Constants.SHILPI_FIRSTNAME, Constants.SHILPI_LASTNAME, "32", Constants.PARENT));
        users.put(Constants.ISHITA_USERNAME,
                new User(Constants.ISHITA_USERNAME, Constants.ISHITA_FIRSTNAME, Constants.ISHITA_LASTNAME, "16", Constants.DEPENDENT));
        users.put(Constants.ROHAN_USERNAME,
                new User(Constants.ROHAN_USERNAME, Constants.ROHAN_FIRSTNAME, Constants.ROHAN_LASTNAME, "13", Constants.DEPENDENT));
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
