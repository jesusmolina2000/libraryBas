package model;

import javax.swing.JOptionPane;
import model.Recurso;

/**
 *
 * @author jesus
 */
public class Inventario implements java.io.Serializable{
    
    public ListaRecurso listaRecurso;
    public ListaPrestamo listaPrestamo;
    
    
    public Inventario() {
        listaRecurso = new ListaRecurso();
        listaPrestamo = new ListaPrestamo();
    }

    public int cuantosPrestamosPorUsuario(int codigoUsuario) {
        int count = 0;
        ListaPrestamo apuntador = listaPrestamo;
        while (apuntador.nodo != null) {
            if(apuntador.nodo.getUsuario().getCodigoUsuario() == codigoUsuario) {
                count++;
            }
            apuntador = apuntador.siguiente;
        }
        return count;
    }
}
