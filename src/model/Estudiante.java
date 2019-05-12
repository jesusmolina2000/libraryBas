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
public class Estudiante extends NodoUsuario {

    private final StringProperty curso = new SimpleStringProperty();

    public Estudiante() {
    }

    public Estudiante(String nommbreUsuario, int codigoUsuario, String curso) {
        super(nommbreUsuario, codigoUsuario);
        setCurso(curso);
    }

    public String getCurso() {
        return curso.get();
    }

    public void setCurso(String value) {
        curso.set(value);
    }

    public StringProperty cursoProperty() {
        return curso;
    }

}
