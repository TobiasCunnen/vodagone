package oose.dea.tobiascunnen.datasource.connection;

import oose.dea.tobiascunnen.datasource.connection.DBConnection;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MSSQLConnection implements DBConnection {

    private Properties properties = new Properties();

    private String driver;
    private String connectionURL;

    private void setProperties() {

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("mssql.driver");
        connectionURL = properties.getProperty("mssql.connectionString");
    }


    @Override
    public Connection getConnection() {

        Connection cnEmps = null;

        this.setProperties();

        try {

            Class.forName(driver);
            cnEmps = DriverManager.getConnection(connectionURL);

        } catch (SQLException e) {
            System.out.println("Error connecting to a database: " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cnEmps;

    }

}
