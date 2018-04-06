package oose.dea.tobiascunnen.domain;

import oose.dea.tobiascunnen.datasource.connection.DBConnection;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementResponse;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbonnementDAO {

    @Inject
    private DBConnection dbConnection;

    private Connection con;

    public List<AbonnementResponse> getAbonnementen(String filter) {
        
        List<AbonnementResponse> abonnementen = new ArrayList<>();

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

    private AbonnementResponse getRowData(ResultSet rs) throws SQLException {

        AbonnementResponse abonnement = new AbonnementResponse();

        abonnement.setId(rs.getInt("id"));
        abonnement.setAanbieder(rs.getString("aanbieder"));
        abonnement.setDienst(rs.getString("dienst"));

        return abonnement;
    }

    private void setCon(){

        this.con = dbConnection.getConnection();
    }

}
