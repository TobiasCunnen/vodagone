package oose.dea.tobiascunnen.domain;

import oose.dea.tobiascunnen.data.DBConnection;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbonnementDAO {

    @Inject
    private DBConnection dbConnection;

    private Connection con;

    public void getAbonnementen() {

        this.setCon();

        String sql = "SELECT * FROM Abonnementen";

        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

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
