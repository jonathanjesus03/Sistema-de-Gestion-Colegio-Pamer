/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraArboles;

import Modelo.Referidos;
import java.io.Serializable;

/**
 *
 * @author Samsung
 */
public class ArbolReferidos implements Serializable{
    private NodoReferidos raiz;

    public ArbolReferidos() {
        this.raiz = null;
    }

    public NodoReferidos getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoReferidos raiz) {
        this.raiz = raiz;
    }
    
    
    //método que agrega un nodo al arbol
    public NodoReferidos Agregar(NodoReferidos nodo,Referidos elem){
        if(nodo==null){
            NodoReferidos nuevo = new NodoReferidos(elem);
            return nuevo;
        }else{
            if(elem.getNdoc().compareTo(
                    nodo.getReferido().getNdoc())>0){
                nodo.setDer(Agregar(nodo.getDer(),elem));
            }else{
               nodo.setIzq(Agregar(nodo.getIzq(),elem));  
            }
        }
        return nodo;
    }//fin agregar
    
    public NodoReferidos BuscarporDNI(String dato){
        NodoReferidos aux=raiz;
        while(aux!=null){
            if(aux.getReferido().getNdoc().startsWith(dato)){
                return aux;
            }else{
                if(dato.compareToIgnoreCase(aux.getReferido().getNdoc())>0){
                    aux = aux.getDer();
                }else{
                    aux = aux.getIzq();
                }
            }                
        }//fin while
        return null;
    }//fin buscar
    
     public NodoReferidos Eliminar(NodoReferidos nodoEliminar, String dato){
        if(nodoEliminar == null){
            return null;
        }
        return nodoEliminar;
    }
}
