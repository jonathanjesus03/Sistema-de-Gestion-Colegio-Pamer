/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraArrayList.ArrayListUsers;
import Modelo.Registro;
import Persistencia.AlmacenarUsuarios;
import Procesos.Mensajes;
import Procesos.ProcesosRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;

/**
 *
 * @author cr075
 */
public class ControlRegistro implements ActionListener {

    FrmRegistro frm;
    ArrayListUsers lista;

    public ControlRegistro(FrmRegistro frmrgt) {
        frm = frmrgt;
        lista = new ArrayListUsers();
        lista = AlmacenarUsuarios.recuperarUsuarios();
        frm.btnGuardar.addActionListener(this);
        frm.btnIrInicio.addActionListener(this);
        ProcesosRegistro.Presentacion(frm);
    }

    public void mostrarfrmlog() {
        FrmLogin log = new FrmLogin();
        ControlLogin con = new ControlLogin(log);
        frm.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frm.btnGuardar == e.getSource()) {
            Registro usu = ProcesosRegistro.leerRegistro(frm);
            lista.agregarUsuario(usu);
            AlmacenarUsuarios.GuardarUsuarios(lista);
            Mensajes.mostrarmsj("Usuario agregado exitósamente!!");
            ProcesosRegistro.limpiarEntradas(frm);
            //mensaje de que se registró exitosamente
        }
        if (frm.btnIrInicio == e.getSource()) {
            mostrarfrmlog();
        }
    }

}
