package oose.dea.tobiascunnen.cotroller;

import jdk.nashorn.internal.parser.Token;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementRequest;
import oose.dea.tobiascunnen.service.AbonnementenVanAbonneesService;
import oose.dea.tobiascunnen.service.TokenService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("abonnementen")
public class Abonnementen {

    @Inject
    AbonnementenVanAbonneesService abonnementenVanAbonneesService;

    @Inject
    TokenService tokenService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response abonnementen(@QueryParam("token") Integer token) {

        if (tokenService.getToken().equals(token)) {

            return abonnementenVanAbonneesService.getAbonneenten();

        } else {
            return Response.status(403).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectOneAbonnement(@QueryParam("token") Integer token, @PathParam("id") int id) {

        if (tokenService.getToken().equals(token)) {

          return abonnementenVanAbonneesService.selectOneAbonnement(id);

        } else {
            return Response.status(403).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAbonnementen(@QueryParam("token") Integer token, AbonnementRequest abonnementRequest) {


        if (tokenService.getToken().equals(token)) {

            abonnementenVanAbonneesService.addAbonnement(abonnementRequest.getId(),abonnementRequest.getStartDatum(),"standaard","Proef");

            return abonnementenVanAbonneesService.getAbonneenten();

        } else {
            return Response.status(403).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAbonnement(@QueryParam("token") Integer token, @PathParam("id") int id) {

        if (tokenService.getToken().equals(token)) {

            abonnementenVanAbonneesService.deleteAbonnement(id);

            return abonnementenVanAbonneesService.selectOneAbonnement(id);

        } else {
            return Response.status(403).build();
        }
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verdubbelAbonnement(@QueryParam("token") Integer token, @PathParam("id") int id, AbonnementRequest abonnementRequest) {

        if (tokenService.getToken().equals(token)) {

           abonnementenVanAbonneesService.updateVerdubbeling(abonnementRequest.getVerdubbeling(),id);

            return abonnementenVanAbonneesService.selectOneAbonnement(id);
        } else {
            return Response.status(403).build();
        }
    }

}
