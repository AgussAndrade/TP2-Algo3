package edu.fiuba.algo3.modelo;

public class Correcta implements Opcion {
    protected String enunciado;
    protected boolean fueSeleccionada = false;

    public Correcta(String enunciado) {
        this.enunciado = enunciado;
    }

    @Override
    public Opcion copiarOpcion(){
        return new Correcta(enunciado);
    }

    @Override
    public String texto(){
        return enunciado;
    }

    @Override
    public boolean esCorrecta() {
        return true;
    }

    @Override
    public boolean fueSeleccionadaCorrectamente() {
        return fueSeleccionada;
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
