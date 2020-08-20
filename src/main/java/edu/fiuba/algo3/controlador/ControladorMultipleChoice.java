package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ControladorMultipleChoice extends ControladorPregunta {
    public ToggleButton botonOpcion1, botonOpcion2, botonOpcion3, botonOpcion4, botonOpcion5;
    private List<Binaria> opciones;

    @FXML
    public void initialize() {
        cargarBotones();
        inicializarLabelsPregunta();
        ajustarLabel(enunciadoPregunta);
        opciones = ((MultipleChoice) preguntaActual).obtenerOpciones();
        Collections.shuffle(opciones);
        ToggleButton[] botonesOpciones = new ToggleButton[]{botonOpcion1, botonOpcion2, botonOpcion3, botonOpcion4, botonOpcion5};
        int i = 0;
        for (Binaria opcion : opciones) {
            botonesOpciones[i].setText(opciones.get(i).texto());
            botonesOpciones[i].setVisible(true);
            i++;
        }
        for (; i < botonesOpciones.length; i++) {
            ((HBox)botonesOpciones[i].getParent()).getChildren().remove(botonesOpciones[i]);
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

    public void activarOpcion(ActionEvent actionEvent) {
        if (((ToggleButton) actionEvent.getSource()).isSelected()) {
            opciones.get(Integer.parseInt(((ToggleButton) actionEvent.getSource()).getId())-1).seleccionar();
        } else opciones.get(Integer.parseInt(((ToggleButton) actionEvent.getSource()).getId())-1).deseleccionar();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(opciones));
    }
}
