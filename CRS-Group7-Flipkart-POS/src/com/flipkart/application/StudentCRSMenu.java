package com.flipkart.application;
import java.util.*;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Grade;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorImpl;



public class StudentCRSMenu {
    Scanner sc = new Scanner(System.in);
    private boolean is_registered;

    Boolean isLoggedIn = true;

    public void create_menu(int studentId) {

        while (isLoggedIn) {
            System.out.println("*****************************");
            System.out.println("**********Student Menu*********");
            System.out.println("*****************************");
            System.out.println("1. Course Registration");
            System.out.println("2. Add Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Course");
            System.out.println("5. View Registered Courses");
            System.out.println("6. View grade card");
            System.out.println("7. Make Payment");
            System.out.println("8. Logout");
            System.out.println("*****************************");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    registerCourses(studentId);
                    break;

                case 2:
                    addCourse(studentId);
                    break;

                case 3:

                    dropCourse(studentId);
                    break;

                case 4:
                    viewCourse(studentId);
                    break;

                case 5:
                    viewRegisteredCourse(studentId);
                    break;

                case 6:
                    viewGradeCard(studentId);
                    break;

                case 7:
                    isLoggedIn = false;
                    return;

                default:
                    System.out.println("***** Wrong Choice *****");
            }
        }
    }

    private void registerCourses(int studentId) {
        if (is_registered) {
            System.out.println(" Registration is already completed");
            return;
        }

        System.out.println("Registration Successful");
        is_registered = true;
    }

    private void addCourse(int studentId) {
        if (is_registered) {
            List<Course> availableCourseList = viewCourse(studentId);

            if (availableCourseList == null)
                return;

        } else {
            System.out.println("Please complete registration");
        }
    }

    private void dropCourse(int studentId)
    {
        if(is_registered)
        {
            List<Course> registeredCourseList=viewRegisteredCourse(studentId);

            if(registeredCourseList==null)
                return;

            System.out.println("Enter the Course Code : ");
            String courseCode = sc.next();
        }
        else
        {
            System.out.println("Please complete registration");
        }
    }

    private List<Course> viewCourse(int studentId)
    {
        List<Course> course_available=null;

        if(course_available.isEmpty())
        {
            System.out.println("NO COURSE AVAILABLE");
            return null;
        }


        System.out.println(String.format("%-20s %-20s %-20s %-20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
        for(Course obj : course_available)
        {
            System.out.println(String.format("%-20s %-20s %-20s %-20s",obj.getCourseId(), obj.getCourseName(),obj.getInstructorId()));
        }
        return course_available;
    }

    private List<Course> viewRegisteredCourse(int studentId)
    {
        List<Course> course_registered=null;


        if(course_registered.isEmpty())
        {
            System.out.println("You haven't registered for any course");
            return null;
        }

        System.out.println(String.format("%-20s %-20s %-20s","COURSE ID", "COURSE NAME","INSTRUCTOR ID"));

        for(Course obj : course_registered)
        {
            System.out.println(String.format("%-20s %-20s %-20s ",obj.getCourseId(), obj.getCourseName(),obj.getInstructorId()));
        }

        return course_registered;
    }


    private void viewGradeCard(int studentId)
    {


        List<Grade> grade_card=null;
        System.out.println(String.format("%-20s %-20s %-20s","COURSE ID", "GRADE"));

        if(grade_card.isEmpty())
        {
            System.out.println("You haven't registered for any course");
            return;
        }

        for(Grade obj : grade_card)
        {
            System.out.println(String.format("%-20s %-20s %-20s",obj.getCourseId(),obj.getGrade()));
        }
    }

}