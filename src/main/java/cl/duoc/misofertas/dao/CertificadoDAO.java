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
import cl.duoc.misofertas.dto.UsuarioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Beto
 */
public class CertificadoDAO {

    public boolean addCertificado(CertificadoDTO certificadoDTO) throws SQLException {

        Connection con = new DBConnection().connect();

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        boolean inserted = false;

        String command = "{call add_certificado(?,?,?,?)}";
        try (CallableStatement cstmt = con.prepareCall(command)) {
            cstmt.setDate(1, date);
            cstmt.setString(2, certificadoDTO.getRut());
            cstmt.setString(3, certificadoDTO.getDescuento().getIdDescuento());
            cstmt.setLong(4, certificadoDTO.getCodigoBarra());

            int row = cstmt.executeUpdate();

            if (row > 0) {
                inserted = true;
            }

        }
        return inserted;
    }

    public List<CertificadoDTO> getByRut(String rut) throws SQLException, ParseException {

        Connection con = new DBConnection().connect();

        String sp = "{call get_certificados(?, ?)}";

        CallableStatement cs = con.prepareCall(sp);
        cs.setString(1, rut);
        cs.registerOutParameter(2, OracleTypes.CURSOR);

        cs.executeUpdate();

        ResultSet rs = rs = (ResultSet) cs.getObject(2);

        List<CertificadoDTO> certificados = new ArrayList<>();

        while (rs.next()) {
            CertificadoDTO certificadoDTO = new CertificadoDTO();
            certificadoDTO.setIdCertificado(rs.getString("id_certificado"));
            certificadoDTO.setCodigoBarra(rs.getLong("codigo_barra"));
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = dateFormat.format(rs.getDate("fecha_emision"));

            java.util.Date fechaParsed = dateFormat.parse(fecha);
            java.sql.Date sqlDate = new java.sql.Date(fechaParsed.getTime());
            
            certificadoDTO.setFechaEmision(sqlDate);
            certificadoDTO.setRut(rs.getString("rut"));

            DescuentoDTO descuentoDTO = new DescuentoDTO();
            descuentoDTO.setIdDescuento(rs.getString("id_descuento"));
            descuentoDTO.setPorcentaje(rs.getString("porcentaje"));
            descuentoDTO.setTope(rs.getString("tope"));
            
            RubroDTO rubroDTO = new RubroDTO();
            rubroDTO.setNombre(rs.getString("rubro"));
            descuentoDTO.setRubro(rubroDTO);
            
            certificadoDTO.setDescuento(descuentoDTO);

            certificados.add(certificadoDTO);
        }

        return certificados;
    }
     
     public List<CertificadoDTO> getById(String id) throws SQLException, ParseException {

        Connection con = new DBConnection().connect();

        String sp = "{call get_certificados_by_id(?, ?)}";

        CallableStatement cs = con.prepareCall(sp);
        cs.setString(1, id);
        cs.registerOutParameter(2, OracleTypes.CURSOR);

        cs.executeUpdate();

        ResultSet rs = rs = (ResultSet) cs.getObject(2);

        List<CertificadoDTO> certificados = new ArrayList<>();

        while (rs.next()) {
            CertificadoDTO certificadoDTO = new CertificadoDTO();
            certificadoDTO.setIdCertificado(rs.getString("id_certificado"));
            certificadoDTO.setCodigoBarra(rs.getLong("codigo_barra"));
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = dateFormat.format(rs.getDate("fecha_emision"));

            java.util.Date fechaParsed = dateFormat.parse(fecha);
            java.sql.Date sqlDate = new java.sql.Date(fechaParsed.getTime());
            certificadoDTO.setRut(rs.getString("rut"));
            certificadoDTO.setFechaEmision(sqlDate);
            
            DescuentoDTO descuentoDTO = new DescuentoDTO();
            descuentoDTO.setIdDescuento(rs.getString("id_descuento"));
            descuentoDTO.setPorcentaje(rs.getString("porcentaje"));
            descuentoDTO.setTope(rs.getString("tope"));
            
            RubroDTO rubroDTO = new RubroDTO();
            rubroDTO.setNombre(rs.getString("rubro"));
            descuentoDTO.setRubro(rubroDTO);
            
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombre(rs.getString("nombre"));
            usuarioDTO.setApellido(rs.getString("apellido"));
            usuarioDTO.setRut(rs.getString("rut"));
            usuarioDTO.setPuntosAcumulados(Integer.valueOf(rs.getString("puntos_acumulados")));
            
            certificadoDTO.setDescuento(descuentoDTO);
            certificadoDTO.setUsuarioDTO(usuarioDTO);

            certificados.add(certificadoDTO);
        }

        return certificados;
    }

    public boolean certificadoExists() throws SQLException, ParseException {

       /*boolean exists = false;
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String strDate = sdf.format(cal.getTime());
        
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        sdf1.applyPattern("dd/MM/yy");
        Date date = sdf1.parse(strDate);
        String string =sdf1.format(date);

        Connection con = new DBConnection().connect();

        PreparedStatement ps = con.prepareStatement("select * from certificado where fecha_emision = ?");
        ps.setDate(1, new java.sql.Date(date.getTime()));
        ResultSet rs = ps.executeQuery();
        if (rs.isBeforeFirst()) {
            exists = true;
        }*/

        return false;
    }

}
