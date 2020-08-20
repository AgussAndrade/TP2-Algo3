package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.List;

public class ControladorVerdaderoFalso extends ControladorPregunta{

    List<Binaria> selecciones;

    @FXML
    public void initialize() {
        cargarBotones();
        inicializarLabelsPregunta();
        ajustarLabel(enunciadoPregunta);
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        selecciones =((VerdaderoFalso)preguntaActual).obtenerOpciones();
        iniciarTemporizador();
    }

    public void seleccionadoVerdadero(ActionEvent actionEvent) throws IOException {
        if((selecciones.get(0).texto()).equals("Verdadero")){
            selecciones.get(0).seleccionar();
        }else{

            selecciones.get(1).seleccionar();
        }
        accionExclusividad();
        responder();
    }

    public void seleccionadoFalso(ActionEvent actionEvent) throws IOException {
        if((selecciones.get(0).texto()).equals("Falso")){
            selecciones.get(0).seleccionar();
        }else{
            selecciones.get(1).seleccionar();
        }
        accionExclusividad();
        responder();
    }

    private void responder() throws IOException {
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }
}
