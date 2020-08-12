package edu.fiuba.algo3.Interfaz;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ControladorRegistroDeJugadores extends ControladorPrincipal {
    @FXML
    public TextField nombreJugador1;
    public Button enviar;
    public TextField nombreJugador2;
    @FXML
    public AnchorPane anchorPrincipal;

    public void registrarJugadores(ActionEvent actionEvent) throws IOException {
        jugadores.add(new Jugador(nombreJugador1.getText()));
        jugadores.add(new Jugador(nombreJugador2.getText()));
        flujoDePrograma.siguienteEscena();
    }
}