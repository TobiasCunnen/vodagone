package oose.dea.tobiascunnen.domain;

import oose.dea.tobiascunnen.datasource.connection.MSSQLConnection;

import javax.inject.Inject;
import java.sql.*;

public class AbonnementDAO {

    @Inject
    private MSSQLConnection dbConnection;

    private Connection con;

    public void getAbonnementen() {

        this.setCon();

        String sql = "SELECT * FROM Abonnementen";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("id");
            String aanbieder = rs.getString("aanbieder");
            String dienst = rs.getString("dienst");

            System.out.println("id: "+id+" aanbieder: "+aanbieder+" dienst: "+dienst);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setCon(){

        this.con = dbConnection.getConnection();
    }

}
