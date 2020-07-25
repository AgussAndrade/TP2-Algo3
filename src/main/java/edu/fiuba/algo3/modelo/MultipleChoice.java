package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoice implements Pregunta {
    String nombre;
    List<Opcion> opciones;
    Estrategia estrategia;
    public MultipleChoice(String nombre, List<Opcion> opciones, Estrategia estrategia) {
        this.nombre = nombre;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public void comprobarRespuestas(List<Respuesta> respuestas) {
        for(Respuesta respuesta : respuestas) {
            respuesta.validar(estrategia);
        }
    }
}
