/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Modelo.Registro;
import Vista.FrmRegistro;

/**
 *
 * @author cr075
 */
public class ProcesosRegistro {
    public static void Presentacion(FrmRegistro frm){
        frm.setTitle("Bienvenido al Registro de Usuarios del Sistema de Matrículas");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }
    public static Registro leerRegistro(FrmRegistro frm){
        Registro reg=new Registro();
        reg.setUsu(frm.txtUsu.getText());
        reg.setNom(frm.txtNom.getText());
        reg.setContra(frm.txtContra.getText());
        return reg;
    }
    public static void limpiarEntradas(FrmRegistro frm){
        frm.txtUsu.setText("");
        frm.txtNom.setText("");
        frm.txtContra.setText("");
        frm.txtUsu.requestFocus();
    }
}
