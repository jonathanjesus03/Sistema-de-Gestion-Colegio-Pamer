/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import javax.swing.JOptionPane;

/**
 *
 * @author cr075
 */
public class Mensajes {
    public static void mostrarmsj(String msj){
        JOptionPane.showMessageDialog(null, msj);
    }
    public static String introducirmsj(String msj){
        return JOptionPane.showInputDialog(msj);
    }
    
    public static int confirmarmsj(String msj,String titulo){ //opciones, si o no SI:0 Y NO:1
       return JOptionPane.showConfirmDialog(null, msj, titulo, JOptionPane.YES_NO_OPTION);
    }
}
