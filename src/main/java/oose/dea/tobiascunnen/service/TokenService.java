package oose.dea.tobiascunnen.service;

import java.util.Random;

public class TokenService {

    private static Integer token;

    public Integer generateToken() {

        Random random = new Random();
        token = random.nextInt();

        return token;
    }

    public Integer getToken() {
        return token;
    }
}
