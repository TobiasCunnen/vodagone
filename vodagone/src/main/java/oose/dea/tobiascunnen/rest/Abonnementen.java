package oose.dea.tobiascunnen.rest;

import oose.dea.tobiascunnen.rest.dtos.AbonnementResponse;
import oose.dea.tobiascunnen.rest.dtos.DetailAbonnement;
import oose.dea.tobiascunnen.rest.dtos.SimpelAbonnement;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("abonnementen")
public class Abonnementen {

    List<SimpelAbonnement> abo = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response abonnementen(@QueryParam("token") String token) {

        AbonnementResponse abonnementResponse = new AbonnementResponse();

        if ("1234-1234".equals(token)) {


            abo.add(new SimpelAbonnement(0,"Vodafone","Mobiele telefonie 100"));
            abo.add(new SimpelAbonnement(1,"Vodafone","Mobiele telefonie 250"));
            abo.add(new SimpelAbonnement(2,"Ziggo","Kabel-internet (download 300 Mpbs)"));
            abonnementResponse.setAbonnementen(abo);
            abonnementResponse.setTotalPrice(42.37);

            return Response.ok().entity(abonnementResponse).build();
        } else {
            return Response.status(403).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectAbonnement(@QueryParam("token") String token, @PathParam("id") int id) {

        if ("1234-1234".equals(token)) {

            DetailAbonnement detailAbonnement = new DetailAbonnement();
            detailAbonnement.setId(id);
            detailAbonnement.setAanbieder("Vodafone");
            detailAbonnement.setDienst("Mobiele telefonie 100");
            detailAbonnement.setPrijs("€5,- per maand");
            detailAbonnement.setStartDatum("2017-01-01");
            detailAbonnement.setVerdubbeling("standaard");
            detailAbonnement.setDeelbaar(false);
            detailAbonnement.setStatus("actief");

            return Response.ok().entity(detailAbonnement).build();
        }else {
            return Response.status(403).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response specifiekAbonnement(@QueryParam("token") String token, @PathParam("id") int id) {

        if ("1234-1234".equals(token)) {

            DetailAbonnement detailAbonnement = new DetailAbonnement();
            detailAbonnement.setId(id);
            detailAbonnement.setAanbieder("Vodafone");
            detailAbonnement.setDienst("Mobiele telefonie 100");
            detailAbonnement.setPrijs("€5,- per maand");
            detailAbonnement.setStartDatum("2017-01-01");
            detailAbonnement.setVerdubbeling("standaard");
            detailAbonnement.setDeelbaar(false);
            detailAbonnement.setStatus("opgezegd");

            return Response.ok().entity(detailAbonnement).build();
        }else {
            return Response.status(403).build();
        }
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectAbonnement(@QueryParam("token") String token, @PathParam("id") int id) {

        if ("1234-1234".equals(token)) {

            DetailAbonnement detailAbonnement = new DetailAbonnement();
            detailAbonnement.setId(id);
            detailAbonnement.setAanbieder("Vodafone");
            detailAbonnement.setDienst("Mobiele telefonie 100");
            detailAbonnement.setPrijs("€5,- per maand");
            detailAbonnement.setStartDatum("2017-01-01");
            detailAbonnement.setVerdubbeling("standaard");
            detailAbonnement.setDeelbaar(false);
            detailAbonnement.setStatus("actief");

            return Response.ok().entity(detailAbonnement).build();
        }else {
            return Response.status(403).build();
        }
    }
}
