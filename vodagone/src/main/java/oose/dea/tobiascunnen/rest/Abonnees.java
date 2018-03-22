package oose.dea.tobiascunnen.rest;


import oose.dea.tobiascunnen.rest.dtos.AbonneesResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("abonnees")
public class Abonnees {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response abonnees(@QueryParam("token") String token){

        if("1234-1234".equals(token)) {

            AbonneesResponse abonneesResponse = new AbonneesResponse();

            abonneesResponse.setId(0);
            abonneesResponse.setName("Meron");
            abonneesResponse.setEmail("Meron.Brouwer@han.nl");

            return Response.ok().entity(abonneesResponse).build();
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
