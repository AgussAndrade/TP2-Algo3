package edu.fiuba.algo3.modelo.aplicadores;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.aplicadores.AplicadorDePuntos;

import java.util.List;

public class AplicadorSimple implements AplicadorDePuntos {

    @Override
    public void sumarPuntos(List<Respuesta> respuestas) {
        for(Respuesta respuesta : respuestas){
            respuesta.jugador().sumarPuntos(respuesta.obtenerPuntos());
        }
    }
}
