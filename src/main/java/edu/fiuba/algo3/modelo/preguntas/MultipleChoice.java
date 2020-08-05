package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;

import java.util.List;

public class MultipleChoice extends Pregunta {

    public MultipleChoice(String enunciado, List<Opcion> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }
}
