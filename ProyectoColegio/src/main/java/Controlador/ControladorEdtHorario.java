/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralHorario;
import EstructuraListaCircular.ListaCircularProfesor;
import EstructuraListaDoble.ListaEnlazadaDobleSalon;
import EstructuraListaSimple.ListaEnlazadaSimpleCurso;
import EstructuraPila.PilaHorario;
import Modelo.Curso;
import Modelo.Horario;
import Modelo.Profesor;
import Modelo.Salon;
import Persistencia.AlmacenarCurso;
import Persistencia.AlmacenarHorario;
import Persistencia.AlmacenarProfesores;
import Persistencia.AlmacenarSalon;
import Procesos.Mensajes;
import Procesos.ProcesosHorario;
import Vista.EdtHorario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cr075
 */
public class ControladorEdtHorario implements ActionListener {

    EdtHorario vista;
    Horario ho;
    PilaHorario lista;
     //listas de Profesor,Salon y Curso
    ListaCircularProfesor listaprof = AlmacenarProfesores.recuperarProfesores();
    ListaEnlazadaDobleSalon listasalon = AlmacenarSalon.recuperarSalon();
    ListaEnlazadaSimpleCurso listacurso = AlmacenarCurso.recuperarCurso();
    public ControladorEdtHorario(EdtHorario edt) {
        vista = edt;
        lista = new PilaHorario();
        lista = AlmacenarHorario.recuperarHorario();
        vista.btnActualizar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.btnVerificarCurso.addActionListener(this);
        vista.btnVerificarProf.addActionListener(this);
        vista.btnVerificarSalon.addActionListener(this);
        vista.txtCod.setEditable(false);
        vista.txtGrado.setEditable(false);
        vista.txtNombreCurso.setEditable(false);
        vista.txtNombreProf.setEditable(false);
        vista.txtSeccion.setEditable(false);
        ProcesosHorario.Presentacion(vista);
        if (CentralHorario.horarioActualizar != null) {
            MostrarDatosHorario(CentralHorario.horarioActualizar);
        }
    }

    private void MostrarDatosHorario(Horario ho) {
        vista.txtCod.setText(ho.getCod());
        // Seleccionar el curso en el JComboBox
        if (ho.getCodCurso() != null) {
            vista.cbxCodCurso.setSelectedItem(ho.getCodCurso());
        }

        // Seleccionar el salón en el JComboBox
        if (ho.getCodSalon() != null) {
            vista.cbxCodSalon.setSelectedItem(ho.getCodSalon());
        }

        // Seleccionar el profesor en el JComboBox
        if (ho.getCodProfesor() != null) {
            vista.cbxDniProf.setSelectedItem(ho.getCodProfesor());
        }
        vista.txtGrado.setText(ho.getGrado());
        vista.txtNombreCurso.setText(ho.getNombreCurso());
        vista.txtNombreProf.setText(ho.getNombreProfesor());
        vista.txtSeccion.setText(ho.getSeccion());
        // Marcar los checkboxes según los días seleccionados
        List<String> dias = ho.getDias(); 
        vista.chkLunes.setSelected(dias.contains("Lunes"));
        vista.chkMartes.setSelected(dias.contains("Martes"));
        vista.chkMier.setSelected(dias.contains("Miércoles"));
        vista.chkJue.setSelected(dias.contains("Jueves"));
        vista.chkVie.setSelected(dias.contains("Viernes"));

        // Convertir LocalTime a Date para los spinners
        LocalTime horaInicio = ho.getHorainicio();
        LocalTime horaFin = ho.getHorariofinal();
        Date horaInicioDate = Date.from(horaInicio.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
        Date horaFinDate = Date.from(horaFin.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());

        // Configurar los spinners con las horas
        vista.spnHoraIni.setValue(horaInicioDate);
        vista.spnHoraFin.setValue(horaFinDate);
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if (vista.btnActualizar == e.getSource()) {
            if (vista.cbxCodSalon.getSelectedIndex() > 0) {
                if (vista.cbxCodCurso.getSelectedIndex() > 0) {
                    if (vista.cbxDniProf.getSelectedIndex() > 0) {
                        ho = ProcesosHorario.LeerDatosCurso(vista);
                        lista.actualizar(ControladorRptHorario.posicionActualizar, ho);
                        AlmacenarHorario.GuardarHorario(lista);
                        ProcesosHorario.LimpiarDatosHorario(vista);
                        CentralHorario.horarioActualizar = null;
                        Mensajes.mostrarmsj("Horario actualizado exitósamente!!");
                    } else {
                        Mensajes.mostrarmsj("Seleccione el número de documento del profesor.");
                    }
                } else {
                    Mensajes.mostrarmsj("Seleccione el código del curso.");
                }
            } else {
                Mensajes.mostrarmsj("Seleccione el código del salón.");
            }
        }
            if (vista.btnVerificarSalon == e.getSource()) {
                 if (vista.cbxCodSalon.getSelectedIndex() > 0) {
                    String codSalon = vista.cbxCodSalon.getSelectedItem().toString();
                    if (listasalon.buscarporcod(codSalon)) {
                        Mensajes.mostrarmsj("Salón encontrado en nuestro sistema.");
                        Salon sa = listasalon.buscarporCodyRetornar(codSalon);
                        vista.txtGrado.setEditable(true);
                        vista.txtSeccion.setEditable(true);
                        vista.txtGrado.setText(sa.getNombre());
                        vista.txtSeccion.setText(sa.getSeccion());
                    } else {
                        Mensajes.mostrarmsj("No hay ningún salón registrado con el código " + codSalon);
                        vista.cbxCodSalon.setSelectedIndex(0);
                    }
                } else {
                    Mensajes.mostrarmsj("Seleccione el código del salón.");
                }
            }

            if (vista.btnVerificarCurso == e.getSource()) {
                 if (vista.cbxCodCurso.getSelectedIndex() > 0) {
                    String codCurso = vista.cbxCodCurso.getSelectedItem().toString();
                    if (listacurso.buscarporCod(codCurso)) {
                        Mensajes.mostrarmsj("Curso encontrado en nuestro sistema.");
                        Curso cu = listacurso.buscarporCodyRetornar(codCurso);
                        vista.txtNombreCurso.setEditable(true);
                        vista.txtNombreCurso.setText(cu.getNombre());
                    } else {
                        Mensajes.mostrarmsj("No hay ningún curso registrado con el código " + codCurso);
                        vista.cbxCodCurso.setSelectedIndex(0);
                    }
                } else {
                    Mensajes.mostrarmsj("Seleccione el código del curso.");
                }
            }

            if (vista.btnVerificarProf == e.getSource()) {
                 if (vista.cbxDniProf.getSelectedIndex() > 0) {
                    String codProf = vista.cbxDniProf.getSelectedItem().toString();
                    if (listaprof.buscarDni(codProf)) {
                        Mensajes.mostrarmsj("Profesor encontrado en nuestro sistema.");
                        Profesor pro = listaprof.buscarDniyRetornar(codProf);
                        vista.txtNombreProf.setEditable(true);
                        vista.txtNombreProf.setText(pro.getNombres());
                    } else {
                        Mensajes.mostrarmsj("No hay ningún profesor registrado con el número de documento " + codProf);
                        vista.cbxDniProf.setSelectedIndex(0);
                    }
                } else {
                    Mensajes.mostrarmsj("Seleccione el número de documento del profesor.");
                }
            }

            if(vista.btnCancelar==e.getSource()){
                CentralHorario.horarioActualizar=null;
                vista.dispose();
            }
        }

    }
