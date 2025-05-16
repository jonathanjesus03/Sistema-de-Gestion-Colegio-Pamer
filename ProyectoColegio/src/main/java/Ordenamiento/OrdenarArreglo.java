/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenamiento;

import EstructuraArreglo.ArregloAlumnos;
import Modelo.Alumno;

/**
 *
 * @author cr075
 */
//Método de Burbuja
public class OrdenarArreglo {
    public static ArregloAlumnos OrdenarNombreASC(ArregloAlumnos Lista){ //le paso como parametro la lista de tipo arreglo ya esa lista no está ordenada   
        ArregloAlumnos ae= new ArregloAlumnos(50); //instaciamos la clase
        Alumno arreglo[]=Lista.getLista().clone(); //copiamos la lista y lo ponemos en un arreglo tipo alumno
        ae.setLista(arreglo);
        ae.actualizarContador();
        Alumno auxiliar; 
        for(int i=1; i<ArregloAlumnos.contador;i++){
            for(int j=0;j<ArregloAlumnos.contador-i;j++){
                if(arreglo[j].getNombres().compareTo(arreglo[j+1].getNombres())>0){//itera la lista de copia
                    auxiliar=arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=auxiliar;
                }
            }
        }
        ae.setLista(arreglo);
        return ae;
    }
}
