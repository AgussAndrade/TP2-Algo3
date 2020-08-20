package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

import java.io.IOException;
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
    public ToggleButton opcion1;
    public ToggleButton opcion2;
    public ToggleButton opcion3;
    public ToggleButton opcion4;
    private  List<Binaria> opciones;
    @FXML
    public void initialize() {
        cargarBotones();
        nombreJugador.setText(jugadores.get(jugadorActual).nombre());
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
        puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
        enunciadoPregunta.setText(preguntaActual.enunciado());
        ajustarLabel(enunciadoPregunta);
        opciones = ((MultipleChoice)preguntaActual).obtenerOpciones();
        Collections.shuffle(opciones);
        if( opciones.size() >= 1){
            opcion1.setVisible(true);
            opcion1.setText(opciones.get(0).texto());
        }
        else{
            opcion1.setVisible(false);
        }
        if( opciones.size() >= 2){
            opcion2.setVisible(true);
            opcion2.setText(opciones.get(1).texto());
        }
        else{
            opcion2.setVisible(false);
        }
        if( opciones.size() >= 3){
            opcion3.setVisible(true);
            opcion3.setText(opciones.get(2).texto());
        }
        else{
            opcion3.setVisible(false);
        }
        if( opciones.size() >= 4){
            opcion4.setVisible(true);
            opcion4.setText(opciones.get(3).texto());
        }
        else{
            opcion4.setVisible(false);
        }

        List<Binaria> opciones =((MultipleChoice)preguntaActual).obtenerOpciones();

        iniciarTemporizador();
    }

    public void responder(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        constructorDeRespuestaActual.conSelecciones(List.copyOf(opciones));
        respuestas.add(constructorDeRespuestaActual.build());

        continuar();
    }

    public void activarOpcion1(ActionEvent actionEvent){
        opciones.get(0).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(opciones));
    }
    public void activarOpcion2(ActionEvent actionEvent){
        opciones.get(1).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(opciones));
    }
    public void activarOpcion3(ActionEvent actionEvent){
        opciones.get(2).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(opciones));
    }
    public void activarOpcion4(ActionEvent actionEvent){
        opciones.get(3).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(opciones));
    }
}
