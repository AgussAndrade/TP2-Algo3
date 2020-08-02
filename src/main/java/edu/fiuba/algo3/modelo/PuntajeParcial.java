package edu.fiuba.algo3.modelo;

import java.util.List;

public class PuntajeParcial implements Estrategia {

    @Override
    public void sumarPuntos(Respuesta respuesta, List<Opcion> opciones){
        int puntosASumar = 0;
        for(Opcion seleccion : respuesta.selecciones()) {
            if(seleccion.fueSeleccionadaCorrectamente()){
                puntosASumar+=1;
            }
            else return;
        }
        respuesta.jugador().sumarPuntos(puntosASumar);
    }
}