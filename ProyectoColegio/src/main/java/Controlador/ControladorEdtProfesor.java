/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralProfesor;
import EstructuraListaCircular.ListaCircularProfesor;
import EstructuraListaCircular.Nodo;
import Modelo.Profesor;
import Persistencia.AlmacenarProfesores;
import Procesos.Mensajes;
import Procesos.ProcesosProfesor;
import Vista.EdtProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Samsung
 */
public class ControladorEdtProfesor implements ActionListener{
    
    EdtProfesor vista;
    ListaCircularProfesor lista;
    Profesor profesor;
    
    public ControladorEdtProfesor(EdtProfesor edt){
        vista = edt;
        lista = new ListaCircularProfesor();
        lista = AlmacenarProfesores.recuperarProfesores();
        Procesos.ProcesosProfesor.Presentacion(vista);
        vista.btnActualizar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.txtDoc.setEditable(false);
        vista.AgruparBotones();
        configurarRadioButtons();
        if (CentralProfesor.ProfesorActualizar != null) {
            IntroducirDatosProfesor(CentralProfesor.ProfesorActualizar);}
    }
    
    private void configurarRadioButtons() {
        vista.rdbMas.addActionListener(this);
        vista.rdbFem.addActionListener(this);
    }
    
    private void IntroducirDatosProfesor(Profesor p){
        vista.txtDoc.setText(p.getNdoc());
        vista.txtNombres.setText(p.getNombres());
        vista.txtFecha.setText(p.getFecha());
        vista.txtContacto.setText(p.getCont());
        vista.txtInstiAnteriores.setText(p.getInstituciones());
        vista.txtApellido.setText(p.getApellidos());
        vista.txtAñosExperiencia.setText(String.valueOf(p.getAños()));
        switch (p.getTipodoc()) {
            case "Dni":
                vista.cbxDoc.setSelectedIndex(1);
                break;
            case "Pasaporte":
                vista.cbxDoc.setSelectedIndex(2);
                break;
            default:
                vista.cbxDoc.setSelectedIndex(0);
                break;
        }
        switch (p.getPais()) {
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
        switch (p.getGrado()) {
            case "1 Grado":
                vista.cbxAcademico.setSelectedIndex(1);
                break;
            case "2 Grado":
                vista.cbxAcademico.setSelectedIndex(2);
                break;
            case "3 Grado":
                vista.cbxAcademico.setSelectedIndex(3);
                break;
            case "4 Grado":
                vista.cbxAcademico.setSelectedIndex(4);
                break;
            case "5 Grado":
                vista.cbxAcademico.setSelectedIndex(5);
                break;
            default:
                vista.cbxAcademico.setSelectedIndex(0);
                break;
        }/*Seleccione, Matemática, Comunicación, Historia, Desarrolllo Personal, Ciencias, Computación*/
        switch (p.getEspeciali()){
            case "Matematica":
                vista.cbxEspecializacion.setSelectedIndex(1);
                break;
            case "Comunicacion":
                vista.cbxEspecializacion.setSelectedIndex(2);
                break;
            case "Historia":
                vista.cbxEspecializacion.setSelectedIndex(3);
                break;
            case "Desarrollo Personal":
                vista.cbxEspecializacion.setSelectedIndex(4);
                break;
            case "Ciencias":
                vista.cbxEspecializacion.setSelectedIndex(5);
                break;
            case "Computacion":
                vista.cbxEspecializacion.setSelectedIndex(6);
                break;
            default:
                throw new AssertionError();
        }
        switch (p.getDispon()){/*Seleccione, 8:00-10:00, 10:00-12:00, 12:00-14:00*/
            case "8:00-10:00":
                vista.cbxDispHoraria.setSelectedIndex(1);
                break;
            case "10:00-12:00":
                vista.cbxDispHoraria.setSelectedIndex(2);
                break;
            case "12:00-14:00":
                vista.cbxDispHoraria.setSelectedIndex(3);
                break;
            default:
                throw new AssertionError();
        }
        
        if (p.getSexo().equals(vista.rdbMas.getText())) { //si es igual a rbtnMas
            vista.rdbMas.setSelected(true); //se selecciona
        } else if (p.getSexo().equals(vista.rdbFem.getText())) {
            vista.rdbFem.setSelected(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnActualizar){
            Nodo actual = lista.buscarNom(CentralProfesor.ProfesorActualizar.getNombreCompleto());
            profesor = ProcesosProfesor.LeerDatosProfesor(vista);
            lista.actualizar(actual, profesor);
            AlmacenarProfesores.GuardarProfesores(lista);
            ProcesosProfesor.LimpiarDatosProfesor(vista);
            CentralProfesor.ProfesorActualizar = null;
            Mensajes.mostrarmsj("Profesor actualizado exitósamente!!");

        }else if(e.getSource() == vista.btnCancelar){
            CentralProfesor.ProfesorActualizar = null;
            vista.dispose();
        }
    }
    
    
    
}
