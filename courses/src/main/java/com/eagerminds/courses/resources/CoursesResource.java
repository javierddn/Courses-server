package com.eagerminds.courses.resources;

import com.eagerminds.courses.model.Course;
import com.eagerminds.courses.services.CourseService;
import com.eagerminds.courses.types.OrderType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoursesResource {

    private final Logger LOG = LoggerFactory.getLogger(CoursesResource.class);

    private final CourseService courseService;

    public CoursesResource(final CourseService courseService) {
        this.courseService = courseService;
    }

    @GET
    public Response getAllCourses(@QueryParam("order") OrderType orderType) {
        return Response.ok(courseService.getAllCourses(true, orderType)).build();
    }

    @GET
    @Path("/{id}")
    public Response getCourseById(@PathParam("id") Integer id) {
        return Response.ok(courseService.getCourseById(id)).build();
    }

    @POST
    public Response createCourse(Course course) {
        if (course.getTitle() == null || course.getTeacher().getId() == null || course.getLevel() == null
                || course.getDuration() == null || course.getActive() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Faltan campos obligatorios: " + course.toString()).build();
        }
        try {
            courseService.insert(course);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(course).build();
    }

}
