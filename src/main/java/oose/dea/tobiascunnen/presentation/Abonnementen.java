package oose.dea.tobiascunnen.presentation;

import oose.dea.tobiascunnen.domain.AbonnementDAO;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementRequest;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementResponse;
import oose.dea.tobiascunnen.presentation.dtos.DetailAbonnement;
import oose.dea.tobiascunnen.presentation.dtos.SimpelAbonnement;
import oose.dea.tobiascunnen.service.AbonnementenVanAbonneesService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("abonnementen")
public class Abonnementen {

    private List<SimpelAbonnement> abo = new ArrayList<>();

    @Inject
    AbonnementenVanAbonneesService abonnementenVanAbonneesService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response abonnementen(@QueryParam("token") String token) {

        if ("1234-1234".equals(token)) {

            return abonnementenVanAbonneesService.getAbonneenten();

        } else {
            return Response.status(403).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectOneAbonnement(@QueryParam("token") String token, @PathParam("id") int id) {

        if ("1234-1234".equals(token)) {

          return abonnementenVanAbonneesService.selectOneAbonnement(id);

        } else {
            return Response.status(403).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAbonnementen(@QueryParam("token") String token, AbonnementRequest abonnementRequest) {


        if ("1234-1234".equals(token)) {

            abonnementenVanAbonneesService.addAbonnement(abonnementRequest.getId(),abonnementRequest.getStartDatum(),"standaard","Proef");

            return abonnementenVanAbonneesService.getAbonneenten();

        } else {
            return Response.status(403).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAbonnement(@QueryParam("token") String token, @PathParam("id") int id) {

        if ("1234-1234".equals(token)) {

            abonnementenVanAbonneesService.deleteAbonnement(id);

            return abonnementenVanAbonneesService.selectOneAbonnement(id);

        } else {
            return Response.status(403).build();
        }
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verdubbelAbonnement(@QueryParam("token") String token, @PathParam("id") int id, AbonnementRequest abonnementRequest) {

        if ("1234-1234".equals(token)) {

           abonnementenVanAbonneesService.updateVerdubbeling(abonnementRequest.getVerdubbeling(),id);

            return abonnementenVanAbonneesService.selectOneAbonnement(id);
        } else {
            return Response.status(403).build();
        }
    }

}
