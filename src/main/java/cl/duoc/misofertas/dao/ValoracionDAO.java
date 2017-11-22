/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dao;

import cl.duoc.misofertas.db.DBConnection;
import cl.duoc.misofertas.dto.UsuarioDTO;
import cl.duoc.misofertas.dto.ValoracionDTO;
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
public class ValoracionDAO {

    public int addValoracion(String idOferta, String rut, String imagen, String nota, String comentario) throws SQLException {
        Connection con = new DBConnection().connect();

        String sp = "{call add_valoracion(?, ?, ?, ?, ?)}";

        CallableStatement cs = con.prepareCall(sp);
        cs.setString(1, idOferta);
        cs.setString(2, rut);
        cs.setString(3, nota);
        cs.setString(4, imagen);
        cs.setString(5, comentario);

        int count = cs.executeUpdate();
        return count;

    }

    public List<ValoracionDTO> getValoraciones(String idOferta) throws SQLException {
        Connection con = new DBConnection().connect();

        String sp = "{call get_valoraciones_oferta(?, ?)}";

        CallableStatement cs = con.prepareCall(sp);
        cs.setString(1, idOferta);
        cs.registerOutParameter(2, OracleTypes.CURSOR);

        cs.executeUpdate();

        ResultSet rs = rs = (ResultSet) cs.getObject(2);

        List<ValoracionDTO> valoraciones = new ArrayList<>();

        while (rs.next()) {
            ValoracionDTO valoracionDTO = new ValoracionDTO();
            valoracionDTO.setIdValoracion(rs.getString("id_valoracion"));
            valoracionDTO.setNota(rs.getString("nota"));
            valoracionDTO.setComentario(rs.getString("comentario"));
            valoracionDTO.setImagen(rs.getString("imagen"));
//            valoracionDTO.setFecha(rs.getDate("fecha"));
            
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombre(rs.getString("nombre"));
            usuarioDTO.setApellido(rs.getString("apellido"));
            
            valoracionDTO.setUsuarioDTO(usuarioDTO);
            valoraciones.add(valoracionDTO);

        }
        return valoraciones;
    }
    
     public int getValoracionesTienda(String idTienda) throws SQLException {
        Connection con = new DBConnection().connect();

        String sp = "{call get_valoraciones_tienda(?, ?)}";

        CallableStatement cs = con.prepareCall(sp);
        cs.setString(1, idTienda);
        cs.registerOutParameter(2, OracleTypes.CURSOR);

        cs.executeUpdate();

        ResultSet rs = rs = (ResultSet) cs.getObject(2);

        int valoraciones = 0;

        while (rs.next()) {
            valoraciones = Integer.valueOf(rs.getString("valoraciones"));

        }
        return valoraciones;
    }

}
