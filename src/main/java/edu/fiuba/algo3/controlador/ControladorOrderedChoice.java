package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Posicionable;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ControladorOrderedChoice extends ControladorPregunta{
    public Label nombreJugador;
    public Label enunciadoPregunta;
    public Label tiempo;
    public Label puntajeJugador1;
    public Label puntajeJugador2;
    public Label nombreJugador2;
    public Label nombreJugador1;
    private List<Posicionable> opciones;
    public ToggleButton opcion1;
    public ToggleButton opcion2;
    public ToggleButton opcion3;
    public ToggleButton opcion4;
    public ToggleButton opcion5;
    public ToggleButton opcion6;
    private int posicion = 1;


    public void initialize() {
        cargarBotones();
        nombreJugador.setText(jugadores.get(jugadorActual).nombre());
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
        puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
        enunciadoPregunta.setText(preguntaActual.enunciado());
        ajustarLabel(enunciadoPregunta);
        System.out.println(((OrderedChoice)preguntaActual).obtenerOpciones());
        opciones = ((OrderedChoice)preguntaActual).obtenerOpciones();
        Collections.shuffle(opciones);

        if( opciones.size() >= 1){
            opcion1.setVisible(true);
            opcion1.setText(opciones.get(0).texto());
        }
        else{
            opcion1.setVisible(false);
        }
        if( opciones.size() >= 2){
            opcion2.setVisible(true);
            opcion2.setText(opciones.get(1).texto());
        }
        else{
            opcion2.setVisible(false);
        }
        if( opciones.size() >= 3){
            opcion3.setVisible(true);
            opcion3.setText(opciones.get(2).texto());
        }
        else{
            opcion3.setVisible(false);
        }
        if( opciones.size() >= 4){
            opcion4.setVisible(true);
            opcion4.setText(opciones.get(3).texto());
        }
        else{
            opcion4.setVisible(false);
        }
        if( opciones.size() >= 5){
            opcion5.setVisible(true);
            opcion5.setText(opciones.get(4).texto());
        }
        else{
            opcion5.setVisible(false);
        }
        if( opciones.size() >= 6){
            opcion6.setVisible(true);
            opcion6.setText(opciones.get(5).texto());
        }
        else{
            opcion6.setVisible(false);
        }
        iniciarTemporizador();
    }

    public void responder(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        constructorDeRespuestaActual.conSelecciones(List.copyOf(opciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    public void seleccionarOpcion(ActionEvent actionEvent){
        if (opcion1.isSelected() && !(opcion1.isDisabled())){
            (opciones.get(0)).seleccionar(posicion);
            opcion1.setDisable(true);
            posicion += 1;
        }
        if (opcion2.isSelected() && !(opcion2.isDisabled())){
            (opciones.get(1)).seleccionar(posicion);
            opcion2.setDisable(true);
            posicion += 1;
        }
        if (opcion3.isSelected() && !(opcion3.isDisabled())){
            (opciones.get(2)).seleccionar(posicion);
            opcion3.setDisable(true);
            posicion += 1;
        }
        if (opcion4.isSelected() && !(opcion4.isDisabled())){
            (opciones.get(3)).seleccionar(posicion);
            opcion4.setDisable(true);
            posicion += 1;
        }
        if (opcion5.isSelected() && !(opcion5.isDisabled())){
            (opciones.get(4)).seleccionar(posicion);
            opcion5.setDisable(true);
            posicion += 1;
        }
        if (opcion6.isSelected() && !(opcion6.isDisabled())){
            (opciones.get(5)).seleccionar(posicion);
            opcion6.setDisable(true);
            posicion += 1;
        }
    }
}
