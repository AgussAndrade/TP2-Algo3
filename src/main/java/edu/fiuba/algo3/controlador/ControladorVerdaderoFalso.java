package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

import java.io.IOException;
import java.util.List;

public class ControladorVerdaderoFalso extends ControladorPregunta{

    public Label nombreJugador;
    public Label enunciadoPregunta;
    public Label tiempo;
    public Label puntajeJugador1;
    public Label puntajeJugador2;
    public Label nombreJugador2;
    public Label nombreJugador1;
    private int multiplicador = 1;
    List<Binaria> selecciones;

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
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        selecciones =((VerdaderoFalso)preguntaActual).obtenerOpciones();
        iniciarTemporizador();
    }

    public void seleccionadoVerdadero(ActionEvent actionEvent) throws IOException {
        if((selecciones.get(0).texto()).equals("Verdadero")){
            selecciones.get(0).seleccionar();
        }else{

            selecciones.get(1).seleccionar();
        }
        accionExclusividad();
        responder();
    }

    public void seleccionadoFalso(ActionEvent actionEvent) throws IOException {
        if((selecciones.get(0).texto()).equals("Falso")){
            selecciones.get(0).seleccionar();
        }else{
            selecciones.get(1).seleccionar();
        }
        accionExclusividad();
        responder();
    }

    private void responder() throws IOException {
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }
}
