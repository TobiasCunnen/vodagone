package oose.dea.tobiascunnen.rest;

import oose.dea.tobiascunnen.rest.dtos.AbonnementRequest;
import oose.dea.tobiascunnen.rest.dtos.AbonnementResponse;
import oose.dea.tobiascunnen.rest.dtos.SimpelAbonnement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("abonnementen")
public class VoegAbonnementToe {

    List<SimpelAbonnement> abo = new ArrayList<>();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response abonnementen(@QueryParam("token") String token, AbonnementRequest abonnementRequest) {

        AbonnementResponse abonnementResponse = new AbonnementResponse();

        if ("1234-1234".equals(token)) {

            abo.add(new SimpelAbonnement(0,"Vodafone","Mobiele telefonie 100"));
            abo.add(new SimpelAbonnement(1,"Vodafone","Mobiele telefonie 250"));
            abo.add(new SimpelAbonnement(2,"Ziggo","Kabel-internet (download 300 Mpbs)"));
            abo.add(new SimpelAbonnement(abonnementRequest.getId(),abonnementRequest.getAanbieder(),abonnementRequest.getDienst()));
            abonnementResponse.setAbonnementen(abo);
            abonnementResponse.setTotalPrice(42.37);


            return Response.ok().entity(abonnementResponse).build();
        } else {
            return Response.status(403).build();
        }
    }
}

