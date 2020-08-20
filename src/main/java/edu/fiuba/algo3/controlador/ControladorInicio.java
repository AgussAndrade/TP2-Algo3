package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;

import java.io.IOException;
public class ControladorInicio extends ControladorPrincipal {

    public Button botonIniciar;
    public MenuButton menuMusica;
    public MenuButton menuTiempo;
    public Slider controlVolumen;

    public void initialize(){
        Platform.runLater(()->botonIniciar.requestFocus());
        controlVolumen.setValue(((flujoDePrograma.getMediaplayer()).getVolume()) * 100);
        controlVolumen.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                (flujoDePrograma.getMediaplayer()).setVolume(controlVolumen.getValue() / 100);
            }
        });
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

    public void setearTreintaSegundos(ActionEvent actionEvent) {
        menuTiempo.setText("30 segundos");
        tiempoBase = 30;
    }

    public void setearCuarentaYCincoSegundos(ActionEvent actionEvent) {
        menuTiempo.setText("45 segundos");
        tiempoBase = 45;
    }

    public void setearSesentaSegundos(ActionEvent actionEvent) {
        menuTiempo.setText("60 segundos");
        tiempoBase = 60;
    }
}