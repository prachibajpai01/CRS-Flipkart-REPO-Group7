package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

import java.util.*;

public class StudentImpl implements StudentInterface{

    Map<String,Student> studentObject =new HashMap<String,Student>(){{
        put("Prachi", new Student());
        put("Akash", new Student());
        put("Shaurya", new Student());
    }};  //userId,student data
    Map<String, Set<String>> studentCourseData=new HashMap<String,Set<String>>(){{
        put("Prachi", new HashSet<>(){{
            add("Java");
        }});
        put("Akash", new HashSet<>(){{
            add("Python");
            add("C++");
        }});
        put("Shaurya", new HashSet<>(){{
            add("Java");
        }});
    }}; //userId,all courses w.r.t student

    @Override
    public int register(String name,String userId,String password,int batch,String branch,String address){
        Student stu=new Student();
        stu.setName(name);
        stu.setUserId(userId);
        stu.setPassword(password);
        stu.setBatch(batch);
        stu.setBranchName(branch);
        stu.setAddress(address);
        studentObject.put(userId,stu);
        return 0;
    }

    @Override
    public String getStudentId(String userId){
        return userId;
    }

    @Override
    public boolean isApproved(String userId) {
        System.out.println("Inside isApproved...");
        return true;
    }

    @Override
    public void addCourse(String userId,String courseId, CourseCatalogueImpl courseCatalogue) {
        if(!studentCourseData.containsKey(userId)){
            studentCourseData.put(userId, new HashSet<>());
        }

        studentCourseData.get(userId).add(courseId);
        //System.out.println(userId+" "+courseId);
        courseCatalogue.enrollStudent(userId, courseId);
    }

    @Override
    public void dropCourse(String userId,String courseId, CourseCatalogueImpl courseCatalogue) {
        studentCourseData.get(userId).remove(courseId);
        courseCatalogue.unenrollStudent(userId, courseId);
    }

    @Override
    public ArrayList<Course> viewCourseList(CourseCatalogueImpl courseCatalogue) {
        System.out.println("Viewing list of courses...");
        return courseCatalogue.sendCatalogue();
    }

    @Override
    public Set<String> viewRegisteredCourses(String userId) {
        return studentCourseData.get(userId);
    }

    @Override
    public List<Grade> viewGradeCard(int studentId) {
        System.out.println("Viewing grade card...");
        return null;
    }
}
