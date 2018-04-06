package test.oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.cotroller.Login;
import oose.dea.tobiascunnen.domain.LoginDAO;
import oose.dea.tobiascunnen.domain.POJO.LoginPOJO;
import oose.dea.tobiascunnen.service.LoginService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginServiceTest {

    @Mock
    private LoginDAO mockDAO;

    @Mock
    LoginPOJO login;

    private LoginService target;

    @Before
    public void setUp() {
        this.target = new LoginService();
        this.mockDAO = mock(LoginDAO.class);
        this.login = mock(LoginPOJO.class);

        this.target.setLoginDAO(mockDAO);
    }

    @Test
    public void successfulUserLogin(){

        String user = "TobiasTest";
        String password = "wachtwoordTest";

        Mockito.when(login.getName()).thenReturn(user);
        Mockito.when(login.getPassword()).thenReturn(password);

        Mockito.when(mockDAO.getLoginData(user)).thenReturn(login);

        Assert.assertTrue(target.userLogin(user,password));
    }

    @Test
    public void unsuccessfulUserLogin(){

        String user = "TobiasTest";
        String password = "wachtwoordTest";

        Mockito.when(login.getName()).thenReturn("notTobias");
        Mockito.when(login.getPassword()).thenReturn(password);

        Mockito.when(mockDAO.getLoginData(user)).thenReturn(login);

        Assert.assertFalse(target.userLogin(user,password));
    }
}