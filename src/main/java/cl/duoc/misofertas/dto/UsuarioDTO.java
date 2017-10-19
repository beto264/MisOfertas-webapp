/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Beto
 */
public class UsuarioDTO implements Serializable {
    
    private String rut;
    private String password;
    private String nombre;
    private String apellido;
    private String username;
    private String fono;
    private String direccion;
    private Date fechaRegistro;
    private Date ultimoAcceso;
    private String rol;
    private Integer puntosAcumulados;
    private String rutEmpresaACargo;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String rut, String password, String nombre, String apellido, String username, String fono, String direccion, Date fechaRegistro, Date ultimoAcceso, String rol, Integer puntosAcumulados, String rutEmpresaACargo) {
        this.rut = rut;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.fono = fono;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.ultimoAcceso = ultimoAcceso;
        this.rol = rol;
        this.puntosAcumulados = puntosAcumulados;
        this.rutEmpresaACargo = rutEmpresaACargo;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "rut=" + rut + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido + ", username=" + username + ", fono=" + fono + ", direccion=" + direccion + ", fechaRegistro=" + fechaRegistro + ", ultimoAcceso=" + ultimoAcceso + ", rol=" + rol + ", puntosAcumulados=" + puntosAcumulados + ", rutEmpresaACargo=" + rutEmpresaACargo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.rut);
        hash = 23 * hash + Objects.hashCode(this.password);
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.apellido);
        hash = 23 * hash + Objects.hashCode(this.username);
        hash = 23 * hash + Objects.hashCode(this.fono);
        hash = 23 * hash + Objects.hashCode(this.direccion);
        hash = 23 * hash + Objects.hashCode(this.fechaRegistro);
        hash = 23 * hash + Objects.hashCode(this.ultimoAcceso);
        hash = 23 * hash + Objects.hashCode(this.rol);
        hash = 23 * hash + Objects.hashCode(this.puntosAcumulados);
        hash = 23 * hash + Objects.hashCode(this.rutEmpresaACargo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioDTO other = (UsuarioDTO) obj;
        if (!Objects.equals(this.rut, other.rut)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.fono, other.fono)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.rutEmpresaACargo, other.rutEmpresaACargo)) {
            return false;
        }
        if (!Objects.equals(this.fechaRegistro, other.fechaRegistro)) {
            return false;
        }
        if (!Objects.equals(this.ultimoAcceso, other.ultimoAcceso)) {
            return false;
        }
        if (!Objects.equals(this.puntosAcumulados, other.puntosAcumulados)) {
            return false;
        }
        return true;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre + " " + apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(Integer puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public String getRutEmpresaACargo() {
        return rutEmpresaACargo;
    }

    public void setRutEmpresaACargo(String rutEmpresaACargo) {
        this.rutEmpresaACargo = rutEmpresaACargo;
    }
    

}
