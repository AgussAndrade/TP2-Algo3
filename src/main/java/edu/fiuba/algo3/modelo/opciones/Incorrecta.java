package edu.fiuba.algo3.modelo.opciones;

public class Incorrecta implements Binaria {
    String enunciado;
    boolean fueSeleccionada=false;
    public Incorrecta(String enunciado) {
        this.enunciado = enunciado;
    }

    @Override
    public String texto(){
        return enunciado;
    }

    @Override
    public Binaria copiarOpcion(){
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
    public void deseleccionar() {
        fueSeleccionada = false;
    }
}
