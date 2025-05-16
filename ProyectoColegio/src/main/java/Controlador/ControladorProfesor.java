/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraListaCircular.ListaCircularProfesor;
import EstructuraListaCircular.Nodo;
import Modelo.Profesor;
import Persistencia.AlmacenarProfesores;
import Procesos.Mensajes;
import Procesos.ProcesosProfesor;
import Vista.RgtProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Samsung
 */
public class ControladorProfesor implements ActionListener{
    Profesor profe;
    ListaCircularProfesor lista;
    RgtProfesor vista;

    public ControladorProfesor(RgtProfesor f2){
        vista = f2;
        vista.btnRegistrar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        lista = new ListaCircularProfesor();
        lista = AlmacenarProfesores.recuperarProfesores();
        ProcesosProfesor.Presentacion(vista);
        vista.AgruparBotones();
        ConfigurarRadioButtons();
    }
    
    private void ConfigurarRadioButtons(){
        vista.rbtnMas.addActionListener(this);
        vista.rbtnFem.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnRegistrar){
            profe = ProcesosProfesor.LeerDatosProfesor(vista);
            lista.InsertarAlFinal(new Nodo(profe));
            AlmacenarProfesores.GuardarProfesores(lista);
            ProcesosProfesor.LimpiarDatosProfesor(vista);
            Mensajes.mostrarmsj("Profesor registrado exitósamente!!");
        }else if(e.getSource() == vista.btnCancelar){
            vista.dispose();
        }
    }
    
    
    
}
