package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorPrincipal;
import edu.fiuba.algo3.lectorDePreguntas.ColeccionDePreguntas;
import edu.fiuba.algo3.lectorDePreguntas.LectorDePreguntas;
import javafx.stage.Stage;

import java.io.IOException;

public class Kahoot {
    ColeccionDePreguntas preguntas;

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