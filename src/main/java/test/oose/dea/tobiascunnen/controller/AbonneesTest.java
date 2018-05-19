package test.oose.dea.tobiascunnen.controller;

import oose.dea.tobiascunnen.cotroller.Abonnees;
import oose.dea.tobiascunnen.service.AbonneesService;
import oose.dea.tobiascunnen.service.TokenService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;

public class AbonneesTest {

    @Mock
    private TokenService mockToken;

    @Mock
    private AbonneesService mockService;

    private Abonnees abonnees;

    @Before
    public void setUp() throws Exception {

        this.abonnees = new Abonnees();
        this.mockService = mock(AbonneesService.class);
        this.mockToken = mock(TokenService.class);

        this.abonnees.setAbonneesService(mockService);
        this.abonnees.setTokenService(mockToken);
    }

    @Test
    public void getAllShareableAbonneesReturnState200(){
        Mockito.when(mockToken.getToken()).thenReturn(1234);
        Mockito.when(mockService.getAbonnees()).thenReturn(Response.status(200).build());

        Response res = abonnees.abonnees(1234);

        Assert.assertEquals(200,res.getStatus());
    }

    @Test
    public void getAllAbonnementenFromUserReturnState403() {

        Mockito.when(mockToken.getToken()).thenReturn(12345);

        Response res = abonnees.abonnees(1234);

        Assert.assertEquals(403,res.getStatus());
    }
}