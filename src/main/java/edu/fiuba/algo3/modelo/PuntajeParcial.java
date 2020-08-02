package edu.fiuba.algo3.modelo;

import java.util.List;

public class PuntajeParcial implements Estrategia {

    @Override
    public void sumarPuntos(Respuesta respuesta){
        int puntosASumar = 0;
        for(Opcion seleccion : respuesta.selecciones()) {
            if(!seleccion.fueSeleccionadaCorrectamente() && !seleccion.esCorrecta()){
                return;
            }
            else if (seleccion.fueSeleccionadaCorrectamente() && seleccion.esCorrecta()) {
                puntosASumar+=1;
            }
        }
        respuesta.jugador().sumarPuntos(puntosASumar);
    }
}