package com.webcammusica.ejercicios.modelo;

import java.io.Serializable;

public class Hortaliza implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    public String género;
 
    public String especie;
 
    public Hortaliza() {
        super();
    }
     
    public Hortaliza(String género, String especie) {
        super();
        this.género = género;
        this.especie = especie;
    }
 
    public String getGénero() {
        return género;
    }
 
    public void setGénero(String género) {
        this.género = género;
    }
 
    public String getEspecie() {
        return especie;
    }
 
    public void setEspecie(String especie) {
        this.especie = especie;
    }
 
}