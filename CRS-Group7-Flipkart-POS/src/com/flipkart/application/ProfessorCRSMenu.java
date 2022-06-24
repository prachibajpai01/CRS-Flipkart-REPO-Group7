package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.ProfessorInterface;
import java.util.*;

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
     * Professor service instance
     */
    ProfessorImpl professorImpl=new ProfessorImpl();

    /**
     * Whether a professor is logged in or not
     */
    Boolean isLoggedIn=true;

    public void createMenu(String profId) {
        /**
         * Create CRS menu for professor with various options.
         * @param profId ID of professor
         */
            while (isLoggedIn) {
                System.out.println("*****************************");
                System.out.println("**********Professor Menu*********");
                System.out.println("*****************************");
                System.out.println("1: Get Courses");
                System.out.println("2. View Enrolled Students");
                System.out.println("3: Add grades");
                System.out.println("4: Logout");
                System.out.println("*****************************");

                System.out.println("Enter Choice");

                int choice;

                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        //view all the courses taught by the professor
                        getCourses(profId);
                        break;
                    case 2:
                        //view all the enrolled students for the course
                        viewEnrolledStudents(profId);
                        break;

                    case 3:
                        //add grade for a student
                        addGrade(profId);
                        break;
                    case 4:
                        //logout from the system
                        CRSApplication.loggedin = false;
                        return;
                    default:
                        System.out.println("***** Wrong Choice *****");
                }
            }
        }

        private void addGrade (String profId){

            System.out.println("Enter student Id");
            String studentId = sc.nextLine();
            sc.nextLine();
            System.out.println("Enter Grade");
            String grade = sc.nextLine();

            System.out.println("Enter Course Code :");

            String courseCode = sc.nextLine();

            if (professorImpl.addGrade(studentId, courseCode, grade))
                System.out.println("Grade added successfully");
        }

        /**
         * Display enrolled students in a course.
         * @param profId ID of professor
         */
        private void viewEnrolledStudents (String profId){
            List<EnrolledStudent> data = professorImpl.viewEnrolledStudents(profId);
            if (data.isEmpty()) {
                System.out.println("No student found!!");
                return;
            }
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i).getStudentId() + " ");
            }

        }

        private void getCourses (String profId){
            ArrayList<Course> courses = professorImpl.getCourses(profId);
            if (courses.isEmpty()) {
                System.out.println("No courses found");
                return;
            }
            for (int i = 0; i < courses.size(); i++) {
                System.out.println(courses.get(i).getCourseName() + " ");


            }
        }
    }