package edu.fiuba.algo3.Interfaz;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class ControladorVerdaderoYFalso {
    /*MODELO*/
    private Pregunta pregunta;
    private List<Jugador> jugadores;

    /*VISTA*/
    /* private URL vistaPregunta = getClass().getResource("/InterfazPreguntaVerdaderoYFalso.fxml");*/
    public Label nombreJugador1, puntajeJugador1, puntajeJugador2, enunciado, temporizador, nombreJugador2;
    public Button botonVerdadero, botonFalso;

    public ControladorVerdaderoYFalso(){
    }

    @FXML
    public void initialize() {
        nombreJugador1.setText("nombreJugador1");
        nombreJugador2.setText("nombreJugador2");
        enunciado.setText("Verdadero o falso");
    }

    public void inicializar(Pregunta pregunta, List<Jugador> jugadores){
        this.pregunta = pregunta;
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        enunciado.setText(pregunta.enunciado());
    }

    public void seleccionadoVerdadero(ActionEvent actionEvent) {
        enunciado.setText("Verdadero");
    }

    public void seleccionadoFalso(ActionEvent actionEvent) {
        enunciado.setText("Falso");
    }
}