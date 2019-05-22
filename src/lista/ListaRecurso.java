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
    
    public void insertarRecurso(ListaRecurso apuntador, String nombreRecurso, int codigoRecurso, String tipo) {
        if(apuntador.nodo == null) {
            Recurso nuevoRecurso = null;
            nodo = nuevoRecurso;
            siguiente = new ListaRecurso();
        } else {
            insertarRecurso(apuntador.siguiente, nombreRecurso, codigoRecurso, tipo);
        }
    }
    
    public Recurso buscarRecursoId(ListaRecurso apuntador, int codigoRecurso) {
        if(apuntador.nodo != null) {
            if(apuntador.nodo.getCodigoRecurso() == codigoRecurso) {
                return apuntador.nodo;
            } else {
                return buscarRecursoId(apuntador.siguiente, codigoRecurso);
            }
        }
        return null;
    }
    
    public void eliminarRecurso(ListaRecurso apuntador, int codigoRecurso){
        ListaRecurso temp = apuntador;
        ListaRecurso anterior = null;
        
        
        if(temp != null && temp.nodo.getCodigoRecurso() == codigoRecurso) {
            apuntador = apuntador.siguiente;
            return;
        }
        
        while(temp != null && temp.nodo.getCodigoRecurso() != codigoRecurso) {
            anterior = temp;
            temp = temp.siguiente;
        }
        
        
        if(temp == null) {
            return;
        }
        
        anterior.siguiente = temp.siguiente;
    }
    
    public void actualizarRecurso(String nombreRecurso, int codigoRecurso, String tipo) {
        Recurso recurso = buscarRecursoId(this, codigoRecurso);
        recurso.setNombreRecurso(nombreRecurso);
        recurso.setTipo(tipo);
    }
}
