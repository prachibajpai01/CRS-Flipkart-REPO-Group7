package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Class for Admin CRS menu
 */
public class AdminCRSMenu {

    /**
     * Scanner to take user input
     */
    Scanner s = new Scanner(System.in);

    /**
     * Admin service instance
     */
    AdminInterface adminImpl = new AdminImpl();

    /**
     * Display menu with various options for admin
     */
    public void createMenu(){
        while(CRSApplication.loggedin){
            System.out.println("*****************************");
            System.out.println("**********Admin Menu*********");
            System.out.println("1. Add Course to catalog");
            System.out.println("2. Delete Course from catalog");
            System.out.println("3. Approve registration");
            System.out.println("4. Add Professor");
            System.out.println("5. Assign Course to Professor");
            System.out.println("6. View pending fee status");
            System.out.println("7. Logout");
            System.out.println("*****************************");

            int choice = s.nextInt();

            switch(choice) {
                case 1:
                    addCourseToCatalogue();
                    break;

                case 2:
                    deleteCourse();
                    break;

                case 3:
                    approveStudent();
                    break;

                case 4:
                    addProfessor();
                    break;

                case 5:
                    assignCourseToProfessor();
                    break;

                case 6:
                    viewPendingAdmissions();
                    break;

                case 7:
                    CRSApplication.loggedin = false;
                    return;

                default:
                    System.out.println("***** Wrong Choice *****");
            }
        }

    }


    /**
     * Admin can add course with a course code and name to catalogue.
     */
    private void addCourseToCatalogue() {
        List<Course> courseList = viewCoursesInCatalogue();

        s.nextLine();
        System.out.println("Enter Course Code:");
        String courseCode = s.nextLine();

        System.out.println("Enter Course Name:");
        String courseName = s.next();

        Course course = new Course(courseCode, courseName, null);

        try {
            adminImpl.addCourse(course);
        } catch (Exception e) {
            System.out.println("Cannot add course");
        }

    }

    /**
     * Method to delete Course from catalogue
     */
    private void deleteCourse() {
        List<Course> courseList = viewCoursesInCatalogue();
        System.out.println("Enter Course Code:");
        String courseCode = s.next();

        try {
            adminImpl.deleteCourse(courseCode);
        } catch (Exception e) {
            System.out.println("Cannot delete course");
        }
    }


    /**
     * Method to approve a Student using Student's ID
     */
    private void approveStudent() {


    }

    /**
     * Admin can add a professor with their details.
     */
    private void addProfessor() {
        System.out.println("Enter Username:");
        String professorUserName = s.next();

        System.out.println("Enter Department:");
        String department = s.next();

        System.out.println("Enter Designation:");
        String designation = s.next();

        System.out.println("Enter User Id:");
        String userId = s.next();

        Professor professor = new Professor(department,designation,userId);

        System.out.println("Enter Password:");
        String password = s.next();
        professor.setPassword(password);
        professor.setName(professorUserName);

        System.out.println("Enter Address:");
        String address = s.next();
        professor.setAddress(address);

        professor.setRole(Role.PROFESSOR);

        try {
            adminImpl.addProfessor(professor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to assign Course to a Professor
     */
    private void assignCourseToProfessor() {
        List<Professor> professorList= adminImpl.viewProfessors();
        System.out.println("*************************** Professor *************************** ");
        System.out.println(String.format("%20s | %20s | %20s ", "ProfessorId", "Name", "Designation"));
        for(Professor professor : professorList) {
            System.out.println(String.format("%20s | %20s | %20s ", professor.getUserId(), professor.getName(), professor.getDesignation()));
        }


        System.out.println("\n\n");
        Collection<Course> courseList= adminImpl.viewCourses();
        System.out.println("**************** Course ****************");
        System.out.println(String.format("%20s | %20s", "CourseCode", "CourseName"));
        for(Course course : courseList) {
            System.out.println(String.format("%20s | %20s ", course.getCourseId(), course.getCourseName()));
        }

        System.out.println("Enter Course Code:");
        String courseCode = s.next();

        System.out.println("Enter Professor's User Id:");
        String userId = s.next();

        try {

            adminImpl.assignCourse(courseCode, userId);

        }
        catch(Exception e) {

            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to view Students who are yet to be approved
     * @return List of Students whose admissions are pending
     */
    private List<Student> viewPendingAdmissions() {

        List<Student> pendingStudentsList= adminImpl.viewPendingAdmissions();
        if(pendingStudentsList.size() == 0) {
            return pendingStudentsList;
        }
        System.out.println(String.format("%20s | %20s | %20s ", "UserId", "StudentId", "Name"));
        for(Student student : pendingStudentsList) {
            System.out.println(String.format("%20s | %20s | %20s", student.getUserId(), student.getUserId(), student.getName()));
        }
        return pendingStudentsList;
    }


    /**
     * Method to display courses in catalogue
     * @return List of courses in catalogue
     */
    private List<Course> viewCoursesInCatalogue() {
        Collection<Course> cL = adminImpl.viewCourses();
        List<Course> courseList = new ArrayList<>(cL);

        if(courseList.size() == 0) {
            System.out.println("No course in the catalogue!");
            return courseList;
        }
        System.out.println(String.format("%20s | %20s | %20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
        for(Course course : courseList) {
            System.out.println(String.format("%20s | %20s | %20s", course.getCourseId(), course.getCourseName(), course.getInstructorId()));
        }
        return courseList;
    }


}

