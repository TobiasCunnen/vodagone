package oose.dea.tobiascunnen.rest;


import oose.dea.tobiascunnen.rest.dtos.AbonnementResponse;
import oose.dea.tobiascunnen.rest.dtos.SimpelAbonnement;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("abonnementen/all")
public class AllAbonnementen {

    private List<SimpelAbonnement> abo = new ArrayList<>();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllAbonnementen(@QueryParam("token") String token, @QueryParam("filter") String filter) {

        AbonnementResponse abonnementResponse = new AbonnementResponse();

        if ("1234-1234".equals(token)) {


            abo.add(new SimpelAbonnement(0, "Vodafone", "Mobiele telefonie 100"));
            abo.add(new SimpelAbonnement(1, "Vodafone", "Mobiele telefonie 250"));
            abonnementResponse.setAbonnementen(abo);
            abonnementResponse.setTotalPrice(42.37);

            return Response.ok().entity(abonnementResponse).build();
        } else {
            return Response.status(403).build();
        }
    }
}
