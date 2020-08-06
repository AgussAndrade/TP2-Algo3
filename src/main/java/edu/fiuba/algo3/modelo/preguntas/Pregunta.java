package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;
import java.util.List;

public abstract class Pregunta {
    protected String enunciado;
    protected List<Opcion> opciones;
    protected Estrategia estrategia;

    public String enunciado(){
        return enunciado;
    }

    public void comprobarRespuestas(List<Respuesta> respuestas){
        for(Respuesta respuesta : respuestas) {
            respuesta.jugador().sumarPuntos(estrategia.devolverSumaDePuntos(respuesta));
        }
    }

    public List<Opcion> obtenerOpciones(){
        List<Opcion> opcionesCopiadas = new ArrayList<>();
        for(Opcion opcionACopiar : opciones){
            opcionesCopiadas.add(opcionACopiar.copiarOpcion());
        }
        return opcionesCopiadas;
    }
}