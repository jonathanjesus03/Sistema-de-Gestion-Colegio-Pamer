/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import EstructuraArreglo.ArregloAlumnos;
import Modelo.Alumno;
import Vista.EdtAlumno;
import Vista.RgtAlumno;
import Vista.RptAlumno;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cr075
 */
public class ProcesosAlumno {
    public static void Presentacion(RgtAlumno vista){
        vista.setTitle("Registro de Alumnos del Colegio Pamer");
        vista.setVisible(true);
    }
    public static void Presentacion(RptAlumno vista){
        vista.setTitle("Reporte de Alumnos del Colegio Pamer");
        vista.setVisible(true);
    }
    public static void Presentacion(EdtAlumno vista){
        vista.setTitle("Editar Alumnos del Colegio Pamer");
        vista.setVisible(true);
    }
    public static Alumno LeerDatosAlumno(RgtAlumno vista) {
        Alumno a = new Alumno();
        a.setTipodoc(vista.cbxTipoDoc.getSelectedItem().toString());
        a.setNdoc(vista.txtNumDoc.getText());
        a.setNombres(vista.txtNom.getText());
        a.setApellidos(vista.txtApellidos.getText());
        if (vista.rbtnMas.isSelected()) {
            a.setSexo(vista.rbtnMas.getText());
        } else if (vista.rbtnFem.isSelected()) {
            a.setSexo(vista.rbtnFem.getText());
        }
        if (vista.rbtnDisSi.isSelected()) {
            a.setDisca(vista.rbtnDisSi.getText());
        } else if (vista.rbtnDisNo.isSelected()) {
            a.setDisca(vista.rbtnDisNo.getText());
        }
        if (vista.rbtnOtroSi.isSelected()) {
            a.setOtrascond(vista.rbtnOtroSi.getText());
        } else if (vista.rbtnOtroNo.isSelected()) {
            a.setOtrascond(vista.rbtnOtroNo.getText());
        }
        a.setPais(vista.cbxPais.getSelectedItem().toString());
        a.setDep(vista.cbxDpto.getSelectedItem().toString());
        a.setDistri(vista.cbxDist.getSelectedItem().toString());
        a.setFecha(vista.txtFecha.getText());
        a.setLengua(vista.cbxLengua.getSelectedItem().toString());
        a.setCont(vista.txtCorreo.getText());
        return a;
    }
     public static Alumno LeerDatosAlumno(EdtAlumno vista) {
        Alumno a = new Alumno();
        a.setTipodoc(vista.cbxTipoDoc.getSelectedItem().toString());
        a.setNdoc(vista.txtNumDoc.getText());
        a.setNombres(vista.txtNom.getText());
        a.setApellidos(vista.txtApellidos.getText());
        if (vista.rbtnMas.isSelected()) {
            a.setSexo(vista.rbtnMas.getText());
        } else if (vista.rbtnFem.isSelected()) {
            a.setSexo(vista.rbtnFem.getText());
        }
        if (vista.rbtnDisSi.isSelected()) {
            a.setDisca(vista.rbtnDisSi.getText());
        } else if (vista.rbtnDisNo.isSelected()) {
            a.setDisca(vista.rbtnDisNo.getText());
        }
        if (vista.rbtnOtroSi.isSelected()) {
            a.setOtrascond(vista.rbtnOtroSi.getText());
        } else if (vista.rbtnOtroNo.isSelected()) {
            a.setOtrascond(vista.rbtnOtroNo.getText());
        }
        a.setPais(vista.cbxPais.getSelectedItem().toString());
        a.setDep(vista.cbxDpto.getSelectedItem().toString());
        a.setDistri(vista.cbxDist.getSelectedItem().toString());
        a.setFecha(vista.txtFecha.getText());
        a.setLengua(vista.cbxLengua.getSelectedItem().toString());
        a.setCont(vista.txtCorreo.getText());
        return a;
    }
      public static void LimpiarDatosAlumno(RgtAlumno vista) {
        vista.cbxDist.setSelectedIndex(0);
        vista.cbxDpto.setSelectedIndex(0);
        vista.cbxLengua.setSelectedIndex(0);
        vista.cbxPais.setSelectedIndex(0);
        vista.cbxTipoDoc.setSelectedIndex(0);
        vista.grupoSexo.clearSelection();
        vista.grupoOtro.clearSelection();
        vista.grupoDisc.clearSelection();
        vista.txtNom.setText("");
        vista.txtApellidos.setText("");
        vista.txtNumDoc.setText("");
        vista.txtFecha.setText("");
        vista.txtCorreo.setText("");
        vista.cbxTipoDoc.requestFocus();
    }
    public static void LimpiarDatosAlumno(EdtAlumno vista) {
        vista.cbxDist.setSelectedIndex(0);
        vista.cbxDpto.setSelectedIndex(0);
        vista.cbxLengua.setSelectedIndex(0);
        vista.cbxPais.setSelectedIndex(0);
        vista.cbxTipoDoc.setSelectedIndex(0);
        vista.grupoSexo.clearSelection();
        vista.grupoOtro.clearSelection();
        vista.grupoDisc.clearSelection();
        vista.txtNom.setText("");
        vista.txtApellidos.setText("");
        vista.txtNumDoc.setText("");
        vista.txtFecha.setText("");
        vista.txtCorreo.setText("");
        vista.cbxTipoDoc.requestFocus();
    }
    public static void MostrarTablaAlumno(RptAlumno vista,ArregloAlumnos lista){
        String titulos[]={"num", "TipoDoc", "N°Doc", "Nombre", "Apellido", 
        "Sexo", "Disc.", "Otro","Pais", "Dep", "Distr","Fecha","Lengua","Contacto","Estado"};
        DefaultTableModel mt =  new DefaultTableModel(null,titulos);
        vista.tabla.setModel(mt);
        for(int pos=0;pos<ArregloAlumnos.contador;pos++){
            mt.addRow(lista.retornarAlumno(pos).Registro(pos+1));
        }
    }
    public static void MostrarTodosLosAlumnos(RptAlumno vista, ArregloAlumnos lista) {
        String titulos[] = {"num", "TipoDoc", "N°Doc", "Nombre", "Apellido",
            "Sexo", "Disc.", "Otro", "Pais", "Dep", "Distr",
            "Fecha", "Lengua", "Contacto", "Estado"};

        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
        mt.setRowCount(0);  // Eliminar todas las filas actuales para limpiar la tabla

        // Agregar todos los alumnos actualizados a la tabla
        for (int i = 0; i < ArregloAlumnos.contador; i++) {
            mt.addRow(lista.retornarAlumno(i).Registro(i + 1));
        }
    }
     public static void MostrarTablaDatos(RptAlumno vista,ArregloAlumnos lista,int pos){
        String titulos[]={"num", "TipoDoc", "N°Doc", "Nombre", "Apellido", 
        "Sexo", "Disc.", "Otro","Pais", "Dep", "Distr","Fecha","Lengua","Contacto","Estado"};
        DefaultTableModel mt =  new DefaultTableModel(null,titulos);
        vista.tabla.setModel(mt);
            mt.addRow(lista.retornarAlumno(pos).Registro(pos+1));
    }
}
