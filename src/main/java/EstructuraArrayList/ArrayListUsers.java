/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraArrayList;

import Modelo.Registro;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author cr075
 */
public class ArrayListUsers implements Serializable{ //lista central de los usuarios, incluye métodos para relacionar login,contraseña y registro
     private ArrayList<Registro> lista=new ArrayList();
     
     public void agregarUsuario(Registro usu){
         lista.add(usu);
     }  
     public boolean autoenticacion(String usu,String contra){
         for(Registro user: lista){
             if(user.getUsu().equalsIgnoreCase(usu) && user.getContra().equalsIgnoreCase(contra)){
                 return true;
             }
         }
         return false;
     }
     public boolean actualizarContraseña(String usu,String nueva){
         for(Registro user:lista){
             if(user.getUsu().equalsIgnoreCase(usu)){
                 user.setContra(nueva);
                 return true;
             }
         }
         return false;
     }
     
    public String mostrarRegistro() {
        StringBuilder registros = new StringBuilder();
        for (Registro user : lista) {
            registros.append("Registro: ").append(user.toString()).append("\n"); //agregamos la lista de los usuarios
        }
        return registros.toString().isEmpty() ? "No hay registros." : registros.toString();
    }
}
