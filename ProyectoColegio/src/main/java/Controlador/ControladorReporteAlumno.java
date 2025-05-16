/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralAlumno;
import EstructuraArreglo.ArregloAlumnos;
import Modelo.Alumno;
import Ordenamiento.OrdenarArreglo;
import Persistencia.AlmacenarAlumnos;
import Procesos.Mensajes;
import Procesos.ProcesosAlumno;
import Vista.RptAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorReporteAlumno implements ActionListener {

    RptAlumno vista;
    ArregloAlumnos lista;
    Alumno a;
    public int posicion = -1;
    public static int posicionActualizar; //valor static propia de la clase

    public ControladorReporteAlumno(RptAlumno rpt) {
        vista = rpt;
        lista = new ArregloAlumnos(50);
        lista = AlmacenarAlumnos.recuperarAlumnos();
        ProcesosAlumno.Presentacion(vista);
        lista.actualizarContador();
        ProcesosAlumno.MostrarTablaAlumno(vista, lista);
        vista.btnBuscar.addActionListener(this);
        vista.btnEdita.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnBuscar == e.getSource()) {
            String dato = vista.txtBuscarDNIoNom.getText();
            posicion = lista.buscarporDnioNom(dato);
            if (dato.isEmpty()) {//si esta vacío
                ProcesosAlumno.MostrarTablaAlumno(vista, lista);
            } else {
                if (posicion == -1) {
                    Mensajes.mostrarmsj("No se encontró ningún alumno con ese Nombre o Dni.");
                } else {
                    if (!vista.txtBuscarDNIoNom.getText().isEmpty()) { //SI NO ESTA VACIO
                        ProcesosAlumno.MostrarTablaDatos(vista, lista, posicion);
                    }
                }
            }
        }
        if (vista.btnEdita == e.getSource()) {
            int filaSeleccionada = vista.tabla.getSelectedRow();
            posicionActualizar = (filaSeleccionada != -1) ? filaSeleccionada : posicion;
            if (posicionActualizar == -1) {
                Mensajes.mostrarmsj("Seleccione un alumno a editar.");
            } else {
                CentralAlumno.alumnoActualizar = lista.retornarAlumno(posicionActualizar);
                Mensajes.mostrarmsj("Navega por la sección de Reportes en la Opción Actualizar para modificar los datos del alumno " + CentralAlumno.alumnoActualizar.getNombres());
            }

        }
        if (vista.btnEliminar == e.getSource()) {
            int filaSeleccionada = vista.tabla.getSelectedRow();

            int posicionEliminar = (filaSeleccionada != -1) ? filaSeleccionada : posicion;

            if (posicionEliminar == -1) {
                Mensajes.mostrarmsj("Seleccione un alumno a eliminar.");
            } else {
                Alumno alumnoAEliminar = lista.retornarAlumno(posicionEliminar);
                int msj = Mensajes.confirmarmsj(
                        "¿Deseas eliminar el registro del alumn@ " + alumnoAEliminar.getNombres() + "?",
                        "Confirmar!!"
                );
                if (msj == 0) {
                    lista.eliminarAlumno(posicionEliminar);
                    AlmacenarAlumnos.GuardarAlumnos(lista);
                    Mensajes.mostrarmsj("Alumno eliminado exitósamente!!");

                    // Limpia el campo de búsqueda y refresca la tabla
                    vista.txtBuscarDNIoNom.setText("");
                    ProcesosAlumno.MostrarTodosLosAlumnos(vista, lista);
                }
            }
        }

        if (vista.btnOrdenar == e.getSource()) {
            ArregloAlumnos aux01 = OrdenarArreglo.OrdenarNombreASC(lista);
            aux01.actualizarContador();
            ProcesosAlumno.MostrarTablaAlumno(vista, aux01);
        }
    }

}
