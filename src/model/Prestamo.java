/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
/**
 *
 * @author jesus
 */
public class Prestamo {

    public Prestamo siguiente;
    
    private NodoRecurso recurso;
    private NodoUsuario usuario;
    private Date fechaDevolucion;
    private Date fechaPrestamo;
    private Date fechaLimite;
    private Multa multas;

    public Prestamo(NodoRecurso recurso, NodoUsuario usuario, Date fechaPrestamo, Date fechaLimite) {
        siguiente=null;
        this.recurso = recurso;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date value) {
        fechaPrestamo = value;
    }
    
    public void devolverRecurso(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public boolean estaDevuelto() {
        return fechaDevolucion != null;
    }
    
    public void multar(int valor) {
        multas.insertarMulta(new Multa(valor));
    }
}
