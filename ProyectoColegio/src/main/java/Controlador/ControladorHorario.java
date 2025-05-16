/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraListaCircular.ListaCircularProfesor;
import EstructuraListaDoble.ListaEnlazadaDobleSalon;
import EstructuraListaSimple.ListaEnlazadaSimpleCurso;
import EstructuraPila.PilaHorario;
import Modelo.Curso;
import Modelo.Horario;
import Modelo.Profesor;
import Modelo.Salon;
import Persistencia.*;
import Procesos.Mensajes;
import Procesos.ProcesosHorario;
import Vista.RgtHorario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorHorario implements ActionListener {

    PilaHorario lista;
    Horario ho;
    RgtHorario vista;
    //listas de Profesor,Salon y Curso
    ListaCircularProfesor listaprof = AlmacenarProfesores.recuperarProfesores();
    ListaEnlazadaDobleSalon listasalon = AlmacenarSalon.recuperarSalon();
    ListaEnlazadaSimpleCurso listacurso = AlmacenarCurso.recuperarCurso();

    public ControladorHorario(RgtHorario rgt) {
        vista = rgt;
        lista=new PilaHorario();
        ProcesosHorario.Presentacion(vista);
        lista = AlmacenarHorario.recuperarHorario();
        vista.btnCancelar.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.btnVerificarCurso.addActionListener(this);
        vista.btnVerificarProf.addActionListener(this);
        vista.btnVerificarSalon.addActionListener(this);
        vista.txtGrado.setEditable(false);
        vista.txtNombreCurso.setEditable(false);
        vista.txtNombreProf.setEditable(false);
        vista.txtSeccion.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnGuardar == e.getSource()) {
            if (!vista.txtCod.getText().isEmpty()) {
                if (vista.cbxCodSalon.getSelectedIndex() > 0) {
                    if (vista.cbxCodCurso.getSelectedIndex() > 0) {
                        if (vista.cbxDniProf.getSelectedIndex() > 0) {
                            // Leer los datos del horario
                            ho = ProcesosHorario.LeerDatosHorario(vista);
                            // Agregar el horario a la pila y guardar
                            lista.agregar(ho);
                            AlmacenarHorario.GuardarHorario(lista);
                            Mensajes.mostrarmsj("Horario registrado exitosamente!!");
                            // Limpiar el formulario
                            ProcesosHorario.LimpiarDatosHorario(vista);
                        } else {
                            Mensajes.mostrarmsj("Seleccione el número de documento del profesor.");
                        }
                    } else {
                        Mensajes.mostrarmsj("Seleccione el código del curso.");
                    }
                } else {
                    Mensajes.mostrarmsj("Seleccione el código del salón.");
                }
            } else {
                Mensajes.mostrarmsj("Ingrese el código del Horario.");
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

            if (vista.btnCancelar == e.getSource()) {
                vista.dispose();
            }
        }

    }


