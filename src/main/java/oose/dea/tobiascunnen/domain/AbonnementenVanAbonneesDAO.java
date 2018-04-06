package oose.dea.tobiascunnen.domain;

import oose.dea.tobiascunnen.datasource.connection.DBConnection;
import oose.dea.tobiascunnen.datasource.mapper.FilterAboMapper;
import oose.dea.tobiascunnen.datasource.mapper.LoginMapper;
import oose.dea.tobiascunnen.datasource.mapper.SelectedAboMapper;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementResponse;
import oose.dea.tobiascunnen.presentation.dtos.AbonnementenResponse;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
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


    private final double verdubbeld = 1.5;

    @Inject
    private DBConnection dbConnection;

    private Connection con;
    private int loginId = LoginMapper.getId();

    public AbonnementenResponse getAbonnementenVanAbonnee() {

        AbonnementenResponse abonnementenResponse = new AbonnementenResponse();
        List<AbonnementResponse> abonnementen = new ArrayList<>();

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

                abonnementen.add(getRowData(rs));

                totalPrice += rs.getDouble("prijs");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        abonnementenResponse.setAbonnementen(abonnementen);
        abonnementenResponse.setTotalPrice(totalPrice);

        return abonnementenResponse;
    }

    public AbonnementResponse selectOneAbonnementenVanAbonnee(int id) {

        this.setCon();

        AbonnementResponse abonnement = new AbonnementResponse();

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

        String sql = "INSERT INTO AbonnementenVanAbonnees (abonneesId,abonnementId,startDatum,verdubbeling,prijs,status) VALUES (?,?,?,?,?,?)";

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {

            PreparedStatement st = con.prepareStatement(sql);


            st.setInt(1, loginId);
            st.setInt(2,abonnementId);
            st.setString(3,dateFormat.format(date));
            st.setString(4,FilterAboMapper.getVerdubbeling());
            st.setBigDecimal(5,FilterAboMapper.getPrijs());
            st.setString(6,status);

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

    private AbonnementResponse getRowData(ResultSet rs) throws SQLException {

        AbonnementResponse abonnement = new AbonnementResponse();

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
