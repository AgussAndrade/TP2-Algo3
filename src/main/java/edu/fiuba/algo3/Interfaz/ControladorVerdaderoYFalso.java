package edu.fiuba.algo3.Interfaz;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorVerdaderoYFalso extends ControladorPrincipal{

    public Label nombreJugador;
    public Label enunciadoPregunta;
    public Label tiempo;
    public Label puntajeJugador1;
    public Label puntajeJugador2;
    public Label nombreJugador2;
    public Label nombreJugador1;

    List<Respuesta> respuestas = new ArrayList<>();
    RespuestaBuilder constructorDeRespuestaActual = new RespuestaBuilder();
    int jugadorActual = 0;

    @FXML
    public void initialize() {
        nombreJugador.setText(jugadores.get(jugadorActual).nombre());
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
        puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
        enunciadoPregunta.setText(preguntas.get(0).enunciado());
    }

    public void seleccionadoVerdadero(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        List<Binaria> selecciones = preguntas.get(0).obtenerOpciones();
        selecciones.get(0).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    public void seleccionadoFalso(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        List<Binaria> selecciones = preguntas.get(0).obtenerOpciones();
        selecciones.get(1).seleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    private void continuar() throws IOException {
        System.out.print(jugadores.size());
        if (jugadorActual < jugadores.size() - 1){
            System.out.print("hasNext--------------------------\n");
            nombreJugador.setText(jugadores.get(jugadorActual++).nombre());
        }else{
            System.out.print("NoNext-----------------------------\n");
            preguntas.get(0).comprobarRespuestas(respuestas,new AplicadorSimple());
            puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
            puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
            flujoDePrograma.siguienteEscena();
        }
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