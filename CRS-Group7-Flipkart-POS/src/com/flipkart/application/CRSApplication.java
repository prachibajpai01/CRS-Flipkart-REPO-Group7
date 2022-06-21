package com.flipkart.application;

import com.flipkart.constant.Role;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.UserImpl;

import java.util.*;

public class CRSApplication {
    UserImpl userImpl = new UserImpl();
    StudentImpl studentImpl = new StudentImpl();
    static boolean loggedin = false;

    static HashMap<String, ArrayList<String>> dummyUserData = new HashMap<String, ArrayList<String>>();

    public static void main(String[] args) {

        dummyUserData.put("1", new ArrayList<String>() {
            {
                add("qwer");
                add("professor");
            }
        });
        dummyUserData.put("2", new ArrayList<String>() {
            {
                add("tyui");
                add("student");
            }
        });
        dummyUserData.put("3", new ArrayList<String>() {
            {
                add("asdf");
                add("admin");
            }
        });

        Scanner sc = new Scanner(System.in);
        CRSApplication crsApplication = new CRSApplication();

        int userInput;
        do {
            System.out.println("----------Welcome to CRS Application---------");
            System.out.println("1. Login");
            System.out.println("2. Student Registration");
            System.out.println("3. Update password");
            System.out.println("4. Exit");
            System.out.println("Enter your choice :");
            userInput = sc.nextInt();

            switch (userInput) {
                case 1:
                    crsApplication.loginUser();
                    break;
                case 2:
                    crsApplication.registerStudent();
                    break;
                case 3:
                    crsApplication.updatePassword();
                    break;
                default:
                    System.out.println("Invalid Input. Please try again!!");
            }
        } while (userInput != 4);
    }

    public void loginUser() {
        Scanner sc = new Scanner(System.in);
        String userId, password;
        System.out.println("Email:");
        userId = sc.next();
        System.out.println("Password:");
        password = sc.next();

        loggedin = userImpl.authenticate(userId, password, dummyUserData);

        if (loggedin) {
            String role = userImpl.getRole(userId);
            Role userRole = Role.stringToName(role);
            switch (userRole) {
                case ADMIN:
                    AdminCRSMenu adminCRSMenu = new AdminCRSMenu();
                    adminCRSMenu.createMenu();
                case PROFESSOR:
                    //call menu
                case STUDENT:
                    int studentId = studentImpl.getStudentId(userId);
                    boolean isApproved = studentImpl.isApproved(studentId);

                    if (isApproved) {
                        StudentCRSMenu studentCRSMenu = new StudentCRSMenu();
                        studentCRSMenu.create_menu(studentId);
                    } else {
                        System.out.println("Failed to login, you have not been approved by the administration!");
                    }
                    break;
            }
        } else {
            System.out.println("Invalid credentials");
        }
    }

    public void registerStudent() {
        Scanner sc = new Scanner(System.in);
        String userId, name, password, address, country, branch;
        int batch;

        System.out.println("Name:");
        name = sc.nextLine();
        System.out.println("Email:");
        userId = sc.next();
        System.out.println("Password:");
        password = sc.next();
        System.out.println("Batch:");
        batch = sc.nextInt();
        System.out.println("Branch:");
        branch = sc.nextLine();
        sc.nextLine();
        System.out.println("Address:");
        address = sc.nextLine();
        System.out.println("Country");
        country = sc.next();

        int studentId = studentImpl.register(name, userId, password, batch, branch, address, country);
    }

    public void updatePassword() {
        Scanner sc = new Scanner(System.in);
        String userId, newPassword;
        System.out.println("Email");
        userId = sc.next();
        System.out.println("New Password:");
        newPassword = sc.next();

        boolean isUpdated = userImpl.updatePassword(userId, newPassword);

        if (isUpdated)
            System.out.println("Password updated successfully!");

        else
            System.out.println("Error while updating. Please try again!");
    }
}

