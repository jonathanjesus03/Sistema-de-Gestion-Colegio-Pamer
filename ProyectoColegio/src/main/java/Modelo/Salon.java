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
public class Salon implements Serializable{
    private String cod,nombre,seccion,ubi,estado;
    private int cap;
    public Salon() {
    }

    public Salon(String cod, String nombre, String seccion, String ubi, int cap, String estado) {
        this.cod = cod;
        this.nombre = nombre;
        this.seccion = seccion;
        this.ubi = ubi;
        this.cap = cap;
        this.estado = estado;
    }
    
    public Object[] Registro(int num){
        Object[] fila={num,cod,nombre,seccion,cap,ubi,estado};
        return fila;
    }
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getUbi() {
        return ubi;
    }

    public void setUbi(String ubi) {
        this.ubi = ubi;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
