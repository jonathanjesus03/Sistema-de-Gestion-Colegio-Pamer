/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import EstructuraCola.ColaMatricula;
import Modelo.Matricula;
import Vista.ListaAlumnoMatriculado;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cr075
 */
public class ProcesosListaAlumnoMatriculado {
    
      public static void Presentacion(ListaAlumnoMatriculado vista) {
        vista.setTitle("Lista de Alumnos matriculados de cada grado");
        vista.setVisible(true);
    }
      public static void MostrarTablaListaAlumnoMatriculado(ListaAlumnoMatriculado vista, ColaMatricula lista) {
        String titulos[] = {"num", "N° Doc. Alumno", "Nombre"};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
        mt.setRowCount(0); // Limpiar filas antes de agregar nuevas
        int num = 0;
        for (Matricula c : lista.getLista()) {
            if(c.getGrado().equalsIgnoreCase(vista.cbxGrado.getSelectedItem().toString())){
            num++;
            mt.addRow(c.RegistroListaAlumnoMatriculado(num));
            }
        }
    }
       public static void LimpiarTabla(ListaAlumnoMatriculado vista) {
        String titulos[] = {"num", "N° Doc. Alumno", "Nombre"};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
        mt.setRowCount(0); // Limpiar filas antes de agregar nuevas
    }
      

}
