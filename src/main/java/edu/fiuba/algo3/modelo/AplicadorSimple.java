package edu.fiuba.algo3.modelo;

import java.util.List;

public class AplicadorSimple implements AplicadorDePuntos{

    @Override
    public void sumarPuntos(List<Respuesta> respuestas) {
        for(Respuesta respuesta : respuestas){
            respuesta.jugador().sumarPuntos(respuesta.obtenerPuntos());
        }
    }
}
