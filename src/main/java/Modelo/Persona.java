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
public class Persona implements Serializable{
    private String tipodoc,ndoc,nombres,apellidos,sexo,pais,fecha,cont;

    public Persona() {
    }

    public Persona(String tipodoc, String ndoc, String nombres, String apellidos, String sexo, String pais, String fecha, String cont) {
        this.tipodoc = tipodoc;
        this.ndoc = ndoc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.pais = pais;
        this.fecha = fecha;
        this.cont = cont;
    }

    public Persona(String tipodoc, String ndoc, String nombres, String apellidos, String pais, String cont) {
        this.tipodoc = tipodoc;
        this.ndoc = ndoc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.pais = pais;
        this.cont = cont;
    }
    
    public String getNombreCompleto(){ return nombres+" "+apellidos;}
        
    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getNdoc() {
        return ndoc;
    }

    public void setNdoc(String ndoc) {
        this.ndoc = ndoc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
    
}
