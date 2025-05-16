/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralApoderado;
import EstructuraArrayList.ArrayListApoderado;
import Modelo.Apoderado;
import Ordenamiento.OrdenarArrayList;
import Persistencia.AlmacenarApoderado;
import Procesos.Mensajes;
import Procesos.ProcesosApoderado;
import Vista.RptApoderado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorReporteApoderado implements ActionListener {

    RptApoderado vista;
    ArrayListApoderado lista;
    Apoderado a;
    public int posicion = -1;
    public static int posicionActualizar; //valor static propia de la clase

    public ControladorReporteApoderado(RptApoderado rep) {
        vista = rep;
        lista = new ArrayListApoderado();
        lista = AlmacenarApoderado.recuperarApoderado();
        ProcesosApoderado.Presentacion(vista);
        ProcesosApoderado.MostrarTablaAlumno(vista, lista);
        vista.btnBuscar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnBuscar == e.getSource()) {
            String dato = vista.txtNomoDni.getText();
            posicion = lista.buscarporDnioNom(dato);
            if (dato.isEmpty()) {//si esta vacío
                ProcesosApoderado.MostrarTablaAlumno(vista, lista);
            } else {
                if (posicion == -1) {
                    Mensajes.mostrarmsj("No se encontró ningún apoderado con ese Nombre o Dni.");
                } else {
                    if (!vista.txtNomoDni.getText().isEmpty()) { //SI NO ESTA VACIO
                        ProcesosApoderado.MostrarTablaDatos(vista, lista, posicion);
                    }
                }
            }
        }

        if (vista.btnEditar == e.getSource()) {
            int filaSeleccionada = vista.tabla.getSelectedRow();
            posicionActualizar = (filaSeleccionada != -1) ? filaSeleccionada : posicion;
            if (posicionActualizar == -1) {
                Mensajes.mostrarmsj("Seleccione un apoderado a editar.");
            } else {
                CentralApoderado.apoderadoActualizar = lista.recuperar(posicionActualizar);
                Mensajes.mostrarmsj("Navega por la sección de Reportes en la Opción Actualizar para modificar los datos del apoderado" + CentralApoderado.apoderadoActualizar.getNombres());
            }
        }
        if (vista.btnEliminar == e.getSource()) {
            int filaSeleccionada = vista.tabla.getSelectedRow();

            int posicionEliminar = (filaSeleccionada != -1) ? filaSeleccionada : posicion;

            if (posicionEliminar == -1) {
                Mensajes.mostrarmsj("Seleccione un apoderado a eliminar.");
            } else {
                Apoderado apoderadoAEliminar = lista.recuperar(posicionEliminar);
                int msj = Mensajes.confirmarmsj(
                        "¿Deseas eliminar el registro del apoderad@ " + apoderadoAEliminar.getNombres() + "?",
                        "Confirmar!!");
                if (msj == 0) {
                    lista.eliminarApoderado(posicionEliminar);
                    AlmacenarApoderado.GuardarApoderado(lista);
                    Mensajes.mostrarmsj("Apoderado eliminado exitósamente!!");
                    // Limpia el campo de búsqueda y refresca la tabla
                    vista.txtNomoDni.setText("");
                    ProcesosApoderado.MostrarTodosLosAlumnos(vista, lista);
                }
            }
        }
        if (vista.btnOrdenar == e.getSource()) {
            ArrayListApoderado copia = lista;
            copia = OrdenarArrayList.ordenarPorNomAsc(copia);
            ProcesosApoderado.MostrarTablaAlumno(vista, copia);
        }
    }

}
