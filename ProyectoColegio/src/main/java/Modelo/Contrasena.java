/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author cr075
 */
public class Contrasena implements Serializable{
   private String usu,nuevacontra, repetircontra;

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getNuevacontra() {
        return nuevacontra;
    }

    public void setNuevacontra(String nuevacontra) {
        this.nuevacontra = nuevacontra;
    }

    public String getRepetircontra() {
        return repetircontra;
    }

    public void setRepetircontra(String repetircontra) {
        this.repetircontra = repetircontra;
    }
   
    
}
