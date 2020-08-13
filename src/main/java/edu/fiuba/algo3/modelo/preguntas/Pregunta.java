package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.AplicadorDePuntos;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;
import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected Estrategia estrategia;

    public String enunciado(){
        return enunciado;
    }

    public void comprobarRespuestas(List<Respuesta> respuestas, AplicadorDePuntos aplicador){
        aplicador.sumarPuntos(estrategia.validarRespuestas(respuestas));
    }

}
