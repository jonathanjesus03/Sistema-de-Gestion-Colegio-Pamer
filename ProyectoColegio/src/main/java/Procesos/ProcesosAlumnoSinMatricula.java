/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import EstructuraArreglo.ArregloAlumnos;
import Vista.AlumnosinMatri;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cr075
 */
public class ProcesosAlumnoSinMatricula {
    public static void Presentacion(AlumnosinMatri vista){
        vista.setTitle("Lista de Alumnos del Colegio Pamer sin Matrícula");
        vista.setVisible(true);
    }
    public static void MostrarTodosLosAlumnosConEstadoFalse(AlumnosinMatri vista, ArregloAlumnos lista) {
        String titulos[] = {"num","N° Doc.", "Nombre","Estado"};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
        mt.setRowCount(0);  // Eliminar todas las filas actuales para limpiar la tabla

        // Agregar todos los alumnos actualizados a la tabla
        for (int i = 0; i < ArregloAlumnos.contador; i++) {
            if(lista.retornarAlumno(i).getEstado()==false){
            mt.addRow(lista.retornarAlumno(i).RegistroSinMatri(i+1));
           }
        }
    }
}
