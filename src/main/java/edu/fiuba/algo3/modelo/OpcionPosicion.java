package edu.fiuba.algo3.modelo;

public class OpcionPosicion implements Opcion {
    String texto;
    int posicion;
    int posicionSeleccionada = 0;
    public OpcionPosicion(String texto, int posicion){
        this.posicion = posicion;
        this.texto = texto;
    }
    public String texto(){
        return texto;
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
