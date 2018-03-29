package oose.dea.tobiascunnen.presentation;


import oose.dea.tobiascunnen.presentation.dtos.SimpelAbonnement;

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

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filterAbonnementen(@QueryParam("token") String token, @QueryParam("filter") String filter) {

        if ("1234-1234".equals(token)) {

            List<SimpelAbonnement> aboList = new ArrayList<>();

            SimpelAbonnement s1 = new SimpelAbonnement(0, "vodafone", "Mobiele telefonie 100");
            SimpelAbonnement s2 = new SimpelAbonnement(1, "vodafone", "Mobiele telefonie 250");
            SimpelAbonnement s3 = new SimpelAbonnement(2,"ziggo", "kabel-internet(download 300 Mbps)");

            aboList.add(s1);
            aboList.add(s2);
            aboList.add(s3);

            return Response.ok().entity(aboList).build();
        } else {
            return Response.status(403).build();
        }
    }
}
