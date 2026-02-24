package com.tight.coupling;

public class TightCouplingExample {

    public static void main(String[] args) {
        UserManger userManger = new UserManger();
        System.out.println(userManger.getUserInfo());

    }
}
