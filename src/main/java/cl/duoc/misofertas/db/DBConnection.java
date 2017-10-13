/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Beto
 */
public final class DBConnection {

    public DBConnection() {
    }

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "sys as sysdba ";
    private static final String PWD = "orclpass";

    public  Connection connect() {

        Connection conn = null;
        
        try {
            Class.forName(DRIVER);

            conn = DriverManager.getConnection(
                    URL, USER, PWD);

        } catch (ClassNotFoundException e) {
            //log driver
        } catch (SQLException ex) {
            //log connection
        }

        return conn;

    }

}
