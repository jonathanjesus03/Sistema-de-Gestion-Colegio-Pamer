/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import EstructuraArrayList.ArrayListUsers;
import EstructuraArreglo.ArregloAlumnos;
import Procesos.Mensajes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author cr075
 */
public class AlmacenarAlumnos {
   
    public static String ARCHIVO="DatosRegistroAlumnos.bin";
    public static void GuardarAlumnos(ArregloAlumnos lista){
        try{
            FileOutputStream fs=new FileOutputStream(ARCHIVO); //recibe datos del programa y envia al archivo 
            ObjectOutputStream ob=new ObjectOutputStream(fs);
            ob.writeObject(lista);
            ob.close();
        } catch(Exception ex){
            Mensajes.mostrarmsj("\"ERROR no se puede guardar..." +ex);
        }
    }
    public static ArregloAlumnos recuperarAlumnos(){
          ArregloAlumnos Lista=new ArregloAlumnos(50);
          try{
           //(input) que se utiliza para leer datos de un archivo.
           FileInputStream fi=new FileInputStream(ARCHIVO);//INPUT ENVIA DATOS DEL ARCHIVO AL PROGRAMA,
           ObjectInputStream oi=new ObjectInputStream(fi);
           Lista=(ArregloAlumnos) oi.readObject(); //en lista se recupera los objetos
            //y lo deserealiza convirtiéndolo de una secuencia de bytes a un objeto ArregloEmpleados
           oi.close();
          }catch(Exception ex){
              Mensajes.mostrarmsj("\"ERROR no se puede recuperar..." +ex);
          }
           return Lista;
    } 
}
