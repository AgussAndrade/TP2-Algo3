package edu.fiuba.algo3.modelo.estrategias;

import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class Clasica implements Estrategia {
    @Override

    public List<Respuesta> validarRespuestas(List<Respuesta> respuestas) {
        List<Respuesta> respondieronCorrectamente = new ArrayList<>();
        for(Respuesta respuesta : respuestas){
            if(respuesta.cantidadDeOpcionesSeleccionadasCorrectamente() == respuesta.cantidadDeOpciones()){
                respuesta.definirPuntosAAgregar(1);
                respondieronCorrectamente.add(respuesta);
            }
            else{
                respuesta.definirPuntosAAgregar(0);
            }
        }
        return respondieronCorrectamente;
    }



}