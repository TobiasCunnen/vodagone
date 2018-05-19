package test.oose.dea.tobiascunnen.service;


import oose.dea.tobiascunnen.domain.AbonnementDAO;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementResponse;
import oose.dea.tobiascunnen.service.AbonnementenService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class AbonnementenServiceTest {

    @Mock
    private AbonnementDAO mockDAO;

    private AbonnementenService target;

    @Before
    public void setUp() {
        this.target = new AbonnementenService();
        this.mockDAO = mock(AbonnementDAO.class);

        this.target.setAbonnementDAO(mockDAO);
    }

    @Test
    public void getAbonnementenServiceReturnState200() {
        List<AbonnementResponse> aboList = new ArrayList<>();
        String filter = "";

        Mockito.when(mockDAO.getAbonnementen(filter)).thenReturn(aboList);

        Response res = target.getAbonnementen(filter);

        Assert.assertEquals(200, res.getStatus());
    }
}