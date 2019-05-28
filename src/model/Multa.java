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
public class Multa implements java.io.Serializable {
    private int valor;
    private boolean pagada;
    
    
    public Multa(int valor) {
        this.valor = valor;
        this.pagada = false;
    }
    
    public void pagar() {
        pagada = true;
    }

    public boolean estaPagada() {
        return pagada;
    }
    
}
