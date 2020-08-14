package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorPrincipal;
import edu.fiuba.algo3.lectorDePreguntas.ColeccionDePreguntas;
import edu.fiuba.algo3.lectorDePreguntas.LectorDePreguntas;
import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.opciones.Correcta;
import edu.fiuba.algo3.modelo.opciones.Incorrecta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kahoot {
//    ColeccionDePreguntas preguntas;
    List<Pregunta> preguntas = new ArrayList<>();


    public Kahoot(){
    }

    public void cargarPreguntas(String archivoPreguntas){
//        LectorDePreguntas lectorDePreguntas = new LectorDePreguntas();
//        preguntas = lectorDePreguntas.leerPreguntas(archivoPreguntas);
        List<Binaria> opciones = new ArrayList<>();
        Correcta opcionCorrecta = new Correcta("True");
        Incorrecta opcionIncorrecta = new Incorrecta("False");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        Pregunta pregunta = new VerdaderoFalso("nombre", opciones, new Clasica());
        preguntas.add(pregunta);
    }

    public void iniciarVista(Stage stage) throws IOException {
        ControladorPrincipal.inicializar(preguntas, stage);
    }
}