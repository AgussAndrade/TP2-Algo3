package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalso extends Pregunta {
    private VerdaderoFalso(String enunciado,List<Opcion> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }

}
