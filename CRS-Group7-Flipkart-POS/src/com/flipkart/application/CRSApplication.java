package com.flipkart.application;

import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.CourseCatalogueImpl;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.UserImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


/**
 * Class for CRS application implementation and start point.
 */
public class CRSApplication {

    /**
     * User service instance
     */
    UserImpl userImpl=new UserImpl();

    /**
     * Student service instance
     */
    StudentImpl studentImpl=new StudentImpl();

    /**
     * Course catalogue service to interact with courses.
     */
    CourseCatalogueImpl courseCatalogue = new CourseCatalogueImpl();
    static boolean loggedin = false;

    /**
     * Execution of CRS Application starts here.
     * @param args any command line string srguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CRSApplication crsApplication = new CRSApplication();

        int userInput;
        do
        {
            System.out.println("----------Welcome to CRS Application---------");
            System.out.println("1. Login");
            System.out.println("2. Student Registration");
            System.out.println("3. Update password");
            System.out.println("4. Exit");
            System.out.println("Enter your choice :");
            userInput=sc.nextInt();

            switch(userInput)
            {
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
        }while(userInput!=4);
    }

    /**
     * Display current date and time.
     */
    private static void displayCurrentDateTime() {

        // Date currentDate = new Date();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();


        //System.out.println("Current Date and Time - Before Java 8 : " + currentDate);
        System.out.println("Current Date - From Java 8 : " + localDate);
        System.out.println("Current Time - From Java 8 : " + localTime);
    }

    /**
     * Login the user by taking user ID and password.
     */
    public void loginUser() {
        Scanner sc=new Scanner(System.in);
        String userId,password;
        System.out.println("User Name:");
        userId=sc.next();
        System.out.println("Password:");
        password=sc.next();

        try {
            loggedin = userImpl.authenticate(userId, password);

            if (loggedin) {
                displayCurrentDateTime();
                String role = userImpl.getRole(userId);
                switch (role) {
                    case "ADMIN":
                        AdminCRSMenu adminCRSMenu = new AdminCRSMenu();
                        adminCRSMenu.createMenu();
                    case "PROFESSOR":
                        //call menu
                    case "STUDENT":
                        String studentId = studentImpl.getStudentId(userId);
                        boolean isApproved = studentImpl.isApproved(studentId);

                        if (isApproved) {
                            StudentCRSMenu studentCRSMenu = new StudentCRSMenu();
                            studentCRSMenu.createMenu(studentId, courseCatalogue);
                        } else {
                            System.out.println("Failed to login, you have not been approved by the administration!");
                        }
                        break;
                }
            } else {
                System.out.println("Invalid credentials");
                throw new UserNotFoundException(userId);
            }
        }catch(UserNotFoundException e){
            System.out.println(e);
        }
        finally{
            System.out.println("User log in");
        }
    }

    /**
     * Register student for semester by taking details.
     */
    public void registerStudent() {
        Scanner sc=new Scanner(System.in);
        String userId,name,password,address,branch;
        int batch;

        System.out.println("Name:");
        name=sc.nextLine();
        System.out.println("Email:");
        userId=sc.next();
        System.out.println("Password:");
        password=sc.next();
        System.out.println("Batch:");
        batch=sc.nextInt();
        System.out.println("Branch:");
        branch=sc.nextLine();
        sc.nextLine();
        System.out.println("Address:");
        address=sc.nextLine();

//        int studentId=studentImpl.register(name,userId,password,batch,branch,address);
    }

    /**
     * Update password of user.
     */
    public void updatePassword() {
        Scanner sc=new Scanner(System.in);
        String userId,newPassword;
        System.out.println("Email");
        userId=sc.next();
        System.out.println("New Password:");
        newPassword=sc.next();

        boolean isUpdated=userImpl.updatePassword(userId, newPassword);

        if(isUpdated)
            System.out.println("Password updated successfully!");
        else
            System.out.println("Error while updating. Please try again!");
    }
}
