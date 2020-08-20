package edu.fiuba.algo3.controlador;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ControladorResumenDePuntos extends ControladorPregunta {
    public Label nombreJugador1;
    public Label nombreJugador2;
    public Label puntosJugador1;
    public Label puntosJugador2;
    public Label puntosAnterioresJugador1Label;
    public Label puntosAnterioresJugador2Label;
    public Label puntosGanadosJugador1Label;
    public Label puntosGanadosJugador2Label;
    public Label nombreJugador;
    public AnchorPane informacionJugador1;
    public AnchorPane informacionJugador2;


    public void initialize() throws IOException {
        int diferenciaActualJ1 = jugadores.get(0).puntos() - puntosAnterioresJugador1;
        int diferenciaActualJ2 = jugadores.get(1).puntos() - puntosAnterioresJugador2;

        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntosJugador1.setText(String.valueOf(jugadores.get(0).puntos()));
        puntosJugador2.setText(String.valueOf(jugadores.get(1).puntos()));
        puntosAnterioresJugador1Label.setText(String.valueOf(puntosAnterioresJugador1));
        puntosAnterioresJugador2Label.setText(String.valueOf(puntosAnterioresJugador2));


        if(diferenciaActualJ1 > 0){
            puntosGanadosJugador1Label.setText("+" + String.valueOf(diferenciaActualJ1));
            informacionJugador1.setStyle("-fx-background-color: #43B581 ; -fx-background-radius: 30 30 30 30");
        }
        else if(diferenciaActualJ1 == 0){
            puntosGanadosJugador1Label.setText("+" + String.valueOf(diferenciaActualJ1));
            informacionJugador1.setStyle("-fx-background-color: #F04747 ; -fx-background-radius: 30 30 30 30");
        }
        else{
            puntosGanadosJugador1Label.setText(String.valueOf(diferenciaActualJ1));
            informacionJugador1.setStyle("-fx-background-color: #F04747 ; -fx-background-radius: 30 30 30 30");
        }
        if(diferenciaActualJ2 > 0){
            puntosGanadosJugador2Label.setText("+" + String.valueOf(diferenciaActualJ2));
            informacionJugador2.setStyle("-fx-background-color: #43B581 ; -fx-background-radius: 30 30 30 30");
        }
        else if(diferenciaActualJ2 == 0){
            puntosGanadosJugador2Label.setText("+" + String.valueOf(diferenciaActualJ2));
            informacionJugador2.setStyle("-fx-background-color: #F04747 ; -fx-background-radius: 30 30 30 30");
        }
        else{
            puntosGanadosJugador2Label.setText(String.valueOf(diferenciaActualJ2));
            informacionJugador2.setStyle("-fx-background-color: #F04747 ; -fx-background-radius: 30 30 30 30");
        }
        puntosAnterioresJugador1 = jugadores.get(0).puntos();
        puntosAnterioresJugador2 = jugadores.get(1).puntos();
    }

    public void irALaPregunta() throws IOException {
        flujoDePrograma.escenaIntermedia();
    }
}
