package com.dipen.rest;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by dipen on 4/27/2017.
 */
@Path("{pathParam}/test")
public class MyResourceParams {

    /** It is not possible in singleton as object is created before request and it doesn't have any value to inject
     * It is possibel with default (new instance per request) as value can be injected for request object
     * **/
    @QueryParam("queryParam")  private String queryParam;
    @PathParam("pathParam") private String pathParam;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest()
    {
        return "This is queryParamExample "+ queryParam + " and PathParamExample " + pathParam;
    }
}
