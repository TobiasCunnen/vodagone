package test.oose.dea.tobiascunnen.domain;

import oose.dea.tobiascunnen.dao.AbonneesDAO;
import oose.dea.tobiascunnen.datasource.connection.DBConnection;
import oose.dea.tobiascunnen.datasource.mapper.LoginMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AbonneesDAOTest {

    private DBConnection db;

    private AbonneesDAO target;

    @Before
    public void setUp() {
        this.target = new AbonneesDAO();
        this.db = new DBConnection();

        this.target.setDbConnection(db);
    }

    @Test
    public void getAllshareableAbonneesDAO() {

        Mockito.when(LoginMapper.getId()).thenReturn(1);

        Assert.assertNotNull(target.getAbonnees());
    }
}