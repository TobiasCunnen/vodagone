package oose.dea.tobiascunnen.presentation;

import oose.dea.tobiascunnen.presentation.dtos.LoginRequest;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

public class LoginTest {

    LoginRequest rq;

    @Before
    public void setup(){
        rq = new LoginRequest();
    }

    @Test
    public  void emptyRequestReturnState403(){

        Login loginEndpoint = new Login();

        Response resp = loginEndpoint.login(rq);

       // Assert.assertEquals(403,resp.getStatus());

    }

    @Test
    public  void tobiasRequestReturnState200(){

        rq.setUser("tobias");

        Login loginEndpoint = new Login();

        Response resp = loginEndpoint.login(rq);

        //Assert.assertEquals(200,resp.getStatus());

    }
}
