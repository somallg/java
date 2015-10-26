package com.somallg.jax.rs.json.resource;

import com.somallg.jax.rs.json.domain.Person;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by somallg on 12/7/14.
 */

@Stateless
@Path("/")
public class EJBResource {

    @Path("person")
    @GET
    @Produces(value = {"application/xml", "application/json"})
    public Person getPerson() {
        Person p = new Person();
        p.setName("Lala");
        p.setAge(23);

        return p;
    }

    @Path("list")
    @GET
    @Produces(value = {"application/xml", "application/json"})
    public List<Person> getList() {
        Person p1 = new Person();
        p1.setName("Lala");
        p1.setAge(23);

        Person p2 = new Person();
        p2.setName("Lili");
        p2.setAge(21);

       return Arrays.asList(p1, p2);
    }

    @Path("listString")
    @GET
    @Produces(value = {"text/plain"})
    public List<String> getListString() {
        return Arrays.asList("a", "b", "c");
    }

    @Path("post")
    @POST
    @Consumes(value = {"application/xml", "application/json"})
    public void postPerson(Person person) {
        System.out.println("Person " + person.getName() + " " + person.getAge());
    }
}
