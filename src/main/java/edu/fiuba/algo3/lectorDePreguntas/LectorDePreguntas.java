package edu.fiuba.algo3.lectorDePreguntas;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.List;

public interface LectorDePreguntas {
    List<Pregunta> leerPreguntas(String direccion);
}
