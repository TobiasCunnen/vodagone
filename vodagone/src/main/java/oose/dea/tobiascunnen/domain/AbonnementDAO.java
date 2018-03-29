package oose.dea.tobiascunnen.domain;

import oose.dea.tobiascunnen.data.DBConnection;

import java.sql.Connection;

public class AbonnementDAO {

    Connection con = new DBConnection().getConnection();
}
