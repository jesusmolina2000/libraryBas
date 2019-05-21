/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.ImageIcon;
import model.Usuario;

/**
 *
 * @author jesus
 */
public class Comunidad implements java.io.Serializable{

    private Usuario nodo;
    private Comunidad siguiente;
    
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
    
    public void insertarUsuario(Comunidad apuntador, String nombreUsuario, int codigoUsuario, String tipoUsuario, ImageIcon foto) {
        if(apuntador.nodo == null) {
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
            nodo = nuevoUsuario;
            siguiente = new Comunidad();
        } else {
            insertarUsuario(apuntador.siguiente, nombreUsuario, codigoUsuario, tipoUsuario, foto);
        }
    }
    
    public Usuario buscarUsuarioId(Comunidad apuntador, int codigoUsuario) {
        if(apuntador.nodo != null) {
            if(apuntador.nodo.getCodigoUsuario() == codigoUsuario) {
                return apuntador.nodo;
            } else {
                return buscarUsuarioId(apuntador.siguiente, codigoUsuario);
            }
        }
        return null;
    }

}
