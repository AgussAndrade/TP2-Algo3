package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FlujoDePrograma {
    private final Stage stage;
    static FXMLLoader loader;
    static Parent root;
    static Scene scene ;

    public FlujoDePrograma(Stage stage){
        this.stage = stage;
    }

    public void primeraEscena() throws IOException {
        stage.setTitle("Kahoot!");
        loader = new FXMLLoader(getClass().getResource("/vista/MenuDeInicio.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void escenaIntermedia () throws IOException{
        loader = new FXMLLoader(getClass().getResource("/vista/Final.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void escenaParaPregunta(Pregunta pregunta) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/vista/InterfazPregunta" + pregunta.getClass().getSimpleName() + pregunta.devolverEstrategia().getClass().getSimpleName() + ".fxml" ));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void escenaFinal() throws IOException {
            loader = new FXMLLoader(getClass().getResource("/vista/Final.fxml"));
            root = loader.load();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    public void salir() {
        stage.close();
        System.exit(0);
    }

    public void escenaRegistroDeJugadores() throws IOException {
        loader = new FXMLLoader(getClass().getResource("/vista/InterfazRegistroJugadores.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void siguienteEscena() throws IOException {
//        if (escenaActual.hasNext()) {
//            loader = new FXMLLoader(getClass().getResource(escenaActual.next()));
//            root = loader.load();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } else {
//            stage.close();
//            System.exit(0);
//        }
//    }

}