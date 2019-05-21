package model;

import javax.swing.JOptionPane;
import lista.ListaPrestamo;
import lista.ListaRecurso;
import model.Recurso;

/**
 *
 * @author jesus
 */
public class Inventario implements java.io.Serializable{
    
    public ListaRecurso listaRecurso;
    public ListaPrestamo listaPrestamo;
    
    
    
    

 /*   public Recurso recurso;

    public Inventario() {
        recurso = null;
    }

    public void añadirRecursoAInventario(String nombreProducto, int codigoProducto, String tipo) {
        Recurso nuevoRecurso = new Recurso(nombreProducto, codigoProducto, tipo);
        if (recurso == null) {
            recurso = nuevoRecurso;
        } else {
            nuevoRecurso.siguiente = recurso;
            recurso.anterior = nuevoRecurso;
            recurso = nuevoRecurso;
        }
    }

    public Recurso buscarRecursoNombre(String nombreProducto) {
        Recurso buscarRecurso = recurso;
        while (buscarRecurso != null) {
            if (buscarRecurso.nombreProductoProperty().equals(nombreProducto)) {
                return buscarRecurso;
            }
            buscarRecurso = buscarRecurso.siguiente;
        }
        return null;
    }

    public Recurso buscarRecursoCodigo(int codigoProducto) {
        Recurso buscarRecurso = recurso;
        while (buscarRecurso != null) {
            if (buscarRecurso.codigoProductoProperty().toString().equals(codigoProducto)) {
                return buscarRecurso;
            }
            buscarRecurso = buscarRecurso.siguiente;
        }
        return null;
    }

    public void eliminar(Recurso recurso, int codigoProducto) {
        Recurso E = buscarRecursoCodigo(codigoProducto);

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

*/
}
