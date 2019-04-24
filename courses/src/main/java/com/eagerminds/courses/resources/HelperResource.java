package com.eagerminds.courses.resources;

import com.eagerminds.courses.types.LevelType;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/helper")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelperResource {

    @GET
    @Path("/levels")
    public Response getAllLevels() {
        return Response.ok(LevelType.values()).build();
    }

}
