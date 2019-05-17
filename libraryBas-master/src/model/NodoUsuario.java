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
 * @author jesus
 */
public class NodoUsuario {

    private final StringProperty nombreUsuario = new SimpleStringProperty();
    private final IntegerProperty codigoUsuario = new SimpleIntegerProperty();
    public NodoUsuario siguiente;

    public NodoUsuario() {
        siguiente = null;
    }

    public NodoUsuario(String nommbreUsuario, int codigoUsuario) {
        setNombreUsuario(nommbreUsuario);
        setCodigoUsuario(codigoUsuario);
        siguiente = null;
    }

    public int getCodigoUsuario() {
        return codigoUsuario.get();
    }

    public void setCodigoUsuario(int value) {
        codigoUsuario.set(value);
    }

    public IntegerProperty codigoUsuarioProperty() {
        return codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario.get();
    }

    public void setNombreUsuario(String value) {
        nombreUsuario.set(value);
    }

    public StringProperty nombreUsuarioProperty() {
        return nombreUsuario;
    }

}
