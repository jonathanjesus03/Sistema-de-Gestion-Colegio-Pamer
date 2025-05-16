/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

/**
 *
 * @author cr075
 */
public class ControlMenu implements ActionListener {

    FrmMenu menu;

    public ControlMenu(FrmMenu men) {
        menu = men;
        menu.LstAlumMatr.addActionListener(this);
        menu.itemCursosProfesor.addActionListener(this);
        menu.itemEdtAlumno.addActionListener(this);
        menu.itemEdtCurso.addActionListener(this);
        menu.itemEdtHorario.addActionListener(this);
        menu.itemEdtMatricula.addActionListener(this);
        menu.itemEdtProfesor.addActionListener(this);
        menu.itemEdtSalon.addActionListener(this);
        menu.itemElgrSinMatAlumno.addActionListener(this);
        menu.itemRgtAlumno.addActionListener(this);
        menu.itemRgtApoderado.addActionListener(this);
        menu.itemRgtCursos.addActionListener(this);
        menu.itemRgtHorario.addActionListener(this);
        menu.itemRgtMatricula.addActionListener(this);
        menu.itemRgtProfesor.addActionListener(this);
        menu.itemRgtSalon.addActionListener(this);
        menu.itemRptAlumno.addActionListener(this);
        menu.itemRptApoderado.addActionListener(this);
        menu.itemRptCurso.addActionListener(this);
        menu.itemRptHorario.addActionListener(this);
        menu.itemRptMatricula.addActionListener(this);
        menu.itemRptProfesor.addActionListener(this);
        menu.itemRptSalon.addActionListener(this);
        menu.itemEdtApoderado.addActionListener(this);
    }

    private void mostrarFrame(JInternalFrame frame) { //llama a la clase de los contenedores
        menu.dspEscritorio.removeAll(); //ventana que contiene contenedores, dspEscritorio
        menu.dspEscritorio.add(frame); //añadir el contenedor a la ventanamenu.dspEscritorio.removeAll();
        menu.dspEscritorio.repaint();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //menu-Registrar
        if (menu.itemRgtHorario == e.getSource()) {
            RgtHorario hora = new RgtHorario();
            hora.configurarSpinnerHora();
            mostrarFrame(hora); //llamo al método mostrar frame para mostrarlo 
            ControladorHorario control=new ControladorHorario(hora);
        }
        if (menu.itemRgtAlumno == e.getSource()) {
            RgtAlumno alum = new RgtAlumno();
            alum.AgruparBotones();
            mostrarFrame(alum); //llamo al método mostrar frame para mostrarlo 
            ControladorAlumno control = new ControladorAlumno(alum);
        }
        if (menu.itemRgtApoderado == e.getSource()) {
            RgtApoderado apo = new RgtApoderado();
            mostrarFrame(apo); //llamo al método mostrar frame para mostrarlo 
            ControladorApoderado contro=new ControladorApoderado(apo); 
        }
          if (menu.itemRgtSalon == e.getSource()) {
            RgtSalon sal = new RgtSalon();
            mostrarFrame(sal); //llamo al método mostrar frame para mostrarlo 
            ControladorSalon control=new ControladorSalon(sal);
        }
        if (menu.itemRgtCursos == e.getSource()) {
            RgtCursos cur = new RgtCursos();
            mostrarFrame(cur); //llamo al método mostrar frame para mostrarlo 
            ControladorCurso control=new ControladorCurso(cur);
        }
        if (menu.itemRgtProfesor == e.getSource()) {
            RgtProfesor prof = new RgtProfesor();
            prof.AgruparBotones();
            mostrarFrame(prof); //llamo al método mostrar frame para mostrarlo 
            ControladorProfesor ctrl = new ControladorProfesor(prof);
        }
        if (menu.itemElgrSinMatAlumno == e.getSource()) {
            AlumnosinMatri elegir = new AlumnosinMatri();
            mostrarFrame(elegir); //llamo al método mostrar frame para mostrarlo 
            ControladorAlumnosSinMatricular control=new ControladorAlumnosSinMatricular(elegir);
        }
        if (menu.itemRgtMatricula == e.getSource()) {
            RgtMatricula mat = new RgtMatricula();
            mostrarFrame(mat); //llamo al método mostrar frame para mostrarlo 
            ControladorMatricula control=new ControladorMatricula(mat);
        }

        //menu-Listar
        if (menu.LstAlumMatr == e.getSource()) {
            ListaAlumnoMatriculado matr = new ListaAlumnoMatriculado();
            mostrarFrame(matr); //llamo al método mostrar frame para mostrarlo 
            ControladorListaAlumnoMatriculado control=new ControladorListaAlumnoMatriculado(matr);   
        }
        if (menu.itemCursosProfesor == e.getSource()) {
            ListaCursosProfesor cpr = new ListaCursosProfesor();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorListaCursoProfesor control=new ControladorListaCursoProfesor(cpr);
        }
        //reporte-Reportes
        if (menu.itemRptAlumno == e.getSource()) {
            RptAlumno cpr = new RptAlumno();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorReporteAlumno control = new ControladorReporteAlumno(cpr);
            //ControlCliente control=new ControlCliente(c);   
        }
        if (menu.itemRptApoderado == e.getSource()) {
            RptApoderado cpr = new RptApoderado();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorReporteApoderado control=new ControladorReporteApoderado(cpr);
        }
        if (menu.itemRptCurso == e.getSource()) {
            RptCurso cpr = new RptCurso();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorReporteCurso control=new ControladorReporteCurso(cpr);
           }
        if (menu.itemRptSalon == e.getSource()) {
            RptSalon cpr = new RptSalon();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorReporteSalon control=new ControladorReporteSalon(cpr);
        }
        if (menu.itemRptProfesor == e.getSource()) {
            RptProfesor cpr = new RptProfesor();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorReporteProfesor control = new ControladorReporteProfesor(cpr);   
        }
        if (menu.itemRptMatricula == e.getSource()) {
            RptMatricula cpr = new RptMatricula();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorRptMatricula control=new ControladorRptMatricula(cpr);  
        }
        if (menu.itemRptHorario == e.getSource()) {
            RptHorario cpr = new RptHorario();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorRptHorario control=new ControladorRptHorario(cpr);
        }
        //reporte-actualizar
        if (menu.itemEdtAlumno == e.getSource()) {
            EdtAlumno cpr = new EdtAlumno();
            cpr.AgruparBotones();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorEdtAlumno control = new ControladorEdtAlumno(cpr);
        }
        if (menu.itemEdtApoderado == e.getSource()) {
            EdtApoderado cpr = new EdtApoderado();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorEdtApoderado control=new ControladorEdtApoderado(cpr);
        }
         if (menu.itemEdtProfesor == e.getSource()) {
            EdtProfesor cpr = new EdtProfesor();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorEdtProfesor ctrl = new ControladorEdtProfesor(cpr);
         }
         if (menu.itemEdtSalon == e.getSource()) {
            EdtSalon cpr = new EdtSalon();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorEdtSalon control=new ControladorEdtSalon(cpr);
         }
        if (menu.itemEdtCurso == e.getSource()) {
            EdtCursos cpr = new EdtCursos();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorEdtCurso control=new ControladorEdtCurso(cpr);
        }
        if (menu.itemEdtHorario == e.getSource()) {
            EdtHorario cpr = new EdtHorario();
            cpr.configurarSpinnerHora();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorEdtHorario control=new ControladorEdtHorario(cpr);
        }
        if (menu.itemEdtMatricula == e.getSource()) {
            EdtMatricula cpr = new EdtMatricula();
            mostrarFrame(cpr); //llamo al método mostrar frame para mostrarlo 
            ControladorEdtMatricula control=new ControladorEdtMatricula(cpr); 
        }
    }

}
