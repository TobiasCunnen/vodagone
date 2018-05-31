package oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.datasource.mapper.SelectedAboMapper;
import oose.dea.tobiascunnen.dao.AbonnementenVanAbonneesDAO;
import oose.dea.tobiascunnen.domain.Abonnement;
import oose.dea.tobiascunnen.domain.Abonnementen;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementResponse;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementenResponse;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AbonnementenVanAbonneesService {

    @Inject
    AbonnementenVanAbonneesDAO abonnementenVanAbonneesDAO;

    public Abonnementen getAbonnementen(){

        return abonnementenVanAbonneesDAO.getAbonnementenVanAbonnee();
    }

    public Abonnement selectOneAbonnement(int id){

        return abonnementenVanAbonneesDAO.selectOneAbonnementenVanAbonnee(id);
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
