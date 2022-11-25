package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @RestClient
    ExampleClient exampleClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        //exampleClient.getTest();
        try {
            exampleClient.getTest();
        } catch (WebApplicationException wae) {
            System.out.println("The response from the exception:");
            System.out.println(wae.getResponse().getEntity());
        }
        return "Hello from RESTEasy Reactive";
    }
}