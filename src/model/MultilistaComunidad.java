/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.NodoUsuario;

/**
 *
 * @author jesus
 */
public class MultilistaComunidad {

    public NodoUsuario usuario;

    public MultilistaComunidad() {
        usuario = null;
    }

    //
    public void insertarUsuario(String nombreUsuario, int codigoUsuario, String tipoUsuario) {
        NodoUsuario ultimoUsuario = ultimoUsuario();
        NodoUsuario nuevoUsuario = null;
        switch (tipoUsuario) {
            case "Estudiante":
                nuevoUsuario = new Estudiante(nombreUsuario, codigoUsuario, tipoUsuario);
                break;
            case "Docente":
                nuevoUsuario = new Docente(nombreUsuario, codigoUsuario, nombreUsuario);
                break;
            case "Padre de familia":
                nuevoUsuario = new PadreDefamilia(nombreUsuario, codigoUsuario);
                break;
        }
        if (ultimoUsuario != null) {
            ultimoUsuario.siguiente = nuevoUsuario;
        } else {
            usuario = nuevoUsuario;
        }
    }

    public NodoUsuario buscarUsuarioNombre(String nombreUsuario) {
        NodoUsuario usuarioBuscar = usuario;
        while (usuarioBuscar != null) {
            if (usuarioBuscar.getNombreUsuario().equals(nombreUsuario)) {
                return usuarioBuscar;
            }
            usuarioBuscar = usuarioBuscar.siguiente;
        }
        return null;
    }

    public NodoUsuario ultimoUsuario() {
        NodoUsuario apuntador = usuario;
        while (apuntador != null) {
            if (apuntador.siguiente == null) {
                return apuntador;
            }
            apuntador = apuntador.siguiente;
        }
        return null;
    }

}
