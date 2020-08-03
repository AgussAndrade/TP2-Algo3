package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class GroupChoice extends Pregunta {
    public GroupChoice(String enunciado, List<Opcion> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }
}