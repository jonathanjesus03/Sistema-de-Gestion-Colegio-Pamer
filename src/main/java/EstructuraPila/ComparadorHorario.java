/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraPila;

import Modelo.Horario;
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author cr075
 */
public class ComparadorHorario implements Serializable, Comparator<Horario>{

    @Override
    public int compare(Horario o1, Horario o2) {
        return o1.getHorainicio().compareTo(o2.getHorainicio()); //compara de forma ascedente la hora de inicio.
    }
    
}
