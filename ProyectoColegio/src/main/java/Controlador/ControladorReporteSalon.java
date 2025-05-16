/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralSalon;
import EstructuraListaDoble.ListaEnlazadaDobleSalon;
import Modelo.Salon;
import Ordenamiento.OrdenarListaDoble;
import Persistencia.AlmacenarSalon;
import Procesos.Mensajes;
import Procesos.ProcesosSalon;
import Vista.RptSalon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorReporteSalon implements ActionListener{
    
    RptSalon vista;
    ListaEnlazadaDobleSalon lista;
    public int posicion = -1;
    public static int posicionActualizar; //valor static propia de la clase

    public ControladorReporteSalon(RptSalon rpt) {
        vista=rpt;
        lista=new ListaEnlazadaDobleSalon();
        lista=AlmacenarSalon.recuperarSalon();
        vista.btnBuscar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        ProcesosSalon.Presentacion(vista);
        ProcesosSalon.MostrarTablaSalon(vista, lista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if (vista.btnBuscar == e.getSource()) {
            String dato = vista.txtCodBuscar.getText();
            posicion = lista.buscarporCod(dato); 
            if (dato.isEmpty()) {//si esta vacío
                ProcesosSalon.MostrarTablaSalon(vista, lista);
            } else {
                if (posicion == -1) {
                    Mensajes.mostrarmsj("No se encontró ningún salón con ese código.");
                    vista.txtCodBuscar.setText("");
                } else {
                    if (!vista.txtCodBuscar.getText().isEmpty()) { //SI NO ESTA VACIO
                        ProcesosSalon.MostrarTablaSalonBuscado(vista, lista, posicion);
                    }
                }
            }
        }
          if (vista.btnEditar == e.getSource()) {
            int filaSeleccionada = vista.tabla.getSelectedRow();
            posicionActualizar = (filaSeleccionada != -1) ? filaSeleccionada : posicion;
            if (posicionActualizar == -1) {
                Mensajes.mostrarmsj("Seleccione un salón a editar.");
            } else {
                CentralSalon.salonActualizar = lista.retornarSalon(posicionActualizar);
                Mensajes.mostrarmsj("Navega por la sección de Reportes en la Opción Actualizar para modificar los datos del Salon " + CentralSalon.salonActualizar.getNombre()+" "+CentralSalon.salonActualizar.getSeccion());
            }
        }
           if (vista.btnEliminar == e.getSource()) {
            int filaSeleccionada = vista.tabla.getSelectedRow();

            int posicionEliminar = (filaSeleccionada != -1) ? filaSeleccionada : posicion;

            if (posicionEliminar == -1) {
                Mensajes.mostrarmsj("Seleccione un salón a eliminar.");
            } else {
                Salon salonAEliminar = lista.retornarSalon(posicionEliminar);
                int msj = Mensajes.confirmarmsj(
                        "¿Deseas eliminar el registro del salón con el código " + salonAEliminar.getCod()+ "?",
                        "Confirmar!!");
                if (msj == 0) {
                    lista.eliminarPorPosicion(posicionEliminar);
                    AlmacenarSalon.GuardarSalon(lista);
                    Mensajes.mostrarmsj("Salón eliminado exitósamente!!");
                    // Limpia el campo de búsqueda y refresca la tabla
                    vista.txtCodBuscar.setText("");
                    ProcesosSalon.MostrarTablaSalon(vista, lista);
                }
            }
        }
          if (vista.btnOrdenar == e.getSource()) {
            ListaEnlazadaDobleSalon copia=lista;
            copia= OrdenarListaDoble.OrdenarporNombre(copia);
            ProcesosSalon.MostrarTablaSalon(vista, copia);
        }
    }
    
}
