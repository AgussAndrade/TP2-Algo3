package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.preguntas.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FlujoDePrograma {
    public MediaPlayer mediaPlayer = null;
    private final Stage stage;
    static FXMLLoader loader;
    static Parent root;
    static Scene scene ;
    List<String> ordenDeAparicionDeEscenas;
    ListIterator<String> escenaActual;

    public FlujoDePrograma(Stage stage){
        this.stage = stage;
        stage.setTitle("Kahoot!");

        ordenDeAparicionDeEscenas = new ArrayList<>();
        ordenDeAparicionDeEscenas.add("/vista/MenuDeInicio.fxml");
        ordenDeAparicionDeEscenas.add("/vista/InterfazRegistroJugadores.fxml");
        ordenDeAparicionDeEscenas.add("/vista/InterfazPregunta.fxml");
        ordenDeAparicionDeEscenas.add("/vista/Final.fxml");

        escenaActual = ordenDeAparicionDeEscenas.listIterator();
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

    public void escenaParaPregunta(Pregunta pregunta) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/vista/InterfazPregunta" + pregunta.getClass().getSimpleName() + ".fxml" ));
//        ((ControladorPregunta)loader.getController()).cargarBotones(pregunta.devolverEstrategia(),pregunta);
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void escenaIntermedia() throws IOException {
        loader = new FXMLLoader(getClass().getResource("/vista/PantallaIntermedia.fxml" ));
//        ((ControladorPregunta)loader.getController()).cargarBotones(pregunta.devolverEstrategia(),pregunta);
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void escenaResumenDePuntos() throws IOException {
        loader = new FXMLLoader(getClass().getResource("/vista/ResumenDePuntos.fxml" ));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Stage stage() {
        return stage;
    }
    public void musica(String nombre_cancion){
        if (mediaPlayer != null){
            mediaPlayer.pause();
        }
        String cancion = new File("src/main/resources/music/" + nombre_cancion + ".mp3").toURI().toString();
        mediaPlayer = new MediaPlayer(new Media(cancion));
        mediaPlayer.play();
        mediaPlayer.setVolume(0.2);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void pausarMusica() {
        if (mediaPlayer != null){
            mediaPlayer.pause();
        }
    }
}