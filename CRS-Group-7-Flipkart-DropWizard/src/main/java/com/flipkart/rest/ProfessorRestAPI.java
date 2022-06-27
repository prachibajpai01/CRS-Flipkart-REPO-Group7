package com.flipkart.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.validator.ProfessorValidator;

@Path("/professor")
public class ProfessorRestAPI {
    ProfessorInterface professorInterface= new ProfessorImpl();

    @GET
    @Path("/getEnrolledStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnrolledStudent> viewEnrolledStudents(
            @NotNull
            @QueryParam("profId") String profId) throws ValidationException	{

        List<EnrolledStudent> students=new ArrayList<EnrolledStudent>();
        try
        {
            students=professorInterface.viewEnrolledStudents(profId);
        }
        catch(Exception ex)
        {
            return null;
        }
        return students;
    }

    @GET
    @Path("/getCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses(
            @NotNull
            @QueryParam("profId") String profId) throws ValidationException	{

        List<Course> courses=new ArrayList<Course>();
        try
        {
            courses=professorInterface.getCourses(profId);
        }
        catch(Exception ex)
        {
            return null;
        }
        return courses;

    }

    @PUT
    @Path("/addGrade")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGrade(
            @NotNull
            @QueryParam("studentId") String studentId,
            @NotNull
            @QueryParam("courseCode") String courseCode,
            @NotNull
            @QueryParam("profId") String profId,
            @QueryParam("grade") String grade) throws ValidationException  	{

        try
        {

                professorInterface.addGrade(studentId, courseCode, grade);

        }
        catch(Exception ex)
        {
            return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
        }
        return Response.status(200).entity( "Grade updated for student: "+studentId).build();
    }


}
