package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.Collection;
import java.util.List;

public class AdminDaoOperation implements AdminDaoInterface{
    @Override
    public void deleteCourse(String courseCode){
        return ;
    }
    @Override
    public void addCourse(Course course){

    }
    @Override
    public List<Student> viewPendingAdmissions(){
        return null;
    }

    @Override
    public void approveStudent(String studentId){

    }
    @Override
    public void addProfessor(Professor professor){

    }
    public void assignCourse(String courseCode, String professorId){

    }
    public Collection<Course> viewCourses(){
        return null;
    }
    public List<Professor> viewProfessors(){
        return null;
    }

    public void sendNotification(String  studentId, Notification notification){

    }
}
