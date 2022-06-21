package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.NotificationType;

import java.util.*;

public class AdminImpl implements AdminInterface{

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

    @Override
    public void addCourse(Course course) {
        if(courseList.containsKey(course.getCourseId())){
            System.out.println("Course already present in catalog");
        }
        try{
            courseList.put(course.getCourseId(), course);
            System.out.println("Course added successfully");

        }catch (Exception e){
            System.out.println("There was some error in adding course");
        }
    }

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

    @Override
    public void addProfessor(Professor professor) {
        if(!professorList.containsKey(professor.getUserId())){
            System.out.println("Professor with same userid already present");
        }
        try{
            System.out.println("Professor added successfully");
            professorList.put(professor.getUserId(), professor);
        }catch (Exception e){
            System.out.println("There was some error in adding professor");
        }
    }

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

    @Override
    public Collection<Course> viewCourses() {
        return courseList.values();
    }

    @Override
    public List<Professor> viewProfessors() {
        List<Professor> professors = new ArrayList<>(professorList.values());
        return professors;
    }

    @Override
    public void sendNotification(String studentId,Notification notification) {

    }
}
