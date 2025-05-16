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
public class Apoderado extends Persona implements Serializable{
    private String relacion,ndocalum,distrito,dep,celu;

    public Apoderado() {
    }

    public Apoderado(String relacion, String ndocalum, String distrito, String dep,
            String celu, String tipodoc, String ndoc, String nombres, String apellidos, String pais, String cont) {
        super(tipodoc, ndoc, nombres, apellidos, pais, cont);
        this.relacion = relacion;
        this.ndocalum = ndocalum;
        this.distrito = distrito;
        this.dep = dep;
        this.celu = celu;
    }

    public Object[] Registro(int num){
        Object[] fila={num,relacion,ndocalum,super.getTipodoc(),super.getNdoc(),super.getNombres(),super.getApellidos(),super.getPais()
        ,dep,distrito,super.getCont(),celu};
        return fila;
    }
    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getNdocalum() {
        return ndocalum;
    }

    public void setNdocalum(String ndocalum) {
        this.ndocalum = ndocalum;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getCelu() {
        return celu;
    }

    public void setCelu(String celu) {
        this.celu = celu;
    }
    
}
