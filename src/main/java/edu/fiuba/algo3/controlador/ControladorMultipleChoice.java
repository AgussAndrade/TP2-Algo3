package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ControladorMultipleChoice extends ControladorPregunta{
    public Label nombreJugador;
    public Label enunciadoPregunta;
    public Label tiempo;
    public Label puntajeJugador1;
    public Label puntajeJugador2;
    public Label nombreJugador2;
    public Label nombreJugador1;
    public Button opcion1;
    public Button opcion2;
    public Button opcion3;
    public Button opcion4;
    private  List<Binaria> selecciones;

    @FXML
    public void initialize() {
        nombreJugador.setText(jugadores.get(jugadorActual).nombre());
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
        puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
        enunciadoPregunta.setText(preguntaActual.enunciado());
        selecciones = ((MultipleChoice)preguntaActual).obtenerOpciones();
        Collections.shuffle(selecciones);
        opcion1.setText(selecciones.get(0).texto());
        opcion2.setText(selecciones.get(1).texto());
        opcion3.setText(selecciones.get(2).texto());
        opcion4.setText(selecciones.get(3).texto());

        List<Binaria> opciones =((MultipleChoice)preguntaActual).obtenerOpciones();

        iniciarTemporizador();
    }

    public void responder(ActionEvent actionEvent) throws IOException {
        ToggleButton toggleButton = new ToggleButton();
        toggleButton.isSelected();
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    public void activarOpcion1(ActionEvent actionEvent){
        selecciones.get(0).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
    }
    public void activarOpcion2(ActionEvent actionEvent){
        selecciones.get(1).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
    }
    public void activarOpcion3(ActionEvent actionEvent){
        selecciones.get(2).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
    }
    public void activarOpcion4(ActionEvent actionEvent){
        selecciones.get(3).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
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
