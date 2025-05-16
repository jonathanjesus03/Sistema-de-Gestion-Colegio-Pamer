/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraPila.PilaHorario;
import Persistencia.AlmacenarHorario;
import Procesos.Mensajes;
import Vista.ListaCursosProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorListaCursoProfesor implements ActionListener{
    ListaCursosProfesor vista;
    PilaHorario lista=AlmacenarHorario.recuperarHorario();
    
    public ControladorListaCursoProfesor(ListaCursosProfesor listapr) {
        vista=listapr;
        vista.btnFiltrar.addActionListener(this);
        Procesos.ProcesosListaCursoProfesor.Presentacion(vista);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.btnFiltrar==e.getSource()){
            if(vista.cbxDniProf.getSelectedIndex()> 0){
                Procesos.ProcesosListaCursoProfesor.MostrarTablaCursoSProfesor(vista, lista);
            } else {
                Mensajes.mostrarmsj("Seleccione un Profesor.");
                Procesos.ProcesosListaCursoProfesor.LimpiarTabla(vista);
            }
        }
    }
    
    
}
