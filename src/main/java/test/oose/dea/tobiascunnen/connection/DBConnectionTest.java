package test.oose.dea.tobiascunnen.connection;

import oose.dea.tobiascunnen.datasource.connection.DBConnection;
import oose.dea.tobiascunnen.datasource.connection.DbType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DBConnectionTest {

    private DBConnection con;

    //Must be the same as the db running.
    DbType type = DbType.MySQL;

    @Before
    public void setUp(){
        this.con = new DBConnection(type);
    }


    @Test
    public void getConnectionWithDB() {
        Assert.assertNotNull(con.getConnection());
    }
}