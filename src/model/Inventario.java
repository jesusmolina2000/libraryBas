package model;

import javax.swing.JOptionPane;
import model.NodoRecurso;

/**
 *
 * @author 201811294029
 */
public class Inventario {

    public NodoRecurso recurso;

    public Inventario() {
        recurso = null;
    }

    public void añadirRecursoAInventario(String nombreProducto, int codigoProducto, String tipo) {
        NodoRecurso nuevoRecurso = new NodoRecurso(nombreProducto, codigoProducto, tipo);
        if (recurso == null) {
            recurso = nuevoRecurso;
        } else {
            nuevoRecurso.siguiente = recurso;
            recurso.anterior = nuevoRecurso;
            recurso = nuevoRecurso;
        }
    }

    public NodoRecurso buscarRecursoNombre(String nombreProducto) {
        NodoRecurso buscarRecurso = recurso;
        while (buscarRecurso != null) {
            if (buscarRecurso.nombreProductoProperty().equals(nombreProducto)) {
                return buscarRecurso;
            }
            buscarRecurso = buscarRecurso.siguiente;
        }
        return null;
    }

    public NodoRecurso buscarRecursoCodigo(int codigoProducto) {
        NodoRecurso buscarRecurso = recurso;
        while (buscarRecurso != null) {
            if (buscarRecurso.codigoProductoProperty().toString().equals(codigoProducto)) {
                return buscarRecurso;
            }
            buscarRecurso = buscarRecurso.siguiente;
        }
        return null;
    }

    public void eliminar(NodoRecurso recurso, int codigoProducto) {
        NodoRecurso E = buscarRecursoCodigo(codigoProducto);

        if (E != null) {
            if (E == recurso) {
                recurso = recurso.siguiente;
                if (recurso != null) {
                    recurso.anterior = null;
                }
            } else {
                if (E.siguiente == null) {
                    (E.anterior).siguiente = null;
                } else {
                    (E.anterior).siguiente = E.siguiente;
                    (E.siguiente).anterior = E.anterior;
                }
            }
            E.anterior = null;
            E.siguiente = null;
            JOptionPane.showMessageDialog(null, "Fue eliminado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "no existe");
        }
    }

}
