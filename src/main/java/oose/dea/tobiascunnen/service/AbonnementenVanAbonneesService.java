package oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.datasource.mapper.SelectedAboMapper;
import oose.dea.tobiascunnen.domain.AbonnementenVanAbonneesDAO;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class AbonnementenVanAbonneesService {

    @Inject
    AbonnementenVanAbonneesDAO abonnementenVanAbonneesDAO;

    public Response getAbonnementen(){

        return Response.ok().entity(abonnementenVanAbonneesDAO.getAbonnementenVanAbonnee()).build();
    }

    public Response selectOneAbonnement(int id){

        return Response.ok().entity(abonnementenVanAbonneesDAO.selectOneAbonnementenVanAbonnee(id)).build();
    }

    public void addAbonnement(int abonnementId, String verdubbeling, String status){
        abonnementenVanAbonneesDAO.addAbonnement(abonnementId,verdubbeling,status);
    }

    public void deleteAbonnement(int abonnementId){
        abonnementenVanAbonneesDAO.deleteAbonnement(abonnementId);
    }

    public void updateStatus(String status, int abonnementId){
        abonnementenVanAbonneesDAO.updateStatus(status,abonnementId);
    }

    public void updateVerdubbeling(String verdubbeling, int id) {
        abonnementenVanAbonneesDAO.updateVerdubbeling(verdubbeling,dubbelPrijs(),id);
    }

    private BigDecimal dubbelPrijs() {
        BigDecimal prijs = SelectedAboMapper.getPrijs();
        BigDecimal dubbel = BigDecimal.valueOf(1.5);
        prijs = prijs.multiply(dubbel);
        prijs = prijs.setScale(2, RoundingMode.CEILING);

        return prijs;
    }

    public void setAbonnementenVanAbonneesDAO(AbonnementenVanAbonneesDAO abonnementenVanAbonneesDAO) {
        this.abonnementenVanAbonneesDAO = abonnementenVanAbonneesDAO;
    }
}
