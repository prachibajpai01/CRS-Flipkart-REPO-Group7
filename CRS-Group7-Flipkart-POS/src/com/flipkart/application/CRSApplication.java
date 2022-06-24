package com.flipkart.application;

import java.util.Scanner;

public class CRSApplication {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        CRSApplication crsApplication = new CRSApplication();

        int userInput;
        do{
            System.out.println("----------Welcome to CRS Application---------");
            System.out.println("1. Login");
            System.out.println("2. Update password");
            System.out.println("3. Exit");
            System.out.println("Enter your choice :");
            userInput=sc.nextInt();

            if(userInput==1){
                login();
            }
        }while(userInput!=3);
    }

    public static void login(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Give user ID:");
        String userId = sc.next();
        System.out.print("Give password:");
        String password = sc.next();


    }
}