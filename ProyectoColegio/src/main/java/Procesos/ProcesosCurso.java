/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import EstructuraListaSimple.NodoSimple;
import EstructuraListaSimple.ListaEnlazadaSimpleCurso;
import Modelo.Curso;
import Vista.EdtCursos;
import Vista.RgtCursos;
import Vista.RptCurso;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cr075
 */
public class ProcesosCurso {
    public static void Presentacion(RgtCursos vista){
        vista.setTitle("Registro de Curso del Colegio Pamer");
        vista.setVisible(true);
    }
    public static void Presentacion(RptCurso vista){
        vista.setTitle("Reporte de Curso del Colegio Pamer");
        vista.setVisible(true);
    }
    public static void Presentacion(EdtCursos vista){
        vista.setTitle("Editar Curso del Colegio Pamer");
        vista.setVisible(true);
    }
    public static Curso LeerDatosCurso(RgtCursos vista) {
        Curso a = new Curso();
        a.setCod(vista.txtCod.getText());
        a.setNombre(vista.txtNombre.getText());
        return a;
    }
     public static Curso LeerDatosCurso(EdtCursos vista) {
        Curso a = new Curso();
        a.setNombre(vista.txtNombre.getText());
        return a;
    } //
      public static void LimpiarDatosCurso(RgtCursos vista) {
       vista.txtCod.setText("");
       vista.txtNombre.setText("");
    }
    public static void LimpiarDatosCurso(EdtCursos vista) {
       vista.txtCod.setText("");
       vista.txtNombre.setText("");
    } //
    public static void MostrarTablaCursos(RptCurso vista, ListaEnlazadaSimpleCurso lista){
        String titulos[] = {"num","Código", "Nombre del curso"};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
         mt.setRowCount(0); // Limpiar filas antes de agregar nuevas
               int num=0;
       for(NodoSimple aux=lista.ini;aux!=null;aux=aux.sig){ //nodo recorre toda la lista simple enlazada 
           num++;
           mt.addRow(aux.curso.Registro(num)); //el nodo llamas directo a la clase salon con su método registro
       }
    }
    
    public static void MostrarTablaCursoBuscado(RptCurso vista, ListaEnlazadaSimpleCurso lista,int posi){
        String titulos[] = {"num","Código", "Nombre del curso"};
        DefaultTableModel mt =  new DefaultTableModel(null,titulos);
        vista.tabla.setModel(mt);
               int num=0,pos=0;
       for(NodoSimple aux=lista.ini;aux!=null;aux=aux.sig,pos++){ //nodo recorre toda la lista simple enlazada 
           num++;
           if(pos==posi){
           mt.addRow(aux.curso.Registro(num)); //el nodo llamas directo a la clase salon con su método registro
           break; //se termina el bucle cuando se encuentra el nodo buscado
       }
       }
    }
}
