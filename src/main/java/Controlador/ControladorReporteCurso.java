/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import ClasesCentrales.CentralCurso;
import EstructuraListaSimple.ListaEnlazadaSimpleCurso;
import Modelo.Curso;
import Ordenamiento.OrdenarListaSimple;
import Persistencia.AlmacenarCurso;
import Procesos.Mensajes;
import Procesos.ProcesosCurso;
import Vista.RptCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cr075
 */
public class ControladorReporteCurso implements ActionListener{
     
    RptCurso vista;
    ListaEnlazadaSimpleCurso lista;
    public int posicion = -1;
    public static int posicionActualizar; //valor static propia de la clase

    public ControladorReporteCurso(RptCurso rpt) {
        vista=rpt;
        lista=new  ListaEnlazadaSimpleCurso();
        lista=AlmacenarCurso.recuperarCurso();
        vista.btnBuscar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        ProcesosCurso.Presentacion(vista);
        ProcesosCurso.MostrarTablaCursos(vista, lista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if (vista.btnBuscar == e.getSource()) {
            String dato = vista.txtBuscar.getText();
            posicion = lista.buscarporCodoNom(dato); 
            if (dato.isEmpty()) {//si esta vacío
                ProcesosCurso.MostrarTablaCursos(vista, lista);
            } else {
                if (posicion == -1) {
                    Mensajes.mostrarmsj("No se encontró ningún curso con ese código.");
                    vista.txtBuscar.setText("");
                } else {
                    if (!vista.txtBuscar.getText().isEmpty()) { //SI NO ESTA VACIO
                        ProcesosCurso.MostrarTablaCursoBuscado(vista, lista, posicion);
                    }
                }
            }
        }
          if (vista.btnEditar == e.getSource()) {
            int filaSeleccionada = vista.tabla.getSelectedRow();
            posicionActualizar = (filaSeleccionada != -1) ? filaSeleccionada : posicion;
            if (posicionActualizar == -1) {
                Mensajes.mostrarmsj("Seleccione un curso a editar.");
            } else {
                CentralCurso.cursoActualizar = lista.retornarCurso(posicionActualizar);
                Mensajes.mostrarmsj("Navega por la sección de Reportes en la Opción Actualizar para modificar los datos del Curso: " + CentralCurso.cursoActualizar.getCod()+" del Grado:  "+CentralCurso.cursoActualizar.getNombre());
            }
        }
           if (vista.btnEliminar == e.getSource()) {
            int filaSeleccionada = vista.tabla.getSelectedRow();

            int posicionEliminar = (filaSeleccionada != -1) ? filaSeleccionada : posicion;

            if (posicionEliminar == -1) {
                Mensajes.mostrarmsj("Seleccione un curso a eliminar.");
            } else {
                Curso cursoAEliminar = lista.retornarCurso(posicionEliminar);
                int msj = Mensajes.confirmarmsj(
                        "¿Deseas eliminar el registro del curso con el código " + cursoAEliminar.getCod()+ "?",
                        "Confirmar!!");
                if (msj == 0) {
                    lista.eliminarPorPosicion(posicionEliminar);
                    AlmacenarCurso.GuardarCurso(lista);
                    Mensajes.mostrarmsj("Curso eliminado exitósamente!!");
                    // Limpia el campo de búsqueda y refresca la tabla
                    vista.txtBuscar.setText("");
                    ProcesosCurso.MostrarTablaCursos(vista, lista);
                }
            }
        }
          if (vista.btnOrdenar == e.getSource()) {
            ListaEnlazadaSimpleCurso copia=lista;
            copia= OrdenarListaSimple.ordenarPorNombreASC(copia);
            ProcesosCurso.MostrarTablaCursos(vista, copia);
        }
    }
}
