package oose.dea.tobiascunnen.presentation;

import oose.dea.tobiascunnen.presentation.dtos.LoginRequest;
import oose.dea.tobiascunnen.presentation.dtos.LoginResponse;
import oose.dea.tobiascunnen.service.LoginService;
import oose.dea.tobiascunnen.service.TokenService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class Login {

    @Inject
    LoginService loginService;

    @Inject
    TokenService tokenService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginRequest) {

        LoginResponse loginResponse = new LoginResponse();

        if (loginService.userLogin(loginRequest.getUser(),loginRequest.getPassword())) {

            loginResponse.setUser(loginRequest.getUser());
            loginResponse.setToken(tokenService.generateToken());

            return Response.ok().entity(loginResponse).build();

        } else {

            return Response.status(403).build();
        }
    }
}
