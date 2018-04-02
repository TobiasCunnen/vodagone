package oose.dea.tobiascunnen.presentation;

import oose.dea.tobiascunnen.service.AbonnementenService;
import oose.dea.tobiascunnen.service.TokenService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("abonnementen/all")
public class AllAbonnementen {

    @Inject
    AbonnementenService abonnementenService;

    @Inject
    TokenService tokenService;


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterAbonnementen(@QueryParam("token") Integer token, @QueryParam("filter") String filter) {

        if (tokenService.getToken().equals(token)) {

            return abonnementenService.getAbonneenten(filter);

        } else {
            return Response.status(403).build();
        }
    }
}
