package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Interfaz.ControladorPrincipal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlujoDePrograma {
    private final Stage stage;
    static FXMLLoader loader;
    static Parent root;
    static Scene scene ;
    static Stage _stage;
    List<String> ordenDeAparicionDeEscenas;

    public FlujoDePrograma(Stage stage){
        this.stage = stage;
        ordenDeAparicionDeEscenas = new ArrayList<String>();
        ordenDeAparicionDeEscenas.add("/MenuDeInicio.fxml");
        ordenDeAparicionDeEscenas.add("/InterfazRegistroJugadores.fxml");
        ordenDeAparicionDeEscenas.add("/InterfazPreguntaVerdaderoYFalso.fxml");
    }

    public void primeraEscena() throws IOException {
        stage.setTitle("Kahoot!");
        loader = new FXMLLoader(getClass().getResource(ordenDeAparicionDeEscenas.get(0)));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void siguienteEscena() throws IOException {
        ControladorPrincipal controladorActual = loader.getController();
    }

}
