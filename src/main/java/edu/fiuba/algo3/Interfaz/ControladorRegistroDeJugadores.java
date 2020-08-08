package edu.fiuba.algo3.Interfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorRegistroDeJugadores {
    @FXML
    public TextField nombreJugador1;
    public Button enviar;
    public TextField nombreJugador2;

    public void registrarJugadores(ActionEvent actionEvent) {
        nombreJugador1.getText();
    }
}
