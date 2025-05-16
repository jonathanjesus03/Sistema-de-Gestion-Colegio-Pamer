/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenamiento;

import EstructuraArrayList.ArrayListApoderado;
import Modelo.Apoderado;
import java.util.ArrayList;

/**
 *
 * @author cr075
 */
//Método de Burbuja
public class OrdenarArrayList {
   public static ArrayListApoderado ordenarPorNomAsc(ArrayListApoderado lista) {
    ArrayListApoderado ae = new ArrayListApoderado(); // Clonamos la lista
    ae.setLista(new ArrayList<>(lista.getLista())); // Clonamos la lista interna de apoderados
    Apoderado auxiliar;
  
    for (int i = 1; i < ae.longitudLista(); i++) {
        for (int j = 0; j < ae.longitudLista() - i; j++) {
            if (ae.getLista().get(j).getNombres().compareTo(ae.getLista().get(j+1).getNombres())>0) {
                auxiliar = ae.getLista().get(j);
                ae.getLista().set(j, ae.getLista().get(j + 1));
                ae.getLista().set(j + 1, auxiliar);
            }
        }
    }
    
    return ae;
}
 
}
