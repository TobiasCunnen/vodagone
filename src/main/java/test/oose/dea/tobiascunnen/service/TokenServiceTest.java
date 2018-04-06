package test.oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.service.TokenService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

public class TokenServiceTest {

    private TokenService target;

    @Before
    public void setUp() {
        this.target = new TokenService();
    }

    @Test
    public void testGenerateToken(){
        Assert.assertNotNull(target.generateToken());
    }
}