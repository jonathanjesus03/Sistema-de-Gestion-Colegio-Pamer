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
public class ListaEnlazadaSimpleCurso implements Serializable{

    public NodoSimple ini;
    public NodoSimple fin;

    public ListaEnlazadaSimpleCurso() {
        ini = fin = null; //lista vacía
    }

    // Método agregar al final
    public void agregaralfinal(NodoSimple nuevo) {
        if (ini == null && fin == null) {
            ini = fin = nuevo;
        } else {
            fin.sig = nuevo;
            fin = nuevo;
        }
        fin.sig = null;
    }

    // Método que devuelve la posición del curso por su código
    public int buscarporCodoNom(String cod) {
        int pos = 0;
        for (NodoSimple i = ini; i != null; i = i.sig, pos++) {
            if (cod.equalsIgnoreCase(i.curso.getCod())||cod.equalsIgnoreCase(i.curso.getNombre())) {
                return pos;
            }
        }
        return -1; // No encontrado
    }
       // Método que devuelve la posición del curso por su código
    public boolean buscarporCod(String cod) {
        int pos = 0;
        for (NodoSimple i = ini; i != null; i = i.sig, pos++) {
            if (cod.equalsIgnoreCase(i.curso.getCod())) {
                return true;
            }
        }
        return false; // No encontrado
    }
       // Método que devuelve la posición del curso por su código
    public Curso buscarporCodyRetornar(String cod) {
        int pos = 0;
        for (NodoSimple i = ini; i != null; i = i.sig, pos++) {
            if (cod.equalsIgnoreCase(i.curso.getCod())) {
                return i.curso;
            }
        }
        return null; // No encontrado
    }
    

    // Método que devuelve el curso por posición
    public Curso retornarCurso(int posi) {
        int pos = 0;
        for (NodoSimple i = ini; i != null; i = i.sig, pos++) {
            if (pos == posi) {
                return i.curso;
            }
        }
        return null; // Posición inválida
    }

    // Método actualizar por posición
    public void actualizar(int posicion, Curso curso) {
        if (posicion < 0) {
            return; // Posición no válida
        }

        int pos = 0;
        NodoSimple actual = ini;

        while (actual != null && pos < posicion) {
            actual = actual.sig;
            pos++;
        }

        if (actual != null) {
            actual.curso = curso; // Actualizar el curso
        }
    }

    public void eliminarPorPosicion(int posicion) {
        if (posicion < 0) {
            System.out.println("Posición inválida.");
            return;
        }

        // Caso 1: Lista vacía
        if (ini == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        // Caso 2: Eliminar el primer nodo
        if (posicion == 0) {
            ini = ini.sig; // Avanzar el inicio al siguiente nodo
            if (ini == null) { // Si la lista queda vacía
                fin = null;
            }
            return;
        }

        // Caso 3: Eliminar un nodo intermedio o final
        NodoSimple anterior = ini; // Nodo previo al que queremos eliminar
        NodoSimple actual = ini.sig; // Nodo en la posición 1
        int pos = 1;

        // Recorrer hasta la posición deseada o final de la lista
        while (actual != null && pos < posicion) {
            anterior = actual;
            actual = actual.sig;
            pos++;
        }

        // Verificar si se llegó a la posición válida
        if (actual == null) {
            System.out.println("Posición fuera de rango.");
            return;
        }

        // Reconectar nodos
        anterior.sig = actual.sig;

        // Si se eliminó el último nodo, actualizar el puntero `fin`
        if (actual == fin) {
            fin = anterior;
        }
    }

}
