package edu.fiuba.algo3.modelo;

import java.util.List;

public class VerdaderoFalso implements Pregunta {
    String enunciado;
    List<Opcion> opciones;
    Estrategia estrategia;

    public VerdaderoFalso(String enunciado, List<Opcion> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
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
