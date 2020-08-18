package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    public Button botonExclusividadJugador1;
    public Button botonExclusividadJugador2;
    public Button botonMultiplicadorX2Jugador1;
    public Button botonMultiplicadorX2Jugador2;
    public Button botonMultiplicadorX3Jugador1;
    public Button botonMultiplicadorX3Jugador2;
    private int multiplicador = 1;

    @FXML
    public void initialize() {
        cargarBotones();
        nombreJugador.setText(jugadores.get(jugadorActual).nombre());
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
        puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
        enunciadoPregunta.setText(preguntaActual.enunciado());
        iniciarTemporizador();
    }

    public void seleccionadoVerdadero(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        List<Binaria> selecciones =((VerdaderoFalso)preguntaActual).obtenerOpciones();
        selecciones.get(0).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        constructorDeRespuestaActual.conMultiplicador(new Multiplicador(multiplicador));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    public void seleccionadoFalso(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        List<Binaria> selecciones = ((VerdaderoFalso)preguntaActual).obtenerOpciones();
        selecciones.get(1).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        constructorDeRespuestaActual.conMultiplicador(new Multiplicador(multiplicador));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    public void activarExclusividad(ActionEvent actionEvent) {
        if(jugadorActual == 0){
            botonExclusividadJugador1.setVisible(false);
            llamadosAAplicadorDePuntos +=1;
        }
        else {
            botonExclusividadJugador2.setVisible(false);
            llamadosAAplicadorDePuntos +=1;
        }
    }

    public void activarMultiplicadorX2(ActionEvent actionEvent) {
        //       System.out.println(jugadorActual);
        if(jugadorActual == 0){
            botonMultiplicadorX2Jugador1.setVisible(false);
            botonMultiplicadorX3Jugador1.setVisible(false);
            multiplicador =2;
        }
        else {
            botonMultiplicadorX2Jugador2.setVisible(false);
            botonMultiplicadorX3Jugador2.setVisible(false);
            multiplicador = 2;
        }
    }

    public void activarMultiplicadorX3(ActionEvent actionEvent) {
        if(jugadorActual == 0){
            botonMultiplicadorX2Jugador1.setVisible(false);
            botonMultiplicadorX3Jugador1.setVisible(false);
            multiplicador = 3;
        }

        else {
            botonMultiplicadorX2Jugador2.setVisible(false);
            botonMultiplicadorX3Jugador2.setVisible(false);
            multiplicador = 3;
        }
    }
}
