package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Kahoot kahoot = new Kahoot();
        kahoot.cargarPreguntas("preguntas.json");
        kahoot.iniciarVista(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}