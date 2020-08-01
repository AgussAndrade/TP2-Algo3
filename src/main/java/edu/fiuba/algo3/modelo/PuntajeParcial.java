package edu.fiuba.algo3.modelo;

import java.util.List;

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
    public void sumarPuntos(Respuesta respuesta, List<Opcion> opciones){
        int puntosASumar = 0;
        for(Opcion seleccion : respuesta.selecciones()) {
            if(seleccion.esCorrecta()){
                puntosASumar+=1;
            }
        }
        respuesta.jugador().sumarPuntos(puntosASumar);
    }
}