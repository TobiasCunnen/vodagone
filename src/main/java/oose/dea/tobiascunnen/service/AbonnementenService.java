package oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.domain.AbonnementDAO;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class AbonnementenService {

    @Inject
    AbonnementDAO abonnementDAO;

    public Response getAbonneenten(String filter){

        return Response.ok().entity(abonnementDAO.getAbonnementen(filter)).build();
    }
}
