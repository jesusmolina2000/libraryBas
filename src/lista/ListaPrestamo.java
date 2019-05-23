/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import model.Prestamo;

/**
 *
 * @author jesus
 */
public class ListaPrestamo implements java.io.Serializable {
    private Prestamo nodo;
    private ListaPrestamo siguiente;
    
    public ListaPrestamo(){
        nodo = null;
        siguiente = null;
    }
    
    public void insertarPrestamo(ListaPrestamo apuntador, String nombreProducto, int codigoProducto, String tipo) {
        if(apuntador.nodo == null) {
            Prestamo nuevoPrestamo = null;
            nodo = nuevoPrestamo;
            siguiente = new ListaPrestamo();
        } else {
            insertarPrestamo(apuntador.siguiente, nombreProducto, codigoProducto, tipo);
        }
        
        
    }
    
    
}
