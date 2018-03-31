package oose.dea.tobiascunnen.presentation;


import oose.dea.tobiascunnen.domain.AbonnementDAO;
import oose.dea.tobiascunnen.presentation.dtos.AbonneesResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("abonnees")
public class Abonnees {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response abonnees(@QueryParam("token") String token){

        if("1234-1234".equals(token)) {

            AbonneesResponse abonneesResponse = new AbonneesResponse();

            List<AbonneesResponse> abonneesResponseList = new ArrayList<>();

            abonneesResponse.setId(0);
            abonneesResponse.setName("Meron");
            abonneesResponse.setEmail("Meron.Brouwer@han.nl");

            abonneesResponseList.add(abonneesResponse);

            AbonneesResponse abonneesResponse2 = new AbonneesResponse();

            abonneesResponse2.setId(1);
            abonneesResponse2.setName("Dennis");
            abonneesResponse2.setEmail("Dennis.Breuker@han.nl");

            abonneesResponseList.add(abonneesResponse2);

            return Response.ok().entity(abonneesResponseList).build();
        }else {
            return Response.status(403).build();
        }
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response shareWithAbonnee(@QueryParam("token") String token, @PathParam("id") int id){

        if ("1234-1234".equals(token)){
            AbonneesResponse abonneesResponse = new AbonneesResponse();

            abonneesResponse.setId(id);
            abonneesResponse.setName("Maron");
            abonneesResponse.setEmail("Maron.Brouwer@han.nl");

            return Response.ok().entity(abonneesResponse).build();
        }else{
            return Response.status(403).build();
        }

    }

}
