package oose.dea.tobiascunnen.service;

import oose.dea.tobiascunnen.dao.LoginDAO;
import oose.dea.tobiascunnen.domain.Login;

import javax.inject.Inject;

public class LoginService {

    @Inject
    LoginDAO loginDAO;

    public boolean userLogin(String user, String password) {

        Login login = loginDAO.getLoginData(user);

        if(login.getName().equals(user) && login.getPassword().equals(password)) {
            return true;
        }

        return false;
    }

    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
}
