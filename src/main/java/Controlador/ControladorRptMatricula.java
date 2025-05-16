/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralMatricula;
import EstructuraArreglo.ArregloAlumnos;
import EstructuraCola.ColaMatricula;
import EstructuraPila.PilaHorario;
import Modelo.Horario;
import Modelo.Matricula;
import Persistencia.AlmacenarAlumnos;
import Persistencia.AlmacenarHorario;
import Persistencia.AlmacenarMatricula;
import Procesos.Mensajes;
import Procesos.ProcesosMatricula;
import Vista.RptMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cr075
 */
public class ControladorRptMatricula implements ActionListener{
    RptMatricula vista;
    Matricula mat;
    ColaMatricula lista;
    int posicion=-1;
    public static int posicionActualizar;
    int posicionVerHorario;
    ArregloAlumnos listaAlum=AlmacenarAlumnos.recuperarAlumnos();


    public ControladorRptMatricula(RptMatricula rpt) {
        vista=rpt;
        lista=new ColaMatricula();
        lista=AlmacenarMatricula.recuperarMatricula();
        listaAlum.actualizarContador();
        vista.btnBuscar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnVerPrimero.addActionListener(this);
        vista.btnVerHorario.addActionListener(this);
        Procesos.ProcesosMatricula.Presentacion(vista);
        ProcesosMatricula.MostrarTablaMatricula(vista, lista);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if(vista.btnBuscar==e.getSource()){
               String dato = vista.txtBuscar.getText();
            posicion = lista.obtenerCod(dato);
            if (dato.isEmpty()) {//si esta vacío
                ProcesosMatricula.MostrarTablaMatricula(vista, lista);
            } else {
                if (posicion == -1) {
                    Mensajes.mostrarmsj("No se encontró ninguna matrícula con ese código.");
                    vista.txtBuscar.setText("");
                } else {
                    if (!vista.txtBuscar.getText().isEmpty()) { //SI NO ESTA VACIO
                        ProcesosMatricula.MostrarTablaMatriculaBuscado(vista, lista, posicion);
                    }
                }
            }
         }
         if(vista.btnEditar==e.getSource()){
            int filaSeleccionada = vista.tabla.getSelectedRow();
            posicionActualizar = (filaSeleccionada != -1) ? filaSeleccionada : posicion;
            if (posicionActualizar == -1) {
                Mensajes.mostrarmsj("Seleccione un horario a editar.");
            } else {
                CentralMatricula.matriculaActualizar = lista.obtenerporPos(posicionActualizar);
                Mensajes.mostrarmsj("Navega por la sección de Reportes en la Opción Actualizar para modificar los datos de la Matrícula con Código: " +  CentralMatricula.matriculaActualizar.getCod() + " ");
            }
         }
         if(vista.btnEliminar==e.getSource()){
                  int msj = Mensajes.confirmarmsj(
                    "¿Deseas eliminar el registro de matrícula: " + lista.obtener().toString() + "?",
                    "Confirmar!!");
            if (msj == 0) {
                mat=lista.obtener();
                mat.EliminarMatriculaAlumno(listaAlum);
                AlmacenarAlumnos.GuardarAlumnos(listaAlum);
                lista.descolar();
                AlmacenarMatricula.GuardarMatricula(lista);
                Mensajes.mostrarmsj("Matrícula eliminada exitósamente!!");
                // Limpia el campo de búsqueda y refresca la tabla
                vista.txtBuscar.setText("");
                ProcesosMatricula.MostrarTablaMatricula(vista, lista);
            }
            //al momento de eliminar el estado de matricula se tiene que cambiar a false. 
         }
         if(vista.btnVerPrimero==e.getSource()){
             Mensajes.mostrarmsj(lista.obtener().toString());
         }
        if (vista.btnVerHorario == e.getSource()) {
            int filaSeleccionada = vista.tabla.getSelectedRow(); 
            posicionVerHorario = (filaSeleccionada != -1) ? filaSeleccionada : posicion;
            if (filaSeleccionada == -1) {
                Mensajes.mostrarmsj("Selecciona una matrícula para ver su horario.");
            } else {
                Matricula matriculaSeleccionada = lista.obtenerporPos(posicionVerHorario);
                PilaHorario pilaHorarios = AlmacenarHorario.recuperarHorario();

                List<Horario> horariosRelacionados = new ArrayList<>();
                for (Horario horario : pilaHorarios.getPila()) {
                    if (horario.getGrado().equalsIgnoreCase(matriculaSeleccionada.getGrado())
                            && horario.getSeccion().equalsIgnoreCase(matriculaSeleccionada.getSeccion())) {//si coiniciden 
                        horariosRelacionados.add(horario); //se guarda en la lista, todos los horarios con ese grado y seccion
                    }
                }
                // Si se encuentran los horarios con ese grado y seccion, muestra la ficha
                if (!horariosRelacionados.isEmpty()) { //si no esta vacio la lista
                    StringBuilder resumenHorario = new StringBuilder("Horario para la matrícula:\n"); //cadena 
                    for (Horario horario : horariosRelacionados) { 
                        resumenHorario.append(horario.toStringHorario()).append("\n-------------------------\n"); //agrego el horario con el formato toStringHorario
                    }
                    Mensajes.mostrarmsj(resumenHorario.toString());
                } else {
                    Mensajes.mostrarmsj("No se encontraron horarios para el grado y sección seleccionados.");
                }
            }
        }

    }
    
}
