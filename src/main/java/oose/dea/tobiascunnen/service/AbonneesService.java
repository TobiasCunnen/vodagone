package oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.dao.AbonneesDAO;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class AbonneesService {

    @Inject
    AbonneesDAO abonneesDAO;

    public Response getAbonnees(){
        return Response.ok().entity(abonneesDAO.getAbonnees()).build();
    }

    public Response selectOneAbonnee(int id) {
        return Response.ok().entity(abonneesDAO.selectOneAbonnee(id)).build();
    }

    public void setAbonneesDAO(AbonneesDAO abonneesDAO) {
        this.abonneesDAO = abonneesDAO;
    }
}
