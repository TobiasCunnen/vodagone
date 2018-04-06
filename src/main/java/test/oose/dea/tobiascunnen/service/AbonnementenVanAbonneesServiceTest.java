package test.oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.domain.AbonnementenVanAbonneesDAO;
import oose.dea.tobiascunnen.domain.POJO.AbonneesPOJO;
import oose.dea.tobiascunnen.domain.POJO.AbonnementenPOJO;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementResponse;
import oose.dea.tobiascunnen.service.AbonnementenVanAbonneesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class AbonnementenVanAbonneesServiceTest {

    @Mock
    private AbonnementenVanAbonneesDAO mockDAO;

    private AbonnementenVanAbonneesService target;

    @Before
    public void setUp() {
        this.target = new AbonnementenVanAbonneesService();
        this.mockDAO = mock(AbonnementenVanAbonneesDAO.class);

        this.target.setAbonnementenVanAbonneesDAO(mockDAO);
    }

    @Test
    public void getAbonnementenFromUserServiceReturnState200(){
        AbonnementResponse aboRes = new AbonnementResponse();

        Mockito.when(mockDAO.getAbonnementenVanAbonnee()).thenReturn(aboRes);

        Response res = target.getAbonnementen();

        Assert.assertEquals(200,res.getStatus());
    }
}