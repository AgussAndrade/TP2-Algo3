package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Interfaz.ControladorInicio;
import edu.fiuba.algo3.Interfaz.ControladorPrincipal;
import edu.fiuba.algo3.modelo.lectorDePreguntas.LectorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Kahoot {
    List<Jugador> jugadores;
    List<Pregunta> preguntas;
    LectorDePreguntas lectorDePreguntas;
    FXMLLoader loader;
    Parent root;
    Scene scene ;
    Stage stage;

    public Kahoot(Stage stage) throws IOException {
        /*Se arma la ventana inicial*/
        this.stage = stage;
        stage.setTitle("Kahoot!");
        loader = new FXMLLoader(getClass().getResource("/MenuDeInicio.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        lectorDePreguntas = new LectorDePreguntas();
        preguntas = lectorDePreguntas.leerPreguntas("preguntas.json");
        ControladorPrincipal.inicializar(preguntas);
    }

}