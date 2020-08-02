package edu.fiuba.algo3.modelo;

public class Incorrecta implements Opcion {
    String nombre;
    boolean fueSeleccionada=false;
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

    @Override
    public boolean fueSeleccionadaCorrectamente() {
        return !fueSeleccionada;
    }

    @Override
    public void seleccionar() {
        fueSeleccionada = true;
    }

    @Override
    public void seleccionar(int parametro) {
        fueSeleccionada = true;
    }
}
