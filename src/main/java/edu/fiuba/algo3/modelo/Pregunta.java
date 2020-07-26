package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected List<Opcion> opciones;
    protected Estrategia estrategia;

    public String nombre(){
        return enunciado;
    }

    public void comprobarRespuestas(List<Respuesta> respuestas){
        for(Respuesta respuesta : respuestas) {
            respuesta.validar(estrategia);
        }
    }
}
