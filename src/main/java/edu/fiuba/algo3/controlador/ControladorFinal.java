package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.lectorDePreguntas.LectorDePreguntasJson;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.List;

public class ControladorFinal extends ControladorPregunta{
    public Label puntosDelGanador;
    public Label nombreDelGanador;

    public void initialize(){
        String ganador;
        int puntosGanador;
        if (jugadores.get(0).puntos() > jugadores.get(1).puntos()){
            ganador = jugadores.get(0).nombre();
            puntosGanador = jugadores.get(0).puntos();
        }
        else {
            ganador = jugadores.get(1).nombre();
            puntosGanador = jugadores.get(1).puntos();
        }
        nombreDelGanador.setText(ganador);
        puntosDelGanador.setText(String.valueOf(puntosGanador));
    }

    public void seleccionadoSalir(ActionEvent actionEvent) throws IOException {
        flujoDePrograma.siguienteEscena();
    }

    public void seleccionadovolverAJugar(ActionEvent actionEvent) throws IOException {
        LectorDePreguntasJson lectorDePreguntas = new LectorDePreguntasJson();
        List<Pregunta> preguntas = lectorDePreguntas.leerPreguntas("preguntas.json");
        ControladorPrincipal.inicializar(preguntas, flujoDePrograma.stage());
    }
}
