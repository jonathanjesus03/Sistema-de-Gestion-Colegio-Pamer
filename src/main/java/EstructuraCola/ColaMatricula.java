/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraCola;

import Modelo.Matricula;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author cr075
 */
public class ColaMatricula implements Serializable{
    private PriorityQueue<Matricula> lista;

    public ColaMatricula() {
        lista=new PriorityQueue(50,new ComparadorMatricula());
    }
    //metodo agregar
    public void colar(Matricula nueva){
        lista.add(nueva);
    }
    //metodo eliminar
    public void descolar(){
        lista.poll();
    }
    //obtiene la fecha con mayor prioridad
    public Matricula obtener(){
        return lista.peek();
    }
    //Obtener por Cod
    public Matricula obtenerporCod(String cod){
        for(Matricula mat:lista){
            if(mat.getCod().equalsIgnoreCase(cod)) return mat;
        }
        return null;
    }
    
    public Matricula obtenerporDNI(String dni){
        for(Matricula mat:lista){
            if(mat.getAlumno().getNdoc().equalsIgnoreCase(dni)) return mat;
        }
        return null;
    }
    
     //Obtener pos por Cod
    public int obtenerCod(String cod){
        int i=0;
        for(Matricula mat:lista){
            if(mat.getCod().equalsIgnoreCase(cod)) return i;
            i++;
        }
        return -1;
    }
     //Obtener pos por Cod
    public Matricula obtenerporPos(int pos){
        int i=0;
        for(Matricula mat:lista){
            if(i==pos) return mat;
            i++;
        }
        return null;
    }
    public void actualizarPorPosicion(int pos, Matricula nuevaMatricula) {
        // Convertir la cola en una lista
        List<Matricula> temporal = new ArrayList<>(lista); //copia de la cola

        // Actualizar el elemento en la posición indicada
        temporal.set(pos, nuevaMatricula);

        // Reconstruir la cola con la lista actualizada
        lista.clear(); //limpia
        lista.addAll(temporal); //agrega la actualización 
}

    
    public PriorityQueue<Matricula> getLista() {
        return lista;
    }

    public void setLista(PriorityQueue<Matricula> lista) {
        this.lista = lista;
    }
    
    
}
