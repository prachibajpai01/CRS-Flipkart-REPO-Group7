package com.flipkart.bean;

public class EnrolledStudent {

    /**
     * Every course has a code
     */
    private String courseCode;

    /**
     * semester of registered student
     */
    private int sem;
    /**
     * grade of registered student
     */
    private String grade;
    /**
     * Id of the student
     */
    private String studentId;

    /**
     * Enrolled student
     * @param courseCode
     * @param studentId
     * @param sem
     * @param grade
     */

    public EnrolledStudent(String courseCode, String studentId, int sem, String grade) {
        super();
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.sem = sem;
        this.grade = grade;
    }

    public EnrolledStudent(){

    }

    /**
     * Course code getter
     * @return course code
     */

    public String getCourseCode() {
        return courseCode;
    }

    /**
     * course code setter
     * @param courseCode
     */

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * student id getter
     * @return student Id
     */

    public String  getStudentId() {
        return studentId;
    }

    /**
     * student Id setter
     * @param studentId
     */

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * sem getter
     * @return sem
     */
    public int getSem() {
        return sem;
    }

    /**
     * sem setter
     * @param sem
     */

    public void setSem(int sem) {
        this.sem = sem;
    }

    /**
     * grade getter
     * @return grade
     */

    public String getGrade() {
        return grade;
    }

    /**
     * grade setter
     * @param grade
     */

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
