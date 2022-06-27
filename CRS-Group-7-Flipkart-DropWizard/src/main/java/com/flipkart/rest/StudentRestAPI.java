package com.flipkart.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.*;

import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.CourseNotFoundException;

@Path("/student")
public class StudentRestAPI {

    AdminInterface adminInterface = new AdminImpl();
    StudentInterface studentInterface = new StudentImpl();

    /**
     * Method to handle API request for course registration
     * @param courseList
     * @param studentId
     * @throws ValidationException
     * @return
     */

    @POST
    @Path("/registerCourses")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerCourses(List<String> courseList,
                                    @NotNull
                                    @QueryParam("studentId") String studentId) throws ValidationException, CourseAlreadyRegisteredException, CourseLimitExceededException {


        try
        {
            if(adminInterface.getRegistrationStatus(studentId) == true)
                return Response.status(200).entity("Student "+ studentId+" is already registered.").build();

            List<Course> availableCourseList = adminInterface.viewCourses();
            Set<String> hash_set = new HashSet<String>();

            for(String courseCode:courseList) {
                adminInterface.checkCourse(courseCode, studentId, availableCourseList);

                if(!hash_set.add(courseCode))
                    return Response.status(500).entity("Duplicate value  : "+courseCode).build();
            }

            for(String courseCode:courseList)
                studentInterface.addCourse(courseCode, studentId);

            adminInterface.approveStudent(studentId);
        }
        catch (CourseLimitExceededException | CourseNotFoundException | CourseAlreadyRegisteredException e)
        {
            System.out.println(e.getMessage());
            return Response.status(500).entity(e.getMessage()).build();
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }


        return Response.status(201).entity( "Registration Successful").build();

    }



    /**
     * Handles api request to add a course
     * @param courseCode
     * @param studentId
     * @return
     * @throws ValidationException
     */
    @PUT
    @Path("/addCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(
            @NotNull
            @QueryParam("courseCode") String courseCode,
            @NotNull
            @QueryParam("studentId") String studentId) throws ValidationException{

        if(adminInterface.getRegistrationStatus(studentId) == false)
            return Response.status(200).entity("Student course registration is pending").build();

        try{

            List<Course> availCourseList = studentInterface.viewAvailableCourseList(studentId);
            adminInterface.checkCourse(courseCode, studentId, availCourseList);
            studentInterface.addCourse(courseCode, studentId);

            return Response.status(201).entity( "You have successfully added Course : " + courseCode).build();

        }
        catch (CourseNotFoundException |
               CourseAlreadyRegisteredException | CourseLimitExceededException e)
        {
            System.out.println(e.getMessage());

            return Response.status(500).entity(e.getMessage()).build();
        }


    }


    /**
     * Handles API request to drop a course
     * @param courseCode
     * @param studentId
     * @return
     * @throws ValidationException
     */
    @DELETE
    @Path("/dropCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dropCourse(
            @NotNull
            @QueryParam("courseCode") String courseCode,
            @NotNull
            @QueryParam("studentId") String studentId) throws ValidationException{

        if(adminInterface.getRegistrationStatus(studentId) == false)
            return Response.status(200).entity("Student course registration is pending").build();

        studentInterface.dropCourse(courseCode, studentId);
        return Response.status(201).entity( "You have successfully dropped Course : " + courseCode).build();

    }


    /**
     * Method handles API request to view the list of available courses for a student
     * @param studentId
     * @return
     * @throws ValidationException
     */
    @GET
    @Path("/viewAvailableCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCourse(
            @NotNull
            @QueryParam("studentId") String studentId) throws ValidationException{

        return studentInterface.viewAvailableCourseList(studentId);

    }

    /**
     * Method handles API request to view the list of registered courses for a student
     * @param studentId
     * @return
     * @throws ValidationException
     */
    @GET
    @Path("/viewRegisteredCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewRegisteredCourse(
            @NotNull
            @QueryParam("studentId") String studentId) throws ValidationException{

        return studentInterface.viewRegisteredCourses(studentId);
    }

    /**
     * Method handles request to display the grade card for student
     * @param studentId
     * @return
     * @throws ValidationException
     */

    @GET
    @Path("/viewGradeCard")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnrolledStudent> viewGradeCard(
            @NotNull
            @QueryParam("studentId") String studentId) throws ValidationException{


        List<EnrolledStudent> grade_card = studentInterface.viewGradeCard(studentId);
        return grade_card;
    }

}
