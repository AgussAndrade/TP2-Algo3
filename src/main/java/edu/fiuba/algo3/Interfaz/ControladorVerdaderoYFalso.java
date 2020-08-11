package edu.fiuba.algo3.Interfaz;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Multiplicador;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaBuilder;
import edu.fiuba.algo3.modelo.opciones.Correcta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ControladorVerdaderoYFalso extends ControladorPrincipal{

    public Label nombreJugador;
    public Label enunciadoPregunta;
    public Label tiempo;
    public Label puntajeJugador1;
    public Label puntajeJugador2;
    public Label nombreJugador2;
    public Label nombreJugador1;

    List<Respuesta> respuestas = new ArrayList<>();
    RespuestaBuilder constructorDeRespuestaActual;
    ListIterator<Jugador> jugadorActual;

    @FXML
    public void initialize() {
        jugadorActual = jugadores.listIterator();
        nombreJugador.setText(jugadores.get(0).nombre());
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
        puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
//        enunciadoPregunta.setText(preguntas.get(0).enunciado());
    }

    public void seleccionadoVerdadero(ActionEvent actionEvent) {
//        constructorDeRespuestaActual.conResponsable(jugadorActual.next());
//        List<Opcion> selecciones = preguntas.get(0);
//        constructorDeRespuestaActual.conSelecciones(selecciones);
//        respuestas.add(constructorDeRespuestaActual.build());
    }

    public void seleccionadoFalso(ActionEvent actionEvent) {
//        List<Opcion> selecciones = preguntas.get(0);
//        constructorDeRespuestaActual.conSelecciones(selecciones);
//        respuestas.add(constructorDeRespuestaActual.build());
    }

    public void activarExclusividad(ActionEvent actionEvent) {
    }

    public void activarMultiplicadorX2(ActionEvent actionEvent) {
//        constructorDeRespuestaActual.conMultiplicador(new Multiplicador(2));
    }

    public void activarMultiplicadorX3(ActionEvent actionEvent) {
//        constructorDeRespuestaActual.conMultiplicador(new Multiplicador(3));
    }
}