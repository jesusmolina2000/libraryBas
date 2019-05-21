/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import javax.swing.ImageIcon;
import model.Docente;
import model.Estudiante;
import model.NodoUsuario;
import model.PadreDefamilia;

/**
 *
 * @author mariomerco
 */
public class ListaUsuario implements java.io.Serializable {
    private NodoUsuario nodo;
    private ListaUsuario siguiente;
    
    public ListaUsuario() {
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
    
    public void insertarUsuario(ListaUsuario apuntador, String nombreUsuario, int codigoUsuario, String tipoUsuario, ImageIcon foto) {
        if(apuntador.nodo == null) {
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
            nodo = nuevoUsuario;
            siguiente = new ListaUsuario();
        } else {
            insertarUsuario(apuntador.siguiente, nombreUsuario, codigoUsuario, tipoUsuario, foto);
        }
    }
    
    public NodoUsuario buscarUsuarioId(ListaUsuario apuntador, int codigoUsuario) {
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
