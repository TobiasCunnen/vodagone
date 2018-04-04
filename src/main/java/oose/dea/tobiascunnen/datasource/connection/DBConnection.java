package oose.dea.tobiascunnen.datasource.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private Properties properties = new Properties();

    private String driver;
    private String connectionURL;

    private DbType dbType = DbType.MySQL;

    private void setProperties() {
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch(dbType){
            case MySQL:
                driver = properties.getProperty("mysql.driver");
                connectionURL = properties.getProperty("mysql.connectionString");
                break;
            case MsSQL:
                driver = properties.getProperty("mssql.driver");
                connectionURL = properties.getProperty("mssql.connectionString");
                break;
        }

    }

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
