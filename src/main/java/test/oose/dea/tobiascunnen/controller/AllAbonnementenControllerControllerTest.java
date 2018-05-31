package test.oose.dea.tobiascunnen.controller;

import oose.dea.tobiascunnen.cotroller.AllAbonnementenController;
import oose.dea.tobiascunnen.service.AbonnementenService;
import oose.dea.tobiascunnen.service.TokenService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;

public class AllAbonnementenControllerControllerTest {

    @Mock
    private AbonnementenService mockService;

    @Mock
    private TokenService mockToken;

    private AllAbonnementenController abonnementen;

    @Before
    public void setUp() {
        this.abonnementen = new AllAbonnementenController();
        this.mockService = mock(AbonnementenService.class);
        this.mockToken = mock(TokenService.class);

        this.abonnementen.setAbonnementenService(mockService);
        this.abonnementen.setTokenService(mockToken);
    }

    @Test
    public void getAllAbonnementenFilterReturnState200() {

        String filter = "";

        Mockito.when(mockToken.getToken()).thenReturn(1234);
        Mockito.when(mockService.getAbonnementen(filter)).thenReturn(Response.status(200).build());

        Response res = abonnementen.filterAbonnementen(1234,filter);

        Assert.assertEquals(200,res.getStatus());
    }

    @Test
    public void getAllAbonnementenFilterReturnState403() {

        Mockito.when(mockToken.getToken()).thenReturn(12345);

        Response res = abonnementen.filterAbonnementen(1234,"filter");

        Assert.assertEquals(403,res.getStatus());
    }
}