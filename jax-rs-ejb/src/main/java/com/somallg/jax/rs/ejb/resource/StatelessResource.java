package com.somallg.jax.rs.ejb.resource;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by somallg on 12/7/14.
 */
@Stateless
@Path("/")
public class StatelessResource {

    @Path("hello")
    @GET
    public String getHello() {
        return "Hello Angular Trang";
    }
}
