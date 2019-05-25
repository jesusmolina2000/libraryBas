/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.util.Date;
import model.Prestamo;
import model.Usuario;
import model.Recurso;

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
    
    public void insertarPrestamo(ListaPrestamo apuntador, Recurso Recurso, Usuario usuario, Date fechaPrestamo, Date fechaLimite) {
        if(apuntador.nodo == null) {
            Prestamo nuevoPrestamo = new Prestamo(Recurso, usuario, fechaPrestamo, fechaLimite);
            nodo = nuevoPrestamo;
            siguiente = new ListaPrestamo();
        } else {
            insertarPrestamo(apuntador.siguiente, Recurso, usuario, fechaPrestamo, fechaLimite);
        }
        
        
    }
    
    
}
