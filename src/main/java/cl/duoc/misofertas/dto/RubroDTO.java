/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.dto;


/**
 *
 * @author Beto
 */
public class RubroDTO {

    private String idRubro;
    private String nombre;

    public RubroDTO() {
    }

    public String getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(String idRubro) {
        this.idRubro = idRubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "RubroDTO{" + "idRubro=" + idRubro + ", nombre=" + nombre + '}';
    }
    
    
    
}
