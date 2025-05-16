/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralApoderado;
import EstructuraArrayList.ArrayListApoderado;
import Modelo.Apoderado;
import Persistencia.AlmacenarApoderado;
import Procesos.Mensajes;
import Procesos.ProcesosApoderado;
import Vista.EdtApoderado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author cr075
 */
public class ControladorEdtApoderado implements ActionListener{
   EdtApoderado vista;
    ArrayListApoderado lista;
    Apoderado a;

    public ControladorEdtApoderado(EdtApoderado edt) {
        vista=edt;
        lista = new ArrayListApoderado();
        lista = AlmacenarApoderado.recuperarApoderado();
        ProcesosApoderado.Presentacion(vista);
        vista.btnActualizar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        if(CentralApoderado.apoderadoActualizar!=null){
            IntroducirDatosApoderado(CentralApoderado.apoderadoActualizar);
        }
        vista.txtNdocA.setEditable(false);
        vista.txtNumDoc.setEditable(false);
    }
    private void IntroducirDatosApoderado(Apoderado a){
        vista.txtNumDoc.setText(a.getNdoc());
        vista.txtNom.setText(a.getNombres());
        vista.txtCorreo.setText(a.getCont());
        vista.txtNdocA.setText(a.getNdocalum());
        vista.txtCelu.setText(a.getCelu());
                vista.txtApe.setText(a.getApellidos());
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
          switch (a.getRelacion()) {
            case "Padre":
                vista.cbxRelacion.setSelectedIndex(1);
                break;
            case "Madre":
                vista.cbxRelacion.setSelectedIndex(2);
                break;
            case "Otro Parentesco":
                vista.cbxRelacion.setSelectedIndex(2);
                break;
            default:
                vista.cbxRelacion.setSelectedIndex(0);
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
        switch (a.getDistrito()) {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.btnActualizar==e.getSource()){
            String dnial=vista.txtNdocA.getText();
            // Leer otros datos, excluyendo txtNdocA
            a = ProcesosApoderado.LeerDatosAlumno(vista);
            a.setNdocalum(dnial);
            lista.actualizarApoderado(ControladorReporteApoderado.posicionActualizar,a);
            AlmacenarApoderado.GuardarApoderado(lista);
            ProcesosApoderado.LimpiarDatosAlumno(vista);
            //despues de actualizar, la variable estatica se vuelve null para que en reportes no sea referida con el mismo apoderado
            CentralApoderado.apoderadoActualizar = null;
            Mensajes.mostrarmsj("Apoderado actualizado exitósamente!!");
        }
        if(vista.btnCancelar==e.getSource()){
            CentralApoderado.apoderadoActualizar=null;
            vista.dispose();
        }
    } 
}
