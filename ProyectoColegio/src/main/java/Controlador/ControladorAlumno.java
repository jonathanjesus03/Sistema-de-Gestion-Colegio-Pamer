/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraArreglo.ArregloAlumnos;
import Modelo.Alumno;
import Persistencia.AlmacenarAlumnos;
import Procesos.Mensajes;
import Procesos.ProcesosAlumno;
import Vista.RgtAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorAlumno implements ActionListener {

    Alumno a;
    ArregloAlumnos lista;
    RgtAlumno vista;

    public ControladorAlumno(RgtAlumno f1) {
        vista = f1;
        lista = new ArregloAlumnos(50);
        lista = AlmacenarAlumnos.recuperarAlumnos();
        lista.actualizarContador();
        ProcesosAlumno.Presentacion(vista);
        vista.btnGuardar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.AgruparBotones();
        configurarRadioButtons();
    }

    private void configurarRadioButtons() {
        vista.rbtnMas.addActionListener(this);
        vista.rbtnFem.addActionListener(this);
        vista.rbtnDisSi.addActionListener(this);
        vista.rbtnDisNo.addActionListener(this);
        vista.rbtnOtroSi.addActionListener(this);
        vista.rbtnOtroNo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnGuardar == e.getSource()) {
            a = ProcesosAlumno.LeerDatosAlumno(vista);
            lista.agregarAlumno(a);
            AlmacenarAlumnos.GuardarAlumnos(lista);
            ProcesosAlumno.LimpiarDatosAlumno(vista);
            Mensajes.mostrarmsj("Alumno registrado exitósamente!!");
        }
        if (vista.btnCancelar == e.getSource()) {
            vista.dispose();//cierra el jinternalframe
        }
    }

}
