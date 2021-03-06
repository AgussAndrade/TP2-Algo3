package edu.fiuba.algo3.modelo.estrategias;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public interface Estrategia {
        /* define los puntos a agregar al jugador en cada respuesta
        y devuelve una lista de jugadores que respondieron
        correctamente segun el criterio de la estrategia
         */
    List<Respuesta> validarRespuestas(List<Respuesta> respuestas);


}
