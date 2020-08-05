package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.estrategias.Estrategia;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.List;

public class VerdaderoFalso extends Pregunta {
    public VerdaderoFalso(String enunciado, List<Opcion> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }

}
