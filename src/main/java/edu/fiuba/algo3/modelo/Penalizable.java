package edu.fiuba.algo3.modelo;

import java.util.List;

public class Penalizable implements Estrategia {
    @Override
    public void sumarPuntos(Respuesta respuesta, List<Opcion> opciones) {
        for (Opcion seleccion : respuesta.selecciones()) {
            if (!seleccion.fueSeleccionadaCorrectamente()) {
                respuesta.jugador().sumarPuntos(1);
            } else {
                respuesta.jugador().sumarPuntos(-1);
            }
        }
    }
}
