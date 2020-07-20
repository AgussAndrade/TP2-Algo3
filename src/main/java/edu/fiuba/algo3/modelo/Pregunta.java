package edu.fiuba.algo3.modelo;

import java.util.List;

public interface Pregunta {
    public String nombre();

    void comprobarRespuestas(List<Respuesta> respuestas);
}
