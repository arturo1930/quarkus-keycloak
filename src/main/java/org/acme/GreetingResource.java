package org.acme;


import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/hello")
public class GreetingResource {

    @Inject
    JsonWebToken jwt;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({"ROLE_PRUEBA", "view-clients"})
    public String hello(@Context SecurityContext ctx) {
        return "Hello from Quarkus key cloak:"+ctx.getUserPrincipal()+ " "+jwt.getExpirationTime();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)    
    @Path("/hello2")
    public String hello2() {
        return "Hello from Quarkus";
    }
}
