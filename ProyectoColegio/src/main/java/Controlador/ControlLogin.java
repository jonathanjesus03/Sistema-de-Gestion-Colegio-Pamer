/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraArrayList.ArrayListUsers;
import Modelo.Login;
import Persistencia.AlmacenarUsuarios;
import Procesos.Mensajes;
import Procesos.ProcesosLogin;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author cr075
 */
public class ControlLogin implements ActionListener {

    FrmLogin vista;
    ArrayListUsers lista;
    boolean rpta;

    public ControlLogin(FrmLogin flog) {
        vista = flog;
        lista = new ArrayListUsers();
        lista = AlmacenarUsuarios.recuperarUsuarios();
        vista.btnIngresar.addActionListener(this);
        vista.btnCerrar.addActionListener(this);
        vista.btnOlvidarContr.addActionListener(this);
        vista.btnRegistrarse.addActionListener(this);
        ProcesosLogin.Presentacion(vista);
    }

    public void mostrarMenu() {
        String usu = vista.txtUsu.getText();
        FrmMenu fm = new FrmMenu();
        ControlMenu cm = new ControlMenu(fm);
        fm.setVisible(true);
        fm.setTitle("Bienvenido al menú de Gestión de Matrículas Nivel Primario, " + "Usuario: " + usu.toUpperCase());
        fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vista.setVisible(false);
    }

    public void mostrarfrmContrasena() {
        FrmContrasena contrasena = new FrmContrasena();
        ControlContrasena control = new ControlContrasena(contrasena);
        contrasena.setVisible(true);
        vista.setVisible(false);
    }

    public void mostrarfrmRegistro() {
        FrmRegistro registro = new FrmRegistro();
        ControlRegistro control = new ControlRegistro(registro);
        registro.setVisible(true);
        vista.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnIngresar == e.getSource()) {
            Login log = ProcesosLogin.leerLogin(vista);
            rpta = lista.autoenticacion(log.getUsu(), log.getContra());
            if (rpta == false) {
                Mensajes.mostrarmsj("No está registrado o introdujo el usuario o contraseña incorrecta");
                ProcesosLogin.limpiarEntradas(vista);
            } else {
                mostrarMenu();
            }
        }
        if (vista.btnCerrar == e.getSource()) {
            System.exit(0); //cierra completamente el programa 
        }
        if (vista.btnOlvidarContr == e.getSource()) {
            mostrarfrmContrasena();
        }
        if (vista.btnRegistrarse == e.getSource()) {
            mostrarfrmRegistro();
        }

    }
}
