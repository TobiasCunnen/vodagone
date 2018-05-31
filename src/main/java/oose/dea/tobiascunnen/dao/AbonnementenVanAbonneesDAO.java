package oose.dea.tobiascunnen.dao;

import oose.dea.tobiascunnen.datasource.connection.DBConnection;
import oose.dea.tobiascunnen.datasource.mapper.LoginMapper;
import oose.dea.tobiascunnen.datasource.mapper.SelectedAboMapper;
import oose.dea.tobiascunnen.domain.Abonnement;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementResponse;
import oose.dea.tobiascunnen.domain.Abonnementen;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbonnementenVanAbonneesDAO {

    @Inject
    private DBConnection dbConnection;

    private Connection con;
    private int loginId = LoginMapper.getId();

    public Abonnementen     getAbonnementenVanAbonnee() {

        Abonnementen abonnementen = new Abonnementen();
        List<Abonnement> abonnementenList = new ArrayList<>();

        double totalPrice = 0;

        this.setCon();

        String sql = "SELECT abonnementId,aanbieder,dienst,AVA.prijs,AVA.verdubbeling,deelbaar, startDatum, status " +
                "FROM AbonnementenVanAbonnees AVA INNER JOIN Abonnementen A ON A.Id = AVA.abonnementId " +
                "WHERE abonneesId = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,loginId);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                abonnementenList.add(getRowData(rs));

                totalPrice += rs.getDouble("prijs");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        abonnementen.setAbonnementen(abonnementenList);
        abonnementen.setTotalPrice(totalPrice);

        return abonnementen;
    }

    public Abonnement selectOneAbonnementenVanAbonnee(int id) {

        this.setCon();

        Abonnement abonnement = new Abonnement();

        String sql = "SELECT abonnementId,aanbieder,dienst,AVA.prijs,AVA.verdubbeling,deelbaar, startDatum, status " +
                "FROM AbonnementenVanAbonnees AVA INNER JOIN Abonnementen A ON A.Id = AVA.abonnementId " +
                "WHERE abonneesId = ? AND abonnementId = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,loginId);
            st.setInt(2,id);

            ResultSet rs = st.executeQuery();

            rs.next();

            abonnement = getRowData(rs);

            setSelectedAboMapper(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abonnement;
    }

    public void addAbonnement(int abonnementId, String verdubbeling, String status){

        this.setCon();

        String sql = "INSERT INTO abonnementenvanabonnees " +
                     "SELECT ?,?, verdubbeling, prijs, ?,? " +
                     "FROM abonnementen " +
                     "WHERE id = ?; ";

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {

            PreparedStatement st = con.prepareStatement(sql);


            st.setInt(1, loginId);
            st.setInt(2,abonnementId);
            st.setInt(5,abonnementId);
            st.setString(3,dateFormat.format(date));
            st.setString(4,status);

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

            st.setInt(1,loginId);
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
            st.setInt(2,loginId);
            st.setInt(3,abonnementId);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVerdubbeling(String verdubbeling,BigDecimal prijs, int id) {
        this.setCon();

        String sql = "UPDATE AbonnementenVanAbonnees SET verdubbeling = ?, prijs = ? WHERE abonneesId = ? AND abonnementId = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1,verdubbeling);
            st.setBigDecimal(2,prijs);
            st.setInt(3,loginId);
            st.setInt(4,id);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Abonnement getRowData(ResultSet rs) throws SQLException {

        Abonnement abonnement = new Abonnement();

        abonnement.setId(rs.getInt("abonnementId"));
        abonnement.setAanbieder(rs.getString("aanbieder"));
        abonnement.setDienst(rs.getString("dienst"));
        abonnement.setPrijs("€" + rs.getString("prijs") + " per maand.");
        abonnement.setStartDatum(rs.getString("startDatum"));
        abonnement.setDeelbaar(rs.getBoolean("deelbaar"));
        abonnement.setVerdubbeling(rs.getString("verdubbeling"));
        abonnement.setStatus(rs.getString("status"));

        return abonnement;
    }

    private void setSelectedAboMapper(ResultSet rs) throws SQLException {

        SelectedAboMapper.setId(rs.getInt("abonnementId"));
        SelectedAboMapper.setAanbieder(rs.getString("aanbieder"));
        SelectedAboMapper.setDienst(rs.getString("dienst"));
        SelectedAboMapper.setPrijs(rs.getBigDecimal("prijs"));
        SelectedAboMapper.setStartDatum(rs.getString("startDatum"));
        SelectedAboMapper.setDeelbaar(rs.getBoolean("deelbaar"));
        SelectedAboMapper.setVerdubbeling(rs.getString("verdubbeling"));
        SelectedAboMapper.setStatus(rs.getString("status"));
    }
    private void setCon(){

        this.con = dbConnection.getConnection();
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }
}
