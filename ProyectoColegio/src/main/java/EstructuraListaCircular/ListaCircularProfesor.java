/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraListaCircular;

import Modelo.Profesor;
import java.io.Serializable;

/**
 *
 * @author cr075
 */
public class ListaCircularProfesor implements Serializable{
    public Nodo lc;

    public ListaCircularProfesor() {
        lc=null;
    }
    
    
    public int contarElementos() {
        if (lc == null) {
            return 0;
        }

        Nodo actual = lc;
        int contador = 1; 

        while (actual.enlace != lc) { 
            contador++;
            actual = actual.enlace;
        }
        return contador;
    }
    
    public void InsertarAlFinal(Nodo nuevo){
        //si la lista contiene elementos
        if(lc!=null){
            nuevo.enlace=lc.enlace;//queremos que lc=el ultimo elemento de la lista, su enlace que apunta al primer nodo sea igual al enlace del nodo nuevo.
            lc.enlace=nuevo; //enlace de lc apunta a nuevo ya que ya no es el último elemento de la lista, sino el penultimo
        }
        lc=nuevo; //actualizamos lc, ya que lc es el ultimo elemento entonces lo igualamos a nuevo. 
    }
    
    public void eliminar(String cod){
        Nodo actual;
        actual=lc; //inicia desde el ultimo nodo de la lista circular.
        boolean encontrado=false;
       
        //itera toda la lista antes de llegar al nodo con el cod encontrado y antes de llegar al ultimo elemento
        while(actual.enlace!=lc && !encontrado){ //termina el ciclo, si encontrado es true y si el nodo actual está enlazado a si mismo
            encontrado= (actual.enlace.profesor.getNdoc().equalsIgnoreCase(cod)); //true: si encuentra el cod, false: si no encuentra
            if(!encontrado) actual=actual.enlace;//si encontrado sigue siendo false, pasa al siguiente
        }
        //verificar
        encontrado=(actual.enlace.profesor.getNdoc().equalsIgnoreCase(cod));
        if(encontrado){
            Nodo p; //nodo a eliminar 
            p=actual.enlace;// 'p' apunta al nodo que se va a eliminar, que es el siguiente de 'actual'.
            //caso 1: la lista vacía
            if(lc.enlace==lc){ //enlazada a si misma
                lc=null;
            } else{ //caso 2: no está vacía
                //si en caso actual.enlace=lc,  Si el nodo a eliminar es el último nodo (lc)
                if(p==lc){
                    lc=actual; //actual se convierte en el ultimo nodo
                }
                actual.enlace=p.enlace; //actual.enlace ya no apunta a p sino a p.enlace 
            }
        }
    }
    
    public void actualizar(Nodo actual, Profesor p){
        actual.profesor=p;
    }
    public int buscarDNIoNom(String dato){
        Nodo actual=lc; //empieza siendo el ultimo en la lista
        int pos = 0;
        if(lc!=null){
            do{
              if(dato.equalsIgnoreCase(actual.profesor.getNdoc())||dato.equalsIgnoreCase(actual.profesor.getNombres())){
                  return pos;
              } else{
                  actual=actual.enlace;
                  pos++;
              }  
            }while(actual!=lc); //mientras no vuelva a ser primero en la lista
        }
        return -1;
    }
     public boolean buscarDni(String dato){
        Nodo actual=lc; //empieza siendo el ultimo en la lista
        int pos = 0;
        if(lc!=null){
            do{
              if(dato.equalsIgnoreCase(actual.profesor.getNdoc())){
                  return true;
              } else{
                  actual=actual.enlace;
                  pos++;
              }  
            }while(actual!=lc); //mientras no vuelva a ser primero en la lista
        }
        return false;
    }
      public Profesor buscarDniyRetornar(String dato){
        Nodo actual=lc; //empieza siendo el ultimo en la lista
        int pos = 0;
        if(lc!=null){
            do{
              if(dato.equalsIgnoreCase(actual.profesor.getNdoc())){
                  return actual.profesor;
              } else{
                  actual=actual.enlace;
                  pos++;
              }  
            }while(actual!=lc); //mientras no vuelva a ser primero en la lista
        }
        return null;
    }
    public Profesor obtenerPorIndice(int index) {
        if (lc == null) {
            throw new IndexOutOfBoundsException("La lista está vacía.");
        }
        int tamaño = contarElementos();
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
        Nodo actual = lc;
        for (int i = 0; i < index; i++) {
            actual = actual.enlace;
        }
        return actual.profesor;
    }
    
     public Nodo buscarNom(String nom){
        Nodo actual=lc.enlace; //empieza siendo el primero en la lista
        if(lc!=null){
            do{
              if(nom.equalsIgnoreCase(actual.profesor.getNombreCompleto())){
                  return actual;
              } else{
                  actual=actual.enlace;
              }  
            }while(actual!=lc.enlace); //mientras no vuelva a ser primero en la lista
        }
        return null;
    }
    
}
