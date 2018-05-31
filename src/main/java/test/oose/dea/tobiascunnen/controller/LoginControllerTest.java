package test.oose.dea.tobiascunnen.controller;


import oose.dea.tobiascunnen.cotroller.LoginController;
import oose.dea.tobiascunnen.presentation.dtos.LoginRequest;
import oose.dea.tobiascunnen.service.LoginService;
import oose.dea.tobiascunnen.service.TokenService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;

public class LoginControllerTest {

    private LoginController login;

    @Mock
    private LoginRequest mockRequest;

    @Mock
    private LoginService mockService;

    @Mock
    private TokenService mockToken;

    @Before
    public void setUp() {

        this.login = new LoginController();
        this.mockService = mock(LoginService.class);
        this.login.setLoginService(mockService);
        this.mockRequest = mock(LoginRequest.class);
        this.mockToken = mock(TokenService.class);
        this.login.setTokenService(mockToken);
    }


    @Test
    public  void userTobiasCunnenRequestReturnState200(){

        Mockito.when(mockService.userLogin("Tobias Cunnen","wachtwoord")).thenReturn(true);

        Mockito.when(mockToken.generateToken()).thenReturn(1234);

        Mockito.when(mockRequest.getUser()).thenReturn("Tobias Cunnen");
        Mockito.when(mockRequest.getPassword()).thenReturn("wachtwoord");

        Response resp = login.login(mockRequest);

        Assert.assertEquals(200,resp.getStatus());

    }
}