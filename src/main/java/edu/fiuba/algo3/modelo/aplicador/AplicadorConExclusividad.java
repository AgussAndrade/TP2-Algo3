package edu.fiuba.algo3.modelo.aplicador;

import edu.fiuba.algo3.modelo.Respuesta;

import java.util.List;

public class AplicadorConExclusividad implements AplicadorDePuntos {
    int factorDeExclusividad;
    public AplicadorConExclusividad(int cantidadDeLlamados){
        factorDeExclusividad = 2 * cantidadDeLlamados;
    }
    public void sumarPuntos(List<Respuesta> respuestasCorrectas){
        Respuesta respuestaCorrecta;
        if(respuestasCorrectas.size() == 1){
            respuestaCorrecta = respuestasCorrectas.get(0);
            respuestaCorrecta.jugador().sumarPuntos(respuestaCorrecta.obtenerPuntos() * factorDeExclusividad);
        }
    }
}
