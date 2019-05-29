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
public class Prestamo implements java.io.Serializable {

    private int id;
    private Recurso recurso;
    private Usuario usuario;
    private Date fechaDevolucion;
    private Date fechaPrestamo;
    private Date fechaLimite;
    private Multa multa;

    public Prestamo(Recurso recurso, Usuario usuario, Date fechaPrestamo, Date fechaLimite, int id) {
        this.recurso = recurso;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getFechaDevolucionString() {
        if (fechaDevolucion == null) {
            return "";
        } else {
            return fechaDevolucion.toString();
        }
    }

    public void setFechaPrestamo(Date value) {
        fechaPrestamo = value;
    }

    public void devolverRecurso(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        this.recurso.Devolver();
    }

    public boolean estaDevuelto() {
        return fechaDevolucion != null;
    }

    public void multar(int valor) {
        multa = new Multa(valor);
    }

    public void pagarMulta() {
        multa.pagar();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public boolean estaMultado() {
        if (multa == null) {
            return false;
        } else {
            return !multa.estaPagada();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
