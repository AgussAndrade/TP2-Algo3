package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;

import java.io.IOException;
public class ControladorInicio extends ControladorPrincipal {

    public Button botonIniciar;
    public SplitMenuButton menuMusica;
    public SplitMenuButton menuTiempo;

    public void initialize(){
        Platform.runLater(()->botonIniciar.requestFocus());

    }

    @FXML
    public void iniciarJuego() throws IOException {
        flujoDePrograma.siguienteEscena();
    }

    public void pausarMusica(ActionEvent actionEvent) {
        menuMusica.setText("Sin musica");
        flujoDePrograma.pausarMusica();
    }

    public void PonerKakut(ActionEvent actionEvent) {
        menuMusica.setText("Kakut");
        flujoDePrograma.musica("kakut");
    }

    public void PonerClasico(ActionEvent actionEvent) {
        menuMusica.setText("Clasico");
        flujoDePrograma.musica("clasico");
    }

    public void setearDiezSegundos(ActionEvent actionEvent) {
        menuTiempo.setText("10");
        tiempoBase = 10;
    }

    public void setearVeinteSegundos(ActionEvent actionEvent) {
        menuTiempo.setText("20");
        tiempoBase = 20;
    }

    public void setearTreintaSegundos(ActionEvent actionEvent) {
        menuTiempo.setText("30");
        tiempoBase = 30;
    }
}