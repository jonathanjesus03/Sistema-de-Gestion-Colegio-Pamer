/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author cr075
 */
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

public class Horario implements Serializable{
    private String cod,codSalon,codCurso,codProfesor;
    private List<String> dias;  // lista de días
    private LocalTime horainicio;
    private LocalTime horariofinal;
    private String nombreCurso,grado,seccion,nombreProfesor;
 
    public Horario() {
    }

    public Object[] Registro(int num){
        String diasConcatenados = String.join(", ", dias);  //la lista se convierte en cadena 
        Object[] fila = {num, cod, codSalon,grado,seccion,codCurso,nombreCurso,codProfesor,nombreProfesor,diasConcatenados, horainicio, horariofinal};
        return fila;
    }
     public Object[] RegistroCursos(int num){
        Object[] fila = {num,codCurso,nombreCurso};
        return fila;
    }
    
    @Override
     public String toString(){
        String diasConcatenados = String.join(", ", dias);  //la lista se convierte en cadena 
        return "Registro Horario: "+
                "\n Código: " +cod+
                "\n Código Salón: " +codSalon+
                "\n Grado: " +grado+
                "\n Sección: " +seccion+
                "\n Código Curso: " +codCurso+
                "\n Nombre Curso: " +nombreCurso+
                "\n Código Profesor: " +codProfesor+
                "\n Nombre Profesor: " +nombreProfesor+
                "\n Días: " +diasConcatenados+
                "\n Hora Inicio: " +horainicio+
                "\n Hora Final: " +horariofinal;
    }
     
    public String toStringHorario() {
        String diasConcatenados = String.join(", ", dias); // Convierte la lista de días en una cadena
        return "Curso: " + nombreCurso
                + "\nDías: " + diasConcatenados
                + "\nHorario: " + horainicio + " - " + horariofinal;
    }

     
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        this.dias = dias;
    }

    public LocalTime getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(LocalTime horainicio) {
        this.horainicio = horainicio;
    }

    public LocalTime getHorariofinal() {
        return horariofinal;
    }

    public void setHorariofinal(LocalTime horariofinal) {
        this.horariofinal = horariofinal;
    }

    public String getCodSalon() {
        return codSalon;
    }

    public void setCodSalon(String codSalon) {
        this.codSalon = codSalon;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(String codProfesor) {
        this.codProfesor = codProfesor;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }
     
}

