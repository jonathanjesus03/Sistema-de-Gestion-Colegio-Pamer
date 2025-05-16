/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraPila;


import Modelo.Horario;
import java.io.Serializable;
import java.util.Stack;

/**
 *
 * @author cr075
 */
public class PilaHorario implements Serializable{
   private Stack<Horario> pila;

    public PilaHorario() {
        pila=new Stack<>();
    }
    //método que agrega datos a la pila
    public void agregar(Horario nueva){
       pila.push(nueva);
    }
    //método que elimina una matricula de la pila
    public void eliminar(){
       /*if(pila.isEmpty()){
            Mensajes.Mostrar("La pila está vacía");
        } else{*/
        pila.pop();
    }
    //metodo cantidad de la pila
    public int LongitudPila(){
        return pila.size();
    }
    //método obtener horario por cod
    public int obtenerporCod(String cod){
        for(int i=0;i<pila.size();i++){
            if(pila.get(i).getCod().equalsIgnoreCase(cod)){
                return i;
            }
        }
        return -1;
    }
    //método obtener horario por cod
    public Horario retornarHorario(int pos){
        for(int i=0;i<pila.size();i++){
            if(i==pos){
                return pila.get(i);
            }
        }
        return null;
    }
      // Método para actualizar un elemento por posición
    public void actualizar(int pos, Horario nuevoHorario) {
        if (pos >= 0 && pos < pila.size()) {
            pila.set(pos, nuevoHorario);
        }
    }

     //metodo cantidad de la pila
    public int Cantidad(){
        return pila.size();
    }
    //metodo retornar objeto
    public Horario obtener(int pos){
        return pila.get(pos);
    }
    //ultimo objeto en la pila
    public Horario ultimoObjeto(){
        return pila.peek();
    }
    //primer elemento ingresado a la pila
    public Horario primeroObjeto(){
        return pila.firstElement();
    }
    //metodo que verifica si la pila esta vacia
    public boolean siEmpty(){
        return pila.empty();
    }
    //get y set de la pila

    public Stack<Horario> getPila() {
        return pila;
    }

    public void setPila(Stack<Horario> pila) {
        this.pila = pila;
    }
}
