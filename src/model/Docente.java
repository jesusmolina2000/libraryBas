/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jesus
 */
public class Docente extends NodoUsuario {

    private final StringProperty asignatura = new SimpleStringProperty();

    public Docente() {
    }

    public Docente(String nommbreUsuario, int codigoUsuario, String nombreAsignatura) {
        super(nommbreUsuario, codigoUsuario);
        setAsignatura(nombreAsignatura);
    }

    public String getAsignatura() {
        return asignatura.get();
    }

    public void setAsignatura(String value) {
        asignatura.set(value);
    }

    public StringProperty asignaturaProperty() {
        return asignatura;
    }

}
