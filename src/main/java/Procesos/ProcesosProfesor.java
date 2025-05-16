/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import EstructuraArreglo.ArregloAlumnos;
import EstructuraListaCircular.ListaCircularProfesor;
import Modelo.Profesor;
import Vista.EdtProfesor;
import Vista.RgtAlumno;
import Vista.RgtProfesor;
import Vista.RptAlumno;
import Vista.RptProfesor;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samsung
 */
public class ProcesosProfesor {
    public static void Presentacion(RgtProfesor vista){
        vista.setTitle("Registro de Profesores del Colegio Pamer");
        vista.setVisible(true);
    }
    public static void Presentacion(RptProfesor vista){
        vista.setTitle("Reporte de Profesores del Colegio Pamer");
        vista.setVisible(true);
    }
    public static void Presentacion(EdtProfesor vista){
        vista.setTitle("Editar Profesor del Colegio Pamer");
        vista.setVisible(true);
    }
    public static Profesor LeerDatosProfesor(RgtProfesor vista) {
        Profesor p = new Profesor();
        p.setTipodoc(vista.cbxTipoDoc.getSelectedItem().toString());
        p.setNdoc(vista.txtNumDoc.getText());
        p.setNombres(vista.txtNombres.getText());
        p.setApellidos(vista.txtApellido.getText());
        if (vista.rbtnMas.isSelected()) {
            p.setSexo(vista.rbtnMas.getText());
        } else if (vista.rbtnFem.isSelected()) {
            p.setSexo(vista.rbtnFem.getText());
        }
        if(vista.check_certificado.isSelected()){
            p.setCertificados(true);
        }
        if(vista.check_curriculum.isSelected()){
            p.setCurriculum(true);
        }
        p.setPais(vista.cbxPais.getSelectedItem().toString());
        p.setFecha(vista.txtFecha.getText());
        p.setCont(vista.txtContacto.getText());
        p.setGrado(vista.cbxGrupoAcademico.getSelectedItem().toString());
        p.setEspeciali(vista.cbxEspecialización.getSelectedItem().toString());
        p.setAños(Integer.parseInt(vista.txtAñosExperiencia.getText()));
        p.setInstituciones(vista.txtInstiAnterior.getText());
        p.setDispon(vista.cbxDispHoraria.getSelectedItem().toString());
        return p;
    }
    
     public static Profesor LeerDatosProfesor(EdtProfesor vista) {
        Profesor p = new Profesor();
        p.setTipodoc(vista.cbxDoc.getSelectedItem().toString());
        p.setNdoc(vista.txtDoc.getText());
        p.setNombres(vista.txtNombres.getText());
        p.setApellidos(vista.txtApellido.getText());
        if (vista.rdbMas.isSelected()) {
            p.setSexo(vista.rdbMas.getText());
        } else if (vista.rdbFem.isSelected()) {
            p.setSexo(vista.rdbFem.getText());
        }
        if(vista.check_certificado.isSelected()){
            p.setCertificados(true);
        }
        if(vista.check_curriculum.isSelected()){
            p.setCurriculum(true);
        }
        p.setPais(vista.cbxPais.getSelectedItem().toString());
        p.setDispon(vista.cbxDispHoraria.getSelectedItem().toString());
        p.setEspeciali(vista.cbxEspecializacion.getSelectedItem().toString());
        p.setGrado(vista.cbxAcademico.getSelectedItem().toString());
        p.setAños(Integer.parseInt(vista.txtAñosExperiencia.getText()));
        p.setFecha(vista.txtFecha.getText());
        p.setCont(vista.txtContacto.getText());
        p.setInstituciones(vista.txtInstiAnteriores.getText());
        return p;
    }
    
      public static void LimpiarDatosProfesor(RgtProfesor vista) {
        vista.cbxDispHoraria.setSelectedIndex(0);
        vista.cbxEspecialización.setSelectedIndex(0);
        vista.cbxGrupoAcademico.setSelectedIndex(0);
        vista.cbxPais.setSelectedIndex(0);
        vista.cbxTipoDoc.setSelectedIndex(0);
        vista.groupSex.clearSelection();
        vista.txtNombres.setText("");
        vista.txtApellido.setText("");
        vista.txtNumDoc.setText(""); 
        vista.txtFecha.setText(""); 
        vista.txtContacto.setText("");
        vista.txtAñosExperiencia.setText("");
        vista.txtInstiAnterior.setText("");
        vista.check_certificado.setSelected(false);
        vista.check_curriculum.setSelected(false);
        vista.cbxTipoDoc.requestFocus();
    }
      
    public static void LimpiarDatosProfesor(EdtProfesor vista) {
        vista.cbxDispHoraria.setSelectedIndex(0);
        vista.cbxAcademico.setSelectedIndex(0);
        vista.cbxDoc.setSelectedIndex(0);
        vista.cbxEspecializacion.setSelectedIndex(0);
        vista.cbxPais.setSelectedIndex(0);
        vista.groupSex.clearSelection();
        vista.txtNombres.setText("");
        vista.txtApellido.setText("");
        vista.txtDoc.setText("");
        vista.txtFecha.setText("");
        vista.txtContacto.setText("");
        vista.txtInstiAnteriores.setText("");
        vista.txtAñosExperiencia.setText("");
        vista.check_certificado.setSelected(false);
        vista.check_curriculum.setSelected(false);
        vista.cbxDoc.requestFocus();
    }
      
    public static void MostrarTablaProfesor(RptProfesor vista,ListaCircularProfesor lista){
        String titulos[]={"num", "TipoDoc", "N°Doc", "Nombre", "Apellido", 
        "Sexo", "Pais.", "Fecha","Correo o N° Cont.", "Grado Academico", "Especialidad","Años Exp.","Instit. Anteri.","Disponibilidad","Curriculum","Certificado"};
        DefaultTableModel mt =  new DefaultTableModel(null,titulos);
        vista.table.setModel(mt);
        for(int pos=0;pos<lista.contarElementos();pos++){
            mt.addRow(lista.obtenerPorIndice(pos).Registro(pos+1));
        }
    }
    
    public static void MostrarTodosLosProfesores(RptProfesor vista, ListaCircularProfesor lista) {
        String titulos[]={"num", "TipoDoc", "N°Doc", "Nombre", "Apellido", 
        "Sexo", "Pais.", "Fecha","Correo o N° Cont.", "Grado Academico", "Especialidad","Años Exp.","Instit. Anteri.","Disponibilidad","Curriculum","Certificado"};
        
        DefaultTableModel mt = (DefaultTableModel) vista.table.getModel();
        mt.setRowCount(0);  // Eliminar todas las filas actuales para limpiar la tabla

        // Agregar todos los alumnos actualizados a la tabla
        for (int i = 0; i < lista.contarElementos(); i++) {
            mt.addRow(lista.obtenerPorIndice(i).Registro(i + 1));
        }
    }
    
     public static void MostrarTablaDatos(RptProfesor vista,ListaCircularProfesor lista,int pos){
        String titulos[]={"num", "TipoDoc", "N°Doc", "Nombre", "Apellido", 
        "Sexo", "Pais.", "Fecha","Correo o N° Cont.", "Grado Academico", "Especialidad","Años Exp.","Instit. Anteri.","Disponibilidad","Curriculum","Certificado"};
        DefaultTableModel mt =  new DefaultTableModel(null,titulos);
        vista.table.setModel(mt);
            mt.addRow(lista.obtenerPorIndice(pos).Registro(pos+1));
    }

}
