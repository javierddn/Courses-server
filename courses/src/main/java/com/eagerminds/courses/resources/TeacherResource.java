package com.eagerminds.courses.resources;

import com.eagerminds.courses.model.Teacher;
import com.eagerminds.courses.services.TeacherService;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/teachers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeacherResource {

    private final TeacherService teacherService;

    public TeacherResource(final TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GET
    public Response getAllTeachers() {
        return Response.ok(teacherService.getAllTeachers()).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeacherById(@PathParam("id") Integer id) {
        return Response.ok(teacherService.getTeacherById(id)).build();
    }

    @POST
    public Response createTeacher(Teacher teacher) {
        if (teacher.getFirstName() == null || teacher.getLastName() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Missing required fields").build();
        }
        return Response.ok(teacherService.insert(teacher)).build();
    }
}
