package oose.dea.tobiascunnen.presentation.dtos;

public class LoginResponse {

    private String user;
    private Integer token;

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
