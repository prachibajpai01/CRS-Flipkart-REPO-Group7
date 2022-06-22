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
            System.out.println("2. Student Registration");
            System.out.println("3. Update password");
            System.out.println("4. Exit");
            System.out.println("Enter your choice :");
            userInput=sc.nextInt();
        }while(userInput!=4);
    }
}