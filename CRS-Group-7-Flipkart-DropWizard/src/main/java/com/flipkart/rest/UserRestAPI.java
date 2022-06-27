package com.flipkart.rest;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Student;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserImpl;
import io.dropwizard.jersey.PATCH;

@Path("/user")
public class UserRestAPI {
    StudentInterface studentInterface= new StudentImpl();
    UserInterface userInterface = new UserImpl();


    /**
     *
     * @param userId: email address of the user
     * @param newPassword: new password to be stored in db.
     * @return @return 201, if password is updated, else 500 in case of error
     */
    @PATCH
    @Path("/updatePassword")
    @Produces("application/json")
    public Response updatePassword(
            @NotNull
            @QueryParam("userId") String userId,
            @NotNull
            @QueryParam("newPassword") String newPassword) throws ValidationException {

        if(userInterface.updatePassword(userId, newPassword))
        {
            return Response.status(201).entity("Password updated successfully! ").build();
        }
        else
        {
            return Response.status(500).entity("Something went wrong, please try again!").build();
        }

    }

    /**
     *
     * @param userId
     * @param password
     * @return
     */

    @POST
    @Path("/login")
    @Consumes("application/json")
    public Response verifyCredentials(
            @NotNull
            @QueryParam("userId") String userId,
            @NotNull
            @QueryParam("password") String password) throws ValidationException {

        try
        {
            boolean loggedin=userInterface.authenticate(userId, password);
            System.out.println(loggedin);
            if(loggedin)
            {
                String role=userInterface.getRole(userId);
                role.toUpperCase();
                switch(role)
                {

                    case "STUDENT":
                        String studentId=studentInterface.getStudentId(userId);
                        boolean isApproved=studentInterface.isApproved(studentId);
                        if(!isApproved)
                        {
                            return Response.status(200).entity("Login unsuccessful! Student "+userId+" has not been approved by the administration!" ).build();
                        }
                        break;

                }
                return Response.status(200).entity("Login successful").build();
            }
            else
            {
                return Response.status(500).entity("Invalid credentials!").build();
            }
        }
        catch (UserNotFoundException e)
        {
            return Response.status(500).entity(e.getMessage()).build();
        }

    }

    /**
     *
     * @param userId
     * @return
     * @throws ValidationException
     */
    @GET
    @Path("/getRole")
    @Produces("application/json")
    public String getRole(
            @NotNull
            @QueryParam("userId") String userId ) throws ValidationException{

        return userInterface.getRole(userId);
    }

    /**
     *
     * @param student
     * @return 201, if user is created, else 500 in case of error
     */
    @POST
    @Path("/studentRegistration")
    @Consumes("application/json")
    public Response register(@Valid Student student)
    {

        try
        {
            studentInterface.register(student.getUserName(), student.getUserId(), student.getPassword(), student.getBatch(), student.getBranchName());
        }
        catch(Exception ex)
        {
            return Response.status(500).entity("Something went wrong! Please try again.").build();
        }


        return Response.status(201).entity("Registration Successful for "+student.getUserId()).build();
    }

}
