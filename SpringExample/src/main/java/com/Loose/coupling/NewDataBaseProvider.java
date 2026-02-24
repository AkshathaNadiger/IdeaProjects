package com.Loose.coupling;

public class NewDataBaseProvider implements UserDataProvider{
    @Override
    public String getUserDetails() {
        return "Feting from NewDB";
    }
}
