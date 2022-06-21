package com.flipkart.service;
import java.util.Collection;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;


public interface AdminInterface {
    public void deleteCourse(String courseCode);
    public void addCourse(Course course);
    public List<Student> viewPendingAdmissions();
    public void approveStudent(String studentId);
    public void addProfessor(Professor professor);
    public void assignCourse(String courseCode, String professorId);
    public Collection<Course> viewCourses();
    public List<Professor> viewProfessors();

    public void sendNotification(String  studentId, Notification notification);
}
