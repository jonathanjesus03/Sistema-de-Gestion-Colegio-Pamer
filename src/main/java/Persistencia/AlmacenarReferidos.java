/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraArboles.ArbolReferidos;
import Procesos.Mensajes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Samsung
 */
public class AlmacenarReferidos {
    
    public static String ARCHIVO="DatosRegistroReferidos.bin";
    public static void GuardarReferidos(ArbolReferidos lista){
        try{
            FileOutputStream fs=new FileOutputStream(ARCHIVO); //recibe datos del programa y envia al archivo 
            ObjectOutputStream ob=new ObjectOutputStream(fs);
            ob.writeObject(lista);
            ob.close();
        } catch(Exception ex){
            Mensajes.mostrarmsj("\"ERROR no se puede guardar..." +ex);
        }
    }
    public static ArbolReferidos recuperarReferidos(){
          ArbolReferidos arbol=new ArbolReferidos();
          try{
           //(input) que se utiliza para leer datos de un archivo.
           FileInputStream fi=new FileInputStream(ARCHIVO);//INPUT ENVIA DATOS DEL ARCHIVO AL PROGRAMA,
           ObjectInputStream oi=new ObjectInputStream(fi);
           arbol=(ArbolReferidos) oi.readObject(); //en lista se recupera los objetos
            //y lo deserealiza convirtiéndolo de una secuencia de bytes a un objeto ArregloEmpleados
           oi.close();
          }catch(Exception ex){
              Mensajes.mostrarmsj("\"ERROR no se puede recuperar..." +ex);
          }
           return arbol;
    } 
}
