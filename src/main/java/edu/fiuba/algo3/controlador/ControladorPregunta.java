package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaBuilder;
import edu.fiuba.algo3.modelo.multiplicadores.AplicadorSimple;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.*;

public class ControladorPregunta extends ControladorPrincipal {
    public javafx.scene.layout.BorderPane BorderPane;

    public Label enunciadoPregunta;
    public Label puntajeJugador1;
    public Label puntajeJugador2;
    public Label nombreJugador1;
    public Label nombreJugador2;
    public Label nombreJugador;
    public Label tiempo;
    public javafx.scene.layout.BorderPane borderPane;

    Timer temporizador;
    int tiempoRestante;
    int jugadorActual = 0;
    Pregunta preguntaActual;
    List<Respuesta> respuestas = new ArrayList<>();
    RespuestaBuilder constructorDeRespuestaActual = new RespuestaBuilder();



    public void initialize() throws IOException {
        borderPane.setCenter(FXMLLoader.load(getClass().getResource("InterfazVerdaderoFalso")));
        flujoDePrograma.escenaParaPregunta(preguntaActual=preguntas.remove(0));
    }

    protected void continuar() throws IOException {
        if (jugadorActual < jugadores.size() - 1){
            System.out.print("continuar()\n");
            temporizador.cancel();
            nombreJugador.setText(jugadores.get(++jugadorActual).nombre());
            iniciarTemporizador();
        }else{
            preguntaActual.comprobarRespuestas(respuestas,new AplicadorSimple());
            temporizador.cancel();
            if (!preguntas.isEmpty()){
                flujoDePrograma.escenaParaPregunta(preguntaActual=preguntas.remove(0));
            }else flujoDePrograma.siguienteEscena();
        }
    }

    protected void iniciarTemporizador(){
        temporizador = new Timer();
        tiempoRestante = 10;
        temporizador.schedule(new TimerTask(){
            @Override
            public void run() {
                Platform.runLater(()-> {
                    if (tiempoRestante>0){
                        tiempo.setText(Integer.toString(tiempoRestante));
                        tiempoRestante--;
                    }
                    else try {
                        continuar();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

        }, 0,1000);
    }
}
