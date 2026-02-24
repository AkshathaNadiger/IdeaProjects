package com.tight.coupling;

public class UserManger {

    private UserDataBase userDataBase = new UserDataBase();

    public String getUserInfo() {
        return userDataBase.getUserDetails();
    }
}
