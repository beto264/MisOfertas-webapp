/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dao;

import cl.duoc.misofertas.db.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Beto
 */
public class ValoracionDAO {
    
    public int addValoracion(String idOferta, String rut, String imagen, String nota) throws SQLException{
        Connection con = new DBConnection().connect();

        String sp = "{call add_valoracion(?, ?, ?, ?)}";

        CallableStatement cs = con.prepareCall(sp);
        cs.setString(1, idOferta);
        cs.setString(2, rut);
        cs.setString(3, nota);
        cs.setString(4, imagen);

        int count = cs.executeUpdate();
        return count;
        
    }
}
