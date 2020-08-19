package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaBuilder;
import edu.fiuba.algo3.modelo.aplicadores.AplicadorFactory;
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
    static int jugadorActual = 0;
    static int llamadosAAplicadorDePuntos = 0;
    static Pregunta preguntaActual;
    static List<Respuesta> respuestas = new ArrayList<>();
    RespuestaBuilder constructorDeRespuestaActual = new RespuestaBuilder();

    public void initialize() throws IOException {
        //System.out.print("seCreoControladorPregunta\n");
        Platform.runLater(()-> {
            try {
                flujoDePrograma.escenaParaPregunta(preguntaActual=preguntas.remove(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    protected void continuar() throws IOException {
        temporizador.cancel();
        if (jugadorActual < jugadores.size() - 1){
            temporizador.cancel();
      //      System.out.print(jugadorActual + "\n");
            nombreJugador.setText(jugadores.get(++jugadorActual).nombre());
            flujoDePrograma.escenaIntermedia();
        }else{
            preguntaActual.comprobarRespuestas(respuestas, AplicadorFactory.creacAplicadorSegunLosLlamados(llamadosAAplicadorDePuntos));
            llamadosAAplicadorDePuntos = 0;
            if (!preguntas.isEmpty()){
                jugadorActual=0;
                respuestas.clear();
                preguntaActual=preguntas.remove(0);
                flujoDePrograma.escenaIntermedia();
            }else {
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
        //System.out.println(jugadorActual);
        if(jugadorActual == 0){
            if(estrategia.equals("Penalizable")){
                botonExclusividadJugador1.setVisible(false);
                botonExclusividadJugador2.setVisible(false);
                botonMultiplicadorX2Jugador2.setVisible(false);
                botonMultiplicadorX2Jugador1.setVisible(true);
                botonMultiplicadorX3Jugador2.setVisible(false);
                botonMultiplicadorX3Jugador1.setVisible(true);

            }
            else{
                botonExclusividadJugador1.setVisible(true);
                botonExclusividadJugador2.setVisible(false);
                botonMultiplicadorX2Jugador1.setVisible(false);
                botonMultiplicadorX2Jugador2.setVisible(false);
                botonMultiplicadorX3Jugador1.setVisible(false);
                botonMultiplicadorX3Jugador2.setVisible(false);
            }
        }
        else{
            if(estrategia.equals("Penalizable")){
                botonExclusividadJugador2.setVisible(false);
                botonExclusividadJugador1.setVisible(false);
                botonMultiplicadorX2Jugador1.setVisible(false);
                botonMultiplicadorX2Jugador2.setVisible(true);
                botonMultiplicadorX3Jugador1.setVisible(false);
                botonMultiplicadorX3Jugador2.setVisible(true);

            }
            else{
                botonExclusividadJugador2.setVisible(true);
                botonExclusividadJugador1.setVisible(false);
                botonMultiplicadorX2Jugador2.setVisible(false);
                botonMultiplicadorX2Jugador1.setVisible(false);
                botonMultiplicadorX3Jugador2.setVisible(false);
                botonMultiplicadorX3Jugador1.setVisible(false);
            }
        }
    }
}
