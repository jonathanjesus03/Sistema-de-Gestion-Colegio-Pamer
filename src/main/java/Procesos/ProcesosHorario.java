/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import EstructuraListaCircular.ListaCircularProfesor;
import EstructuraListaCircular.Nodo;
import EstructuraListaDoble.ListaEnlazadaDobleSalon;
import EstructuraListaDoble.NodoDoble;
import EstructuraListaSimple.ListaEnlazadaSimpleCurso;
import EstructuraListaSimple.NodoSimple;
import EstructuraPila.PilaHorario;
import Modelo.Horario;
import Persistencia.AlmacenarCurso;
import Persistencia.AlmacenarProfesores;
import Persistencia.AlmacenarSalon;
import Vista.EdtHorario;
import Vista.RgtHorario;
import Vista.RptHorario;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cr075
 */
public class ProcesosHorario {

    public static void Presentacion(RgtHorario vista) {
        vista.setTitle("Registro de Horario del Colegio Pamer");
        vista.setVisible(true);
    }

    public static void Presentacion(RptHorario vista) {
        vista.setTitle("Reporte de Horario del Colegio Pamer");
        vista.setVisible(true);
    }

    public static void Presentacion(EdtHorario vista) {
        vista.setTitle("Editar Horario del Colegio Pamer");
        vista.setVisible(true);
    }

    public static Horario LeerDatosHorario(RgtHorario vista) {
        Horario a = new Horario();
        a.setCod(vista.txtCod.getText());
         a.setCodCurso(vista.cbxCodCurso.getSelectedItem().toString());
        a.setCodProfesor(vista.cbxDniProf.getSelectedItem().toString());
        a.setCodSalon(vista.cbxCodSalon.getSelectedItem().toString());
        a.setGrado(vista.txtGrado.getText());
        a.setSeccion(vista.txtSeccion.getText());
        a.setNombreProfesor(vista.txtNombreProf.getText());
        a.setNombreCurso(vista.txtNombreCurso.getText());
        List<String> dias = new ArrayList<>();
        if (vista.chkLunes.isSelected()) {
            dias.add("Lunes");
        }
        if (vista.chkMartes.isSelected()) {
            dias.add("Martes");
        }
        if (vista.chkMier.isSelected()) {
            dias.add("Miércoles");
        }
        if (vista.chkJue.isSelected()) {
            dias.add("Jueves");
        }
        if (vista.chkVie.isSelected()) {
            dias.add("Viernes");
        }
        a.setDias(dias);
        //leer las horas
        Date horaInicioDate = (Date) vista.spnHoraIni.getValue();
        Date horaFinalDate = (Date) vista.spnHoraFin.getValue();
        //convertir Date a LocalTime
        LocalTime horaInicio = horaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime(); //zoneId define en qué zona horaria se encuentra tu sistema.
        LocalTime horaFin = horaFinalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        a.setHorainicio(horaInicio);
        a.setHorariofinal(horaFin);
        return a;
    }

    public static Horario LeerDatosCurso(EdtHorario vista) {
        Horario a = new Horario();
        a.setCod(vista.txtCod.getText());
        a.setCodCurso(vista.cbxCodCurso.getSelectedItem().toString());
        a.setCodProfesor(vista.cbxDniProf.getSelectedItem().toString());
        a.setCodSalon(vista.cbxCodSalon.getSelectedItem().toString());
        a.setGrado(vista.txtGrado.getText());
        a.setSeccion(vista.txtSeccion.getText());
        a.setNombreProfesor(vista.txtNombreProf.getText());
        a.setNombreCurso(vista.txtNombreCurso.getText());
        List<String> dias = new ArrayList<>();
        if (vista.chkLunes.isSelected()) {
            dias.add("Lunes");
        }
        if (vista.chkMartes.isSelected()) {
            dias.add("Martes");
        }
        if (vista.chkMier.isSelected()) {
            dias.add("Miércoles");
        }
        if (vista.chkJue.isSelected()) {
            dias.add("Jueves");
        }
        if (vista.chkVie.isSelected()) {
            dias.add("Viernes");
        }
        a.setDias(dias);
        //leer las horas
        Date horaInicioDate = (Date) vista.spnHoraIni.getValue();
        Date horaFinalDate = (Date) vista.spnHoraFin.getValue();
        //convertir Date a LocalTime
        LocalTime horaInicio = horaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime(); //zoneId define en qué zona horaria se encuentra tu sistema.
        LocalTime horaFin = horaFinalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        a.setHorainicio(horaInicio);
        a.setHorariofinal(horaFin);
        return a;
    } //

    public static void LimpiarDatosHorario(RgtHorario vista) {
        vista.txtCod.setText("");
        vista.cbxCodCurso.setSelectedIndex(0);
        vista.cbxCodSalon.setSelectedIndex(0);
        vista.cbxDniProf.setSelectedIndex(0);
        vista.txtGrado.setText("");
        vista.txtNombreCurso.setText("");
        vista.txtNombreProf.setText("");
        vista.txtSeccion.setText("");
        vista.chkLunes.setSelected(false);
        vista.chkMartes.setSelected(false);
        vista.chkMier.setSelected(false);
        vista.chkJue.setSelected(false);
        vista.chkVie.setSelected(false);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 8); //horario predeterminado para registrar 
        cal.set(Calendar.MINUTE, 0);
        Date horaDefecto = cal.getTime();
        vista.spnHoraIni.setValue(horaDefecto);
        vista.spnHoraFin.setValue(horaDefecto);
    }

    public static void LimpiarDatosHorario(EdtHorario vista) {
        vista.txtCod.setText("");
        vista.cbxCodCurso.setSelectedIndex(0);
        vista.cbxCodSalon.setSelectedIndex(0);
        vista.cbxDniProf.setSelectedIndex(0);
        vista.txtGrado.setText("");
        vista.txtNombreCurso.setText("");
        vista.txtNombreProf.setText("");
        vista.txtSeccion.setText("");
        vista.chkLunes.setSelected(false);
        vista.chkMartes.setSelected(false);
        vista.chkMier.setSelected(false);
        vista.chkJue.setSelected(false);
        vista.chkVie.setSelected(false);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 8); //horario predeterminado para registrar 
        cal.set(Calendar.MINUTE, 0);
        Date horaDefecto = cal.getTime();
        vista.spnHoraIni.setValue(horaDefecto);
        vista.spnHoraFin.setValue(horaDefecto);
    } //

    public static void MostrarTablaHorario(RptHorario vista, PilaHorario pila) {
        String titulos[] = {"num", "Código", "Cod. Salón", "Grado", "Sección", "Cod. Curso", "Nom. Curso", "DNI Profesor", "Nom. Prof.", "Días", "Hora Ini.", "Hora Fin."};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
        mt.setRowCount(0); // Limpiar filas antes de agregar nuevas
        for (int i = 0; i < pila.Cantidad(); i++) {
            mt.addRow(pila.obtener(i).Registro(i + 1));
        }
    }

    public static void MostrarTablaHorarioBuscado(RptHorario vista, PilaHorario pila, int posi) {
        String titulos[] = {"num", "Código", "Cod. Salón", "Grado", "Sección", "Cod. Curso", "Nom. Curso", "DNI Profesor", "Nom. Prof.", "Días", "Hora Ini.", "Hora Fin"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        vista.tabla.setModel(mt);

        if (posi >= 0 && posi < pila.Cantidad()) { // Verifica que la posición sea válida
            Horario horario = pila.obtener(posi); // Obtiene el horario por la posición
            mt.addRow(horario.Registro(posi + 1)); // Añade una fila con los datos del horario
        }
    }
    //COMBO BOX 
    public static void LlenarComboDesdeCursos(JComboBox<String> cbx) {
        ListaEnlazadaSimpleCurso listaCursos = AlmacenarCurso.recuperarCurso(); // Recuperar cursos desde archivo
        cbx.removeAllItems();
        cbx.addItem("Seleccione un curso"); // Opción inicial

        NodoSimple actual = listaCursos.ini; 
        while (actual != null) {
            cbx.addItem(actual.curso.getCod()); // Agregar código del curso al ComboBox
            actual = actual.sig; // Avanzar al siguiente nodo
        }
    }

    public static void LlenarComboDesdeSalones(JComboBox<String> cbx) {
        ListaEnlazadaDobleSalon listaSalones = AlmacenarSalon.recuperarSalon(); // Recuperar salones desde archivo
        cbx.removeAllItems();
        cbx.addItem("Seleccione un salón"); // Opción inicial

        NodoDoble actual = listaSalones.ini; // Supongo que usas nodos en tu lista
        while (actual != null) {
            cbx.addItem(actual.salon.getCod()); // Agregar código del salón al ComboBox
            actual = actual.sig; // Avanzar al siguiente nodo
        }
    }

    public static void LlenarComboDesdeProfesores(JComboBox<String> cbx) {
        ListaCircularProfesor listaProfesores = AlmacenarProfesores.recuperarProfesores(); // Recuperar lista desde archivo
        cbx.removeAllItems();
        cbx.addItem("Seleccione un profesor"); // Opción inicial

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
}
