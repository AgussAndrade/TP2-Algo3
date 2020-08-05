package edu.fiuba.algo3.modelo.estrategias;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

public class PuntajeParcial implements Estrategia {

    @Override
    public int devolverSumaDePuntos(Respuesta respuesta){
        int puntosASumar = 0;
        for(Opcion seleccion : respuesta.selecciones()) {
            if (seleccion.fueSeleccionadaCorrectamente() && seleccion.esCorrecta()) {
                puntosASumar+=1;
            }
        }
        return (puntosASumar);
    }
}