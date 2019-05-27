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
    private String tipo;
    
    public Usuario(String nommbreUsuario, int codigoUsuario, Image foto, String tipo) {
        setNombreUsuario(nommbreUsuario);
        setCodigoUsuario(codigoUsuario);
        setFoto(foto);
        setTipo(tipo);
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
