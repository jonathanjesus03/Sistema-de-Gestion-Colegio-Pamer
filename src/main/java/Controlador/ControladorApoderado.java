/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraArrayList.ArrayListApoderado;
import EstructuraArreglo.ArregloAlumnos;
import Modelo.Apoderado;
import Persistencia.AlmacenarAlumnos;
import Persistencia.AlmacenarApoderado;
import Procesos.Mensajes;
import Procesos.ProcesosApoderado;
import Vista.RgtApoderado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorApoderado implements ActionListener{

    Apoderado a;
    ArrayListApoderado lista;
    ArregloAlumnos listaa=AlmacenarAlumnos.recuperarAlumnos();;
    RgtApoderado vista;
    public ControladorApoderado(RgtApoderado ap) {
        vista=ap;
        lista=new ArrayListApoderado();
        listaa.actualizarContador();
        ProcesosApoderado.Presentacion(vista);
        lista=AlmacenarApoderado.recuperarApoderado();
        vista.btnCancelar.addActionListener(this);
        vista.btnAgregar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.btnAgregar==e.getSource()){
            if(!vista.txtNdocA.getText().isEmpty()){
              a=ProcesosApoderado.LeerDatosAlumno(vista);
            if(a.getNdocalum()!=null && !listaa.buscarporDni(a.getNdocalum())) {
                Mensajes.mostrarmsj("No hay ningún alumno registrado con el número de documento " +a.getNdocalum());
                ProcesosApoderado.LimpiarDatosAlumno(vista);
            } else {
                lista.agregarApoderado(a);
                AlmacenarApoderado.GuardarApoderado(lista);
                Mensajes.mostrarmsj("Apoderado registrado exitósamente!!");
                ProcesosApoderado.LimpiarDatosAlumno(vista);
            }
        } else {
                Mensajes.mostrarmsj("Ingrese el numero de documento del alumno.");
            }
        }
        if(vista.btnCancelar==e.getSource()){
            vista.dispose();
        }
    }
    
}
