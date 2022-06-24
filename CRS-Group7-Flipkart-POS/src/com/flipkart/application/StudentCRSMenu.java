package com.flipkart.application;

import java.util.*;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.GradeCard;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.CourseCatalogueImpl;
import com.flipkart.service.StudentImpl;

/**
 * Class for Student CRS menu.
 */
public class StudentCRSMenu {

    /**
     * Scanner to take user input
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Course catalogue service instance
     */
    CourseCatalogueImpl courseCatalogue = null;

    /**
     * Student service instance
     */
    StudentImpl studentImpl=new StudentImpl();
    AdminInterface adminImpl = new AdminImpl();

    /**
     * Create CRS menu for student
     * @param studentId ID of student
     * @param courseCatalogue Catalogue of courses to interact with courses.
     */
    public void createMenu(String studentId, CourseCatalogueImpl courseCatalogue) {
        this.courseCatalogue = courseCatalogue;
        while (CRSApplication.loggedin) {
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
                    //viewGradeCard(studentId);
                    break;

                case 6:
                    CRSApplication.loggedin = false;
                    return;

                default:
                    System.out.println("***** Wrong Choice *****");
            }
        }
    }

    /**
     * Add a course for a student by taking course ID.
     * @param studentId ID of student.
     */
    private void addCourse(String studentId) {
        Scanner sc=new Scanner(System.in);
        viewCourse(studentId);

        System.out.println("Enter course id to add :");
        String newcourseid=sc.nextLine();
        studentImpl.addCourse(studentId,newcourseid,courseCatalogue);
    }

    /**
     * Drop course for a student by taking course ID
     * @param studentId ID of student
     */
    private void dropCourse(String studentId) {
            Set<String> registeredCourseList = viewRegisteredCourse(studentId);

            if (registeredCourseList == null)
                return;

            System.out.println("Enter the Course Code : ");
            String courseCode = sc.next();
            studentImpl.dropCourse(studentId,courseCode,courseCatalogue);
    }

    /**
     * Display courses available in catalogue along with returning them.
     * @param studentId ID of student
     * @return ArrayList of available courses.
     */
    private ArrayList<Course> viewCourse(String studentId) {
        ArrayList<Course> course_available = courseCatalogue.sendCatalogue();

        if (course_available.isEmpty()) {
            System.out.println("NO COURSE AVAILABLE");
            return new ArrayList<>();
        }



        System.out.println(String.format("%-20s %-20s %-20s", "COURSE CODE", "COURSE NAME", "INSTRUCTOR"));

        for (Course obj : course_available) {
            System.out.println(String.format("%-20s %-20s %-20s", obj.getCourseId(), obj.getCourseName(), obj.getInstructorId()));
        }
        return course_available;
    }

    /**
     * Display registered courses of a student
     * @param studentId ID of student
     * @return list of courses of student
     */
    private Set<String> viewRegisteredCourse(String studentId) {

       return null;
    }

    /**
     * Display grade card of student
     * @param studentId ID of student
     */
    /*private void viewGradeCard(String studentId) {


        List<EnrolledStudent> grade_card = adminImpl.generateGradeCard(studentId);
        System.out.println(String.format("%-20s %-20s %-20s", "COURSE ID", "GRADE"));

        if (grade_card.isEmpty()) {
            System.out.println("You haven't registered for any course");
            return;
        }

        for (EnrolledStudent obj : grade_card) {
            System.out.println(String.format("%-20s %-20s %-20s", obj.getCourseCode(), obj.getGrade()));
        }
    }*/

}