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
public class NodoDoble implements Serializable{
    public NodoDoble sig;
    public NodoDoble ant;
    public Salon salon;
      public NodoDoble(Salon sa) {
          salon=sa;
          sig=ant=null;
    }
}
