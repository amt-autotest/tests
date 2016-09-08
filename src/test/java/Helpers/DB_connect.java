package Helpers;

/**
 * Created by maxsolovianov on 9/7/2016.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_connect {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:jtds:sqlserver://localhost:1433/AutomotiveTest";
    private static final String user = "estafetauser";
    private static final String password = "Gfhjkm lkz tcnfatns";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) {
        String query = "select * from Companies";

        try {
            // type of Driver
            DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());

            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String count = rs.getString(1);
                System.out.println("Total number of Users in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and result set here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }
}
