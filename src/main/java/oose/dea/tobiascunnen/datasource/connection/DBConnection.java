package oose.dea.tobiascunnen.datasource.connection;

import java.sql.Connection;

public interface DBConnection {

    void setProperties();

    Connection getConnection();
}
