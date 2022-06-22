package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;

import java.util.*;

public class ProfessorImpl implements ProfessorInterface {

    HashMap<String, Set<String>> profCourses = new HashMap<String, Set<String>>() {
        {
            put("01", new HashSet<>() {{
                add("456");
            }});
            put("02", new HashSet<>() {{
                add("789");
            }});
        }
    }; // profId, set of courses they teach

    HashMap<String, Professor> profObject = new HashMap<>() {
        {

        }
    }; // profId, Professor object

    @Override
    public boolean addGrade(int studentId, String courseCode, String grade) {
        return false;
    }

    @Override
    public List<EnrolledStudent> viewEnrolledStudents(String profId) {
        return null;
    }

    @Override
    public ArrayList<Course> getCourses(String profId, CourseCatalogueImpl courseCatalogue) {
        ArrayList<Course> res = new ArrayList<>();
        for (String courseId : profCourses.get(profId)) {
            res.add(courseCatalogue.getCourse(courseId));
        }
        return res;
    }

    @Override
    public Professor getProfessorById(String profId) {
        return profObject.get(profId);
    }
}
