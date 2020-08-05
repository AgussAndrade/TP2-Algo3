package edu.fiuba.algo3.modelo.opciones;

public class OpcionPosicion implements Opcion {
    String enunciado;
    int posicion;
    int posicionSeleccionada = 0;

    public OpcionPosicion(String texto, int posicion){
        this.posicion = posicion;
        this.enunciado = texto;
    }

    @Override
    public String texto(){
        return enunciado;
    }

    @Override
    public Opcion copiarOpcion() {
        return new OpcionPosicion(enunciado,posicion);
    }

    @Override
    public boolean esCorrecta() {//TODO
        return true;
    }

    @Override
    public boolean fueSeleccionadaCorrectamente() {
        return posicionSeleccionada == posicion;
    }

    @Override
    public void seleccionar() { //TODO

    }

    @Override
    public void seleccionar(int parametro) {
        posicionSeleccionada = parametro;
    }
}
