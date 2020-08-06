package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.opciones.Correcta;
import edu.fiuba.algo3.modelo.opciones.Incorrecta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
//        String nombre = "España es un pais";
//
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new Correcta("Correcta"));
//        opciones.add(new Incorrecta("Incorrecta"));
//
//        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());
//        Group interfazPreguntaVerdaderoYFalso = new InterfazPreguntaVerdaderoYFalso(pregunta);
//        Scene scene = new Scene(interfazPreguntaVerdaderoYFalso,1280,600);
//        Scene scene1 = new Scene(new InterfazPedirJugadores(),700,600);
//        stage.setScene(scene1);
//
//
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}