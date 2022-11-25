package org.acme;

import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
@RegisterRestClient(configKey = "example")
public interface ExampleClient {

    @GET
    Response getTest();

    @ClientExceptionMapper
    static RuntimeException toException(Response response) {
        String json = response.readEntity(String.class);
        System.out.println("This should be the example output:");
        System.out.println(json);
        return null;
    }


}
