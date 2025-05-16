/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Samsung
 */
public class Referidos extends Alumno implements Serializable{
    private String dniDelReferidor;
    
    public Referidos() {
    }
    
    public Object[] Registro(int num) {
    Object[] fila = {
        num, super.getTipodoc(), super.getNdoc(), super.getNombres(), super.getApellidos(), 
        super.getSexo(), super.getDisca(), super.getOtrascond(), super.getPais(), super.getDep(), super.getDistri(), super.getFecha(), 
        super.getLengua(), super.getCont(), super.getEstado()}; //si hay datos en colegio precedente y es diferente de null, se muestra normal. si es null y Si está vacío muestra N/A
    return fila;
    }
    
    public Object[] RegistroSinMatri(int num) {
    Object[] fila = {num, super.getNdoc(),super.getNombres(), super.getEstado()}; 
    return fila;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.dniDelReferidor);
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
        final Referidos other = (Referidos) obj;
        return true;
    }
    
       public String getDniDelReferidor() {
        return dniDelReferidor;
    }

    public void setDniDelReferidor(String dniDelReferidor) {
        this.dniDelReferidor = dniDelReferidor;
    }
}
