package edu.fiuba.algo3.modelo.opciones;

public class OpcionDeGrupo implements Grupales {
    String enunciado;
    String grupo;
    String grupoSeleccionado;

    public OpcionDeGrupo(String enunciado, String grupo){
        this.grupo = grupo;
        this.enunciado = enunciado;
    }

    @Override
    public Grupales copiarOpcion(){
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
    public void seleccionar(String parametro) {
        grupoSeleccionado = parametro;
    }
}
