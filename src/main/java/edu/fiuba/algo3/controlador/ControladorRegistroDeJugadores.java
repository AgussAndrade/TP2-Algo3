package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ControladorRegistroDeJugadores extends ControladorPrincipal {
    public TextField nombreJugador1;
    public TextField nombreJugador2;
    public Button enviar;

    public void initialize(){
        Platform.runLater(()->nombreJugador1.requestFocus());
    }

    public void registrarJugadores(ActionEvent actionEvent) throws IOException {
        jugadores.add(new Jugador(nombreJugador1.getText()));
        jugadores.add(new Jugador(nombreJugador2.getText()));
        if(preguntas.isEmpty()){
            flujoDePrograma.escenaFinal();
        }
        else{
            flujoDePrograma.escenaParaPregunta(preguntas.get(0));
        }
    }

    public void enterCampoJugador1(ActionEvent actionEvent) throws IOException {
        if (nombreJugador2.getText().isBlank()){
            nombreJugador2.requestFocus();
        } else {
            registrarJugadores(new ActionEvent());
        }
    }

    public void enterCampoJugador2(ActionEvent actionEvent) throws IOException {
        if (nombreJugador1.getText().isBlank()){
            nombreJugador1.requestFocus();
        } else {
            registrarJugadores(new ActionEvent());
        }
    }
}