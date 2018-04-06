package test.oose.dea.tobiascunnen.controller;

import oose.dea.tobiascunnen.cotroller.Abonnementen;
import oose.dea.tobiascunnen.service.AbonnementenVanAbonneesService;
import oose.dea.tobiascunnen.service.TokenService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;

public class AbonnementenTest {

    @Mock
    private AbonnementenVanAbonneesService mockService;

    @Mock
    private TokenService mockToken;

    private Abonnementen abonnementen;

    @Before
    public void setUp() {

        this.abonnementen = new Abonnementen();
        this.mockService = mock(AbonnementenVanAbonneesService.class);
        this.mockToken = mock(TokenService.class);

        this.abonnementen.setAbonnementenVanAbonneesService(mockService);
        this.abonnementen.setTokenService(mockToken);
    }

    @Test
    public void getAllAbonnementenFromUserReturnState200() {

        Mockito.when(mockToken.getToken()).thenReturn(1234);
        Mockito.when(mockService.getAbonnementen()).thenReturn(Response.status(200).build());

        Response res = abonnementen.abonnementen(1234);

        Assert.assertEquals(200,res.getStatus());
    }

    @Test
    public void getAllAbonnementenFromUserReturnState403() {

        Mockito.when(mockToken.getToken()).thenReturn(12345);

        Response res = abonnementen.abonnementen(1234);

        Assert.assertEquals(403,res.getStatus());
    }
}