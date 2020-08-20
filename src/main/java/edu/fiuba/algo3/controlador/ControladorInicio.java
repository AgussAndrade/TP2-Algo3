package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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
        flujoDePrograma.siguienteEscena();
    }

    public void pausarMusica(ActionEvent actionEvent) {
        flujoDePrograma.pausarMusica();
    }

    public void PonerKakut(ActionEvent actionEvent) {
        flujoDePrograma.musica("kakut");
    }

    public void PonerClasico(ActionEvent actionEvent) {
        flujoDePrograma.musica("clasico");
    }

    public void setearDiezSegundos(ActionEvent actionEvent) {
        tiempoBase = 10;
    }

    public void setearVeinteSegundos(ActionEvent actionEvent) {
        tiempoBase = 20;
    }

    public void setearTreintaSegundos(ActionEvent actionEvent) {
        tiempoBase = 30;
    }
}