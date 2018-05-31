package test.oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.dao.AbonnementenVanAbonneesDAO;
import oose.dea.tobiascunnen.domain.Abonnement;
import oose.dea.tobiascunnen.domain.Abonnementen;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementenResponse;
import oose.dea.tobiascunnen.service.AbonnementenVanAbonneesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

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
        Abonnementen abonnementen = mock(Abonnementen.class);

        Mockito.when(mockDAO.getAbonnementenVanAbonnee()).thenReturn(abonnementen);

        Abonnementen actual = target.getAbonnementen();

        Assert.assertEquals(abonnementen,actual);
    }
}