package oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.dao.AbonnementDAO;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementResponse;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class AbonnementenService {

    @Inject
    AbonnementDAO abonnementDAO;

    public List<AbonnementResponse> getAbonnementen(String filter){

        return abonnementDAO.getAbonnementen(filter);
    }

    public void setAbonnementDAO(AbonnementDAO abonnementDAO) {
        this.abonnementDAO = abonnementDAO;
    }
}
