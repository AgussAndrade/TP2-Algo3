package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Interfaz.ControladorPrincipal;
import edu.fiuba.algo3.Interfaz.ControladorRegistroDeJugadores;
import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.opciones.Correcta;
import edu.fiuba.algo3.modelo.opciones.Incorrecta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kahoot {
    List<Jugador> jugadores;
    List<Pregunta> preguntas;
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
        stage.show();
        ControladorPrincipal controladorPrincipal = (ControladorPrincipal) loader.getController();
        controladorPrincipal.inicializar(jugadores, preguntas);
    }


}