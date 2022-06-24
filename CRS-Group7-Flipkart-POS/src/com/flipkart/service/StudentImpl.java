package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;

import java.util.*;

public class StudentImpl implements StudentInterface{

    StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
    //userId,all courses w.r.t student

    @Override
    public void register(String name,String userId,String password,int batch,String branch,String address){
        System.out.println("hhhhhh"+branch);
        studentDaoInterface.register(name, userId, password, batch, branch, address);
    }

    /**
     * Method to get studentId
     * @param userId,: studentId of the student
     */
    @Override
    public String getStudentId(String userId){
        return userId;
    }

    /**
     * Method know whether student isapproved
     * @param userId,: studentId of the student
     */
    @Override
    public boolean isApproved(String userId) {
        return true;
    }

    /**
     * Method to add course
     *
     * @param userId,courseId,courseCatalogue: studentId of the student,courseId of the course,CourseCatalogueImpl instance
     * @return
     */
    @Override
    public Boolean addCourse(String userId, String courseId) {
        return studentDaoInterface.addCourse(userId, courseId);
//        if(!studentCourseData.containsKey(userId)){
//            studentCourseData.put(userId, new HashSet<>());
//        }
//
//        studentCourseData.get(userId).add(courseId);
//        //System.out.println(userId+" "+courseId);
//        courseCatalogue.enrollStudent(userId, courseId);
    }

    /**
     * Method to drop course
     *
     * @param userId,courseId,courseCatalogue: studentId of the student,courseId of the course,CourseCatalogueImpl instance
     */
    @Override
    public Boolean dropCourse(String userId, String courseId) {
        return studentDaoInterface.dropCourse(userId, courseId);
//        studentCourseData.get(userId).remove(courseId);
//        courseCatalogue.unenrollStudent(userId, courseId);
    }

    /**
     * Method to view all courses
     * @param courseCatalogue: CourseCatalogueImpl instance
     */
    @Override
    public ArrayList<Course> viewCourseList(CourseCatalogueImpl courseCatalogue) {
        System.out.println("Viewing list of courses...");
        return courseCatalogue.sendCatalogue();
    }

    /**
     * Method to view student registered courses
     * @param userId: studentId of the student
     */
    @Override
    public void viewRegisteredCourses(String userId) {

//        return studentCourseData.get(userId);
    }

    /**
     * Method to view grade of student
     * @param studentId: studentId of the student
     */
    @Override
    public List<GradeCard> viewGradeCard(int studentId) {
        System.out.println("Viewing grade card...");
        return null;
    }
}
