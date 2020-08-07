package edu.fiuba.algo3.modelo.estrategias;

import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class PuntajeParcial implements Estrategia {
    @Override
    public List<Respuesta> setearSumaDePuntos(List<Respuesta> respuestas) {
        List<Respuesta> respondieronCorrectamente = new ArrayList<>();
        for (Respuesta respuesta : respuestas) {
            if (respuesta.cantidadDeOpcionesSeleccionadasCorrectamente() == respuesta.cantidadDeOpciones()) {
                respuesta.definirPuntosAAgregar(respuesta.cantidadDeOpcionesCorrectasSeleccionadasCorrectamente());
                respondieronCorrectamente.add(respuesta);
            }
        }
        return respondieronCorrectamente;
    }
}