package edu.fiuba.algo3.modelo;

public class Correcta implements Opcion {
    String nombre;
    public Correcta(String nombre) {
        this.nombre = nombre;
    }
    public String texto(){
        return nombre;
    }
}
