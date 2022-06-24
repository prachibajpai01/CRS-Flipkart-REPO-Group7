package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.service.CourseCatalogueImpl;
import com.flipkart.service.ProfessorImpl;

import java.util.Scanner;

/**
 * Class for Professor CRS menu
 */
public class ProfessorCRSMenu {

    /**
     * Scanner to take user input
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Course catalogue service instance
     */
    CourseCatalogueImpl courseCatalogue=null;

    /**
     * Professor service instance
     */
    ProfessorImpl professorImpl=new ProfessorImpl();

    /**
     * Whether a professor is logged in or not
     */
    Boolean isLoggedIn=true;

    /**
     * Create CRS menu for professor with various options.
     * @param profId ID of professor
     * @param courseCatalogue Catalogue of courses to interact with courses.
     */
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

    /**
     * Display enrolled students in a course.
     * @param profId ID of professor
     */
    public void viewEnrolledStudents(String profId){
        for(Course course:professorImpl.getCourses(profId, courseCatalogue)){
            System.out.println("Students in course "+course.getCourseName()+": "+courseCatalogue.getEnrolledStudents(course.getCourseId()));
        }
    }
}
