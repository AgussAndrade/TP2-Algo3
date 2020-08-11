package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Interfaz.ControladorInicio;
import edu.fiuba.algo3.Interfaz.ControladorPrincipal;
import edu.fiuba.algo3.modelo.lectorDePreguntas.ColeccionDePreguntas;
import edu.fiuba.algo3.modelo.lectorDePreguntas.LectorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

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