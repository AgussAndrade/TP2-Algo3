package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrderedChoice extends Pregunta {

    public OrderedChoice(String enunciado, List<Opcion> opciones, EstrategiaOrderedChoice estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }
}
