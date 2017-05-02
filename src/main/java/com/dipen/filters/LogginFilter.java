package com.dipen.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by dipen on 5/2/2017.
 */
@Provider
public class LogginFilter implements ContainerRequestFilter, ContainerResponseFilter{

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("This is loggin using request filter" + containerRequestContext.getHeaders());
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        System.out.println("This is loggin using response filter" + containerResponseContext.getHeaders());
    }
}
