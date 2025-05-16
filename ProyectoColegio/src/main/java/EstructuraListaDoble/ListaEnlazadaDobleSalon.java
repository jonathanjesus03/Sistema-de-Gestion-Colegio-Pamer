/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraListaDoble;

import Modelo.Salon;
import java.io.Serializable;

/**
 *
 * @author cr075
 */
public class ListaEnlazadaDobleSalon implements Serializable {

    public NodoDoble ini;
    public NodoDoble fin;

    public ListaEnlazadaDobleSalon() {
        ini = fin = null;
    }

    //metodo agregar al final
    public void agregaralfinal(NodoDoble nuevo) {
        if (ini == null && fin == null) {
            ini = fin = nuevo;
        } else {
            nuevo.ant = fin;
            fin.sig = nuevo;
        }
        fin = nuevo;
        fin.sig = null;
    }

    //metodo que devuelve la posicion del salon por su codigo
    public int buscarporCod(String cod) {
        int pos = 0;
        for (NodoDoble i = ini; i != null; i = i.sig, pos++) {
            if (cod.equalsIgnoreCase(i.salon.getCod())) {
                return pos;
            }
        }
        return -1;
    }
    //metodo que devuelve la posicion del salon por su codigo

    public boolean buscarporcod(String cod) {
        int pos = 0;
        for (NodoDoble i = ini; i != null; i = i.sig, pos++) {
            if (cod.equalsIgnoreCase(i.salon.getCod())) {
                return true;
            }
        }
        return false;
    }
     //metodo que devuelve la posicion del salon por su codigo

    public Salon buscarporCodyRetornar(String cod) {
        for (NodoDoble i = ini; i != null; i = i.sig) {
            if (cod.equalsIgnoreCase(i.salon.getCod())) {
                return i.salon;
            }
        }
        return null;
    }

    //metodo que devuelve salon por pos
    public Salon retornarSalon(int posi) {
        int pos = 0;
        for (NodoDoble i = ini; i != null; i = i.sig, pos++) {
            if (posi == pos) {
                return i.salon;
            }
        }
        return null;
    }

    // Método actualizar por posición
    public void actualizar(int posicion, Salon salon) {
        if (posicion < 0) {
            return; // Posición no válida
        }

        int pos = 0;
        NodoDoble actual = ini;

        while (actual != null && pos < posicion) {
            actual = actual.sig;
            pos++;
        }
        if (actual != null) {
            actual.salon = salon;//se actualiza
        }
    }

    public void eliminarPorPosicion(int posicion) {
        if (posicion < 0) {
            System.out.println("Posición inválida.");
            return;
        }
        NodoDoble actual = ini;
        int pos = 0;
        while (actual != null && pos < posicion) {
            actual = actual.sig;
            pos++;
        }

        if (actual == null) {
            System.out.println("Posición fuera de rango.");
            return;
        }
        // Caso 1: El nodo es el primero en la lista
        if (ini == actual) {
            ini = actual.sig;
            if (actual.sig != null) {
                actual.sig.ant = null; // El nuevo primer nodo no tiene anterior
            } else {
                fin = null; // Si la lista queda vacía, fin también se hace null
            }
        } //2do caso:  no es el primero ni el último
        else if (actual.sig != null) { //el nodo siguiente de actual tiene valor, hay que eliminar sus referencia
            actual.ant.sig = actual.sig;
            actual.sig.ant = actual.ant;
        } //3r caso: es el ultimo en la lista
        else {
            actual.ant.sig = null;
            fin = actual.ant;
        }
    }

}
