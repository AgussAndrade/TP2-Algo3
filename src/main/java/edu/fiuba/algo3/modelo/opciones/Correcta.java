package edu.fiuba.algo3.modelo.opciones;

public class Correcta implements Binarias{
    protected String enunciado;
    protected boolean fueSeleccionada = false;

    public Correcta(String enunciado) {
        this.enunciado = enunciado;
    }

    @Override
    public Binarias copiarOpcion(){
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

}
