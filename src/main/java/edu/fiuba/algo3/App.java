package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorPrincipal;
import edu.fiuba.algo3.lectorDePreguntas.LectorDePreguntasJson;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        LectorDePreguntasJson lectorDePreguntas = new LectorDePreguntasJson();
        List<Pregunta> preguntas = lectorDePreguntas.leerPreguntas("preguntas.json");
        ControladorPrincipal.inicializar(preguntas, stage);
    }

    public static void main(String[] args) {
        launch();
    }

}