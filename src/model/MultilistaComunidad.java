/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.ImageIcon;
import model.NodoUsuario;

/**
 *
 * @author jesus
 */
public class MultilistaComunidad {

    private NodoUsuario nodo;
    private MultilistaComunidad siguiente;
    
    public MultilistaComunidad() {
        nodo = null;
        siguiente = null;
    }
    
    /*public NodoUsuario ultimoUsuario() {
        NodoUsuario apuntador = usuario;
        while (apuntador != null) {
            if (apuntador.siguiente == null) {
                return apuntador;
            }
            apuntador = apuntador.siguiente;
        }
        return null;
    }*/
    
    public void insertarUsuario(MultilistaComunidad apuntador, String nombreUsuario, int codigoUsuario, String tipoUsuario, ImageIcon foto) {
        if(apuntador.nodo == null) {
            NodoUsuario nuevoUsuario = null;
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
            siguiente = new MultilistaComunidad();
        } else {
            insertarUsuario(apuntador.siguiente, nombreUsuario, codigoUsuario, tipoUsuario, foto);
        }
    }
    
    public NodoUsuario buscarUsuarioId(MultilistaComunidad apuntador, int codigoUsuario) {
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
