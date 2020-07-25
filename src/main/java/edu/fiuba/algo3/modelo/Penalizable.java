package edu.fiuba.algo3.modelo;

import java.util.List;

public class Penalizable implements Estrategia {

    public Penalizable() {
    }
    @Override
    public int puntosPorIncorrecta() {
        return -1;
    }

    @Override
    public int puntosPorCorrecta() {
        return 1;
    }

    @Override
    public void sumarPuntos(Jugador jugador, List<Opcion> selecciones){
        int puntosASumar = 0;
        for(Opcion seleccion : selecciones) {
            puntosASumar += seleccion.obtenerPuntos(this);
        }
        jugador.sumarPuntos( puntosASumar);
    }
}
