package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
public class ControladorInicio extends ControladorPrincipal {

    public Button botonIniciar;

    public void initialize(){
        Platform.runLater(()->botonIniciar.requestFocus());
    }

    @FXML
    public void iniciarJuego() throws IOException {
        flujoDePrograma.escenaRegistroDeJugadores();
    }
}
//ControladorMenuDeInicio controladorPrincipal = (ControladorMenuDeInicio)loader.getController();