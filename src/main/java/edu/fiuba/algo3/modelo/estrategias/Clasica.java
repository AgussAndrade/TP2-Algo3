package edu.fiuba.algo3.modelo.estrategias;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.List;

public class Clasica implements Estrategia {
    @Override
    public int devolverSumaDePuntos(Respuesta respuesta) {
        for (Opcion seleccion : respuesta.selecciones()) {
            if (!seleccion.fueSeleccionadaCorrectamente()) {
                return 0;
            }
        }
        return (1);
    }
}