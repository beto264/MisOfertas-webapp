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
public class TiendaDTO {
    
    private String nombre;
    private String direccion;
    private String numero;
    private Double latitud;
    private Double longitud;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String[] splitted = direccion.split("#");
        this.direccion = splitted[0];
        this.numero = splitted[1];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getNumero() {
        return numero;
    }
    
    @Override
    public String toString() {
        return "TiendaDTO{" + "nombre=" + nombre + ", direccion=" + direccion + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }

}
