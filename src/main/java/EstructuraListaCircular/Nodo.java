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
public class Nodo implements Serializable{
    public Profesor profesor;
    public Nodo enlace;

    public Nodo(Profesor p) {
        profesor=p;
        enlace=this;
    } 
}
