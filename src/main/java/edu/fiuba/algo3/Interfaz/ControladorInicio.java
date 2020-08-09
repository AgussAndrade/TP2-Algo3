package edu.fiuba.algo3.Interfaz;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.List;

public class ControladorInicio {
    @FXML
    public Button botonIniciar;

    @FXML
    public AnchorPane anchorInicio;

    public void inicializar(List<Jugador> jugadores, List<Pregunta> preguntas){

    }

    @FXML
    public void iniciarJuego() throws IOException {
        AnchorPane nuevoAnchorPane = FXMLLoader.load(getClass().getResource("/InterfazRegistroJugadores.fxml"));
        anchorInicio.getChildren().setAll(nuevoAnchorPane);
        //ControladorMenuDeInicio controladorPrincipal = (ControladorMenuDeInicio)loader.getController();
    }
}
