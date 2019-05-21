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
public class Recurso implements java.io.Serializable {

    private final StringProperty nombreRecurso = new SimpleStringProperty();
    private final IntegerProperty codigoRecurso = new SimpleIntegerProperty();
    private final StringProperty tipo = new SimpleStringProperty();


    public Recurso(String nombreProducto, int codigoProducto, String tipo) {
        setCodigoProducto(codigoProducto);
        setTipo(tipo);
        setNombreProducto(nombreProducto);
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
        return codigoRecurso.get();
    }

    public void setCodigoProducto(int value) {
        codigoRecurso.set(value);
    }

    public IntegerProperty codigoProductoProperty() {
        return codigoRecurso;
    }

    public String getNombreProducto() {
        return nombreRecurso.get();
    }

    public void setNombreProducto(String value) {
        nombreRecurso.set(value);
    }

    public StringProperty nombreProductoProperty() {
        return nombreRecurso;
    }

}
