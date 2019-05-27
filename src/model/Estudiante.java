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
public class Estudiante extends Usuario implements java.io.Serializable {

    public Estudiante(String nombreUsuario, int codigoUsuario, Image foto) {
        super(nombreUsuario, codigoUsuario, foto, "Estudiante");
    }
}
