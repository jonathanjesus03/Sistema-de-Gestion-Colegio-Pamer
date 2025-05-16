/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenamiento;

import EstructuraListaSimple.ListaEnlazadaSimpleCurso;
import EstructuraListaSimple.NodoSimple;
import Modelo.Curso;

/**
 *
 * @author cr075
 */
//Metodo de Selección
public class OrdenarListaSimple {
    public static ListaEnlazadaSimpleCurso ordenarPorNombreASC(ListaEnlazadaSimpleCurso lista) {
        NodoSimple k;
        for (NodoSimple i = lista.ini; i != null; i = i.sig) {
            k = i;
            for (NodoSimple j = i.sig; j != null; j = j.sig) {
                // Comparar los nombres alfabéticamente usando compareTo
                if (j.curso.getNombre().compareToIgnoreCase(i.curso.getNombre()) < 0) { 
                    k = j;
                }
            }

            // Intercambiar los cursos
            Curso aux = i.curso; // Guardamos en aux el curso actual
            i.curso = k.curso;  // Actualizamos el curso actual con el más pequeño
            k.curso = aux;      // Intercambiamos los cursos
        }
        return lista;
    }
}
