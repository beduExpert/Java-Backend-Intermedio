package com.example.rest;

public class Subscriber {

    public static void multiplicar(Integer n)  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Subscriber2: "+n*n);
    }
}
