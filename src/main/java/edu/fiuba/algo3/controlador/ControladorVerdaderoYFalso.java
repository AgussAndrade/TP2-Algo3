
package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.multiplicadores.AplicadorSimple;
import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.*;

public class ControladorVerdaderoYFalso extends ControladorPregunta{

    public Label nombreJugador;
    public Label enunciadoPregunta;
    public Label tiempo;
    public Label puntajeJugador1;
    public Label puntajeJugador2;
    public Label nombreJugador2;
    public Label nombreJugador1;
    int tiempoRestante;
    Timer temporizador;

    List<Respuesta> respuestas = new ArrayList<>();
    RespuestaBuilder constructorDeRespuestaActual = new RespuestaBuilder();
    int jugadorActual = 0;

    @FXML
    public void initialize() {
        iniciarTemporizador();
        nombreJugador.setText(jugadores.get(jugadorActual).nombre());
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
        puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
        enunciadoPregunta.setText(preguntas.get(0).enunciado());
    }

    public void seleccionadoVerdadero(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        List<Binaria> selecciones =((VerdaderoFalso)preguntaActual).obtenerOpciones();
        selecciones.get(0).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    public void seleccionadoFalso(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        List<Binaria> selecciones = ((VerdaderoFalso)preguntaActual).obtenerOpciones();
        selecciones.get(1).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    public void activarExclusividad(ActionEvent actionEvent) {
    }

    public void activarMultiplicadorX2(ActionEvent actionEvent) {
        constructorDeRespuestaActual.conMultiplicador(new Multiplicador(2));
    }

    public void activarMultiplicadorX3(ActionEvent actionEvent) {
        constructorDeRespuestaActual.conMultiplicador(new Multiplicador(3));
    }

}