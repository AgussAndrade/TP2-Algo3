package edu.fiuba.algo3.modelo.estrategias;

import edu.fiuba.algo3.modelo.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.List;

public class Penalizable implements Estrategia {
    @Override
    public List<Respuesta> setearSumaDePuntos(List<Respuesta> respuestas){
        for(Respuesta respuesta : respuestas) {
            int aSumar = 0;
            for (Opcion seleccion : respuesta.selecciones()) {
                if (!seleccion.fueSeleccionadaCorrectamente() && !seleccion.esCorrecta()) {
                    aSumar += (respuesta.multiplicador().multiplicarPuntos(-1));
                }
                else if (seleccion.fueSeleccionadaCorrectamente() && seleccion.esCorrecta()) {
                    aSumar += (respuesta.multiplicador().multiplicarPuntos(1));

                }
            }
            respuesta.definirPuntosAAgregar(aSumar);
        }
        return respuestas;

    }
}
