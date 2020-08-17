package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaBuilder;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;
import edu.fiuba.algo3.modelo.multiplicadores.AplicadorSimple;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.*;

public class ControladorPregunta extends ControladorPrincipal {
    public Label nombreJugador;
    public Label tiempo;
    public Button botonMultiplicadorX3Jugador1;
    public Button botonMultiplicadorX2Jugador1;
    public Button botonExclusividadJugador1;
    public Button botonMultiplicadorX3Jugador2;
    public Button botonMultiplicadorX2Jugador2;
    public Button botonExclusividadJugador2;

    Timer temporizador;
    int tiempoRestante;
    int jugadorActual = 0;
    static Pregunta preguntaActual;
    List<Respuesta> respuestas = new ArrayList<>();
    RespuestaBuilder constructorDeRespuestaActual = new RespuestaBuilder();
    public void initialize() throws IOException {
        Platform.runLater(()-> {
            try {
                flujoDePrograma.escenaParaPregunta(preguntaActual=preguntas.remove(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    protected void continuar() throws IOException {
        if (jugadorActual < jugadores.size() - 1){
            temporizador.cancel();
            nombreJugador.setText(jugadores.get(++jugadorActual).nombre());
            cargarBotones();
            iniciarTemporizador();
        }else{
            preguntaActual.comprobarRespuestas(respuestas,new AplicadorSimple());
            temporizador.cancel();
            if (!preguntas.isEmpty()){
                flujoDePrograma.escenaParaPregunta(preguntaActual=preguntas.remove(0));
            }else {
                jugadorActual=0;
                flujoDePrograma.siguienteEscena();
            }
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

    public void cargarBotones() {
        String estrategia = preguntaActual.devolverEstrategia().getClass().getSimpleName();
        if(jugadorActual == 0){
            if(estrategia == "Penalizable"){
                botonExclusividadJugador1.setVisible(false);
                botonExclusividadJugador2.setVisible(false);
                botonMultiplicadorX2Jugador2.setVisible(false);
                botonMultiplicadorX2Jugador1.setVisible(true);
                botonMultiplicadorX3Jugador2.setVisible(false);
                botonMultiplicadorX3Jugador1.setVisible(true);

            }
            else{
                botonExclusividadJugador1.setVisible(false);
                botonExclusividadJugador2.setVisible(false);
                botonMultiplicadorX2Jugador1.setVisible(false);
                botonMultiplicadorX2Jugador2.setVisible(false);
                botonMultiplicadorX3Jugador1.setVisible(false);
                botonMultiplicadorX3Jugador2.setVisible(false);
            }
        }
        else{
            if(estrategia == "Penalizable"){
                botonExclusividadJugador2.setVisible(false);
                botonExclusividadJugador1.setVisible(false);
                botonMultiplicadorX2Jugador1.setVisible(false);
                botonMultiplicadorX2Jugador2.setVisible(true);
                botonMultiplicadorX3Jugador1.setVisible(false);
                botonMultiplicadorX3Jugador2.setVisible(true);

            }
            else{
                botonExclusividadJugador2.setVisible(false);
                botonExclusividadJugador1.setVisible(false);
                botonMultiplicadorX2Jugador2.setVisible(false);
                botonMultiplicadorX2Jugador1.setVisible(false);
                botonMultiplicadorX3Jugador2.setVisible(false);
                botonMultiplicadorX3Jugador1.setVisible(false);
            }
        }
    }
}
