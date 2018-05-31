package oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.dao.AbonnementDAO;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class AbonnementenService {

    @Inject
    AbonnementDAO abonnementDAO;

    public Response getAbonnementen(String filter){

        return Response.ok().entity(abonnementDAO.getAbonnementen(filter)).build();
    }

    public void setAbonnementDAO(AbonnementDAO abonnementDAO) {
        this.abonnementDAO = abonnementDAO;
    }
}
