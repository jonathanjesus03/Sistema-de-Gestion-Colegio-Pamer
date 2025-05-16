/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import EstructuraArrayList.ArrayListApoderado;
import Modelo.Apoderado;
import Vista.EdtApoderado;
import Vista.RgtApoderado;
import Vista.RptApoderado;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cr075
 */
public class ProcesosApoderado {
    public static void Presentacion(RgtApoderado vista){
        vista.setTitle("Registro de Apoderado del Colegio Pamer");
        vista.setVisible(true);
    }
    public static void Presentacion(RptApoderado vista){
        vista.setTitle("Reporte de Apoderado del Colegio Pamer");
        vista.setVisible(true);
    }
    public static void Presentacion(EdtApoderado vista){
        vista.setTitle("Editar Apoderado del Colegio Pamer");
        vista.setVisible(true);
    }
    public static Apoderado LeerDatosAlumno(RgtApoderado vista) {
        Apoderado a = new Apoderado();
        a.setTipodoc(vista.cbxTipoDoc.getSelectedItem().toString());
        a.setRelacion(vista.cbxRelacion.getSelectedItem().toString());
        a.setNdocalum(vista.txtNdocA.getText());
        a.setNdoc(vista.txtNumDoc.getText());
        a.setNombres(vista.txtNom.getText());
        a.setApellidos(vista.txtApe.getText());
        a.setPais(vista.cbxPais.getSelectedItem().toString());
        a.setDep(vista.cbxDpto.getSelectedItem().toString());
        a.setCont(vista.txtCorreo.getText());
        a.setCelu(vista.txtCelu.getText());
        a.setDistrito(vista.cbxDist.getSelectedItem().toString());
        return a;
    }
     public static Apoderado LeerDatosAlumno(EdtApoderado vista) {
         Apoderado a = new Apoderado();
        a.setTipodoc(vista.cbxTipoDoc.getSelectedItem().toString());
        a.setRelacion(vista.cbxRelacion.getSelectedItem().toString());
        a.setNdoc(vista.txtNumDoc.getText());
        a.setNombres(vista.txtNom.getText());
        a.setApellidos(vista.txtApe.getText());
        a.setPais(vista.cbxPais.getSelectedItem().toString());
        a.setDep(vista.cbxDpto.getSelectedItem().toString());
        a.setCont(vista.txtCorreo.getText());
        a.setCelu(vista.txtCelu.getText());
        a.setDistrito(vista.cbxDist.getSelectedItem().toString());
        return a;
    }
      public static void LimpiarDatosAlumno(RgtApoderado vista) {
        vista.cbxDist.setSelectedIndex(0);
        vista.cbxDpto.setSelectedIndex(0);
        vista.cbxPais.setSelectedIndex(0);
        vista.cbxTipoDoc.setSelectedIndex(0);
        vista.cbxRelacion.setSelectedIndex(0);
        vista.txtNom.setText("");
        vista.txtApe.setText("");
        vista.txtNumDoc.setText("");
        vista.txtCorreo.setText("");
        vista.txtCelu.setText("");
        vista.txtNdocA.setText("");
        vista.cbxTipoDoc.requestFocus();
    }
    public static void LimpiarDatosAlumno(EdtApoderado vista) {
       vista.cbxDist.setSelectedIndex(0);
        vista.cbxDpto.setSelectedIndex(0);
        vista.cbxPais.setSelectedIndex(0);
        vista.cbxTipoDoc.setSelectedIndex(0);
        vista.cbxRelacion.setSelectedIndex(0);
        vista.txtNom.setText("");
        vista.txtApe.setText("");
        vista.txtNumDoc.setText("");
        vista.txtCorreo.setText("");
        vista.txtCelu.setText("");
        vista.txtNdocA.setText("");
        vista.cbxTipoDoc.requestFocus();
    }
    public static void MostrarTablaAlumno(RptApoderado vista,ArrayListApoderado lista){
        String titulos[] = {"num","Relacion","N°D.Alumno", "TipoDoc", "N°Doc", "Nombre", "Apellido",
        "Pais", "Dep", "Distr","Contacto", "Celular"};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
         mt.setRowCount(0); // Limpiar filas antes de agregar nuevas
         for (int i = 0; i <lista.longitudLista(); i++) {
            mt.addRow(lista.recuperar(i).Registro(i+1));
        }
    }
    public static void MostrarTodosLosAlumnos(RptApoderado vista, ArrayListApoderado lista) {
        String titulos[] = {"num","Relacion","N°D.Alumno", "TipoDoc", "N°Doc", "Nombre", "Apellido",
         "Pais", "Dep", "Distr","Contacto", "Celular"};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
        mt.setRowCount(0);  // Eliminar todas las filas actuales para limpiar la tabla
        // Agregar todos los alumnos actualizados a la tabla
        for (int i = 0; i <lista.longitudLista(); i++) {
            mt.addRow(lista.recuperar(i).Registro(i+1));
        }
    }
     public static void MostrarTablaDatos(RptApoderado vista,ArrayListApoderado lista,int pos){
        String titulos[] = {"num","Relacion","N°D.Alumno", "TipoDoc", "N°Doc", "Nombre", "Apellido",
         "Pais", "Dep", "Distr","Contacto", "Celular"};
        DefaultTableModel mt =  new DefaultTableModel(null,titulos);
        vista.tabla.setModel(mt);
            mt.addRow(lista.recuperar(pos).Registro(pos+1));
    }
}
