package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.FlujoDePrograma;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ControladorPrincipal {
    static public List<Pregunta> preguntas;
    static public List<Jugador> jugadores;
    static FlujoDePrograma flujoDePrograma;


    public static void inicializar(List<Pregunta> _preguntas, Stage stage) throws IOException {
        jugadores = new ArrayList<>();
        preguntas = _preguntas;
        flujoDePrograma = new FlujoDePrograma(stage);
        flujoDePrograma.siguienteEscena();
    }
}
