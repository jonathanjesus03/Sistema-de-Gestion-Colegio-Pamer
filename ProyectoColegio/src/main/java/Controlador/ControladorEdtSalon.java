/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralSalon;
import EstructuraListaDoble.ListaEnlazadaDobleSalon;
import Modelo.Salon;
import Persistencia.AlmacenarSalon;
import Procesos.Mensajes;
import Procesos.ProcesosSalon;
import Vista.EdtSalon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorEdtSalon implements ActionListener{
     EdtSalon vista;
    ListaEnlazadaDobleSalon lista;
    Salon sa;

    public ControladorEdtSalon(EdtSalon edt) {
        vista=edt;
        lista=AlmacenarSalon.recuperarSalon();
        ProcesosSalon.Presentacion(vista);
        vista.btnCancelar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.txtCod.setEditable(false);
        if(CentralSalon.salonActualizar!=null){
            MostrarDatosSalon(CentralSalon.salonActualizar);
        }
    }
    private void MostrarDatosSalon(Salon sa){
        vista.txtCod.setText(sa.getCod());
        vista.txtCapa.setText(Integer.toString(sa.getCap()));
        switch(sa.getNombre()){
            case "Grado 1°":
                vista.cbxNom.setSelectedIndex(1);
                break;
            case "Grado 2°":
                vista.cbxNom.setSelectedIndex(2);
                break;
            case "Grado 3°":
                vista.cbxNom.setSelectedIndex(3);
                break;
            case "Grado 4°":
                vista.cbxNom.setSelectedIndex(4);
                break;
            case "Grado 5°":
                vista.cbxNom.setSelectedIndex(5);
                break;
            case "Grado 6°":
                vista.cbxNom.setSelectedIndex(6);
                break;
            case "Laboratorio de Química":
                vista.cbxNom.setSelectedIndex(7);
                break;
            case "Laboratorio de Física":
                vista.cbxNom.setSelectedIndex(8);
                break;
            case "Computación":
                vista.cbxNom.setSelectedIndex(9);
                break;
            case "Sala Proyector":
                vista.cbxNom.setSelectedIndex(10);
                break;
            default:
                vista.cbxNom.setSelectedIndex(0);
                break;
        }
        switch(sa.getSeccion()){
             case "A":
                vista.cbxSeccion.setSelectedIndex(1);
                break;
              case "B":
                vista.cbxSeccion.setSelectedIndex(2);
                break;
            default:
                vista.cbxSeccion.setSelectedIndex(0);
                break;
        }
        switch(sa.getUbi()){
            case "Piso A1":
                vista.cbxUbi.setSelectedIndex(1);
                break;
            case "Piso A2":
                vista.cbxUbi.setSelectedIndex(2);
                break;
            case "Piso B1":
                vista.cbxUbi.setSelectedIndex(3);
                break;
            case "Piso B2":
                vista.cbxUbi.setSelectedIndex(4);
                break;
            default:
                vista.cbxUbi.setSelectedIndex(0);
                break;  
        }
        switch(sa.isEstado()){
            case "Activo": vista.cbxEstado.setSelectedIndex(1); break;
            case "Inactivo": vista.cbxEstado.setSelectedIndex(2); break;
            default: vista.cbxEstado.setSelectedIndex(0); break;
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(vista.btnActualizar==e.getSource()){
            if(!vista.txtCod.getText().isEmpty()){ //si no està vacio
            sa = ProcesosSalon.LeerDatosSalon(vista);
             if(vista.txtCapa.getText().isEmpty()){
                Mensajes.mostrarmsj("Ingrese un número.");
                vista.txtCapa.setText("");
            } else {
            lista.actualizar(ControladorReporteSalon.posicionActualizar, sa);
            AlmacenarSalon.GuardarSalon(lista);
            ProcesosSalon.LimpiarDatosSalon(vista);
            //despues de actualizar, la variable estatica se vuelve null para que en reportes no sea referida con el mismo apoderado
            CentralSalon.salonActualizar= null; //se elimina la referencia del alumno que se actualizó
            Mensajes.mostrarmsj("Salón actualizado exitósamente!!");
        }}else {
               Mensajes.mostrarmsj("Ingrese el còdigo del Salón");
            }}
        if(vista.btnCancelar==e.getSource()){
            CentralSalon.salonActualizar=null;
            vista.dispose();
        }
    }
    
}
