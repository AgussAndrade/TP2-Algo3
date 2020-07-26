package edu.fiuba.algo3.modelo;

import java.util.List;

public class MultipleChoice extends Pregunta {

    public MultipleChoice(String enunciado, List<Opcion> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }
}
