package com.dipen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by dipen on 5/2/2017.
 */
@Path("secured")
public class Secured {

    @GET
    @Path("message")
    @Produces(MediaType.TEXT_PLAIN)
    public String securedMethod()
    {
        return "This is secured";
    }
}
