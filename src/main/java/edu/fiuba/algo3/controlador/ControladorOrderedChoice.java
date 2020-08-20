package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opciones.Posicionable;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorOrderedChoice extends ControladorPregunta{
    private List<Posicionable> opciones;
    public ToggleButton opcion1, opcion2, opcion3, opcion4, opcion5, opcion6;
    private int posicion = 1;
    List<ToggleButton> botonesOpcion = new ArrayList<>();

    public void initialize() {
        cargarBotones();
        inicializarLabelsPregunta();
        ajustarLabel(enunciadoPregunta);
        botonesOpcion.add(opcion1);
        botonesOpcion.add(opcion2);
        botonesOpcion.add(opcion3);
        botonesOpcion.add(opcion4);
        botonesOpcion.add(opcion5);
        botonesOpcion.add(opcion6);
        opciones = ((OrderedChoice)preguntaActual).obtenerOpciones();
        Collections.shuffle(opciones);
        int i = 0;
        for (Posicionable opcion : opciones) {
            botonesOpcion.get(i).setText(opcion.texto());
            botonesOpcion.get(i).setVisible(true);
            i++;
        }
        for (; i < botonesOpcion.size(); i++) {
            ((AnchorPane)botonesOpcion.get(i).getParent()).getChildren().remove(botonesOpcion.get(i));
        }
        iniciarTemporizador();
    }

    public void responder(ActionEvent actionEvent) throws IOException {
        accionExclusividad();
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        constructorDeRespuestaActual.conSelecciones(List.copyOf(opciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    public void seleccionarOpcion(ActionEvent actionEvent) {
        System.out.print(((ToggleButton) actionEvent.getSource()).getId());
        opciones.get(botonesOpcion.indexOf(((ToggleButton) actionEvent.getSource()))).seleccionar(posicion);
        constructorDeRespuestaActual.conSelecciones(List.copyOf(opciones));
        ((ToggleButton) actionEvent.getSource()).setDisable(true);
        posicion += 1;
    }
}
