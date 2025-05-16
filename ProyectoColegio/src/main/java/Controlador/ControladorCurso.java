/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraListaCircular.ListaCircularProfesor;
import EstructuraListaSimple.ListaEnlazadaSimpleCurso;
import EstructuraListaSimple.NodoSimple;
import Modelo.Curso;
import Persistencia.AlmacenarCurso;
import Persistencia.AlmacenarProfesores;
import Procesos.Mensajes;
import Procesos.ProcesosCurso;
import Vista.RgtCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorCurso implements ActionListener {

    Curso cu;
    ListaEnlazadaSimpleCurso lista;
    ListaCircularProfesor listaprof = AlmacenarProfesores.recuperarProfesores();
    RgtCursos vista;
    NodoSimple nuevo;

    public ControladorCurso(RgtCursos cu) {
        vista = cu;
        lista = new ListaEnlazadaSimpleCurso();
        ProcesosCurso.Presentacion(vista);
        lista = AlmacenarCurso.recuperarCurso();
        vista.btnCancelar.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnGuardar == e.getSource()) {
            if (!vista.txtCod.getText().isEmpty()) { //si no està vacio
                cu = ProcesosCurso.LeerDatosCurso(vista);
                    nuevo = new NodoSimple(cu);
                    lista.agregaralfinal(nuevo);
                    AlmacenarCurso.GuardarCurso(lista);
                    Mensajes.mostrarmsj("Curso registrado exitósamente!!");
                    ProcesosCurso.LimpiarDatosCurso(vista);
                } else {
                Mensajes.mostrarmsj("Ingrese el còdigo del Curso");
            }
        }
        if (vista.btnCancelar == e.getSource()) {
            vista.dispose();
        }
    }

}
