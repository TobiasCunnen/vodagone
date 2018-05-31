package oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.dao.AbonneesDAO;
import oose.dea.tobiascunnen.presentation.dtos.AbonneesResponse;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class AbonneesService {

    @Inject
    AbonneesDAO abonneesDAO;

    public List<AbonneesResponse> getAbonnees(){
        return abonneesDAO.getAbonnees();
    }

    public AbonneesResponse selectOneAbonnee(int id) {
        return abonneesDAO.selectOneAbonnee(id);
    }

    public void setAbonneesDAO(AbonneesDAO abonneesDAO) {
        this.abonneesDAO = abonneesDAO;
    }
}
