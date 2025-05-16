/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralAlumnoMatricular;
import EstructuraArboles.ArbolReferidos;
import EstructuraArboles.NodoReferidos;
import EstructuraArreglo.ArregloAlumnos;
import EstructuraCola.ColaMatricula;
import Modelo.Alumno;
import Modelo.Matricula;
import Modelo.Referidos;
import Persistencia.AlmacenarReferidos;
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
    ArbolReferidos arbolreferidos=AlmacenarReferidos.recuperarReferidos();
    
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
        vista.btn_referido.addActionListener(this);
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
                mat=ProcesosMatricula.LeerDatosHorario(vista);
                mat.setAlumno(CentralAlumnoMatricular.alumnoAMatricular);
                mat.RegistrarMatriculaAlumno(listaAlum);
                AlmacenarAlumnos.GuardarAlumnos(listaAlum);
                if (vista.togTraslado.isSelected()) {
                    mat.setEsTraslado(true);
                    if(vista.togTraslado.isSelected() && vista.txtColePre.getText().isEmpty()) {
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
                
                AlmacenarReferidos.GuardarReferidos(arbolreferidos);
            } else {
                Mensajes.mostrarmsj("Ingrese el código de Matrícula");
            }
        }
        
        if(e.getSource() == vista.btn_referido){
            String dniReferidor = Mensajes.introducirmsj("Ingrese el dni del alumno referidor");
            Matricula matriculaReferido = lista.obtenerporDNI(dniReferidor);
         
            if(dniReferidor != null){
                if(matriculaReferido == null){
                    Mensajes.mostrarmsj("No se encontro a un alumno matriculado con el DNI: "+dniReferidor);
                    return;
                }
            
            int mensajeConf = Mensajes.confirmarmsj("¿Seguro que deséa aplicar un nuevo referidor?", "Confirmación");
            if(mensajeConf == 1 || mensajeConf == -1){ return; }
                    
            lista.obtenerporDNI(dniReferidor).aplicarDescuento(0.05);
                
            Referidos referido =  new Referidos();
            Alumno alumnoReferido = CentralAlumnoMatricular.alumnoAMatricular;
            
            referido.setApellidos(alumnoReferido.getApellidos());
            referido.setCont(alumnoReferido.getCont());
            referido.setDep(alumnoReferido.getDep());
            referido.setDisca(alumnoReferido.getDisca());
            referido.setDistri(alumnoReferido.getDisca());
            referido.setDniDelReferidor(dniReferidor);
            referido.setEstado(alumnoReferido.getEstado());
            referido.setFecha(alumnoReferido.getFecha());
            referido.setLengua(alumnoReferido.getLengua());
            referido.setNdoc(alumnoReferido.getNdoc());
            referido.setNombres(alumnoReferido.getNombres());
            referido.setOtrascond(alumnoReferido.getOtrascond());
            referido.setPais(alumnoReferido.getPais());
            referido.setSexo(alumnoReferido.getSexo());
            referido.setTipodoc(alumnoReferido.getTipodoc());
            arbolreferidos.Agregar(new NodoReferidos(referido), referido);
            System.out.println(referido.getNombreCompleto());
            vista.btn_referido.setText("|        SI");
            vista.btn_referido.setEnabled(false);
            }
        }
        

        if (vista.btnCancelar == e.getSource()) {
            CentralAlumnoMatricular.alumnoAMatricular = null;
            vista.dispose();
        }
    }

}
