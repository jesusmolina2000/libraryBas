/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import model.Recurso;

/**
 *
 * @author mariomerco
 */
public class ListaRecurso implements java.io.Serializable {
    private Recurso nodo;
    private ListaRecurso siguiente;
    
    public ListaRecurso() {
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
    
    public void insertarUsuario(ListaRecurso apuntador, String nombreProducto, int codigoProducto, String tipo) {
        if(apuntador.nodo == null) {
            Recurso nuevoRecurso = null;
            nodo = nuevoRecurso;
            siguiente = new ListaRecurso();
        } else {
            insertarUsuario(apuntador.siguiente, nombreProducto, codigoProducto, tipo);
        }
    }
    
    public Recurso buscarRecursoId(ListaRecurso apuntador, int codigoProducto) {
        if(apuntador.nodo != null) {
            if(apuntador.nodo.getCodigoProducto() == codigoProducto) {
                return apuntador.nodo;
            } else {
                return buscarRecursoId(apuntador.siguiente, codigoProducto);
            }
        }
        return null;
    }
    
    public void eliminarRecurso(ListaRecurso apuntador, int codigoRecurso){
        ListaRecurso temp = apuntador;
        ListaRecurso anterior = null;
        
        
        if(temp != null && temp.nodo.getCodigoProducto() == codigoRecurso) {
            apuntador = apuntador.siguiente;
            return;
        }
        
        while(temp != null && temp.nodo.getCodigoProducto() != codigoRecurso) {
            anterior = temp;
            temp = temp.siguiente;
        }
        
        
        if(temp == null) {
            return;
        }
        
        anterior.siguiente = temp.siguiente;
    }
}
