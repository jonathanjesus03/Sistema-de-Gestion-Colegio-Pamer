/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraCola;

import Modelo.Matricula;
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author cr075
 */
public class ComparadorMatricula implements Comparator<Matricula>,Serializable{

    @Override
    public int compare(Matricula o1, Matricula o2) {
        return o1.getFecha().compareTo(o2.getFecha()); //ordena de forma ascendente la fecha 
    }
    
}
