/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import model.Prestamo;
import model.Usuario;
import model.Recurso;

/**
 *
 * @author jesus
 */
public class ListaPrestamo implements java.io.Serializable {
    public Prestamo nodo;
    public ListaPrestamo siguiente;
    
    public static int CONSECUTIVO = 0;
    
    public ListaPrestamo(){
        nodo = null;
        siguiente = null;
    }
    
    public void insertarPrestamo(ListaPrestamo apuntador, Recurso Recurso, Usuario usuario, Date fechaPrestamo, Date fechaLimite) {
        if(apuntador.nodo == null) {
            CONSECUTIVO++;
            Recurso.Prestar();
            Prestamo nuevoPrestamo = new Prestamo(Recurso, usuario, fechaPrestamo, fechaLimite, CONSECUTIVO);
            apuntador.nodo = nuevoPrestamo;
            apuntador.siguiente = new ListaPrestamo();
        } else {
            insertarPrestamo(apuntador.siguiente, Recurso, usuario, fechaPrestamo, fechaLimite);
        }
    }
    
    public void devolverRecurso(int idPrestamo, Date fechaDevolucion) {
        ListaPrestamo apuntador = this;
        while(apuntador.nodo != null) {
            if(apuntador.nodo.getId() == idPrestamo) {
                apuntador.nodo.devolverRecurso(fechaDevolucion);
                return;
            }
            apuntador = apuntador.siguiente;
        }
    }
    
    public void multarPrestamo(int idPrestamo, int valorMulta) {
        ListaPrestamo apuntador = this;
        while(apuntador.nodo != null) {
            if(apuntador.nodo.getId() == idPrestamo) {
                apuntador.nodo.multar(valorMulta);
                return;
            }
            apuntador = apuntador.siguiente;
        }
    }
    
    public void pagarMultaPrestamo(int idPrestamo) {
        ListaPrestamo apuntador = this;
        while(apuntador.nodo != null) {
            if(apuntador.nodo.getId() == idPrestamo) {
                apuntador.nodo.pagarMulta();
                return;
            }
            apuntador = apuntador.siguiente;
        }
    }
    
}
