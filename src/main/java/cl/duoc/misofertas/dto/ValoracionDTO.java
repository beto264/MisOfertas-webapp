/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dto;

import cl.duoc.misofertas.utils.Nota;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Beto
 */
public class ValoracionDTO {
    
    private int idValoracion;
    private int idOferta;
    private String rut;
    private Nota nota;
    private Date fecha;
    private String imagen;

    public ValoracionDTO() {
    }

    public ValoracionDTO(int idValoracion, int idOferta, String rut, Nota nota, Date fecha, String imagen) {
        this.idValoracion = idValoracion;
        this.idOferta = idOferta;
        this.rut = rut;
        this.nota = nota;
        this.fecha = fecha;
        this.imagen = imagen;
    }

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "ValoracionDTO{" + "idValoracion=" + idValoracion + ", idOferta=" + idOferta + ", rut=" + rut + ", nota=" + nota + ", fecha=" + fecha + ", imagen=" + imagen + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idValoracion;
        hash = 89 * hash + this.idOferta;
        hash = 89 * hash + Objects.hashCode(this.rut);
        hash = 89 * hash + Objects.hashCode(this.nota);
        hash = 89 * hash + Objects.hashCode(this.fecha);
        hash = 89 * hash + Objects.hashCode(this.imagen);
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
        final ValoracionDTO other = (ValoracionDTO) obj;
        if (this.idValoracion != other.idValoracion) {
            return false;
        }
        if (this.idOferta != other.idOferta) {
            return false;
        }
        if (!Objects.equals(this.rut, other.rut)) {
            return false;
        }
        if (!Objects.equals(this.imagen, other.imagen)) {
            return false;
        }
        if (this.nota != other.nota) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
