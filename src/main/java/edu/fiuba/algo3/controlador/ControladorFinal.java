package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.io.IOException;

public class ControladorFinal extends ControladorPrincipal{
    public Label puntajeJugador1;
    public Label nombreJugador2;
    public Label puntajeJugador2;
    public Label nombreJugador1;

    public void initialize(){
        puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
        nombreJugador1.setText(jugadores.get(0).nombre());
    }

    public void seleccionadoSalir(ActionEvent actionEvent) throws IOException {
        flujoDePrograma.siguienteEscena();
    }
}
