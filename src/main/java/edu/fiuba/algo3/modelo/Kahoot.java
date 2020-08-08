package edu.fiuba.algo3.modelo;

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
    }

    public void iniciarJuego() throws IOException {

        /*Se cargan de archivo las preguntas*/
        List<Jugador> jugadores = new ArrayList<>();
        List<Pregunta> preguntas= new ArrayList<>();
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Correcta"));
        opciones.add(new Incorrecta("Incorrecta"));
        preguntas.add(new VerdaderoFalso("Brasil es un pais", opciones, new Clasica()));

        /*Se cargan los jugadores -  Deberia hacerse en un controlador*/
        jugadores.add(new Jugador("Juan"));
        jugadores.add(new Jugador("Roberto"));

    }
}
//    ControladorMenuDeInicio controladorPrincipal = (ControladorMenuDeInicio)loader.getController();