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
    StudentImpl studentImpl = new StudentImpl();

    PaymentInterface paymentInterface = new PaymentImpl();

    /**
     * Create CRS menu for student
     *
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
            System.out.println("7. Make payment");
            System.out.println("8. Logout");
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
                    makePayment(studentId);
                    break;

                case 8:
                    CRSApplication.loggedin = false;
                    return;

                default:
                    System.out.println("***** Wrong Choice *****");
            }
        }
    }

    /**
     * Student can make payment by giving reference ID and payment type
     *
     * @param studentId ID of student
     */
    private void makePayment(String studentId) {
        paymentInfo(studentId);

        Scanner sc = new Scanner(System.in);
        System.out.println("Give reference ID of payment to pay: ");
        String refId = sc.next();
        System.out.println("Give payment type (UPI/Cheque/NetBanking): ");
        String paymentType = sc.next();

        if (paymentInterface.makePayment(refId, paymentType)) {
            System.out.println("Payment successful");
        } else {
            System.out.println("Payment failed");
        }
    }

    /**
     * Print payment info for a student
     *
     * @param studentId ID of student
     */
    private void paymentInfo(String studentId) {
        System.out.println(studentId);
        ArrayList<Payment> paymentsInfo = paymentInterface.getPaymentInfo(studentId);
        for (Payment p : paymentsInfo) {
            System.out.println(p.getReferenceId() + " " + p.getStudentId() + " " + p.getAmount() + " " + p.getPaid() + " " + p.getType());
        }
    }

    /**
     * Add a course for a student by taking course ID.
     *
     * @param studentId ID of student.
     */
    private void addCourse(String studentId) {
        Scanner sc = new Scanner(System.in);
        viewCourse(studentId);

        System.out.println("Enter course id to add :");
        String newcourseid = sc.nextLine();
        studentImpl.addCourse(studentId, newcourseid);
    }

    /**
     * Drop course for a student by taking course ID
     *
     * @param studentId ID of student
     */
    private void dropCourse(String studentId) {
        Scanner sc = new Scanner(System.in);
        viewRegisteredCourse(studentId);

        System.out.print("Enter course ID to drop: ");
        String dropCourseId = sc.next();
        studentImpl.dropCourse(studentId, dropCourseId);
    }

    /**
     * Display courses available in catalogue along with returning them.
     * @param studentId ID of student
     * @return ArrayList of available courses.
     */
    private void viewCourse(String studentId) {

        List<Course> avCourses = studentImpl.viewAvailableCourseList(studentId);

        for (Course c : avCourses) {
            System.out.println(
                    c.getCourseId() + " " + c.getCourseName() + " " + c.getInstructorId() + " " + c.getCourseSeats() + " " + c.getOffered()
            );
        }
    }

    /**
     * Display registered courses of a student
     *
     * @param studentId ID of student
     * @return list of courses of student
     */
    private void viewRegisteredCourse(String studentId) {
        studentImpl.viewRegisteredCourses(studentId);
    }

    /**
     * Display grade card of student
     *
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