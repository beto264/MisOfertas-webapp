/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.misofertas.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Beto
 */
public class GoogleMapsGeoClient {

    private static final String URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private static final String API_KEY = ",+Region+Metropolitana&key=AIzaSyAwCJwc27SDv8JI_WXk2FUdco_ca5pwx3E";

    private String direccion;
    private String numero;

    public GoogleMapsGeoClient(String direccion, String numero) {
        this.direccion = direccion;
        this.numero = numero;
        doDireccionFormat();
    }

    private String getPath() {
        StringBuilder path = new StringBuilder();
        path.append(URL)
                .append(direccion)
                .append("+")
                .append(numero)
                .append(API_KEY);

        return path.toString();
    }

    /**
     * Quita todos los espacios en blanco y los reemplaza por (+)
     */
    private void doDireccionFormat() {
        StringBuilder sb = new StringBuilder();
        String[] words = direccion.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            sb.append("+");
        }
        direccion = sb.toString();
    }

    public Double[] getLocacion() {

        Double[] locacion = new Double[2];

        try {
            Client client = Client.create();

            WebResource webResource = client
                    .resource(getPath());

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            JSONObject json = new JSONObject(output);
            JSONArray results = json.getJSONArray("results");
            JSONObject object = results.getJSONObject(0);
            JSONObject geometry = object.getJSONObject("geometry");
            JSONObject location = geometry.getJSONObject("location");

            locacion[0] = location.getDouble("lng");
            locacion[1] = location.getDouble("lat");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return locacion;
    }

    public static void main(String[] args) {
        GoogleMapsGeoClient googleMapsGeoClient = new GoogleMapsGeoClient("Salar de ascotan", "2262");
        Double[] locacion = googleMapsGeoClient.getLocacion();
        System.out.println(String.valueOf(locacion[0]));
        System.out.println(String.valueOf(locacion[1]));
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
