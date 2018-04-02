package oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.domain.AbonnementenVanAbonneesDAO;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class AbonnementenVanAbonneesService {

    @Inject
    AbonnementenVanAbonneesDAO abonnementenVanAbonneesDAO;

    public Response getAbonneenten(){

        return Response.ok().entity(abonnementenVanAbonneesDAO.getAbonnementenVanAbonnee()).build();
    }

    public Response selectOneAbonnement(int id){

        return Response.ok().entity(abonnementenVanAbonneesDAO.selectOneAbonnementenVanAbonnee(id)).build();
    }

    public void addAbonnement(int abonnementId, String startDatum,String verdubbeling, String status){
        abonnementenVanAbonneesDAO.addAbonnement(abonnementId,startDatum,verdubbeling,status);
    }

    public void deleteAbonnement(int abonnementId){
        abonnementenVanAbonneesDAO.deleteAbonnement(abonnementId);
    }

    public void updateStatus(String status, int abonnementId){
        abonnementenVanAbonneesDAO.updateStatus(status,abonnementId);
    }

    public void updateVerdubbeling(String verdubbeling, int id) {
        abonnementenVanAbonneesDAO.updateVerdubbeling(verdubbeling,id);
    }
}
