/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraArreglo.ArregloAlumnos;
import EstructuraCola.ColaMatricula;
import Persistencia.AlmacenarAlumnos;
import Persistencia.AlmacenarMatricula;
import Procesos.Mensajes;
import Vista.ListaAlumnoMatriculado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorListaAlumnoMatriculado implements ActionListener{
    
    ListaAlumnoMatriculado vista;
    ColaMatricula lista=AlmacenarMatricula.recuperarMatricula();
    public ControladorListaAlumnoMatriculado(ListaAlumnoMatriculado listaa) {
        vista=listaa;
        Procesos.ProcesosListaAlumnoMatriculado.Presentacion(vista);
        vista.btnFiltrar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.btnFiltrar==e.getSource()){
            if(vista.cbxGrado.getSelectedIndex()> 0){
                Procesos.ProcesosListaAlumnoMatriculado.MostrarTablaListaAlumnoMatriculado(vista, lista);
            } else {
                Mensajes.mostrarmsj("Seleccione el grado.");
                Procesos.ProcesosListaAlumnoMatriculado.LimpiarTabla(vista);
            }
        }
        
    }
    
}
