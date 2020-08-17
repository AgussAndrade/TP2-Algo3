package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opciones.Posicionable;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;

public class ControladorOrderedChoice extends ControladorPregunta{
    public Label nombreJugador;
    public Label enunciadoPregunta;
    public Label tiempo;
    public Label puntajeJugador1;
    public Label puntajeJugador2;
    public Label nombreJugador2;
    public Label nombreJugador1;

    public void initialize() {
        nombreJugador.setText(jugadores.get(jugadorActual).nombre());
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
        puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
        enunciadoPregunta.setText(preguntaActual.enunciado());
        iniciarTemporizador();
    }

    public void responder(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        List<Posicionable> selecciones = ((OrderedChoice)preguntaActual).obtenerOpciones();
//        selecciones.get(1).seleccionar("");
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    public void activarExclusividad(ActionEvent actionEvent) {
    }
}
