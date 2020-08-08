package edu.fiuba.algo3.Interfaz;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.List;

public class ControladorPrincipal {
    public Button botonIniciar;

    @FXML
    public StackPane vistaHolder;
    public AnchorPane anchorInicio;

    public void inicializar(List<Jugador> jugadores, List<Pregunta> preguntas){

    }

    public void iniciarJuego() throws IOException {
        AnchorPane nuevoAnchorPane = FXMLLoader.load(getClass().getResource("/InterfazRegistroJugadores.fxml"));
        anchorInicio.getChildren().setAll(nuevoAnchorPane);
        //ControladorMenuDeInicio controladorPrincipal = (ControladorMenuDeInicio)loader.getController();
    }
}
