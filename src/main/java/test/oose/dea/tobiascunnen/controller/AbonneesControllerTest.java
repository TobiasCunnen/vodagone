package test.oose.dea.tobiascunnen.controller;

import oose.dea.tobiascunnen.cotroller.AbonneesController;
import oose.dea.tobiascunnen.presentation.dtos.AbonneesResponse;
import oose.dea.tobiascunnen.service.AbonneesService;
import oose.dea.tobiascunnen.service.TokenService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class AbonneesControllerTest {

    @Mock
    private TokenService mockToken;

    @Mock
    private AbonneesService mockService;

    private AbonneesController abonneesController;

    @Before
    public void setUp() throws Exception {

        this.abonneesController = new AbonneesController();
        this.mockService = mock(AbonneesService.class);
        this.mockToken = mock(TokenService.class);

        this.abonneesController.setAbonneesService(mockService);
        this.abonneesController.setTokenService(mockToken);
    }

    @Test
    public void getAllShareableAbonneesReturnState200(){

        List<AbonneesResponse> abonneesList = new ArrayList<>();

        Mockito.when(mockToken.getToken()).thenReturn(1234);
        Mockito.when(mockService.getAbonnees()).thenReturn(abonneesList);

        Response res = abonneesController.abonnees(1234);

        Assert.assertEquals(200,res.getStatus());
    }

    @Test
    public void getAllAbonnementenFromUserReturnState403() {

        Mockito.when(mockToken.getToken()).thenReturn(12345);

        Response res = abonneesController.abonnees(1234);

        Assert.assertEquals(403,res.getStatus());
    }
}