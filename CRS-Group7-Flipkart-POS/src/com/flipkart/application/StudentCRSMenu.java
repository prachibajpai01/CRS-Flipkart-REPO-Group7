package com.flipkart.application;

import java.util.*;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.service.CourseCatalogueImpl;
import com.flipkart.service.StudentImpl;

public class StudentCRSMenu {
    Scanner sc = new Scanner(System.in);

    Boolean isLoggedIn = true;
    CourseCatalogueImpl courseCatalogue = null;
    StudentImpl studentImpl=new StudentImpl();

    public void createMenu(String studentId, CourseCatalogueImpl courseCatalogue) {
        this.courseCatalogue = courseCatalogue;
        while (isLoggedIn) {
            System.out.println("*****************************");
            System.out.println("**********Student Menu*********");
            System.out.println("*****************************");
            System.out.println("1. Add Course");
            System.out.println("2. Drop Course");
            System.out.println("3. View Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. View grade card");
            System.out.println("6. Make Payment");
            System.out.println("7. Logout");
            System.out.println("*****************************");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addCourse(studentId);   //done
                    break;

                case 2:

                    dropCourse(studentId);
                    break;

                case 3:
                    viewCourse(studentId);  //done
                    break;

                case 4:
                    viewRegisteredCourse(studentId);    //done
                    break;

                case 5:
                    viewGradeCard(studentId);
                    break;

                case 6:
                    isLoggedIn = false;
                    return;

                default:
                    System.out.println("***** Wrong Choice *****");
            }
        }
    }

    private void addCourse(String studentId) {
        Scanner sc=new Scanner(System.in);
        viewCourse(studentId);

        System.out.println("Enter course id to add :");
        String newcourseid=sc.nextLine();
        studentImpl.addCourse(studentId,newcourseid,courseCatalogue);
    }

    private void dropCourse(String studentId) {
            Set<String> registeredCourseList = viewRegisteredCourse(studentId);

            if (registeredCourseList == null)
                return;

            System.out.println("Enter the Course Code : ");
            String courseCode = sc.next();
    }

    private ArrayList<Course> viewCourse(String studentId) {
        ArrayList<Course> course_available = courseCatalogue.sendCatalogue();

        if (course_available.isEmpty()) {
            System.out.println("NO COURSE AVAILABLE");
            return new ArrayList<>();
        }


        /*
        System.out.println(String.format("%-20s %-20s %-20s %-20s", "COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
        for (Course obj : course_available) {
            System.out.println(String.format("%-20s %-20s %-20s %-20s", obj.getCourseId(), obj.getCourseName(), obj.getInstructorId()));
        }
        */

        for (Course c : course_available) {
            System.out.println(c.getCourseId() + " " + c.getCourseName() + " " + c.getInstructorId());
        }
        return course_available;
    }

    private Set<String> viewRegisteredCourse(String studentId) {
        Set<String> course_registered = studentImpl.viewRegisteredCourses(studentId);

        if (course_registered==null) {
            System.out.println("You haven't registered for any course");
            return null;
        }

//        System.out.println(String.format("%-20s %-20s %-20s", "COURSE ID", "COURSE NAME", "INSTRUCTOR ID"));
//
//        for (Course obj : course_registered) {
//            System.out.println(String.format("%-20s %-20s %-20s ", obj.getCourseId(), obj.getCourseName(), obj.getInstructorId()));
//        }

        for(String s:course_registered){
            System.out.println(s);
        }

        return course_registered;
    }


    private void viewGradeCard(String studentId) {


        List<Grade> grade_card = null;
        System.out.println(String.format("%-20s %-20s %-20s", "COURSE ID", "GRADE"));

        if (grade_card.isEmpty()) {
            System.out.println("You haven't registered for any course");
            return;
        }

        for (Grade obj : grade_card) {
            System.out.println(String.format("%-20s %-20s %-20s", obj.getCourseId(), obj.getGrade()));
        }
    }

}