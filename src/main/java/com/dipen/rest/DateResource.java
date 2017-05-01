package com.dipen.rest;

import com.dipen.model.MyDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by dipen on 5/1/2017.
 */
@Path("date/{StringDate}")
public class DateResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getRequestedDate(@PathParam("StringDate")MyDate myDate)
    {
        return myDate.toString();
    }
}
