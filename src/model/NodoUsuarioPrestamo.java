/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 *
 * @author jesus
 */
public class NodoUsuarioPrestamo extends NodoRecurso{

    private final IntegerProperty fechaPrestamo = new SimpleIntegerProperty();
    public NodoUsuarioPrestamo siguiente;

    public NodoUsuarioPrestamo() {
        siguiente= null;
    }

    public NodoUsuarioPrestamo(String nombreProducto, int codigoProducto, String tipo) {
        super(nombreProducto, codigoProducto, tipo);
        setFechaPrestamo(fechaPrestamo);
        siguiente=null;
    }
    
    

    public int getFechaPrestamo() {
        return fechaPrestamo.get();
    }

    public void setFechaPrestamo(int value) {
        fechaPrestamo.set(value);
    }

    public IntegerProperty fechaPrestamoProperty() {
        return fechaPrestamo;
    }
    
    
    
}
