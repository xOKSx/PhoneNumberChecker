package com.company;

public class Main {

    public static void main(String[] args) {

        String number = "( +( )749(51+2 3j/gf45а+пв 6ю.7";

        String[] report = NumberCheck.check(number);

        System.out.println(report[0]);
        System.out.println(report[1]);
    }
}
