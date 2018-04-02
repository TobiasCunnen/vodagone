package oose.dea.tobiascunnen.datasource.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection implements DBConnection {

    private Properties properties = new Properties();

    private String driver;
    private String connectionURL;

    @Override
    public void setProperties() {
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("mysql.driver");
        connectionURL = properties.getProperty("mysql.connectionString");
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
