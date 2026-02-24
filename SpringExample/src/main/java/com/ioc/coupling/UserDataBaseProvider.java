package com.ioc.coupling;

public  class UserDataBaseProvider implements UserDataProvider {

    @Override
    public  String getUserDetails(){
        return "User details From Database";
    }
}
