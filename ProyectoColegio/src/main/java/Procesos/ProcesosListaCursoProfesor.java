/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import EstructuraListaCircular.ListaCircularProfesor;
import EstructuraListaCircular.Nodo;
import EstructuraPila.PilaHorario;
import Persistencia.AlmacenarProfesores;
import Vista.ListaCursosProfesor;
import Vista.RptHorario;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cr075
 */
public class ProcesosListaCursoProfesor {
    
     public static void LlenarComboDesdeProfesores(JComboBox<String> cbx) {
        ListaCircularProfesor listaProfesores = AlmacenarProfesores.recuperarProfesores(); // Recuperar lista desde archivo
        cbx.removeAllItems();
        cbx.addItem("Seleccione"); // Opción inicial

        if (listaProfesores.lc == null) {
            // Si la lista está vacía, terminamos aquí
            return;
        }

        Nodo actual = listaProfesores.lc.enlace; // El primer nodo en la lista circular
        do {
            cbx.addItem(actual.profesor.getNdoc()); // Agregar DNI del profesor al ComboBox
            actual = actual.enlace; // Avanzar al siguiente nodo
        } while (actual != listaProfesores.lc.enlace); // Mientras no volvamos al primer nodo
    }
     
      public static void Presentacion(ListaCursosProfesor vista) {
        vista.setTitle("Lista de Cursos de un Profesor");
        vista.setVisible(true);
    }
       public static void MostrarTablaCursoSProfesor(ListaCursosProfesor vista, PilaHorario pila) {
        String titulos[] = {"num","Cod. Curso", "Nom. Curso"};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
        mt.setRowCount(0); // Limpiar filas antes de agregar nuevas
        for (int i = 0; i < pila.Cantidad(); i++) {
            if(pila.obtener(i).getCodProfesor().equalsIgnoreCase(vista.cbxDniProf.getSelectedItem().toString())){
              mt.addRow(pila.obtener(i).RegistroCursos(i+1));
        }
       }
    }
      public static void LimpiarTabla(ListaCursosProfesor vista) {
        String titulos[] = {"num", "Cod. Curso", "Nom. Curso"};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
        mt.setRowCount(0); // Limpiar filas antes de agregar nuevas
    }
       
}
