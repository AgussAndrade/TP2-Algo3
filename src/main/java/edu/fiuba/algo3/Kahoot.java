package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorPrincipal;
import edu.fiuba.algo3.lectorDePreguntas.LectorDePreguntasJson;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Kahoot {
    List<Pregunta> preguntas;

    public Kahoot(){
    }

    public void cargarPreguntas(String archivoPreguntas){
        LectorDePreguntasJson lectorDePreguntas = new LectorDePreguntasJson();
        preguntas = lectorDePreguntas.leerPreguntas(archivoPreguntas);
    }

    public void iniciarVista(Stage stage) throws IOException {
        ControladorPrincipal.inicializar(preguntas, stage);
    }
}