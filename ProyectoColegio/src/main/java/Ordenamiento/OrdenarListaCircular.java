/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenamiento;

import EstructuraListaCircular.ListaCircularProfesor;
import EstructuraListaCircular.Nodo;
import Modelo.Profesor;

/**
 *
 * @author cr075
 */
//Método de Selección
public class OrdenarListaCircular {
    public static ListaCircularProfesor ordenarPorNombreASC(ListaCircularProfesor lista) {
        if (lista.lc == null || lista.lc.enlace == lista.lc) {
            // Si la lista está vacía o tiene solo un elemento, no hay nada que ordenar
            return lista;
        }
        Nodo k;
        Nodo inicio = lista.lc.enlace; // El primer nodo en la lista circular (el siguiente de lc)

        // Bucle exterior para cada nodo en la lista
        for (Nodo i = inicio; i != lista.lc; i = i.enlace) {
            k = i;
            // Bucle interior para encontrar el nodo con el menor grado en el sublista
            for (Nodo j = i.enlace; j != inicio; j = j.enlace) {
                if (j.profesor.getNombres().compareTo(k.profesor.getNombres()) < 0) {
                    k = j; // Encontramos un nodo con un grado menor
                }
            }

            // Intercambiar los datos entre `i` y `k`
            Profesor aux = i.profesor;
            i.profesor = k.profesor;
            k.profesor = aux;
        }
        return lista;
    }
}
