package edu.fiuba.algo3.controlador;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.io.IOException;

public class ControladorPantallaIntermedia extends ControladorPregunta {
    public Label nombreJugador;
    public void initialize() throws IOException {
        nombreJugador.setText(jugadores.get(jugadorActual).nombre());
    }
    public void irALaPregunta() throws IOException {
        flujoDePrograma.escenaParaPregunta(preguntaActual);
    }
}
