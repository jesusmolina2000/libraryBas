/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 201811294029
 */
public class NodoRecurso {

    private final StringProperty nombreProducto = new SimpleStringProperty();
    private final IntegerProperty codigoProducto = new SimpleIntegerProperty();
    private final StringProperty tipo = new SimpleStringProperty();
    public NodoRecurso siguiente;
    public NodoRecurso anterior;

    public NodoRecurso() {
        siguiente = null;
        anterior = null;
    }

    public NodoRecurso(String nombreProducto, int codigoProducto, String tipo) {
        setCodigoProducto(codigoProducto);
        setTipo(tipo);
        setNombreProducto(nombreProducto);
        siguiente = null;
        anterior = null;
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String value) {
        tipo.set(value);
    }

    public StringProperty tipoProperty() {
        return tipo;
    }

    public int getCodigoProducto() {
        return codigoProducto.get();
    }

    public void setCodigoProducto(int value) {
        codigoProducto.set(value);
    }

    public IntegerProperty codigoProductoProperty() {
        return codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto.get();
    }

    public void setNombreProducto(String value) {
        nombreProducto.set(value);
    }

    public StringProperty nombreProductoProperty() {
        return nombreProducto;
    }

}
