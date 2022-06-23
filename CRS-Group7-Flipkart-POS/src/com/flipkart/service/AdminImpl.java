package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.NotificationType;
import com.flipkart.dao.AdminDaoOperation;

import java.util.*;

public class AdminImpl implements AdminInterface{

    AdminDaoOperation adminDaoOperation = new AdminDaoOperation();

    HashMap<String,Course> courseList = new HashMap<String,Course>(){{
        put("CSB101",new Course("CSB101","Java","1"));
        put("CSB201",new Course("CSB201","Android","2"));
    }};

    HashMap<String,Student> studentList = new HashMap<String,Student>(){{
        put("01",new Student("Computer Science",1,false,"01"));
        put("02",new Student("Computer Science",2,false,"02"));
    }};


    HashMap<String,Professor> professorList = new HashMap<String,Professor>(){{
        put("01",new Professor("Computer Science","Assistant Professor","01"));
        put("02",new Professor("Computer Science","Professor","02"));
    }};

    /**
     * Method to delete course
     * @param courseCode : courseCode of the course
     */
    @Override
    public void deleteCourse(String courseCode) {
        if(!courseList.containsKey(courseCode)){
            System.out.println("Course not found in catalog");
        }
        try{
            courseList.remove(courseCode);
            System.out.println("Course removed successfully");

        }catch (Exception e){
            System.out.println("There was some error in deleting course");
        }
    }

    /**
     * Method to add course
     * @param course : course object
     */
    @Override
    public void addCourse(Course course) {
        adminDaoOperation.addCourse(course);
    }

    /**
     * Method to view pending assignments
     */
    @Override
    public List<Student> viewPendingAdmissions() {
        List<Student> pendingStudents = new ArrayList<Student>();
        for(Student s : studentList.values()){
            if(s.getApproved() == false){
                pendingStudents.add(s);
                Notification notification = new Notification(1,"Registration is pending..");
                notification.setNotificationType(NotificationType.PAYMENT_DUE);
                sendNotification(s.getUserId(),notification);
            }
        }
        System.out.println("List of pending student(s) are : ");
        return pendingStudents;
    }

    /**
     * Method to approve student
     * @param studentId : studentId of student
     */
    @Override
    public void approveStudent(String studentId) {
        Student oldStudent = studentList.get(studentId);
        if(oldStudent.getApproved() == true){
            System.out.println("Student registration already approved");
            return;
        }
        try {
            studentList.replace(studentId, new Student(oldStudent.getBranchName(), oldStudent.getBatch(), true, studentId));
            System.out.println("Student approved successfully");

        }catch (Exception e){
            System.out.println("Couldn't approve registration");
        }
    }

    /**
     * Method to add professor
     * @param professor : professor object
     */
    @Override
    public void addProfessor(Professor professor) {
        adminDaoOperation.addProfessor(professor);
    }

    /**
     * Method to assign course
     * @param courseCode,professorId : courseCode of course,professorId for professor
     */
    @Override
    public void assignCourse(String courseCode, String professorId) {
        Course oldCourse = courseList.get(courseCode);
        try {
            System.out.println("Course assigned successfully");
            courseList.replace(courseCode, new Course(oldCourse.getCourseId(), oldCourse.getCourseName(), professorId));
        }catch (Exception e){
            System.out.println("There was some error in assigning the courser");
        }
    }

    /**
     * Method to view courses
     */
    @Override
    public Collection<Course> viewCourses() {
        return courseList.values();
    }

    /**
     * Method to view professor
     */
    @Override
    public List<Professor> viewProfessors() {
        List<Professor> professors = new ArrayList<>(professorList.values());
        return professors;
    }

    /**
     * Method to send notifications
     * @param studentId,Notification : studentId of student,Notification object
     */
    @Override
    public void sendNotification(String studentId,Notification notification) {

    }
}
