package com.Loose.coupling;

public class LooseCouplingExample {


    public static void main(String[] args) {
        UserDataProvider databaseProvider = new UserDataBaseProvider();
        UserManager userManagerWithDB = new UserManager(databaseProvider);
        System.out.println(userManagerWithDB.getUserInfo());

        UserDataProvider webserviceProvider = new WebServiceDataProvider();
        UserManager userManagerWithWS = new UserManager(webserviceProvider);
        System.out.println(userManagerWithWS.getUserInfo());

        UserDataProvider newDataBaseProvider = new NewDataBaseProvider();
        UserManager userManagerWithNewDB = new UserManager(newDataBaseProvider);
        System.out.println(userManagerWithNewDB.getUserInfo());



    }
}
