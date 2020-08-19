package edu.fiuba.algo3.controlador;

import javafx.scene.control.Label;

import java.io.IOException;

public class ControladorResumenDePuntos extends ControladorPregunta {
    public Label nombreJugador1;
    public Label nombreJugador2;
    public Label puntosJugador1;
    public Label puntosJugador2;
    public Label difJugador1;
    public Label difJugador2;
    public Label nombreJugador;
    private int diferenciaActualJ1 = 0;
    private int diferenciaActualJ2 = 0;
    public void initialize() throws IOException {
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntosJugador1.setText(String.valueOf(jugadores.get(0).puntos()));
        puntosJugador2.setText(String.valueOf(jugadores.get(1).puntos()));
        diferenciaActualJ1 = jugadores.get(0).puntos() - diferenciaActualJ1;
        diferenciaActualJ2 = jugadores.get(1).puntos() - diferenciaActualJ2;
        if(diferenciaActualJ1 > 0){
            difJugador1.setText("+" + String.valueOf(jugadores.get(0).puntos()));
        }
        else{
            difJugador1.setText(String.valueOf(jugadores.get(0).puntos()));
        }
        if(diferenciaActualJ2 > 0){
            difJugador2.setText("+" + String.valueOf(jugadores.get(1).puntos()));
        }
        else{
            difJugador2.setText(String.valueOf(jugadores.get(1).puntos()));
        }
    }
    public void irALaPregunta() throws IOException {
        flujoDePrograma.escenaIntermedia();
    }
}
