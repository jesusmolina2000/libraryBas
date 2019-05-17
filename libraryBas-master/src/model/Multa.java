/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jesus
 */
public class Multa {
    private int valor;
    private boolean pagada;
    
    Multa siguiente;
    
    public Multa(int valor) {
        this.valor = valor;
        this.pagada = false;
        siguiente = null;
    }
    
    public void insertarMulta(Multa multa) {
        
    }
    
    public void pagarMulta() {
        pagada = true;
    }
}
