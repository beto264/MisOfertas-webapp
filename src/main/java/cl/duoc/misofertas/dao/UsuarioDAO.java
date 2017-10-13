/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dao;

import cl.duoc.misofertas.db.DBConnection;
import cl.duoc.misofertas.dto.UsuarioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Beto
 */
public final class UsuarioDAO {

    private final Connection con = new DBConnection().connect();

    public boolean validUser(UsuarioDTO usuario) throws SQLException {

        boolean isValid = false;

        String command = "{call valid_user(?,?,?)}";
        try (CallableStatement cstmt = con.prepareCall(command)) {
            cstmt.setString(1, usuario.getUsername());
            cstmt.setString(2, usuario.getPassword());
            cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            cstmt.execute();

            String output = cstmt.getString(3);

            if (output.equalsIgnoreCase("CORRECTO")) {
                isValid = true;
            }

        }
        return isValid;
    }

    public boolean addUser(UsuarioDTO usuario) throws SQLException {

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        boolean inserted = false;

        String command = "{call add_user(?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement cstmt = con.prepareCall(command)) {
            cstmt.setString(1, usuario.getRut());
            cstmt.setString(2, usuario.getPassword());
            cstmt.setString(3, usuario.getNombre());
            cstmt.setString(4, usuario.getApellido());
            cstmt.setString(5, usuario.getUsername());
            cstmt.setString(6, usuario.getFono());
            cstmt.setString(7, usuario.getDireccion());
            cstmt.setDate(8, date);
            cstmt.setDate(9, date);
            cstmt.setString(10, "Consumidor");
            cstmt.setInt(11, 0);
            cstmt.setString(12, "");

            int row = cstmt.executeUpdate();

            if (row > 0) {
                inserted = true;
            }

        }
        return inserted;
    }

    public boolean userExists(String correo, String rut) throws SQLException {

        boolean exists = false;

        PreparedStatement ps = con.prepareStatement("select * from usuario where correo = ? or rut = ?");
        ps.setString(1, correo);
        ps.setString(2, rut);
        ResultSet rs = ps.executeQuery();
        if (rs.isBeforeFirst()) {
            exists = true;
        }

        return exists;
    }

    //Modificar más adelante
    public UsuarioDTO getUserByEmail(String correo) throws SQLException {

        PreparedStatement ps = con.prepareStatement("select * from usuario where correo = ? ");
        ps.setString(1, correo);

        ResultSet rs = ps.executeQuery();

        UsuarioDTO usuarioDTO = null;
        while (rs.next()) {
            usuarioDTO = new UsuarioDTO();
            usuarioDTO.setUsername(rs.getString("correo"));
            usuarioDTO.setPassword(rs.getString("password"));
            usuarioDTO.setRol(rs.getString("rol"));
            usuarioDTO.setNombre(rs.getString("nombre"));
        }

        return usuarioDTO;
    }

}
