package edu.fiuba.algo3.modelo;

public class Incorrecta implements Opcion {
    String nombre;
    public Incorrecta(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String texto(){
        return nombre;
    }

    @Override
    public boolean esCorrecta(){
        return false;
    }
}
