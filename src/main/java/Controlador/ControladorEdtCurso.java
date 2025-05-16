/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralCurso;
import EstructuraListaSimple.ListaEnlazadaSimpleCurso;
import Modelo.Curso;
import Persistencia.AlmacenarCurso;
import Procesos.Mensajes;
import Procesos.ProcesosCurso;
import Vista.EdtCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorEdtCurso implements ActionListener {

    EdtCursos vista;
    ListaEnlazadaSimpleCurso lista;
    Curso cu;

    public ControladorEdtCurso(EdtCursos edt) {
        vista = edt;
        lista = AlmacenarCurso.recuperarCurso();
        ProcesosCurso.Presentacion(vista);
        vista.btnCancelar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        if (CentralCurso.cursoActualizar != null) {
            MostrarDatosCurso(CentralCurso.cursoActualizar);
        }
        vista.txtCod.setEditable(false);
    }

    private void MostrarDatosCurso(Curso cu) {
        vista.txtCod.setText(cu.getCod());
        vista.txtNombre.setText(cu.getNombre());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnActualizar == e.getSource()) {
            cu = ProcesosCurso.LeerDatosCurso(vista);
            String cod = vista.txtCod.getText(); //los datos traidos
            // Leer otros datos, excluyendo txtNdocA
            cu = ProcesosCurso.LeerDatosCurso(vista);
            cu.setCod(cod); //se guardan en la misma instancia
            lista.actualizar(ControladorReporteCurso.posicionActualizar, cu);
            AlmacenarCurso.GuardarCurso(lista);
            ProcesosCurso.LimpiarDatosCurso(vista);
            //despues de actualizar, la variable estatica se vuelve null para que en reportes no sea referida con el mismo apoderado
            CentralCurso.cursoActualizar = null;
            Mensajes.mostrarmsj("Curso actualizado exitósamente!!");
        }
        if (vista.btnCancelar == e.getSource()) {
            CentralCurso.cursoActualizar = null;
            vista.dispose();
        }
    }
}
