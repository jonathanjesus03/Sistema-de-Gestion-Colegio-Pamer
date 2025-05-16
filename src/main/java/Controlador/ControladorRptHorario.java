/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralHorario;
import EstructuraPila.ComparadorHorario;
import EstructuraPila.PilaHorario;
import Modelo.Horario;
import Ordenamiento.OrdenarPila;
import Persistencia.AlmacenarHorario;
import Procesos.Mensajes;
import Procesos.ProcesosHorario;
import Vista.RptHorario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorRptHorario implements ActionListener {

    RptHorario vista;
    Horario ho;
    int posicion = -1;
    public static int posicionActualizar;
    PilaHorario lista;
    ComparadorHorario comparador;

    public ControladorRptHorario(RptHorario rpt) {
        vista = rpt;
        lista = new PilaHorario();
        comparador = new ComparadorHorario();
        lista = AlmacenarHorario.recuperarHorario();
        ProcesosHorario.Presentacion(vista);
        ProcesosHorario.MostrarTablaHorario(vista, lista);
        vista.btnEliminar.addActionListener(this);
        vista.btnVerPrimero.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnVerUltimo.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnBuscar == e.getSource()) {
            String dato = vista.txtCodBuscar.getText();
            posicion = lista.obtenerporCod(dato);
            if (dato.isEmpty()) {//si esta vacío
                ProcesosHorario.MostrarTablaHorario(vista, lista);
            } else {
                if (posicion == -1) {
                    Mensajes.mostrarmsj("No se encontró ningún horario con ese código.");
                    vista.txtCodBuscar.setText("");
                } else {
                    if (!vista.txtCodBuscar.getText().isEmpty()) { //SI NO ESTA VACIO
                        ProcesosHorario.MostrarTablaHorarioBuscado(vista, lista, posicion);
                    }
                }
            }
        }
        if (vista.btnEditar == e.getSource()) {
            int filaSeleccionada = vista.tabla.getSelectedRow();
            posicionActualizar = (filaSeleccionada != -1) ? filaSeleccionada : posicion;
            if (posicionActualizar == -1) {
                Mensajes.mostrarmsj("Seleccione un horario a editar.");
            } else {
                CentralHorario.horarioActualizar = lista.retornarHorario(posicionActualizar);
                Mensajes.mostrarmsj("Navega por la sección de Reportes en la Opción Actualizar para modificar los datos del Horario " + CentralHorario.horarioActualizar.getCod() + " ");
            }
        }
        if (vista.btnEliminar == e.getSource()) {
            int msj = Mensajes.confirmarmsj(
                    "¿Deseas eliminar el registro del salón: " + lista.ultimoObjeto().toString() + "?",
                    "Confirmar!!");
            if (msj == 0) {
                lista.eliminar();
                AlmacenarHorario.GuardarHorario(lista);
                Mensajes.mostrarmsj("Horario eliminado exitósamente!!");
                // Limpia el campo de búsqueda y refresca la tabla
                vista.txtCodBuscar.setText("");
                ProcesosHorario.MostrarTablaHorario(vista, lista);
            }
        }

        if (vista.btnOrdenar == e.getSource()) {
          lista = OrdenarPila.ordenarPorHora(comparador, lista); // Sobrescribe `lista` con la pila ordenada
          ProcesosHorario.MostrarTablaHorario(vista, lista); // Muestra la pila ordenada en la tabla
        }

        if (vista.btnVerPrimero == e.getSource()) {
            Mensajes.mostrarmsj(lista.primeroObjeto().toString());
        }
        if (vista.btnVerUltimo == e.getSource()) {
            Mensajes.mostrarmsj(lista.ultimoObjeto().toString());
        }
    }

}
