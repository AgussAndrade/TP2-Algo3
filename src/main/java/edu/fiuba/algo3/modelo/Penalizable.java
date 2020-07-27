package edu.fiuba.algo3.modelo;

import java.util.List;

public class Penalizable implements Estrategia {

    @Override
    public int puntosPorIncorrecta() {
        return -1;
    }

    @Override
    public int puntosPorCorrecta() {
        return 1;
    }

    @Override
    public void sumarPuntos(Respuesta respuesta){
        int puntosASumar = 0;
        for(Opcion seleccion : respuesta.selecciones()) {
            puntosASumar += seleccion.obtenerPuntos(this);
        }
        respuesta.jugador().sumarPuntos(puntosASumar);
    }
}
