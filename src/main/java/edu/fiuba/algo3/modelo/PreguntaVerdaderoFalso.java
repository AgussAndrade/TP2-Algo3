package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaVerdaderoFalso implements Pregunta {
    String enunciado;
    List<Opcion> opciones;
    Estrategia estrategia;

    public PreguntaVerdaderoFalso(String enunciado, List<Opcion> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.estrategia = estrategia;
    }

    public String nombre(){
        return enunciado;
    }

    public void comprobarRespuestas(List<Respuesta> respuestas){
        for(Respuesta respuesta : respuestas) {
            respuesta.validar(estrategia);
        }
    }
}
