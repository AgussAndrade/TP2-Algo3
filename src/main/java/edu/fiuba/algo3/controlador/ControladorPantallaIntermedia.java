package edu.fiuba.algo3.controlador;

import javafx.scene.control.Label;

import java.io.IOException;

public class ControladorPantallaIntermedia extends ControladorPregunta {
    public Label nombreJugador;
    public Label tipoDePregunta;
    public void initialize() throws IOException {
        nombreJugador.setText(jugadores.get(jugadorActual).nombre());
        tipoDePregunta.setText( obtenerTextoPregunta());
    }

    private String obtenerTextoPregunta() {
        String respuesta = "";
        if (preguntaActual.getClass().getSimpleName().equals("VerdaderoFalso")){
            respuesta += "Pregunta verdadero y falso";
        }
        else if (preguntaActual.getClass().getSimpleName().equals("MultipleChoice")){
            respuesta += "Pregunta multiple choice";
        }
        else if (preguntaActual.getClass().getSimpleName().equals("GroupChoice")){
            respuesta += "Pregunta group choice";
        }
        else{
            respuesta += "Pregunta ordered choice";
        }
        return (respuesta + obtenertextoEstrategia());
    }

    private String obtenertextoEstrategia() {
        if(preguntaActual.devolverEstrategia().getClass().getSimpleName().equals("Clasica")){
            return " clasica";
        }
        else if(preguntaActual.devolverEstrategia().getClass().getSimpleName().equals("PuntajeParcial")){
            return " puntaje parcial";
        }
        else {
            return" penalizable";
        }
    }

    public void irALaPregunta() throws IOException {
        flujoDePrograma.escenaParaPregunta(preguntaActual);
    }
}
