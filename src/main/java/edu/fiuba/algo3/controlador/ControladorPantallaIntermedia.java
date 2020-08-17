package edu.fiuba.algo3.controlador;

import javafx.application.Platform;

import java.io.IOException;

public class ControladorPantallaIntermedia extends ControladorPregunta {
    public void initialize() throws IOException {
    }
    public void irALaPregunta() throws IOException {
        flujoDePrograma.escenaParaPregunta(preguntaActual);
    }
}
