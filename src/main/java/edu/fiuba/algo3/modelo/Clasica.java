package edu.fiuba.algo3.modelo;

import java.util.List;

public class Clasica implements Estrategia {
    @Override
    public void sumarPuntos(Respuesta respuesta, List<Opcion> opciones) {
        for (Opcion seleccion : respuesta.selecciones()) {
            if (!seleccion.fueSeleccionadaCorrectamente()) {
                return;
            }
        }
        respuesta.jugador().sumarPuntos(1);
    }
}