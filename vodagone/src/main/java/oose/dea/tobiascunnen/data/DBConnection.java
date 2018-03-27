package oose.dea.tobiascunnen.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

   public Connection getConnection(){
       Connection cnEmps = null;
       try
       {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

           String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
                   "databaseName=vodagoneDB;user=sa;password=dbrules;";
           cnEmps = DriverManager.getConnection(connectionUrl);
       }
       catch (SQLException e)
       {
           System.out.println("Error connecting to a database: " + e);
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }

       return cnEmps;
   }
}
