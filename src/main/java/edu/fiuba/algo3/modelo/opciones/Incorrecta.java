package edu.fiuba.algo3.modelo.opciones;

public class Incorrecta implements Opcion {
    String enunciado;
    boolean fueSeleccionada=false;
    public Incorrecta(String nombre) {
        this.enunciado = nombre;
    }

    @Override
    public String texto(){
        return enunciado;
    }

    @Override
    public Opcion copiarOpcion(){
        return new Incorrecta(enunciado);
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
