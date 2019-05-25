/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 201811294029
 */
public class Recurso implements java.io.Serializable {

    private final StringProperty nombreRecurso = new SimpleStringProperty();
    private final IntegerProperty codigoRecurso = new SimpleIntegerProperty();
    private final StringProperty tipo = new SimpleStringProperty();
    private boolean prestado;

    public Recurso(String nombreRecurso, int codigoRecurso, String tipo) {
        setCodigoRecurso(codigoRecurso);
        setTipo(tipo);
        setNombreRecurso(nombreRecurso);
        prestado = false;
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String value) {
        tipo.set(value);
    }

    public StringProperty tipoProperty() {
        return tipo;
    }

    public int getCodigoRecurso() {
        return codigoRecurso.get();
    }

    public void setCodigoRecurso(int value) {
        codigoRecurso.set(value);
    }

    public IntegerProperty codigoRecurso() {
        return codigoRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso.get();
    }

    public void setNombreRecurso(String value) {
        nombreRecurso.set(value);
    }

    public StringProperty nombreRecursoProperty() {
        return nombreRecurso;
    }
    
    public void Prestar() {
        prestado = true;
    }
    
    public void Devolver() {
        prestado = false;
    }
    
    public boolean getPrestado() {
        return prestado;
    }

}
