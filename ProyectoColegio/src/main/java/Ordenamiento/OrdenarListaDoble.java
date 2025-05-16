/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenamiento;

import EstructuraListaDoble.ListaEnlazadaDobleSalon;
import EstructuraListaDoble.NodoDoble;
import Modelo.Salon;

/**
 *
 * @author cr075
 */
//Método de Inserción
public class OrdenarListaDoble {
     public static ListaEnlazadaDobleSalon OrdenarporNombre(ListaEnlazadaDobleSalon lista){
        for(NodoDoble i=lista.ini.sig;i!=null;i=i.sig){ //i=1
            Salon value=i.salon;
            NodoDoble j=i;
            while(j!=lista.ini && j.ant.salon.getNombre().compareToIgnoreCase(value.getNombre())>0){ //i=0
                j.salon=j.ant.salon; //j=lista.getIni().sig su valor de salon se actualiza con el nodo anterior
                j=j.ant; //disminuye, toma valor del anterior nodo
            }
            j.salon=value; //actualiza el nodo anterior: nodo ini con el valor del  nodo sig
        }
        return lista;
     }
}
