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
public class NodoReferidos implements Serializable{
    private Referidos referido;
    private NodoReferidos der;
    private NodoReferidos izq;

    public NodoReferidos(Referidos referido) {
        this.referido = referido;
        der=izq = null;
    }

    public Referidos getReferido() {
        return referido;
    }

    public void setReferido(Referidos referido) {
        this.referido = referido;
    }

    public NodoReferidos getDer() {
        return der;
    }

    public void setDer(NodoReferidos der) {
        this.der = der;
    }

    public NodoReferidos getIzq() {
        return izq;
    }

    public void setIzq(NodoReferidos izq) {
        this.izq = izq;
    }
    
    
    
}
