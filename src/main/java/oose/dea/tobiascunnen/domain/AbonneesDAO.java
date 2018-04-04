package oose.dea.tobiascunnen.domain;

import oose.dea.tobiascunnen.datasource.connection.DBConnection;
import oose.dea.tobiascunnen.domain.POJO.AbonneesPOJO;

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

    public List<AbonneesPOJO> getAbonnees() {

        this.setCon();

        List<AbonneesPOJO> abonnees = new ArrayList<>();

        String sql = "SELECT id, name, email FROM abonnees WHERE id != ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,1);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                abonnees.add(getRowData(rs));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abonnees;
    }

    public AbonneesPOJO selectOneAbonnee(int id) {

        this.setCon();

        AbonneesPOJO abonnee = new AbonneesPOJO();

        String sql = "SELECT id, name, email FROM abonnees WHERE id = ?";

        try {

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,id);

            ResultSet rs = st.executeQuery();

            rs.next();

            abonnee = getRowData(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abonnee;
    }

    private AbonneesPOJO getRowData(ResultSet rs) throws SQLException {

        AbonneesPOJO abonnee = new AbonneesPOJO();

        abonnee.setId(rs.getInt("id"));
        abonnee.setName(rs.getString("name"));
        abonnee.setEmail(rs.getString("email"));

        return abonnee;
    }

    private void setCon(){

        this.con = dbConnection.getConnection();
    }
}
