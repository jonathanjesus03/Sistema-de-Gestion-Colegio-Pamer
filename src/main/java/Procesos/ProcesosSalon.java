/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import EstructuraListaDoble.ListaEnlazadaDobleSalon;
import EstructuraListaDoble.NodoDoble;
import Modelo.Salon;
import Vista.EdtSalon;
import Vista.RgtSalon;
import Vista.RptSalon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cr075
 */
public class ProcesosSalon {
    public static void Presentacion(RgtSalon vista){
        vista.setTitle("Registro de Salón del Colegio Pamer");
        vista.setVisible(true);
    }
    public static void Presentacion(RptSalon vista){
        vista.setTitle("Reporte de Salón del Colegio Pamer");
        vista.setVisible(true);
    }
    public static void Presentacion(EdtSalon vista){
        vista.setTitle("Editar Salón del Colegio Pamer");
        vista.setVisible(true);
    }
    public static Salon LeerDatosSalon(RgtSalon vista) {
        Salon a = new Salon();
        a.setCod(vista.txtCod.getText());
         try {
        a.setCap(Integer.parseInt(vista.txtCapa.getText()));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(vista, "Ingrese un valor numérico válido en Capacidad", "Error", JOptionPane.ERROR_MESSAGE);
        vista.txtCapa.setText(""); // Limpiar el campo de capacidad
        return null; // Devuelve null para indicar que hubo un error en la entrada
    }
        a.setCap(Integer.parseInt(vista.txtCapa.getText()));
        a.setEstado(vista.cbxEstado.getSelectedItem().toString());
        a.setNombre(vista.cbxNom.getSelectedItem().toString());
        a.setSeccion(vista.cbxSeccion.getSelectedItem().toString());
        a.setUbi(vista.cbxUbi.getSelectedItem().toString());
        return a;
    }
     public static Salon LeerDatosSalon(EdtSalon vista) {
          Salon a = new Salon();
        a.setCod(vista.txtCod.getText());
         try {
        a.setCap(Integer.parseInt(vista.txtCapa.getText()));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(vista, "Ingrese un valor numérico válido en Capacidad", "Error", JOptionPane.ERROR_MESSAGE);
        vista.txtCapa.setText(""); // Limpiar el campo de capacidad
        return null; // Devuelve null para indicar que hubo un error en la entrada
    }
        a.setCap(Integer.parseInt(vista.txtCapa.getText()));
        a.setEstado(vista.cbxEstado.getSelectedItem().toString());
        a.setNombre(vista.cbxNom.getSelectedItem().toString());
        a.setSeccion(vista.cbxSeccion.getSelectedItem().toString());
        a.setUbi(vista.cbxUbi.getSelectedItem().toString());
        return a;
    }
      public static void LimpiarDatosSalon(RgtSalon vista) {
       vista.cbxEstado.setSelectedIndex(0);
       vista.cbxNom.setSelectedIndex(0);
       vista.cbxSeccion.setSelectedIndex(0);
       vista.cbxUbi.setSelectedIndex(0);
       vista.txtCapa.setText("");
       vista.txtCod.setText("");
       vista.txtCod.requestFocus();
    }
    public static void LimpiarDatosSalon(EdtSalon vista) {
      vista.cbxEstado.setSelectedIndex(0);
       vista.cbxNom.setSelectedIndex(0);
       vista.cbxSeccion.setSelectedIndex(0);
       vista.cbxUbi.setSelectedIndex(0);
       vista.txtCapa.setText("");
       vista.txtCod.setText("");
       vista.txtCod.requestFocus();
    }
    public static void MostrarTablaSalon(RptSalon vista, ListaEnlazadaDobleSalon lista){
        String titulos[] = {"num","Código","Nombre del Salon", "Sección", "Capacidad", "Ubicación", "Estado"};
        DefaultTableModel mt = (DefaultTableModel) vista.tabla.getModel();
         mt.setRowCount(0); // Limpiar filas antes de agregar nuevas
               int num=0;
       for(NodoDoble aux=lista.ini;aux!=null;aux=aux.sig){ //nodo recorre toda la lista simple enlazada 
           num++;
           mt.addRow(aux.salon.Registro(num)); //el nodo llamas directo a la clase salon con su método registro
       }
    }
    
    public static void MostrarTablaSalonBuscado(RptSalon vista, ListaEnlazadaDobleSalon lista,int posi){
        String titulos[] = {"num","Código","Nombre del Salon", "Sección", "Capacidad", "Ubicación", "Estado"};
        DefaultTableModel mt =  new DefaultTableModel(null,titulos);
        vista.tabla.setModel(mt);
               int num=0,pos=0;
       for(NodoDoble aux=lista.ini;aux!=null;aux=aux.sig,pos++){ //nodo recorre toda la lista simple enlazada 
           num++;
           if(pos==posi){
           mt.addRow(aux.salon.Registro(num)); //el nodo llamas directo a la clase salon con su método registro
           break; //se termina el bucle cuando se encuentra el nodo buscado
       }
       }
    }
}
