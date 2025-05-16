/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralAlumno;
import EstructuraArreglo.ArregloAlumnos;
import Modelo.Alumno;
import Persistencia.AlmacenarAlumnos;
import Procesos.Mensajes;
import Procesos.ProcesosAlumno;
import Vista.EdtAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorEdtAlumno implements ActionListener {

    EdtAlumno vista;
    ArregloAlumnos lista;
    Alumno a;

    public ControladorEdtAlumno(EdtAlumno rpt) {
        vista = rpt;
        lista = new ArregloAlumnos(50);
        lista = AlmacenarAlumnos.recuperarAlumnos();
        ProcesosAlumno.Presentacion(vista);
        lista.actualizarContador();
        vista.btnActualizar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.AgruparBotones();
        configurarRadioButtons();
        vista.txtNumDoc.setEditable(false);
        if (CentralAlumno.alumnoActualizar != null) {
            IntroducirDatosAlumno(CentralAlumno.alumnoActualizar);
        }
    }

    private void configurarRadioButtons() {
        vista.rbtnMas.addActionListener(this);
        vista.rbtnFem.addActionListener(this);
        vista.rbtnDisSi.addActionListener(this);
        vista.rbtnDisNo.addActionListener(this);
        vista.rbtnOtroSi.addActionListener(this);
        vista.rbtnOtroNo.addActionListener(this);
    }

    private void IntroducirDatosAlumno(Alumno a) {
        vista.txtNumDoc.setText(a.getNdoc());
        vista.txtNom.setText(a.getNombres());
        vista.txtFecha.setText(a.getFecha());
        vista.txtCorreo.setText(a.getCont());
        vista.txtApellidos.setText(a.getApellidos());
        switch (a.getTipodoc()) {
            case "Dni":
                vista.cbxTipoDoc.setSelectedIndex(1);
                break;
            case "Pasaporte":
                vista.cbxTipoDoc.setSelectedIndex(2);
                break;
            default:
                vista.cbxTipoDoc.setSelectedIndex(0);
                break;
        }
        switch (a.getPais()) {
            case "Peru":
                vista.cbxPais.setSelectedIndex(1);
                break;
            case "Otro":
                vista.cbxPais.setSelectedIndex(2);
                break;
            default:
                vista.cbxPais.setSelectedIndex(0);
                break;
        }
        switch (a.getDep()) {
            case "Callao (Provincia Constitucional)":
                vista.cbxDpto.setSelectedIndex(1);
                break;
            case "Lima":
                vista.cbxDpto.setSelectedIndex(2);
                break;
            case "Otro":
                vista.cbxDpto.setSelectedIndex(3);
                break;
            default:
                vista.cbxDpto.setSelectedIndex(0);
                break;
        }
        switch (a.getDistri()) {
            case "Comas":
                vista.cbxDist.setSelectedIndex(1);
                break;
            case "Puente Piedra":
                vista.cbxDist.setSelectedIndex(2);
                break;
            case "Rímac":
                vista.cbxDist.setSelectedIndex(3);
                break;
            case "San Martín de Porres":
                vista.cbxDist.setSelectedIndex(4);
                break;
            case "Lima (Centro)":
                vista.cbxDist.setSelectedIndex(5);
                break;
            case "Otro":
                vista.cbxDist.setSelectedIndex(6);
                break;
            default:
                vista.cbxDist.setSelectedIndex(0);
                break;
        }
        switch (a.getLengua()) {
            case "Español":
                vista.cbxLengua.setSelectedIndex(1);
                break;
            case "Quechua":
                vista.cbxLengua.setSelectedIndex(2);
                break;
            case "Aymara":
                vista.cbxLengua.setSelectedIndex(3);
                break;
            case "Otro":
                vista.cbxLengua.setSelectedIndex(4);
                break;
            default:
                vista.cbxLengua.setSelectedIndex(0);
                break;
        }
        if (a.getSexo().equals(vista.rbtnMas.getText())) { //si es igual a rbtnMas
            vista.rbtnMas.setSelected(true); //se selecciona
        } else if (a.getSexo().equals(vista.rbtnFem.getText())) {
            vista.rbtnFem.setSelected(true);
        }
        if (a.getDisca().equals(vista.rbtnDisSi.getText())) {
            vista.rbtnDisSi.setSelected(true);
        } else if (a.getDisca().equals(vista.rbtnDisNo.getText())) {
            vista.rbtnDisNo.setSelected(true);
        }
        if (a.getOtrascond().equals(vista.rbtnOtroSi.getText())) {
            vista.rbtnOtroSi.setSelected(true);
        } else if (a.getOtrascond().equals(vista.rbtnOtroNo.getText())) {
            vista.rbtnOtroNo.setSelected(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnActualizar == e.getSource()) {
            a = ProcesosAlumno.LeerDatosAlumno(vista);
            lista.actualizarAlumno(a, ControladorReporteAlumno.posicionActualizar);
            AlmacenarAlumnos.GuardarAlumnos(lista);
            ProcesosAlumno.LimpiarDatosAlumno(vista);
            //despues de actualizar, la variable estatica se vuelve null para que en reportes no sea referida con el mismo alumno
            CentralAlumno.alumnoActualizar = null;
            Mensajes.mostrarmsj("Alumno actualizado exitósamente!!");
        }
        if (vista.btnCancelar == e.getSource()) {
            //si no se actualiza igual,se elimina la referencia con el mismo alumno
            CentralAlumno.alumnoActualizar = null;
            vista.dispose();//cierra el jinternalframe
        }
    }

}
