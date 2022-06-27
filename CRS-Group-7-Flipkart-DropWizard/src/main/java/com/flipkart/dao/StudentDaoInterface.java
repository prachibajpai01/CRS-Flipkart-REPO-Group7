package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.User;
import java.util.List;

public interface StudentDaoInterface {

    public void register(String userName, String userID, String password, int batch, String branch);
    public String getStudentId(String userId);
    public boolean isApproved(String studentId);
    public List<Course> viewCourseList(String studentId);
    public Boolean dropCourse(String userId, String courseId);

    public List<Course> viewRegisteredCourses(String userId);
    public List<EnrolledStudent> viewGradeCard(String studentId);

    public void addUser(User user);

    public Boolean addCourse(String userId, String courseId);

}



