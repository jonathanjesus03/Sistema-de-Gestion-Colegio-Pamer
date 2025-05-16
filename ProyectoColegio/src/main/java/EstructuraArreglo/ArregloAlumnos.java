/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraArreglo;

import static EstructuraArreglo.ArregloAlumnos.contador;
import Modelo.Alumno;
import java.io.Serializable;

/**
 *
 * @author cr075
 */
public class ArregloAlumnos implements Serializable{
    private Alumno[] lista;
    public static int contador;

    public ArregloAlumnos(int cantidad) {
        lista=new Alumno[cantidad];
        contador=0;
    }
    
    public void agregarAlumno(Alumno nuevo){
        lista[contador]=nuevo;
        contador++;
    }
    
    public void actualizarAlumno(Alumno actual, int pos){
        lista[pos]=actual;
    }
    
    public Alumno retornarAlumno(int pos){
        return lista[pos];
    }
    
    public void eliminarAlumno(int pos){
        for(int i=pos;i<contador-1;i++){ //itera hasta el penultimo elemento
            lista[i]=lista[i+1]; //la posicion del elemento eliminado toma el valor siguiente
            break;
        }
        lista[contador-1]=null;//el último elemento se elimina
        contador--;//disminuye en uno
    }
    
    public int buscarporDnioNom(String dato){
        for (int i = 0; i < contador; i++) {
            if(dato.equalsIgnoreCase(lista[i].getNdoc()) || dato.equalsIgnoreCase(lista[i].getNombres())){
                return i;
            }
        }
        return -1;
    }
    public boolean buscarporDni(String dato){
        for (int i = 0; i < contador; i++) {
            if(dato.equalsIgnoreCase(lista[i].getNdoc())){
                return true;
            }
        }
        return false;
    }
    public Alumno retornarporDni(String dato){
        for (int i = 0; i < contador; i++) {
            if(dato.equalsIgnoreCase(lista[i].getNdoc())){
                return lista[i];
            }
        }
        return null;
    }
    public boolean buscarporDniSinMatricular(String dato){
        for (int i = 0; i < contador; i++) {
            if(lista[i].getEstado()==false && dato.equalsIgnoreCase(lista[i].getNdoc())){
                return true;
            }
        }
        return false;
    }
    public Alumno retornarporDniSinMatricular(String dato){
        for (int i = 0; i < contador; i++) {
            if(lista[i].getEstado()==false && dato.equalsIgnoreCase(lista[i].getNdoc())){
                return lista[i];
            }
        }
        return null;
    }
    
    public boolean buscarporPosSinMatricular(int pos){
        if (pos >= 0 && pos < contador) {
            if(lista[pos].getEstado()==false){
                return true;
            }
        }
        return false;
    }
   public Alumno retornarporPosSinMatricular(int pos){
        if (pos >= 0 && pos < contador) {
            if(lista[pos].getEstado()==false){
                return lista[pos];
            }
        }
        return null;
    }
    public void actualizarContador(){
        contador=0;
        for (int i = 0; i < lista.length; i++) { //recorre toda la lista
            if(lista[i]!=null){ //si el elemento no está vacío
                contador++; //aumenta contador
            }
        }
    }

    public Alumno[] getLista() {
        return lista;
    }

    public void setLista(Alumno[] lista) {
        this.lista = lista;
    }
    
    
}
