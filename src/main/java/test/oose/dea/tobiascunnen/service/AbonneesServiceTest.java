package test.oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.domain.AbonneesDAO;
import oose.dea.tobiascunnen.presentation.dtos.AbonneesResponse;
import oose.dea.tobiascunnen.service.AbonneesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class AbonneesServiceTest {

    @Mock
    private AbonneesDAO mockDAO;

    private AbonneesService target;

    @Before
    public void setUp(){
        this.target = new AbonneesService();
        this.mockDAO = mock(AbonneesDAO.class);

        this.target.setAbonneesDAO(mockDAO);
    }

    @Test
    public void getAbonneesServiceReturnState200(){

        List<AbonneesResponse> abonneesList = new ArrayList<>();

        Mockito.when(mockDAO.getAbonnees()).thenReturn(abonneesList);

        Response res = target.getAbonnees();

        Assert.assertEquals(200,res.getStatus());
    }
}