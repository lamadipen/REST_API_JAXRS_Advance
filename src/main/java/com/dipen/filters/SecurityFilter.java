package com.dipen.filters;

import org.glassfish.jersey.internal.util.Base64;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by dipen on 5/2/2017.
 */
@Provider
public class SecurityFilter implements ContainerRequestFilter {

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_HEADER_PEFIX = "Basic ";
    private static final String SECURED_PEFIX = "secured";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (containerRequestContext.getUriInfo().getPath().contains(SECURED_PEFIX)) {
           List<String> authHeader = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);

            if (authHeader != null &&authHeader.size() > 0) {
                String authToken = authHeader.get(0);
                //System.out.print("Before Decoded "+ authToken);
                authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PEFIX, "");
                String decodedString = Base64.decodeAsString(authToken);
                //System.out.print("Decoded"+ decodedString);
                StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
                String username = tokenizer.nextToken();
                //System.out.print("Username "+ username);
                String password = tokenizer.nextToken();

                if (username.equals("dipen") && password.equals("lama")) {
                    return;
                }

            }

            Response unauthorizedRespone = Response.status(Response.Status.UNAUTHORIZED).
                    entity("User cannot access the resource").
                    build();

            containerRequestContext.abortWith(unauthorizedRespone);
        }
    }
}
