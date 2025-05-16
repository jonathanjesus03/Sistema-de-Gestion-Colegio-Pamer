/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenamiento;

import EstructuraPila.ComparadorHorario;
import EstructuraPila.PilaHorario;
import Modelo.Horario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cr075
 */
public class OrdenarPila {
    
    public static PilaHorario ordenarPorHora(ComparadorHorario comparador, PilaHorario lista) {
    List<Horario> listaOrdenada = new ArrayList<>(lista.getPila());
    listaOrdenada.sort(comparador); // Ordenar la lista

    PilaHorario pilaOrdenada = new PilaHorario();
    for (Horario horario : listaOrdenada) {
        pilaOrdenada.agregar(horario); // Convertir la lista ordenada de vuelta a una pila
    }
    return pilaOrdenada; // Devolver la pila ordenada
}

    
}
