package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class FlujoDePrograma {
    private final Stage stage;
    static FXMLLoader loader;
    static Parent root;
    static Scene scene ;
    List<String> ordenDeAparicionDeEscenas;
    ListIterator<String> escenaActual;

    public FlujoDePrograma(Stage stage){
        this.stage = stage;
        stage.setTitle("Kahoot!");

        Dictionary vistasDePregunta = new Hashtable();
        vistasDePregunta.put(VerdaderoFalso.class,"InterfazVerdaderoFalso.fxml");
        vistasDePregunta.put(GroupChoice.class,"InterfazGroupChoice.fxml");
        vistasDePregunta.put(MultipleChoice.class,"InterfazMultipleChoice.fxml");
        vistasDePregunta.put(OrderedChoice.class,"InterfazOrderedChoice.fxml");

        ordenDeAparicionDeEscenas = new ArrayList<String>();
        ordenDeAparicionDeEscenas.add("/vista/MenuDeInicio.fxml");
        ordenDeAparicionDeEscenas.add("/vista/InterfazRegistroJugadores.fxml");
        ordenDeAparicionDeEscenas.add("/vista/InterfazPregunta.fxml");
        ordenDeAparicionDeEscenas.add("/vista/Final.fxml");

        escenaActual = ordenDeAparicionDeEscenas.listIterator();
    }

//    public void primeraEscena() throws IOException {
//        stage.setTitle("Kahoot!");
//        loader = new FXMLLoader(getClass().getResource(ordenDeAparicionDeEscenas.get(0)));
//        root = loader.load();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
//        escenaActual.next();
//    }

    public void siguienteEscena() throws IOException {
        if (escenaActual.hasNext()) {
            loader = new FXMLLoader(getClass().getResource(escenaActual.next()));
            root = loader.load();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            stage.close();
            System.exit(0);
        }
    }

    public void escenaParaPregunta(Pregunta pregunta) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/vista/InterfazPregunta" + pregunta.getClass().getSimpleName() + pregunta.devolverEstrategia().getClass().getSimpleName() + ".fxml" ));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}