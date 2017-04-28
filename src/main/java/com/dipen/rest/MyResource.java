package com.dipen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by dipen on 4/27/2017.
 */
@Path("/test")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest()
    {
        return "This is from test method";
    }
}
