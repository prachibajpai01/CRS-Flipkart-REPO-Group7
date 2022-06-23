package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.*;

public class CourseCatalogueImpl implements CourseCatalogueInterface {
    HashMap<String, Set<String>> enrolledStudents = new HashMap<>();// courseid, enrolled students
    HashMap<String, Course> courseId2Object = new HashMap<String, Course>(){
        {
            put("456", new Course("456", "Java", "java@lang"));
            put("789", new Course("789", "Python", "python@lang"));
        }
    };// courseid, course object

    /**
     * Method to get enrolled students
     * @param courseId : courseId of the course
     */
    public Set<String> getEnrolledStudents(String courseId) {
        return enrolledStudents.get(courseId);
    }

    /**
     * Method to view all courses with their details
     */
    @Override
    public ArrayList<Course> sendCatalogue() {
        ArrayList<Course> res=new ArrayList<Course>();
        for(Map.Entry<String, Course> c:courseId2Object.entrySet()){
            //System.out.println(c.getValue().getCourseId()+" "+c.getValue().getCourseName()+" "+c.getValue().getInstructorId());
            res.add(c.getValue());
        }
        return res;
    }

    /**
     * Method to enroll students
     * @param studentId,courseId: studentId of the student,courseId of the course
     */
    @Override
    public void enrollStudent(String studentId, String courseId){
        if(!enrolledStudents.containsKey(courseId)){
            enrolledStudents.put(courseId, new HashSet<>());
        }
        enrolledStudents.get(courseId).add(studentId);
    }

    /**
     * Method to unenroll students
     * @param studentId,courseId: studentId of the student,courseId of the course
     */
    @Override
    public void unenrollStudent(String studentId, String courseId){

        enrolledStudents.get(courseId).remove(studentId);
    }

    /**
     * Method to add courses
     * @param courseId,courseName,instructorId: courseId of the course,coursename of the course,instructorid
     */
    @Override
    public void addCourse(String courseId, String courseName, String instructorId){
        Course newcourse = new Course();
        newcourse.setCourseId(courseId);
        newcourse.setCourseName(courseName);
        newcourse.setInstructorId(instructorId);
        courseId2Object.put(courseId, newcourse);
    }

    /**
     * Method to getcoursedetails
     * @param courseId: courseId of the course
     */
    @Override
    public Course getCourseInfo(String courseId) {
        return courseId2Object.get(courseId);
    }
}
