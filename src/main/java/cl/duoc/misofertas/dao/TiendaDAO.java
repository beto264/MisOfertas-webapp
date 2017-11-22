/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dao;

import cl.duoc.misofertas.db.DBConnection;
import cl.duoc.misofertas.dto.TiendaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Beto
 */
public class TiendaDAO {
    
    public List<TiendaDTO> getAll() throws SQLException {

        Connection con = new DBConnection().connect();

        String sp = "{call get_tiendas(?)}";

        CallableStatement cs = con.prepareCall(sp);
        cs.registerOutParameter(1, OracleTypes.CURSOR);

        cs.executeUpdate();

        ResultSet rs = rs = (ResultSet) cs.getObject(1);

        List<TiendaDTO> tiendas = new ArrayList<>();

        while (rs.next()) {
            TiendaDTO tiendaDTO = new TiendaDTO();
            tiendaDTO.setIdTienda(rs.getString("id_tienda"));
            tiendaDTO.setNombre(rs.getString("nombre"));
            tiendaDTO.setDireccion(rs.getString("direccion"));

            tiendas.add(tiendaDTO);
        }
        
        return tiendas;
    }
}
