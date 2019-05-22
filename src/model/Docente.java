/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author jesus
 */
public class Docente extends Usuario implements java.io.Serializable {

    private final StringProperty asignatura = new SimpleStringProperty();

    public Docente(String nommbreUsuario, int codigoUsuario, String nombreAsignatura, Image foto) {
        super(nommbreUsuario, codigoUsuario, foto);
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
