package edu.fiuba.algo3.modelo.opciones;

public class OpcionDeGrupo implements Opcion {
    String enunciado;
    int grupo;
    int grupoSeleccionado = 0;

    public OpcionDeGrupo(String enunciado, int grupo){
        this.grupo = grupo;
        this.enunciado = enunciado;
    }

    @Override
    public Opcion copiarOpcion(){
        return new OpcionDeGrupo(enunciado,grupo);
    }

    public String texto(){
        return enunciado;
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
