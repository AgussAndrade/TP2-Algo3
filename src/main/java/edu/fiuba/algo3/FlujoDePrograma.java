package edu.fiuba.algo3;

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
    List<String> ordenDeAparicionDeEscenas;
    ListIterator<String> escenaActual;

    public FlujoDePrograma(Stage stage){
        this.stage = stage;
        ordenDeAparicionDeEscenas = new ArrayList<String>();
        ordenDeAparicionDeEscenas.add("/vista/MenuDeInicio.fxml");
        ordenDeAparicionDeEscenas.add("/vista/InterfazRegistroJugadores.fxml");
        ordenDeAparicionDeEscenas.add("/vista/InterfazPreguntaVerdaderoYFalso.fxml");
        ordenDeAparicionDeEscenas.add("/vista/Final.fxml");
        escenaActual = ordenDeAparicionDeEscenas.listIterator();
    }

    public void primeraEscena() throws IOException {
        stage.setTitle("Kahoot!");
        loader = new FXMLLoader(getClass().getResource(ordenDeAparicionDeEscenas.get(0)));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        escenaActual.next();
    }

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

}