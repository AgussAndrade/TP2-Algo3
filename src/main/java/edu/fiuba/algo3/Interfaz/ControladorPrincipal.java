package edu.fiuba.algo3.Interfaz;

import edu.fiuba.algo3.modelo.FlujoDePrograma;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.lectorDePreguntas.ColeccionDePreguntas;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ControladorPrincipal {
    static public ColeccionDePreguntas preguntas;
    static public List<Jugador> jugadores;
    static FlujoDePrograma flujoDePrograma;
    static public AnchorPane anchorInicio;


    public static void inicializar(ColeccionDePreguntas _preguntas, Stage stage) throws IOException {
        jugadores = new ArrayList<>();
        preguntas = _preguntas;
        flujoDePrograma = new FlujoDePrograma(stage);
        flujoDePrograma.primeraEscena();
    }
}
