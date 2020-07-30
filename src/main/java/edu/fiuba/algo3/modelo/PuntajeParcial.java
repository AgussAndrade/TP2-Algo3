package edu.fiuba.algo3.modelo;

public class PuntajeParcial implements Estrategia {
    @Override
    public int puntosPorIncorrecta() {
        return 0;
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