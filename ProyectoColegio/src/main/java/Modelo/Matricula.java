/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import EstructuraArreglo.ArregloAlumnos;
import Persistencia.AlmacenarAlumnos;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author cr075
 */
public class Matricula implements Serializable{
    private Alumno alumno;
    private String cod,grado,seccion,colegiopre;
    private LocalDate fecha;
    private boolean esTraslado,esNuevo,esAntiguo;
    private double pension;

    public Matricula() {
    }

    public void MontodePension(){
        if(grado.equalsIgnoreCase("Grado 1°")) pension=380;
        if(grado.equalsIgnoreCase("Grado 2°")) pension=400;
        if(grado.equalsIgnoreCase("Grado 3°")) pension=420;
        if(grado.equalsIgnoreCase("Grado 4°")) pension=440;
        if(grado.equalsIgnoreCase("Grado 5°")) pension=460;
        if(grado.equalsIgnoreCase("Grado 6°")) pension=480;
    }
    public Object[] Registro(int num){
        Object[] fila={num,cod,alumno.getNdoc(),alumno.getNombres(),(esTraslado ? "SI":"NO"),(colegiopre!=null && !colegiopre.isEmpty() ?
                colegiopre: "N/A"),(esAntiguo ? "SI":"NO"),(esNuevo? "SI":"NO"),grado,seccion,fecha,pension};
        return fila;
    }
    public Object[] RegistroListaAlumnoMatriculado(int num){
        Object[] fila={num,alumno.getNdoc(),alumno.getNombres()};
        return fila;
    }
    
    @Override
    public String toString(){
        return "Datos Matrícula: "+
                "\nCod. Matrícula: "+cod+
                "\nDni Alumno: "+alumno.getNdoc()+
                "\nAlumno: "+alumno.getNombres()+
                "\nEs Traslado? "+esTraslado+
                "\nColegio Precedente: "+colegiopre+
                "\nEs alumno antiguo? "+esAntiguo+
                "\nEs nuevo? "+esNuevo+
                "\nGrado a Matricular: "+grado+
                "\nSección: "+seccion+
                "\nFecha: "+fecha+
                "\nMonto de Pension:"+pension;
    }
   
    public void RegistrarMatriculaAlumno(ArregloAlumnos lista){
        alumno.setEstado(true); //el alumno pasa a estado true=matriculado
        int pos = lista.buscarporDnioNom(alumno.getNdoc());
        if (pos != -1) {
            lista.actualizarAlumno(alumno, pos);
            AlmacenarAlumnos.GuardarAlumnos(lista); // Guardar cambios en almacenamiento persistente
            
            System.out.println("El estado del alumno con N° de documento " + alumno.getNdoc() + " ha sido actualizado en el sistema.");
        } else {
            System.out.println("No se encontró el alumno en el arreglo para actualizar su estado.");
        }
    }
     public void EliminarMatriculaAlumno(ArregloAlumnos lista){
        alumno.setEstado(false); //el alumno pasa a estado false=no matriculado
        int pos = lista.buscarporDnioNom(alumno.getNdoc());
        if (pos != -1) {
            lista.actualizarAlumno(alumno, pos);
            AlmacenarAlumnos.GuardarAlumnos(lista); // Guardar cambios en almacenamiento persistente
            
            System.out.println("El estado del alumno con N° de documento " + alumno.getNdoc() + " ha sido actualizado en el sistema.");
        } else {
            System.out.println("No se encontró el alumno en el arreglo para actualizar su estado.");
        }
    }
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEsTraslado() {
        return esTraslado;
    }

    public void setEsTraslado(boolean esTraslado) {
        this.esTraslado = esTraslado;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public boolean isEsAntiguo() {
        return esAntiguo;
    }

    public void setEsAntiguo(boolean esAntiguo) {
        this.esAntiguo = esAntiguo;
    }

    public String getColegiopre() {
        return colegiopre;
    }

    public void setColegiopre(String colegiopre) {
        this.colegiopre = colegiopre;
    }
    
}
