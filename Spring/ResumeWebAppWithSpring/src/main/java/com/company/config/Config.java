package com.company.config;

import com.company.entity.User;

/**
 * Created by IntelliJ IDEA.
 * User: Alizaman
 * Date: 18/05/2020
 * Time: 01:40
 */
public final class Config {
    private static User loggedIn;

    private Config() {
    }
    public static void addUser(User user){
            loggedIn=user;
    }
    public static User getUser(){
        return loggedIn;
    }
}
