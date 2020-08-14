package edu.fiuba.algo3.modelo.estrategias;

import edu.fiuba.algo3.modelo.Respuesta;

import java.util.List;

public class Penalizable implements Estrategia {
    @Override
    public List<Respuesta> validarRespuestas(List<Respuesta> respuestas){
        for(Respuesta respuesta : respuestas) {
            respuesta.definirPuntosAAgregar(respuesta.cantidadDeOpcionesCorrectasSeleccionadasCorrectamente() - respuesta.cantidadDeOpcionesIncorrectasSeleccionadasincorrectamente());
        }
        return respuestas;

    }

    @Override
    public String nombreDeLaClase() {
        return "penalizable";
    }
}
