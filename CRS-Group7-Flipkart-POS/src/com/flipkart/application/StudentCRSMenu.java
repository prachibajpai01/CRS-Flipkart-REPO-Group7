package com.flipkart.application;

import java.util.*;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.service.*;
import com.flipkart.bean.EnrolledStudent;
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
     * Student service instance
     */
    StudentImpl studentImpl=new StudentImpl();

    PaymentInterface paymentInterface = new PaymentImpl();
    /**
     * Create CRS menu for student
     * @param studentId ID of student
     */
    public void createMenu(String studentId) {
        while (CRSApplication.loggedin) {
            System.out.println("*****************************");
            System.out.println("**********Student Menu*********");
            System.out.println("*****************************");
            System.out.println("1. Add Course");
            System.out.println("2. Drop Course");
            System.out.println("3. View Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. View grade card");
            System.out.println("6. Payment Info");
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
                    paymentInfo(studentId);
                    break;

                case 7:
                    CRSApplication.loggedin = false;
                    return;

                default:
                    System.out.println("***** Wrong Choice *****");
            }
        }
    }

    private void paymentInfo(String studentId) {
        System.out.println(studentId);
        ArrayList<Payment> paymentsInfo = paymentInterface.getPaymentInfo(studentId);
        for(Payment p:paymentsInfo){
            System.out.println(p.getReferenceId()+" "+p.getStudentId()+" "+p.getAmount()+" "+p.getPaid()+" "+p.getType());
        }
    }

    /**
     * Add a course for a student by taking course ID.
     * @param studentId ID of student.
     */
    private void addCourse(String studentId) {
        Scanner sc=new Scanner(System.in);
        //viewCourse(studentId);

        System.out.println("Enter course id to add :");
        String newcourseid=sc.nextLine();
        studentImpl.addCourse(studentId,newcourseid);
    }

    /**
     * Drop course for a student by taking course ID
     * @param studentId ID of student
     */
    private void dropCourse(String studentId) {
        Scanner sc = new Scanner(System.in);
        //viewCourse(studentId);

        System.out.print("Enter course ID to drop: ");
        String dropCourseId = sc.next();
        studentImpl.dropCourse(studentId, dropCourseId);
        /*
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

        return null;
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
    private void viewGradeCard(String studentId) {

        try {
            List<EnrolledStudent> registeredCourses = new ArrayList<EnrolledStudent>();
            registeredCourses = studentImpl.viewGradeCard(studentId);

            System.out.println("Student Username: " + studentId);
            System.out.println(String.format("%30s %30s %30s", "Course Code", "Semester", "Grade"));

            for (EnrolledStudent rc : registeredCourses) {
                System.out
                        .println(String.format("%30s %30s %30s", rc.getCourseCode(), rc.getSem(), rc.getGrade()));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}