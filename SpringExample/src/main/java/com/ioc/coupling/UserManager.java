package com.ioc.coupling;

public class UserManager {
    public UserDataProvider userDataProvider;

    public UserManager(UserDataProvider userDataProvider) {

        this.userDataProvider = userDataProvider;
    }

    public String getUserInfo(){
        return userDataProvider.getUserDetails();
    }
}
