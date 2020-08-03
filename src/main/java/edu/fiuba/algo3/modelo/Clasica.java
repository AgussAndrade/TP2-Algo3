package edu.fiuba.algo3.modelo;

import java.util.List;

public class Clasica implements Estrategia {
    @Override
    public int sumarPuntos(Respuesta respuesta) {
        for (Opcion seleccion : respuesta.selecciones()) {
            if (!seleccion.fueSeleccionadaCorrectamente()) {
                return 0;
            }
        }
        return (1);
    }
}