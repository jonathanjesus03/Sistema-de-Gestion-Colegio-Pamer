/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralAlumnoMatricular;
import EstructuraArreglo.ArregloAlumnos;
import EstructuraCola.ColaMatricula;
import Modelo.Matricula;
import Persistencia.AlmacenarAlumnos;
import Persistencia.AlmacenarMatricula;
import Procesos.Mensajes;
import Procesos.ProcesosMatricula;
import Vista.RgtMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorMatricula implements ActionListener {

    RgtMatricula vista;
    Matricula mat;
    ColaMatricula lista;
    ArregloAlumnos listaAlum=AlmacenarAlumnos.recuperarAlumnos();

    public ControladorMatricula(RgtMatricula rgt) {
        vista = rgt;
        lista = new ColaMatricula();
        lista = AlmacenarMatricula.recuperarMatricula();
        listaAlum.actualizarContador();
        vista.btnCancelar.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.togAntiguo.addActionListener(this);
        vista.togNuevo.addActionListener(this);
        vista.togTraslado.addActionListener(this);
        ProcesosMatricula.Presentacion(vista);
        if (CentralAlumnoMatricular.alumnoAMatricular != null) {
            ProcesosMatricula.MostrarDatosAlumno(CentralAlumnoMatricular.alumnoAMatricular, vista);
        }
        ProcesosMatricula.NoEditarDatosAlumno(vista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnGuardar == e.getSource()) {
            if (!vista.txtCod.getText().isEmpty()) {
                mat = ProcesosMatricula.LeerDatosHorario(vista);
                mat.setAlumno(CentralAlumnoMatricular.alumnoAMatricular);
                mat.RegistrarMatriculaAlumno(listaAlum);
                AlmacenarAlumnos.GuardarAlumnos(listaAlum);
                if (vista.togTraslado.isSelected()) {
                    mat.setEsTraslado(true);
                    if (vista.togTraslado.isSelected() && vista.txtColePre.getText().isEmpty()) {
                        Mensajes.mostrarmsj("Ingrese el colegio precedente para traslados");
                        return;
                    }
                    String colegio = vista.txtColePre.getText();
                    mat.setColegiopre(colegio);
                } else {
                    mat.setEsTraslado(false);
                }
                if (vista.togNuevo.isSelected()) {
                    mat.setEsNuevo(true);
                } else if (vista.togAntiguo.isSelected()) {
                    mat.setEsAntiguo(true);
                }
                lista.colar(mat);
                AlmacenarMatricula.GuardarMatricula(lista);
                Mensajes.mostrarmsj("Matrícula registrada exitósamente");
                ProcesosMatricula.LimpiarDatosHorario(vista);
                CentralAlumnoMatricular.alumnoAMatricular=null;
            } else {
                Mensajes.mostrarmsj("Ingrese el código de Matrícula");
            }
        }

        if (vista.btnCancelar == e.getSource()) {
            CentralAlumnoMatricular.alumnoAMatricular = null;
            vista.dispose();
        }
    }

}
