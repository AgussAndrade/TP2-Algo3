package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.multiplicadores.AplicadorDePuntos;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;

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
    public Estrategia devolverEstrategia(){
        return estrategia;
    }

}
