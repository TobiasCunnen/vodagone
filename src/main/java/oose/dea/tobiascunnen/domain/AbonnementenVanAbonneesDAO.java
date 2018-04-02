package oose.dea.tobiascunnen.domain;

import oose.dea.tobiascunnen.datasource.connection.MSSQLConnection;
import oose.dea.tobiascunnen.domain.POJO.AbonnementenPOJO;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementResponse;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbonnementenVanAbonneesDAO {


    @Inject
    private MSSQLConnection dbConnection;

    private Connection con;

    public AbonnementResponse getAbonnementenVanAbonnee() {

        AbonnementResponse abonnementResponse = new AbonnementResponse();
        List<AbonnementenPOJO> abonnementen = new ArrayList<>();

        double totalPrice = 0;

        this.setCon();

        String sql = "SELECT abonnementId,aanbieder,dienst,prijs,verdubbeling,deelbaar, startDatum, status " +
                "FROM AbonnementenVanAbonnees AVA INNER JOIN Abonnementen A ON A.Id = AVA.abonnementId " +
                "WHERE abonneesId = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,1);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                abonnementen.add(getRowData(rs));
                totalPrice += rs.getDouble("prijs");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        abonnementResponse.setAbonnementen(abonnementen);
        abonnementResponse.setTotalPrice(totalPrice);

        return abonnementResponse;
    }

    public AbonnementenPOJO selectOneAbonnementenVanAbonnee(int id) {

        this.setCon();

        AbonnementenPOJO abonnement = new AbonnementenPOJO();

        String sql = "SELECT abonnementId,aanbieder,dienst,prijs,verdubbeling,deelbaar, startDatum, status " +
                "FROM AbonnementenVanAbonnees AVA INNER JOIN Abonnementen A ON A.Id = AVA.abonnementId " +
                "WHERE abonneesId = ? AND abonnementId = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,1);
            st.setInt(2,id);

            ResultSet rs = st.executeQuery();

            rs.next();

            abonnement = getRowData(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abonnement;
    }

    public void addAbonnement(int abonnementId, String startDatum, String status){

        this.setCon();

        String sql = "INSERT INTO AbonnementenVanAbonnees (abonneesId,abonnementId,startDatum,status) VALUES (?,?,?,?)";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,1);
            st.setInt(2,abonnementId);
            st.setString(3,startDatum);
            st.setString(4,"Proef");

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAbonnement(int abonnementId){

        this.setCon();

        updateStatus("opgezegd",abonnementId);

        String sql = "DELETE FROM AbonnementenVanAbonnees WHERE abonneesId = ? AND abonnementId = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,1);
            st.setInt(2,abonnementId);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(String status, int abonnementId){

        this.setCon();

        String sql = "UPDATE AbonnementenVanAbonnees SET status = ? WHERE abonneesId = ? AND abonnementId = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,status);
            st.setInt(2,1);
            st.setInt(3,abonnementId);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private AbonnementenPOJO getRowData(ResultSet rs) throws SQLException {

        AbonnementenPOJO abonnement = new AbonnementenPOJO();

        abonnement.setId(rs.getInt("abonnementId"));
        abonnement.setAanbieder(rs.getString("aanbieder"));
        abonnement.setDienst(rs.getString("dienst"));
        abonnement.setPrijs("€"+rs.getString("prijs")+" per maand.");
        abonnement.setStartDatum(rs.getString("startDatum"));
        abonnement.setDeelbaar(rs.getBoolean("deelbaar"));
        abonnement.setVerdubbeling(rs.getString("verdubbeling"));
        abonnement.setStatus(rs.getString("status"));

        return abonnement;
    }

    private void setCon(){

        this.con = dbConnection.getConnection();
    }
}
