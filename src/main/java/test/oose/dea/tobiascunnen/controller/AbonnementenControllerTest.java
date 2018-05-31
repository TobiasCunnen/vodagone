package test.oose.dea.tobiascunnen.controller;

import oose.dea.tobiascunnen.cotroller.AbonnementenController;
import oose.dea.tobiascunnen.service.AbonnementenVanAbonneesService;
import oose.dea.tobiascunnen.service.TokenService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;

public class AbonnementenControllerTest {

    @Mock
    private AbonnementenVanAbonneesService mockService;

    @Mock
    private TokenService mockToken;

    private AbonnementenController abonnementenController;

    @Before
    public void setUp() {

        this.abonnementenController = new AbonnementenController();
        this.mockService = mock(AbonnementenVanAbonneesService.class);
        this.mockToken = mock(TokenService.class);

        this.abonnementenController.setAbonnementenVanAbonneesService(mockService);
        this.abonnementenController.setTokenService(mockToken);
    }

    @Test
    public void getAllAbonnementenFromUserReturnState200() {

        Mockito.when(mockToken.getToken()).thenReturn(1234);
        Mockito.when(mockService.getAbonnementen()).thenReturn(Response.status(200).build());

        Response res = abonnementenController.abonnementen(1234);

        Assert.assertEquals(200,res.getStatus());
    }

    @Test
    public void getAllAbonnementenFromUserReturnState403() {

        Mockito.when(mockToken.getToken()).thenReturn(12345);

        Response res = abonnementenController.abonnementen(1234);

        Assert.assertEquals(403,res.getStatus());
    }
}