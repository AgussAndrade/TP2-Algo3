package edu.fiuba.algo3.modelo.opciones;



public class OpcionDeGrupo implements Grupal {
    String enunciado;
    String grupo;
    String grupoSeleccionado = "sinGrupo";

    public OpcionDeGrupo(String enunciado, String grupo){
        this.grupo = grupo;
        this.enunciado = enunciado;
    }

    @Override
    public Grupal copiarOpcion(){
        return new OpcionDeGrupo(enunciado,grupo);
    }

    @Override
    public String texto(){
        return enunciado;
    }

    @Override
    public boolean esCorrecta() {//TODO
        return true;
    }

    @Override
    public boolean fueSeleccionadaCorrectamente() {
        return grupo.equals(grupoSeleccionado);
    }

    @Override
    public void seleccionar(String parametro) {
        grupoSeleccionado = parametro;
    }

    @Override
    public String grupoSeleccionado(){
        return grupoSeleccionado;
    }

    @Override
    public String grupo(){
        return grupo;
    }
}
