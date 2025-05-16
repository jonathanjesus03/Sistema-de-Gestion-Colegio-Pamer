/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;

import EstructuraArrayList.ArrayListUsers;
import Persistencia.AlmacenarUsuarios;

/**
 *
 * @author cr075
 */
public class ProgramaLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayListUsers lista=AlmacenarUsuarios.recuperarUsuarios();
        System.out.println(lista.mostrarRegistro());
    }
    
}
