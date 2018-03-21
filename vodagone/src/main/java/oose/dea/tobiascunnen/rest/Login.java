package oose.dea.tobiascunnen.rest;

import oose.dea.tobiascunnen.rest.dtos.LoginRequest;
import oose.dea.tobiascunnen.rest.dtos.LoginResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
public class Login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginRequest) {

        LoginResponse loginResponse = new LoginResponse();

        if ("tobias".equals(loginRequest.getUser())) {
            loginResponse.setUser("Tobias Cunnen");
            loginResponse.setToken("1234-1234");

            return Response.ok().entity(loginResponse).build();

        } else {

            return Response.status(403).build();
        }
    }
}
