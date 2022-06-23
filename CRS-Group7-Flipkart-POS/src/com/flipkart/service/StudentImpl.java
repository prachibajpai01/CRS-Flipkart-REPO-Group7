package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

import java.util.*;

public class StudentImpl implements StudentInterface{
    //userId,all courses w.r.t student

    @Override
    public int register(String name,String userId,String password,int batch,String branch,String address){
        Student stu=new Student();
        stu.setName(name);
        stu.setUserId(userId);
        stu.setPassword(password);
        stu.setBatch(batch);
        stu.setBranchName(branch);
        stu.setAddress(address);
//        studentObject.put(userId,stu);
        return 0;
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
     * @param userId,courseId,courseCatalogue: studentId of the student,courseId of the course,CourseCatalogueImpl instance
     */
    @Override
    public void addCourse(String userId,String courseId, CourseCatalogueImpl courseCatalogue) {
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
     * @param userId,courseId,courseCatalogue: studentId of the student,courseId of the course,CourseCatalogueImpl instance
     */
    @Override
    public void dropCourse(String userId,String courseId, CourseCatalogueImpl courseCatalogue) {
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
    public List<Grade> viewGradeCard(int studentId) {
        System.out.println("Viewing grade card...");
        return null;
    }
}
