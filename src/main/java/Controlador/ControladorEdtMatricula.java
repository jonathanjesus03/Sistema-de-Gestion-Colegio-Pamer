/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralMatricula;
import EstructuraArboles.ArbolReferidos;
import EstructuraArboles.NodoReferidos;
import EstructuraCola.ColaMatricula;
import Modelo.Matricula;
import Modelo.Referidos;
import Persistencia.AlmacenarMatricula;
import Persistencia.AlmacenarReferidos;
import Procesos.Mensajes;
import Procesos.ProcesosMatricula;
import Vista.EdtMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Messager;

/**
 *
 * @author cr075
 */
public class ControladorEdtMatricula implements ActionListener{
    EdtMatricula vista;
    ColaMatricula lista;
    ArbolReferidos arbolReridos;
    Matricula mat;
    public ControladorEdtMatricula(EdtMatricula edt) {
        vista=edt;
        lista=AlmacenarMatricula.recuperarMatricula();
        arbolReridos = AlmacenarReferidos.recuperarReferidos();
        ProcesosMatricula.Presentacion(vista);
        vista.btnActualizar.addActionListener(this);
         vista.btnCancelar.addActionListener(this);
         vista.btn_referido.addActionListener(this);
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
                
                AlmacenarReferidos.GuardarReferidos(arbolReridos);
        }
        if(e.getSource() == vista.btn_referido){
            String codReferidor = Mensajes.introducirmsj("Ingrese el codigo de la matricula del referidor:");
            if(codReferidor != null){
                //Matricula del quien a referido a otro alumno
                Matricula matriculaReferidor = lista.obtenerporCod(codReferidor);
                if(matriculaReferidor == null){
                    Mensajes.mostrarmsj("No se encontró ninguna matricula con ese codigo");
                    return;
                }
                
                //Eliminar anterior referido
                System.out.println(CentralMatricula.matriculaActualizar.getAlumno().getNdoc());

                Referidos referido = arbolReridos.BuscarporDNI(CentralMatricula.matriculaActualizar.getAlumno().getNdoc()).getReferido();
                if(referido != null){
                    
                    int mensajeConf = Mensajes.confirmarmsj("¿Seguro que deséa cambiar Referidor de este usuario?", "Confirmación");
                    if(mensajeConf == 1 || mensajeConf == -1){ return; }
                    lista.obtenerporDNI(referido.getDniDelReferidor()).aplicarDescuento(1.05);

                    arbolReridos.BuscarporDNI(CentralMatricula.matriculaActualizar.getAlumno().getNdoc())
                            .getReferido()
                            .setDniDelReferidor(matriculaReferidor.getAlumno().getNdoc());
                    System.out.println(referido.getNombreCompleto());
                }else{
                    int mensajeConf = Mensajes.confirmarmsj("¿Seguro que deséa asignar un Referidor de este usuario?", "Confirmación");
                    if(mensajeConf == 1 || mensajeConf == -1){ return; }
                    
                    referido =  new Referidos();
                    referido.setApellidos(matriculaReferidor.getAlumno().getApellidos());
                    referido.setCont(matriculaReferidor.getAlumno().getCont());
                    referido.setDep(matriculaReferidor.getAlumno().getDep());
                    referido.setDisca(matriculaReferidor.getAlumno().getDisca());
                    referido.setDistri(matriculaReferidor.getAlumno().getDisca());
                    referido.setDniDelReferidor(matriculaReferidor.getAlumno().getNdoc());
                    referido.setEstado(matriculaReferidor.getAlumno().getEstado());
                    referido.setFecha(matriculaReferidor.getAlumno().getFecha());
                    referido.setLengua(matriculaReferidor.getAlumno().getLengua());
                    referido.setNdoc(matriculaReferidor.getAlumno().getNdoc());
                    referido.setNombres(matriculaReferidor.getAlumno().getNombres());
                    referido.setOtrascond(matriculaReferidor.getAlumno().getOtrascond());
                    referido.setPais(matriculaReferidor.getAlumno().getPais());
                    referido.setSexo(matriculaReferidor.getAlumno().getSexo());
                    referido.setTipodoc(matriculaReferidor.getAlumno().getTipodoc());

                    arbolReridos.Agregar(new NodoReferidos(referido), referido);
                    System.out.println(referido.getNombreCompleto());
                }
                
                //Aplicar descuento
                lista.obtenerporCod(codReferidor).aplicarDescuento(0.05);
            }
        }
        if(vista.btnCancelar==e.getSource()){
            CentralMatricula.matriculaActualizar=null;
            vista.dispose();
        }
    }
    
}
