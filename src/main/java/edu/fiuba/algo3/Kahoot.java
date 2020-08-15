package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorPrincipal;
import edu.fiuba.algo3.lectorDePreguntas.LectorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Kahoot {
    List<Pregunta> preguntas;

    public Kahoot(){
    }

    public void cargarPreguntas(String archivoPreguntas){
        LectorDePreguntas lectorDePreguntas = new LectorDePreguntas();
        preguntas = lectorDePreguntas.leerPreguntas(archivoPreguntas);
    }

    public void iniciarVista(Stage stage) throws IOException {
        ControladorPrincipal.inicializar(preguntas, stage);
    }
}