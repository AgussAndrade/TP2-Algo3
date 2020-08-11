package edu.fiuba.algo3.Interfaz;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.lectorDePreguntas.ColeccionDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.ArrayList;
import java.util.List;

public abstract class ControladorPrincipal {
    static public ColeccionDePreguntas preguntas;
    static public List<Jugador> jugadores;

    public static void inicializar(ColeccionDePreguntas _preguntas){
        jugadores = new ArrayList<>();
        preguntas = _preguntas;
    }
}
