/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.image.Image;
import javax.swing.ImageIcon;
import model.Usuario;

/**
 *
 * @author jesus
 */
public class Comunidad implements java.io.Serializable {

    public Usuario nodo;
    public Comunidad siguiente;

    public Comunidad() {
        nodo = null;
        siguiente = null;
    }

    /*public Usuario ultimoUsuario() {
        Usuario apuntador = usuario;
        while (apuntador != null) {
            if (apuntador.siguiente == null) {
                return apuntador;
            }
            apuntador = apuntador.siguiente;
        }
        return null;
    }*/
    public void insertarUsuario(Comunidad apuntador, String nombreUsuario, int codigoUsuario, String tipoUsuario, Image foto) {
        if (apuntador.siguiente == null) {
            Usuario nuevoUsuario = null;
            switch (tipoUsuario) {
                case "Estudiante":
                    nuevoUsuario = new Estudiante(nombreUsuario, codigoUsuario, tipoUsuario, foto);
                    break;
                case "Docente":
                    nuevoUsuario = new Docente(nombreUsuario, codigoUsuario, nombreUsuario, foto);
                    break;
                case "Padre de familia":
                    nuevoUsuario = new PadreDefamilia(nombreUsuario, codigoUsuario, foto);
                    break;
            }
            apuntador.nodo = nuevoUsuario;
            apuntador.siguiente = new Comunidad();
        } else {
            insertarUsuario(apuntador.siguiente, nombreUsuario, codigoUsuario, tipoUsuario, foto);
        }
    }

    public Usuario buscarUsuarioId(Comunidad apuntador, int codigoUsuario) {
        if (apuntador.nodo != null) {
            if (apuntador.nodo.getCodigoUsuario() == codigoUsuario) {
                return apuntador.nodo;
            } else {
                return buscarUsuarioId(apuntador.siguiente, codigoUsuario);
            }
        }
        return null;
    }

    public void eliminarUsuario(Comunidad apuntador, int codigoUsuario) {
        Comunidad temp = apuntador;
        Comunidad anterior = null;

        if (temp != null && temp.nodo.getCodigoUsuario() == codigoUsuario) {
            apuntador = apuntador.siguiente;
            return;
        }

        while (temp != null && temp.nodo.getCodigoUsuario() != codigoUsuario) {
            anterior = temp;
            temp = temp.siguiente;
        }

        if (temp == null) {
            return;
        }

        anterior.siguiente = temp.siguiente;
    }

    public void actualizarUsuario(String nombreUsuario, int codigoUsuario, String tipoUsuario, Image foto) {
        Usuario usuario = buscarUsuarioId(this, codigoUsuario);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setFoto(foto);
    }

}
