package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.respuesta.RespuestaBuilder;
import edu.fiuba.algo3.modelo.aplicadores.AplicadorFactory;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

import java.io.IOException;
import java.util.*;

public class ControladorPregunta extends ControladorPrincipal {
    public Label nombreJugador;
    public Label tiempo;
    public ToggleButton botonExclusividadJugador1;
    public ToggleButton botonExclusividadJugador2;
    public ToggleButton botonMultiplicadorX2;
    public ToggleButton botonMultiplicadorX3;
    Timer temporizador;
    int tiempoRestante;
    static int jugadorActual = 0;
    static int llamadosAAplicadorDePuntos = 0;
    static Pregunta preguntaActual;
    static List<Respuesta> respuestas = new ArrayList<>();
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
        temporizador.cancel();
        if (jugadorActual < jugadores.size() - 1){
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
        temporizador = new Timer(true);//Avisa que es un thread secundario y debe finalizar al finalizar el programa
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
        System.out.println(jugadorActual);
        if(estrategia.equals("Penalizable")){
            botonExclusividadJugador1.setVisible(false);
            botonExclusividadJugador2.setVisible(false);
            botonMultiplicadorX2.setVisible(true);
            botonMultiplicadorX2.setSelected(false);
            botonMultiplicadorX3.setSelected(false);
            botonMultiplicadorX3.setVisible(true);
        }else{
            if(jugadorActual == 0){
                botonExclusividadJugador1.setVisible(true);
                botonExclusividadJugador2.setVisible(false);
                if(llamadosExclusividadJugador1 >=2){
                    botonExclusividadJugador1.setDisable(true);
                }
            }else{
                botonExclusividadJugador1.setVisible(false);
                botonExclusividadJugador2.setVisible(true);
                if(llamadosExclusividadJugador2 >=2){
                    botonExclusividadJugador2.setDisable(true);
                }
            }
            botonMultiplicadorX2.setVisible(false);
            botonMultiplicadorX3.setVisible(false);
        }
    }

    public void accionExclusividad() {
        if((jugadorActual == 0) && botonExclusividadJugador1.isSelected()){
            llamadosAAplicadorDePuntos +=1;
            llamadosExclusividadJugador1 ++;
        }else if((jugadorActual == 1) && botonExclusividadJugador2.isSelected()){
            llamadosAAplicadorDePuntos +=1;
            llamadosExclusividadJugador2 ++;
        }
    }

    public void activarMultiplicadorX2(ActionEvent actionEvent) {

        botonMultiplicadorX3.setSelected(false);
        constructorDeRespuestaActual.conMultiplicador(new Multiplicador(2));
    }

    public void activarMultiplicadorX3(ActionEvent actionEvent) {

        botonMultiplicadorX2.setSelected(false);
        constructorDeRespuestaActual.conMultiplicador(new Multiplicador(3));
    }
}
