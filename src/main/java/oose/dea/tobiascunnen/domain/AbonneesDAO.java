package oose.dea.tobiascunnen.domain;

import oose.dea.tobiascunnen.datasource.connection.DBConnection;
import oose.dea.tobiascunnen.datasource.mapper.LoginMapper;
import oose.dea.tobiascunnen.datasource.mapper.SelectedAboMapper;
import oose.dea.tobiascunnen.presentation.dtos.AbonneesResponse;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbonneesDAO {

    @Inject
    private DBConnection dbConnection;

    private Connection con;

    public List<AbonneesResponse> getAbonnees() {

        this.setCon();

        List<AbonneesResponse> abonnees = new ArrayList<>();

        String sql = "SELECT id, name, email FROM abonnees WHERE id != ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,LoginMapper.getId());

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                abonnees.add(getRowData(rs));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abonnees;
    }

    public AbonneesResponse selectOneAbonnee(int id) {

        this.setCon();

        AbonneesResponse abonnee = new AbonneesResponse();

        String sql = "SELECT id, name, email FROM abonnees WHERE id = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,id);

            ResultSet rs = st.executeQuery();

            rs.next();

            abonnee = getRowData(rs);

            schareAbonnement(abonnee.getId(),SelectedAboMapper.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abonnee;
    }

    @Inject
    AbonnementenVanAbonneesDAO dao;

    private void schareAbonnement(int aboneeId, int abonnementId) {

        dao.setLoginId(aboneeId);

        dao.addAbonnement(abonnementId,"","standaard","proef");
    }

    private AbonneesResponse getRowData(ResultSet rs) throws SQLException {

        AbonneesResponse abonnee = new AbonneesResponse();

        abonnee.setId(rs.getInt("id"));
        abonnee.setName(rs.getString("name"));
        abonnee.setEmail(rs.getString("email"));

        return abonnee;
    }

    private void setCon(){

        this.con = dbConnection.getConnection();
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
