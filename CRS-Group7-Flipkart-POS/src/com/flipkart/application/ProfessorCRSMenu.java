package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.service.CourseCatalogueImpl;
import com.flipkart.service.ProfessorImpl;

import java.util.Scanner;

public class ProfessorCRSMenu {
    Scanner sc = new Scanner(System.in);
    CourseCatalogueImpl courseCatalogue=null;
    ProfessorImpl professorImpl=new ProfessorImpl();
    Boolean isLoggedIn=true;

    public void createMenu(String profId, CourseCatalogueImpl courseCatalogue){
        this.courseCatalogue=courseCatalogue;
        while(isLoggedIn){
            System.out.println("*****************************");
            System.out.println("**********Professor Menu*********");
            System.out.println("*****************************");
            System.out.println("1. View Enrolled Students");
            System.out.println("2: Give grades");
            System.out.println("3: Logout");
            System.out.println("*****************************");

            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    viewEnrolledStudents(profId);
                case 2:
                case 3:
                    isLoggedIn=false;
                    System.out.println("Logging out");
                default:
                    System.out.println("Wrong option selected.");
            }
        }
    }

    public void viewEnrolledStudents(String profId){
        for(Course course:professorImpl.getCourses(profId, courseCatalogue)){
            System.out.println("Students in course "+course.getCourseName()+": "+courseCatalogue.getEnrolledStudents(course.getCourseId()));
        }
    }
}
