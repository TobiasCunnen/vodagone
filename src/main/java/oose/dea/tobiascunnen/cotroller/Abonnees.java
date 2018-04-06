package oose.dea.tobiascunnen.cotroller;


import oose.dea.tobiascunnen.service.AbonneesService;
import oose.dea.tobiascunnen.service.TokenService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("abonnees")
public class Abonnees {

    @Inject
    AbonneesService abonneesService;

    @Inject
    TokenService tokenService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response abonnees(@QueryParam("token") Integer token){

        if(tokenService.getToken().equals(token)) {

            return abonneesService.getAbonnees();
        }else {
            return Response.status(403).build();
        }
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response shareWithAbonnee(@QueryParam("token") Integer token, @PathParam("id") int id){

        if (tokenService.getToken().equals(token)){

            return abonneesService.selectOneAbonnee(id);
        }else{
            return Response.status(403).build();
        }

    }

    public void setAbonneesService(AbonneesService abonneesService) {
        this.abonneesService = abonneesService;
    }

    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }
}
