/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralProfesor;
import EstructuraListaCircular.ListaCircularProfesor;
import Modelo.Profesor;
import Persistencia.AlmacenarProfesores;
import Procesos.Mensajes;
import Procesos.ProcesosProfesor;
import Vista.RptProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Samsung
 */
public class ControladorReporteProfesor implements ActionListener{
    RptProfesor vista;
    ListaCircularProfesor listas;
    Profesor profe;
    
    public ControladorReporteProfesor(RptProfesor rpt){
    vista = rpt;
    listas = new ListaCircularProfesor();
    listas = AlmacenarProfesores.recuperarProfesores();
    ProcesosProfesor.Presentacion(vista);
    ProcesosProfesor.MostrarTablaProfesor(vista, listas);
    vista.btnBuscar.addActionListener(this);
    vista.btnEditar.addActionListener(this);
    vista.btnEliminar.addActionListener(this);
    vista.btnOrdenar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnBuscar){
            String dniBuscadooNom = vista.txtBuscar.getText();
            int pos = listas.buscarDNIoNom(dniBuscadooNom);
            
            if(dniBuscadooNom.isEmpty()){   
                ProcesosProfesor.MostrarTablaProfesor(vista, listas);
            }else{
                if(pos == -1){
                    Mensajes.mostrarmsj("No se encontró ningun profesor con el DNI o Nombre dado.");
                }else{
                    if(!vista.txtBuscar.getText().isEmpty()){
                        ProcesosProfesor.MostrarTablaDatos(vista, listas, pos);
                    }
                }
                
            }
            
        }else if(e.getSource() == vista.btnEditar){
              int filaSelect = vista.table.getSelectedRow();
            if(filaSelect==-1){
                Mensajes.mostrarmsj("Profavor seleccione un profesor a editar.");
            }else{
                CentralProfesor.ProfesorActualizar = listas.obtenerPorIndice(filaSelect);
                Mensajes.mostrarmsj("Navega por la sección de Reportes en la Opción Actualizar para modificar los datos del profesor " + CentralProfesor.ProfesorActualizar.getNombres());
            }
            
        }else if(e.getSource() == vista.btnEliminar){
            int filaSelect = vista.table.getSelectedRow();
            if(filaSelect==-1){
                Mensajes.mostrarmsj("Porfavor seleccione un profesor a editar.");
            }else{
                Profesor profeEliminar = listas.obtenerPorIndice(filaSelect);
                int msj = Mensajes.confirmarmsj("¿Deseas eliminar el registro del Profesor " + profeEliminar.getNombres() + "?",
                        "Confirmar!!"
                );   
                if(msj==0){
                    listas.eliminar(listas.obtenerPorIndice(filaSelect).getNdoc());
                    AlmacenarProfesores.GuardarProfesores(listas);
                    Mensajes.mostrarmsj("Profesor eliminado exitósamente!!");

                    vista.txtBuscar.setText("");
                    ProcesosProfesor.MostrarTodosLosProfesores(vista, listas);
                }
            
            
            }
        }else if(e.getSource() == vista.btnOrdenar){
            ListaCircularProfesor listaAux = Ordenamiento.OrdenarListaCircular.ordenarPorNombreASC(listas);
            ProcesosProfesor.MostrarTablaProfesor(vista, listaAux);
        }

    }
}
