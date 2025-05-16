/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraArrayList.ArrayListUsers;
import Modelo.Contrasena;
import Persistencia.AlmacenarUsuarios;
import Procesos.Mensajes;
import Procesos.ProcesosContrasena;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControlContrasena implements ActionListener {

    FrmContrasena frm;
    ArrayListUsers lista;
    boolean rpta;

    public ControlContrasena(FrmContrasena frmcontr) {
        frm = frmcontr;
        lista = new ArrayListUsers();
        lista = AlmacenarUsuarios.recuperarUsuarios();
        frm.btnCambiarcontr.addActionListener(this);
        frm.btnIralInicio.addActionListener(this);
        ProcesosContrasena.Presentacion(frm);
    }

    public void mostrarLog() {
        FrmLogin log = new FrmLogin();
        ControlLogin con = new ControlLogin(log);
        frm.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frm.btnCambiarcontr == e.getSource()) {
            Contrasena contr = ProcesosContrasena.leerContrasena(frm);
            if (!contr.getNuevacontra().equals(contr.getRepetircontra())) {
                Mensajes.mostrarmsj("Las contraseñas ingresadas no coinciden.");
                ProcesosContrasena.limpiarEntradas(frm);
            } else {
                rpta = lista.actualizarContraseña(contr.getUsu(), contr.getNuevacontra());
                if (rpta == false) {
                    Mensajes.mostrarmsj("No se pudo actualizar la contraseña, inténtelo nuevamente.");
                } else {
                    Mensajes.mostrarmsj("Contraseña actualizado exitósamente");
                    AlmacenarUsuarios.GuardarUsuarios(lista);
                    ProcesosContrasena.limpiarEntradas(frm);
                }
            }
        }
        if (frm.btnIralInicio == e.getSource()) {
            mostrarLog();
        }
    }

}
