package edu.fiuba.algo3.modelo.estrategias;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;

import java.util.List;

public class Penalizable implements Estrategia {
    @Override
    public List<Respuesta> validarRespuestas(List<Respuesta> respuestas){
        for(Respuesta respuesta : respuestas) {
            int puntosAAgregar = respuesta.multiplicador().multiplicarPuntos(respuesta.cantidadDeOpcionesCorrectasSeleccionadasCorrectamente() - respuesta.cantidadDeOpcionesIncorrectasSeleccionadasincorrectamente());
            respuesta.definirPuntosAAgregar(puntosAAgregar);
        }
        return respuestas;

    }



}
