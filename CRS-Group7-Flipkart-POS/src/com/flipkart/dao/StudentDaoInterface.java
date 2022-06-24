package com.flipkart.dao;

import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.service.CourseCatalogueImpl;

import java.util.ArrayList;
import java.util.List;

public interface StudentDaoInterface {

    public void register(String userName, String userID, String password, int batch, String branch, String address);
    public String getStudentId(String userId);
    public boolean isApproved(String studentId);
    public void addCourse(String userId, String courseId, CourseCatalogueImpl courseCatalogue);
    public void dropCourse(String userId, String courseId, CourseCatalogueImpl courseCatalogue);
    public ArrayList<Course> viewCourseList(CourseCatalogueImpl courseCatalogue);
    public void viewRegisteredCourses(String userId);
    public List<GradeCard> viewGradeCard(int studentId);

    public void addUser(User user);

}



