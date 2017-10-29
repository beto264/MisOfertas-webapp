/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dao;

import cl.duoc.misofertas.db.DBConnection;
import cl.duoc.misofertas.dto.CertificadoDTO;
import cl.duoc.misofertas.dto.DescuentoDTO;
import cl.duoc.misofertas.dto.RubroDTO;
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
public class DescuentoDAO {
    
    public List<DescuentoDTO> getDescuentosByPuntos(int puntos) throws SQLException {

        Connection con = new DBConnection().connect();
        List<DescuentoDTO> descuentos = new ArrayList<>();
        
        String sp = "{call get_descuentos_by_puntos(?, ?)}";

        CallableStatement cs = con.prepareCall(sp);
        cs.setInt(1, puntos);
        cs.registerOutParameter(2, OracleTypes.CURSOR);

        cs.executeUpdate();

        ResultSet rs = rs = (ResultSet) cs.getObject(2);

        DescuentoDTO descuentoDTO = null;
        RubroDTO rubroDTO = null;
        
        while (rs.next()) {
            descuentoDTO = new DescuentoDTO();
            descuentoDTO.setIdDescuento(rs.getString("id_descuento"));
            descuentoDTO.setPorcentaje(rs.getString("porcentaje"));
            descuentoDTO.setTope(rs.getString("tope"));

            rubroDTO = new RubroDTO();
            rubroDTO.setIdRubro(rs.getString("id_rubro"));
            rubroDTO.setNombre(rs.getString("rubro"));
            descuentoDTO.setRubro(rubroDTO);
            
            descuentos.add(descuentoDTO);
        }

        return descuentos;
    }
}
