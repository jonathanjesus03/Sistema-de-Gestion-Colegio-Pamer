/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralAlumnoMatricular;
import EstructuraArreglo.ArregloAlumnos;
import Modelo.Alumno;
import Persistencia.AlmacenarAlumnos;
import Procesos.Mensajes;
import Procesos.ProcesosAlumnoSinMatricula;
import Vista.AlumnosinMatri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorAlumnosSinMatricular implements ActionListener{
    AlumnosinMatri vista;
    ArregloAlumnos lista;

    public ControladorAlumnosSinMatricular(AlumnosinMatri al) {
        vista=al;
        ProcesosAlumnoSinMatricula.Presentacion(vista);
        lista=new ArregloAlumnos(50);
        lista=AlmacenarAlumnos.recuperarAlumnos();
        lista.actualizarContador();
        vista.btnElegir.addActionListener(this);
        ProcesosAlumnoSinMatricula.MostrarTodosLosAlumnosConEstadoFalse(vista, lista);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.btnElegir==e.getSource()){
            if (vista.btnElegir == e.getSource()) {
                int filaSeleccionada = vista.tabla.getSelectedRow(); // Fila seleccionada
                String dato = vista.txtBuscar.getText().trim();      // Texto de búsqueda (eliminando espacios)

                // Caso 1: Si hay una fila seleccionada
                if (filaSeleccionada != -1) {
                    Alumno alumno = lista.retornarporPosSinMatricular(filaSeleccionada);
                    if (alumno != null) {
                        CentralAlumnoMatricular.alumnoAMatricular = alumno;
                        Mensajes.mostrarmsj("Alumno encontrado por selección de fila. Navegue a la sección de Matrícula.");
                    } else {
                        Mensajes.mostrarmsj("El alumno seleccionado ya está matriculado.");
                    }

                    // Caso 2: Si no hay fila seleccionada, pero hay texto de búsqueda
                } else if (!dato.isEmpty()) {
                    if (lista.buscarporDniSinMatricular(dato)) {
                        Alumno alumno = lista.retornarporDniSinMatricular(dato);
                        CentralAlumnoMatricular.alumnoAMatricular = alumno;
                        Mensajes.mostrarmsj("Alumno encontrado por búsqueda de DNI. Navegue a la sección de Matrícula.");
                    } else {
                        Mensajes.mostrarmsj("No se encontró ningún alumno registrado con el N° Documento: " + dato);
                    }

                    // Caso 3: Ninguna acción válida
                } else {
                    Mensajes.mostrarmsj("Debe seleccionar una fila o ingresar el N° de Documento del alumno.");
                }

                // Limpieza del cuadro de búsqueda
                vista.txtBuscar.setText("");
            }
        }
    }
    
}
