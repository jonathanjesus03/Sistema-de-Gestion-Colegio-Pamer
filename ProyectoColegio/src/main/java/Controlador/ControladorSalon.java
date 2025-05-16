/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import EstructuraListaDoble.ListaEnlazadaDobleSalon;
import EstructuraListaDoble.NodoDoble;
import Modelo.Salon;
import Persistencia.AlmacenarSalon;
import Procesos.Mensajes;
import Procesos.ProcesosSalon;
import Vista.RgtSalon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorSalon implements ActionListener{

    RgtSalon vista;
    Salon a;
    ListaEnlazadaDobleSalon lista;
    NodoDoble nuevo;

    public ControladorSalon(RgtSalon rgt) {
          vista=rgt;
        lista=new ListaEnlazadaDobleSalon();
        ProcesosSalon.Presentacion(vista);
        lista=AlmacenarSalon.recuperarSalon();
        vista.btnCancelar.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
          if(vista.btnGuardar==e.getSource())  {
            if(!vista.txtCod.getText().isEmpty()){ //si no està vacio
              a=ProcesosSalon.LeerDatosSalon(vista);
               if(vista.txtCapa.getText().isEmpty()){
                Mensajes.mostrarmsj("Ingrese un número.");
                vista.txtCapa.setText("");
               }else{
                nuevo=new NodoDoble(a);
                lista.agregaralfinal(nuevo);
                AlmacenarSalon.GuardarSalon(lista);
                Mensajes.mostrarmsj("Salón registrado exitósamente!!");
                ProcesosSalon.LimpiarDatosSalon(vista);  
                        }
            } else {
                Mensajes.mostrarmsj("Ingrese el còdigo del Salón");
            }
        }
        if(vista.btnCancelar==e.getSource()){
            vista.dispose();
        }
    }
    
}
