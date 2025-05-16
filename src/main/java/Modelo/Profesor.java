/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author cr075
 */
public class Profesor extends Persona implements Serializable{
    private String grado,especiali,instituciones,dispon;
    private int años;
    private boolean curriculum,certificados;

    public Profesor() {
    }

    public Profesor(String grado, String especiali, String instituciones, String dispon, int años, boolean curriculum, boolean certificados, String tipodoc, String ndoc, String nombres, String apellidos, String sexo, String pais, String fecha, String cont) {
        super(tipodoc, ndoc, nombres, apellidos, sexo, pais, fecha, cont);
        this.grado = grado;
        this.especiali = especiali;
        this.instituciones = instituciones;
        this.dispon = dispon;
        this.años = años;
        this.curriculum = curriculum;
        this.certificados = certificados;
    }

    public Object[] Registro(int num){
        Object[] fila={num,super.getTipodoc(),super.getNdoc(),super.getNombres(),super.getApellidos(),super.getSexo(),
        super.getPais(),super.getFecha(),super.getCont(),grado,especiali,años,instituciones,dispon,curriculum,certificados};
        return fila;
    }
    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getEspeciali() {
        return especiali;
    }

    public void setEspeciali(String especiali) {
        this.especiali = especiali;
    }

    public String getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(String instituciones) {
        this.instituciones = instituciones;
    }

    public String getDispon() {
        return dispon;
    }

    public void setDispon(String dispon) {
        this.dispon = dispon;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public boolean isCurriculum() {
        return curriculum;
    }

    public void setCurriculum(boolean curriculum) {
        this.curriculum = curriculum;
    }

    public boolean isCertificados() {
        return certificados;
    }

    public void setCertificados(boolean certificados) {
        this.certificados = certificados;
    }
    
}
