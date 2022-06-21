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

    public Set<String> getEnrolledStudents(String courseId) {
        return enrolledStudents.get(courseId);
    }

    @Override
    public ArrayList<Course> sendCatalogue() {
        ArrayList<Course> res=new ArrayList<Course>();
        for(Map.Entry<String, Course> c:courseId2Object.entrySet()){
            //System.out.println(c.getValue().getCourseId()+" "+c.getValue().getCourseName()+" "+c.getValue().getInstructorId());
            res.add(c.getValue());
        }
        return res;
    }

    @Override
    public void enrollStudent(String studentId, String courseId){
        if(!enrolledStudents.containsKey(courseId)){
            enrolledStudents.put(courseId, new HashSet<>());
        }
        enrolledStudents.get(courseId).add(studentId);
    }

    @Override
    public void unenrollStudent(String studentId, String courseId){

        enrolledStudents.get(courseId).remove(studentId);
    }

    @Override
    public void addCourse(String courseId, String courseName, String instructorId){
        Course newcourse = new Course();
        newcourse.setCourseId(courseId);
        newcourse.setCourseName(courseName);
        newcourse.setInstructorId(instructorId);
        courseId2Object.put(courseId, newcourse);
    }
}
