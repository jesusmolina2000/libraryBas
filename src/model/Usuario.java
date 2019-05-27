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
import javafx.scene.image.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jesus
 */
public class Usuario implements java.io.Serializable {

    private final StringProperty nombreUsuario = new SimpleStringProperty();
    private final IntegerProperty codigoUsuario = new SimpleIntegerProperty();
    private Image foto;

    public Usuario(String nommbreUsuario, int codigoUsuario, Image foto) {
        setNombreUsuario(nommbreUsuario);
        setCodigoUsuario(codigoUsuario);
        setFoto(foto);
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
    
    public void setFoto(Image foto) {
        this.foto = foto;
    }
    
    public Image getFoto() {
        return foto;
    }
    
    public String getTipo() {
        if(this instanceof Estudiante) {
            return "Estudiante";
        } else {
            if(this instanceof PadreDefamilia) {
                return "Padre de familia";
            } else {
                return "Docente";
            }
        }
    }
}
