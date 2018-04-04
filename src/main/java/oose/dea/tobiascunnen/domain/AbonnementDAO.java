package oose.dea.tobiascunnen.domain;

import oose.dea.tobiascunnen.datasource.connection.DBConnection;
import oose.dea.tobiascunnen.domain.POJO.AbonnementenPOJO;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbonnementDAO {

    @Inject
    private DBConnection dbConnection;

    private Connection con;

    public List<AbonnementenPOJO> getAbonnementen(String filter) {
        
        List<AbonnementenPOJO> abonnementen = new ArrayList<>();

        this.setCon();

        String sql = "SELECT * FROM Abonnementen WHERE aanbieder LIKE ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,'%'+filter+'%');

            ResultSet rs = st.executeQuery();

        while (rs.next()) {

          abonnementen.add(getRowData(rs));
          
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return abonnementen;
    }

    private AbonnementenPOJO getRowData(ResultSet rs) throws SQLException {

        AbonnementenPOJO abonnement = new AbonnementenPOJO();

        abonnement.setId(rs.getInt("id"));
        abonnement.setAanbieder(rs.getString("aanbieder"));
        abonnement.setDienst(rs.getString("dienst"));

        return abonnement;
    }

    private void setCon(){

        this.con = dbConnection.getConnection();
    }

}
