package edu.fiuba.algo3.modelo;

public class OpcionDeGrupo implements Opcion{
    String texto;
    int grupo;
    int grupoSeleccionado = 0;

    public OpcionDeGrupo(String texto, int grupo){
        this.grupo = grupo;
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
        return grupoSeleccionado == grupo;
    }

    @Override
    public void seleccionar() { //TODO

    }

    @Override
    public void seleccionar(int parametro) {
        grupoSeleccionado = parametro;
    }
}
