/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import EstructuraCola.ColaMatricula;
import Modelo.Alumno;
import Modelo.Matricula;
import Vista.EdtMatricula;
import Vista.RgtMatricula;
import Vista.RptMatricula;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cr075
 */
public class ProcesosMatricula {

    public static void Presentacion(RgtMatricula vista) {
        vista.setTitle("Registro de Matricula del Colegio Pamer");
        vista.setVisible(true);
    }

    public static void Presentacion(RptMatricula vista) {
        vista.setTitle("Reporte de Matricula del Colegio Pamer");
        vista.setVisible(true);
    }

    public static void Presentacion(EdtMatricula vista) {
        vista.setTitle("Editar Matrícula del Colegio Pamer");
        vista.setVisible(true);
    }

    public static Matricula LeerDatosHorario(RgtMatricula vista) {
        Matricula a = new Matricula();
        //a.setAlumno(CentralAlumnoMatricular.alumnoAMatricular);
        a.setCod(vista.txtCod.getText());
        a.setColegiopre(vista.txtColePre.getText());
        // Obtener y convertir la fecha
        String fechaTexto = vista.txtFechaMat.getText();
        if (fechaTexto != null && !fechaTexto.isEmpty()) {
            try {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                a.setFecha(LocalDate.parse(fechaTexto, formato));

            } catch (Exception e) {
                Mensajes.mostrarmsj("Coloque un formato correcto de fechas: DD/MM/YYYY");
            }
        } else {
            a.setFecha(LocalDate.EPOCH); // Asignar un valor predeterminado si no hay fecha
        }
        a.setGrado(vista.cbxGrado.getSelectedItem().toString());
        a.setSeccion(vista.cbxSeccion.getSelectedItem().toString());
        a.MontodePension();
        return a;
    }

    public static Matricula LeerDatosHorario(EdtMatricula vista) {
        Matricula a = new Matricula();
        //a.setAlumno(CentralAlumnoMatricular.alumnoAMatricular);
        a.setCod(vista.txtCod.getText());
        a.setColegiopre(vista.txtColePre.getText());
        // Obtener y convertir la fecha
        String fechaTexto = vista.txtFechaMat.getText();
        if (fechaTexto != null && !fechaTexto.isEmpty()) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            a.setFecha(LocalDate.parse(fechaTexto, formato));
        } else {
            a.setFecha(LocalDate.EPOCH); // Asignar un valor predeterminado si no hay fecha
        }
        a.setGrado(vista.cbxGrado.getSelectedItem().toString());
        a.setSeccion(vista.cbxSeccion.getSelectedItem().toString());
        a.MontodePension();
        return a;
    }

    public static void LimpiarDatosHorario(RgtMatricula vista) {
        vista.txtApellidos.setText("");
        vista.txtCod.setText("");
        vista.txtNom.setText("");
        vista.txtColePre.setText("");
        vista.txtCorreo.setText("");
        vista.txtFecha.setText("");
        vista.txtFechaMat.setText("");
        vista.txtNumDoc.setText("");
        vista.cbxDist.setSelectedIndex(0);
        vista.cbxDpto.setSelectedIndex(0);
        vista.cbxGrado.setSelectedIndex(0);
        vista.cbxLengua.setSelectedIndex(0);
        vista.cbxPais.setSelectedIndex(0);
        vista.cbxSeccion.setSelectedIndex(0);
        vista.cbxTipoDoc.setSelectedIndex(0);
        vista.rbtnDisNo.setSelected(false);
        vista.rbtnDisSi.setSelected(false);
        vista.rbtnFem.setSelected(false);
        vista.rbtnMas.setSelected(false);
        vista.rbtnOtroNo.setSelected(false);
        vista.rbtnOtroSi.setSelected(false);
        // Restablecer los toggle buttons
        vista.togNuevo.setSelected(false);
        vista.togNuevo.setText("NO  |");
        vista.togNuevo.setBackground(Color.DARK_GRAY);
        vista.togNuevo.setVisible(true);
        
        vista.togAntiguo.setSelected(false);
        vista.togAntiguo.setText("NO  |");
        vista.togAntiguo.setBackground(Color.DARK_GRAY);
        vista.togAntiguo.setVisible(true);
       
        vista.togTraslado.setSelected(false);
        vista.togTraslado.setText("NO  |");
        vista.togTraslado.setBackground(Color.DARK_GRAY);
        vista.togTraslado.setVisible(true);
        // Resetear visibilidad de los paneles
        vista.panelNue.setVisible(true);
        vista.panelTras.setVisible(true);
        vista.panelAnti.setVisible(true);
    }

    public static void LimpiarDatosHorario(EdtMatricula vista) {
        vista.txtApellidos.setText("");
        vista.txtNom.setText("");
        vista.txtCod.setText("");
        vista.txtColePre.setText("");
        vista.txtCorreo.setText("");
        vista.txtFecha.setText("");
        vista.txtFechaMat.setText("");
        vista.txtNumDoc.setText("");
        vista.cbxDist.setSelectedIndex(0);
        vista.cbxDpto.setSelectedIndex(0);
        vista.cbxGrado.setSelectedIndex(0);
        vista.cbxLengua.setSelectedIndex(0);
        vista.cbxPais.setSelectedIndex(0);
        vista.cbxSeccion.setSelectedIndex(0);
        vista.cbxTipoDoc.setSelectedIndex(0);
        vista.rbtnDisNo.setSelected(false);
        vista.rbtnDisSi.setSelected(false);
        vista.rbtnFem.setSelected(false);
        vista.rbtnMas.setSelected(false);
        vista.rbtnOtroNo.setSelected(false);
        vista.rbtnOtroSi.setSelected(false);
         // Restablecer los toggle buttons
        vista.togNuevo.setSelected(false);
        vista.togNuevo.setText("NO  |");
        vista.togNuevo.setBackground(Color.DARK_GRAY);
        vista.togNuevo.setVisible(true);
        
        vista.togAntiguo.setSelected(false);
        vista.togAntiguo.setText("NO  |");
        vista.togAntiguo.setBackground(Color.DARK_GRAY);
        vista.togAntiguo.setVisible(true);
       
        vista.togTraslado.setSelected(false);
        vista.togTraslado.setText("NO  |");
        vista.togTraslado.setBackground(Color.DARK_GRAY);
        vista.togTraslado.setVisible(true);
        // Resetear visibilidad de los paneles
        vista.panelNue.setVisible(true);
        vista.panelTras.setVisible(true);
        vista.panelAnti.setVisible(true);
    }

    public static void MostrarTablaMatricula(RptMatricula vista, ColaMatricula lista) {
        String titulos[] = {"num", "Cod.Mat", "N° Doc. Alumno", "Nombre", "Alumno Tras.", "Col. Precedente", "Al. Antiguo", "Al. Nuevo", "Grado a Mat.", "Sección", "Fecha", "M. Pensión"};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
        mt.setRowCount(0); // Limpiar filas antes de agregar nuevas
        int num = 0;
        for (Matricula c : lista.getLista()) {
            num++;
            mt.addRow(c.Registro(num));
        }
    }

    public static void MostrarTablaMatriculaBuscado(RptMatricula vista, ColaMatricula lista, int posi) {
        String titulos[] = {"num", "Cod.Mat", "N° Doc. Alumno", "Nombre", "Alumno Tras.", "Col. Precedente", "Al. Antiguo", "Al. Nuevo", "Grado a Mat.", "Sección", "Fecha", "M. Pensión"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        vista.tabla.setModel(mt);
        // Verifica si la posición está dentro del rango de la lista
        if (posi >= 0 && posi <= lista.getLista().size()) {
            Matricula matri = lista.obtenerporPos(posi); // Ajustar posición a índice 0-based
            mt.addRow(matri.Registro(posi + 1));
        }
    }

    public static void MostrarDatosAlumno(Alumno a, RgtMatricula vista) {
        vista.txtNumDoc.setText(a.getNdoc());
        vista.txtNom.setText(a.getNombres());
        vista.txtFecha.setText(a.getFecha());
        vista.txtCorreo.setText(a.getCont());
        vista.txtApellidos.setText(a.getApellidos());
        switch (a.getTipodoc()) {
            case "Dni":
                vista.cbxTipoDoc.setSelectedIndex(1);
                break;
            case "Pasaporte":
                vista.cbxTipoDoc.setSelectedIndex(2);
                break;
            default:
                vista.cbxTipoDoc.setSelectedIndex(0);
                break;
        }
        switch (a.getPais()) {
            case "Peru":
                vista.cbxPais.setSelectedIndex(1);
                break;
            case "Otro":
                vista.cbxPais.setSelectedIndex(2);
                break;
            default:
                vista.cbxPais.setSelectedIndex(0);
                break;
        }
        switch (a.getDep()) {
            case "Callao (Provincia Constitucional)":
                vista.cbxDpto.setSelectedIndex(1);
                break;
            case "Lima":
                vista.cbxDpto.setSelectedIndex(2);
                break;
            case "Otro":
                vista.cbxDpto.setSelectedIndex(3);
                break;
            default:
                vista.cbxDpto.setSelectedIndex(0);
                break;
        }
        switch (a.getDistri()) {
            case "Comas":
                vista.cbxDist.setSelectedIndex(1);
                break;
            case "Puente Piedra":
                vista.cbxDist.setSelectedIndex(2);
                break;
            case "Rímac":
                vista.cbxDist.setSelectedIndex(3);
                break;
            case "San Martín de Porres":
                vista.cbxDist.setSelectedIndex(4);
                break;
            case "Lima (Centro)":
                vista.cbxDist.setSelectedIndex(5);
                break;
            case "Otro":
                vista.cbxDist.setSelectedIndex(6);
                break;
            default:
                vista.cbxDist.setSelectedIndex(0);
                break;
        }
        switch (a.getLengua()) {
            case "Español":
                vista.cbxLengua.setSelectedIndex(1);
                break;
            case "Quechua":
                vista.cbxLengua.setSelectedIndex(2);
                break;
            case "Aymara":
                vista.cbxLengua.setSelectedIndex(3);
                break;
            case "Otro":
                vista.cbxLengua.setSelectedIndex(4);
                break;
            default:
                vista.cbxLengua.setSelectedIndex(0);
                break;
        }
        if (a.getSexo().equals(vista.rbtnMas.getText())) { //si es igual a rbtnMas
            vista.rbtnMas.setSelected(true); //se selecciona
        } else if (a.getSexo().equals(vista.rbtnFem.getText())) {
            vista.rbtnFem.setSelected(true);
        }
        if (a.getDisca().equals(vista.rbtnDisSi.getText())) {
            vista.rbtnDisSi.setSelected(true);
        } else if (a.getDisca().equals(vista.rbtnDisNo.getText())) {
            vista.rbtnDisNo.setSelected(true);
        }
        if (a.getOtrascond().equals(vista.rbtnOtroSi.getText())) {
            vista.rbtnOtroSi.setSelected(true);
        } else if (a.getOtrascond().equals(vista.rbtnOtroNo.getText())) {
            vista.rbtnOtroNo.setSelected(true);
        }
    }

    
    public static void MostrarDatosAlumno(Alumno a, EdtMatricula vista) {
        vista.txtNumDoc.setText(a.getNdoc());
        vista.txtNom.setText(a.getNombres());
        vista.txtFecha.setText(a.getFecha());
        vista.txtCorreo.setText(a.getCont());
        vista.txtApellidos.setText(a.getApellidos());
        switch (a.getTipodoc()) {
            case "Dni":
                vista.cbxTipoDoc.setSelectedIndex(1);
                break;
            case "Pasaporte":
                vista.cbxTipoDoc.setSelectedIndex(2);
                break;
            default:
                vista.cbxTipoDoc.setSelectedIndex(0);
                break;
        }
        switch (a.getPais()) {
            case "Peru":
                vista.cbxPais.setSelectedIndex(1);
                break;
            case "Otro":
                vista.cbxPais.setSelectedIndex(2);
                break;
            default:
                vista.cbxPais.setSelectedIndex(0);
                break;
        }
        switch (a.getDep()) {
            case "Callao (Provincia Constitucional)":
                vista.cbxDpto.setSelectedIndex(1);
                break;
            case "Lima":
                vista.cbxDpto.setSelectedIndex(2);
                break;
            case "Otro":
                vista.cbxDpto.setSelectedIndex(3);
                break;
            default:
                vista.cbxDpto.setSelectedIndex(0);
                break;
        }
        switch (a.getDistri()) {
            case "Comas":
                vista.cbxDist.setSelectedIndex(1);
                break;
            case "Puente Piedra":
                vista.cbxDist.setSelectedIndex(2);
                break;
            case "Rímac":
                vista.cbxDist.setSelectedIndex(3);
                break;
            case "San Martín de Porres":
                vista.cbxDist.setSelectedIndex(4);
                break;
            case "Lima (Centro)":
                vista.cbxDist.setSelectedIndex(5);
                break;
            case "Otro":
                vista.cbxDist.setSelectedIndex(6);
                break;
            default:
                vista.cbxDist.setSelectedIndex(0);
                break;
        }
        switch (a.getLengua()) {
            case "Español":
                vista.cbxLengua.setSelectedIndex(1);
                break;
            case "Quechua":
                vista.cbxLengua.setSelectedIndex(2);
                break;
            case "Aymara":
                vista.cbxLengua.setSelectedIndex(3);
                break;
            case "Otro":
                vista.cbxLengua.setSelectedIndex(4);
                break;
            default:
                vista.cbxLengua.setSelectedIndex(0);
                break;
        }
        if (a.getSexo().equals(vista.rbtnMas.getText())) { //si es igual a rbtnMas
            vista.rbtnMas.setSelected(true); //se selecciona
        } else if (a.getSexo().equals(vista.rbtnFem.getText())) {
            vista.rbtnFem.setSelected(true);
        }
        if (a.getDisca().equals(vista.rbtnDisSi.getText())) {
            vista.rbtnDisSi.setSelected(true);
        } else if (a.getDisca().equals(vista.rbtnDisNo.getText())) {
            vista.rbtnDisNo.setSelected(true);
        }
        if (a.getOtrascond().equals(vista.rbtnOtroSi.getText())) {
            vista.rbtnOtroSi.setSelected(true);
        } else if (a.getOtrascond().equals(vista.rbtnOtroNo.getText())) {
            vista.rbtnOtroNo.setSelected(true);
        }
    }

    public static void NoEditarDatosAlumno(RgtMatricula vista) {
        vista.cbxTipoDoc.setEnabled(false);
        vista.cbxDist.setEnabled(false);
        vista.cbxDpto.setEnabled(false);
        vista.cbxLengua.setEnabled(false);
        vista.cbxPais.setEnabled(false);
        vista.cbxTipoDoc.setEnabled(false);
        vista.txtApellidos.setEditable(false);
        vista.txtCorreo.setEditable(false);
        vista.txtFecha.setEditable(false);
        vista.txtNom.setEditable(false);
        vista.txtNumDoc.setEditable(false);
        vista.rbtnDisNo.setEnabled(false);
        vista.rbtnDisSi.setEnabled(false);
        vista.rbtnFem.setEnabled(false);
        vista.rbtnMas.setEnabled(false);
        vista.rbtnOtroNo.setEnabled(false);
        vista.rbtnOtroSi.setEnabled(false);
    }
     public static void NoEditarDatosAlumno(EdtMatricula vista) {
        vista.cbxTipoDoc.setEnabled(false);
        vista.cbxDist.setEnabled(false);
        vista.cbxDpto.setEnabled(false);
        vista.cbxLengua.setEnabled(false);
        vista.cbxPais.setEnabled(false);
        vista.cbxTipoDoc.setEnabled(false);
        vista.txtApellidos.setEditable(false);
        vista.txtCorreo.setEditable(false);
        vista.txtFecha.setEditable(false);
        vista.txtNom.setEditable(false);
        vista.txtNumDoc.setEditable(false);
        vista.rbtnDisNo.setEnabled(false);
        vista.rbtnDisSi.setEnabled(false);
        vista.rbtnFem.setEnabled(false);
        vista.rbtnMas.setEnabled(false);
        vista.rbtnOtroNo.setEnabled(false);
        vista.rbtnOtroSi.setEnabled(false);
    }
}
