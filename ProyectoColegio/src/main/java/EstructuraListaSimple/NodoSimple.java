/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraListaSimple;

import Modelo.Curso;
import java.io.Serializable;

/**
 *
 * @author cr075
 */
public class NodoSimple implements Serializable{
    public NodoSimple sig;
    public Curso curso;

    public NodoSimple(Curso c) {
        curso=c;
        sig=null; //se refiere a que el sig nodo es nulo
    }
}
