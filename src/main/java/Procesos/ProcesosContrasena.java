/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Modelo.Contrasena;
import Modelo.Login;
import Modelo.Registro;
import Vista.FrmContrasena;
import Vista.FrmLogin;
import Vista.FrmRegistro;

/**
 *
 * @author cr075
 */
public class ProcesosContrasena {
    public static void Presentacion(FrmContrasena frm){
        frm.setTitle("Cambiar contraseña del Sistema de Matrículas");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }
    public static Contrasena leerContrasena(FrmContrasena frm){
        Contrasena cont=new Contrasena();
        cont.setUsu(frm.txtUsu.getText());
        cont.setNuevacontra(frm.txtNuevaContr.getText());
        cont.setRepetircontra(frm.txtRepCont.getText());
        return cont;
    }
    public static void limpiarEntradas(FrmContrasena frm){
        frm.txtUsu.setText("");
        frm.txtNuevaContr.setText("");
        frm.txtRepCont.setText("");
        frm.txtUsu.requestFocus();
    }
}
