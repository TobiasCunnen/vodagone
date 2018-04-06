package oose.dea.tobiascunnen.domain;


import oose.dea.tobiascunnen.datasource.connection.DBConnection;
import oose.dea.tobiascunnen.datasource.mapper.LoginMapper;
import oose.dea.tobiascunnen.presentation.dtos.LoginPOJO;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    @Inject
    private DBConnection dbConnection;

    private Connection con;

    public LoginPOJO getLoginData(String user) {

        LoginPOJO login = new LoginPOJO();

        if (LoginMapper.getName() != null) {

            if (LoginMapper.getName().equals(user)) {

                login.setName(LoginMapper.getName());
                login.setPassword(LoginMapper.getPassword());
                System.out.println("getLoginFromMap!");

                return login;
            }
        }

        this.setCon();

        String sql = "SELECT * FROM abonnees WHERE name = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                login.setName(rs.getString("name"));
                login.setPassword(rs.getString("wachtwoord"));

                setLoginMap(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return login;
    }

    private void setLoginMap(ResultSet rs) throws SQLException {

        LoginMapper.setId(rs.getInt("id"));
        LoginMapper.setName(rs.getString("name"));
        LoginMapper.setEmail(rs.getString("email"));
        LoginMapper.setPassword(rs.getString("wachtwoord"));
    }

    private void setCon() {

        this.con = dbConnection.getConnection();
    }
}
