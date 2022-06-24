package com.flipkart.exception;
/**
 * Exception to check if course is not assigned to professor
 */
public class CourseNotAssignedToProfessorException extends Exception{
    private String courseId;
    private String professorId;

    /**
     * Constructor
     * @param courseId,professorId: courseId of the course,professorId of the professor
     */
    public CourseNotAssignedToProfessorException(String courseId, String professorId) {
        this.courseId = courseId;
        this.professorId = professorId;
    }

    /**
     * Get courseId
     * @return
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * set course Id
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * get Professor id
     * @return
     */
    public String getProfessorId() {
        return professorId;
    }

    /**
     * set professor id
     * @param professorId
     */
    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage(){
        return "Course with courseid : "+courseId+" or professorId: "+professorId+ " not found";
    }

    public static void main(String args[]) {
        String exampleCourseId = "1235";
        String exampleProfessorId = "1122";
        try {
            throw new CourseNotAssignedToProfessorException(exampleCourseId,exampleProfessorId);
        } catch (CourseNotAssignedToProfessorException e) {
            System.out.println(e);
        }
    }
}
