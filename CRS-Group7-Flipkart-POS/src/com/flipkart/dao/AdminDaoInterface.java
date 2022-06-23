package com.flipkart.dao;

import com.flipkart.bean.*;

import java.util.Collection;
import java.util.List;

public interface AdminDaoInterface {
    public void deleteCourse(String courseCode);
    public void addCourse(Course course);
    public List<Student> viewPendingAdmissions();
    public void approveStudent(String studentId);
    public void addProfessor(Professor professor);

    public void addUser(User user);
    public void assignCourse(String courseCode, String professorId);
    public Collection<Course> viewCourses();
    public List<Professor> viewProfessors();

    public void sendNotification(String  studentId, Notification notification);
}
