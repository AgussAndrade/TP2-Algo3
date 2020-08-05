package edu.fiuba.algo3.modelo.estrategias;

import edu.fiuba.algo3.modelo.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

public class Penalizable implements Estrategia {
    @Override
    public int devolverSumaDePuntos(Respuesta respuesta) {
        Multiplicador multiplicador = respuesta.multiplicador();
        int aSumar = 0;
        for (Opcion seleccion : respuesta.selecciones()) {
            if (!seleccion.fueSeleccionadaCorrectamente() && !seleccion.esCorrecta()) {
                aSumar += (multiplicador.multiplicarPuntos(-1));
            }
            else if (seleccion.fueSeleccionadaCorrectamente() && seleccion.esCorrecta()) {
                aSumar += (multiplicador.multiplicarPuntos(1));

            }
        }
        return aSumar;
    }
}
