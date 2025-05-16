

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraArrayList;

import Modelo.Apoderado;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author cr075
 */
public class ArrayListApoderado implements Serializable{
    private ArrayList<Apoderado> lista;

    public ArrayListApoderado() {
        lista=new ArrayList();
    }
    
    public void agregarApoderado(Apoderado nuevo){
        lista.add(nuevo);
    }
   
    public void eliminarApoderado(int pos){
        lista.remove(pos);
    }
    
    public Apoderado recuperar(int pos){
        return lista.get(pos);
    }
    
    public void actualizarApoderado(int pos,Apoderado actual){
        lista.set(pos, actual);
    }
    
    public int longitudLista(){
        return lista.size();
    }
    
    public int buscarporDnioNom(String dni){
        for(int i=0;i<lista.size();i++){
         if(lista.get(i).getNdoc().equalsIgnoreCase(dni) || lista.get(i).getNombres().equalsIgnoreCase(dni)){
             return i;
         }
    }
        return -1;
    }

    public ArrayList<Apoderado> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Apoderado> lista) {
        this.lista = lista;
    }
    
    
}
