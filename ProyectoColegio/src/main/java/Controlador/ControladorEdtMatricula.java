/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralMatricula;
import EstructuraCola.ColaMatricula;
import Modelo.Matricula;
import Persistencia.AlmacenarMatricula;
import Procesos.Mensajes;
import Procesos.ProcesosMatricula;
import Vista.EdtMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author cr075
 */
public class ControladorEdtMatricula implements ActionListener{
    EdtMatricula vista;
    ColaMatricula lista;
    Matricula mat;
    public ControladorEdtMatricula(EdtMatricula edt) {
        vista=edt;
        lista=AlmacenarMatricula.recuperarMatricula();
        ProcesosMatricula.Presentacion(vista);
        vista.btnActualizar.addActionListener(this);
         vista.btnCancelar.addActionListener(this);
         if (CentralMatricula.matriculaActualizar != null) {
            ProcesosMatricula.MostrarDatosAlumno( CentralMatricula.matriculaActualizar.getAlumno(), vista);
            MostrarDatosMatricula(CentralMatricula.matriculaActualizar);
        }
        ProcesosMatricula.NoEditarDatosAlumno(vista);
        vista.txtCod.setEditable(false);
    }
    
    private void MostrarDatosMatricula(Matricula mat){
        vista.txtCod.setText(mat.getCod());
        if (mat.isEsAntiguo()) {
            vista.togAntiguo.setSelected(true);
        } else {
            vista.togAntiguo.setSelected(false);
        }

        if (mat.isEsNuevo()) {
            vista.togNuevo.setSelected(true);
        } else {
            vista.togNuevo.setSelected(false);
        }

        if (mat.isEsTraslado()) { 
            vista.togTraslado.setSelected(true);
            vista.txtColePre.setText(mat.getColegiopre());
        } else {
            vista.togTraslado.setSelected(false);
            vista.txtColePre.setText(""); 
        }
        // Formatear la fecha antes de mostrarla
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        vista.txtFechaMat.setText(mat.getFecha().format(formatter));
        switch(mat.getGrado()){
            case "Grado 1°" : vista.cbxGrado.setSelectedIndex(0); break;
            case "Grado 2°" : vista.cbxGrado.setSelectedIndex(1); break;
            case "Grado 3°" : vista.cbxGrado.setSelectedIndex(2); break;
            case "Grado 4°" : vista.cbxGrado.setSelectedIndex(3); break;
            case "Grado 5°" : vista.cbxGrado.setSelectedIndex(4); break;
            case "Grado 6°" : vista.cbxGrado.setSelectedIndex(5); break;
        }
        switch(mat.getSeccion()){
            case "A": vista.cbxSeccion.setSelectedIndex(0); break;
            case "B": vista.cbxSeccion.setSelectedIndex(1); break;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.btnActualizar==e.getSource()){
             mat = ProcesosMatricula.LeerDatosHorario(vista);
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
                mat.setAlumno(CentralMatricula.matriculaActualizar.getAlumno());
                lista.actualizarPorPosicion(ControladorRptMatricula.posicionActualizar, mat);
                AlmacenarMatricula.GuardarMatricula(lista);
                Mensajes.mostrarmsj("Matrícula actualizada exitósamente");
                ProcesosMatricula.LimpiarDatosHorario(vista);
                CentralMatricula.matriculaActualizar=null;
        }
        if(vista.btnCancelar==e.getSource()){
            CentralMatricula.matriculaActualizar=null;
            vista.dispose();
        }
    }
    
}
