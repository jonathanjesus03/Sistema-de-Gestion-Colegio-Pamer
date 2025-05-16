/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraListaCircular.ListaCircularProfesor;
import EstructuraListaCircular.Nodo;
import Modelo.Profesor;
import Persistencia.AlmacenarProfesores;
import Procesos.Mensajes;
import Procesos.ProcesosProfesor;
import Vista.RgtProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Samsung
 */
public class ControladorProfesor extends JFrame implements ActionListener{
    Profesor profe;
    ListaCircularProfesor lista;
    RgtProfesor vista;

    public ControladorProfesor(RgtProfesor f2){
        vista = f2;
        vista.btnRegistrar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.btn_certificados.addActionListener(this);
        vista.btn_curriculum.addActionListener(this);
        lista = new ListaCircularProfesor();
        lista = AlmacenarProfesores.recuperarProfesores();
        ProcesosProfesor.Presentacion(vista);
        vista.AgruparBotones();
        ConfigurarRadioButtons();
    }
    
    private void ConfigurarRadioButtons(){
        vista.rbtnMas.addActionListener(this);
        vista.rbtnFem.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnRegistrar){
            profe = ProcesosProfesor.LeerDatosProfesor(vista);
            lista.InsertarAlFinal(new Nodo(profe));
            AlmacenarProfesores.GuardarProfesores(lista);
            ProcesosProfesor.LimpiarDatosProfesor(vista);
            
            
            Mensajes.mostrarmsj("Profesor registrado exitósamente!!");
            
        }else if(e.getSource() == vista.btn_curriculum){
            JFileChooser filechooser = new JFileChooser();
            filechooser.setDialogTitle("Elige un archivo pdf o word para subir el curriculum");
            
            filechooser.setFileFilter(new FileNameExtensionFilter("Archivos pdf y word.", "pdf","doc","docx"));
            
            int result = filechooser.showOpenDialog(this);
            
            if(result == JFileChooser.APPROVE_OPTION){
                File ArchivoCu = filechooser.getSelectedFile();
                
                File CarpetaCu = new File("Curriculums");
                
                if(!CarpetaCu.exists()){
                    CarpetaCu.mkdir();
                }
                
                File ArchivoDestino = new File(CarpetaCu,ArchivoCu.getName());
                try {
                    Files.copy(ArchivoCu.toPath(), ArchivoDestino.toPath());
                    JOptionPane.showMessageDialog(this, "Archivo guardado !EXISTOSAMENTE! en: "+ArchivoDestino.getAbsolutePath());
                    vista.check_curriculum.setSelected(true);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ocurrio un problema al subir el archivo: "+ex.getMessage());
                    profe.setCurriculum(false);
                }
            }
            
        }else if(e.getSource() == vista.btn_certificados){
            JFileChooser filechooser = new JFileChooser();
        
            filechooser.setDialogTitle("Elige un archivo pdf o word para subir el certificado");
            
            filechooser.setFileFilter(new FileNameExtensionFilter("Archivos pdf y word.", "pdf","doc","docx"));
            
            int result = filechooser.showOpenDialog(this);
            
            if(result == JFileChooser.APPROVE_OPTION){
                File ArchivoCe = filechooser.getSelectedFile();
                
                File CarpetaCe = new File("Certificados");
                
                if(!CarpetaCe.exists()){
                    CarpetaCe.mkdir();
                }
                
                File ArchivoDestino = new File(CarpetaCe,ArchivoCe.getName());
                try {
                    Files.copy(ArchivoCe.toPath(), ArchivoDestino.toPath());
                    JOptionPane.showMessageDialog(this, "Archivo guardado !EXISTOSAMENTE! en: "+ArchivoDestino.getAbsolutePath());
                    vista.check_certificado.setSelected(true);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ocurrio un problema al subir el archivo: "+ex.getMessage());
                    profe.setCertificados(false);
                }
                
        }else if(e.getSource() == vista.btnCancelar){
            vista.dispose();
            }
        }
    }
}    
    

