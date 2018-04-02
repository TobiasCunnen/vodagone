package oose.dea.tobiascunnen.domain;


import oose.dea.tobiascunnen.datasource.connection.MySQLConnection;
import oose.dea.tobiascunnen.domain.POJO.LoginPOJO;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    @Inject
    private MySQLConnection dbConnection;

    private Connection con;

    public LoginPOJO getLoginData(String user) {

        this.setCon();

        LoginPOJO login = new LoginPOJO();
        String sql = "SELECT name, wachtwoord FROM abonnees WHERE name = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,user);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                login.setName(rs.getString("name"));
                login.setPassword(rs.getString("wachtwoord"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return login;
    }

    private void setCon() {

        this.con = dbConnection.getConnection();
    }
}
