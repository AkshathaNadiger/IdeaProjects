package com.ioc.coupling;

public class NewDataBaseProvider implements UserDataProvider {
    @Override
    public String getUserDetails() {

        return "Fetching from NewDB";
    }
}
