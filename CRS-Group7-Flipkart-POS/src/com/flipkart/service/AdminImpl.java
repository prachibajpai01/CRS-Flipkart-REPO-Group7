package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

public class AdminImpl implements AdminInterface{

    @Override
    public void deleteCourse(String courseCode, List<Course> courseList) {

    }

    @Override
    public void addCourse(Course course, List<Course> courseList) {

    }

    @Override
    public List<Student> viewPendingAdmissions() {
        return null;
    }

    @Override
    public void approveStudent(int studentId, List<Student> studentList) {

    }

    @Override
    public void addProfessor(Professor professor) {

    }

    @Override
    public void assignCourse(String courseCode, String professorId) {

    }

    @Override
    public List<Course> viewCourses(int catalogId) {
        return null;
    }

    @Override
    public List<Professor> viewProfessors() {
        return null;
    }

    @Override
    public void sendNotification(int studentId) {

    }
}