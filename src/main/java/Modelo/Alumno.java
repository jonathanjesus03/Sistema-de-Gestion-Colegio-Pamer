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
public class Alumno extends Persona implements Serializable{
    private String disca,otrascond,dep,distri,lengua;
    private boolean estado;

    public Alumno() {
    }

    public Object[] Registro(int num) {
    Object[] fila = {
        num, super.getTipodoc(), super.getNdoc(), super.getNombres(), super.getApellidos(), 
        super.getSexo(), disca, otrascond, super.getPais(), dep, distri, super.getFecha(), 
        lengua, super.getCont(), estado}; //si hay datos en colegio precedente y es diferente de null, se muestra normal. si es null y Si está vacío muestra N/A
    return fila;
    }
    
    public Object[] RegistroSinMatri(int num) {
    Object[] fila = {num, super.getNdoc(),super.getNombres(), estado}; 
    return fila;
    }
    
    public String getDisca() {
        return disca;
    }

    public void setDisca(String disca) {
        this.disca = disca;
    }

    public String getOtrascond() {
        return otrascond;
    }

    public void setOtrascond(String otrascond) {
        this.otrascond = otrascond;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getDistri() {
        return distri;
    }

    public void setDistri(String distri) {
        this.distri = distri;
    }

    public String getLengua() {
        return lengua;
    }

    public void setLengua(String lengua) {
        this.lengua = lengua;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
