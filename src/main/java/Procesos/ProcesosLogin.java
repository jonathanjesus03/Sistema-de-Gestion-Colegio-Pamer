/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Modelo.Login;
import Modelo.Registro;
import Vista.FrmLogin;
import Vista.FrmRegistro;

/**
 *
 * @author cr075
 */
public class ProcesosLogin {
    public static void Presentacion(FrmLogin frm){
        frm.setTitle("Bienvenido al Login del Sistema de Matrículas");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }
    public static Login leerLogin(FrmLogin frm){
        Login log=new Login();
        log.setUsu(frm.txtUsu.getText());
        log.setContra(frm.txtContra.getText());
        return log;
    }
    public static void limpiarEntradas(FrmLogin frm){
        frm.txtUsu.setText("");
        frm.txtContra.setText("");
        frm.txtUsu.requestFocus();
    }
}
