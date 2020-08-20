package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorPrincipal;
import edu.fiuba.algo3.lectorDePreguntas.LectorDePreguntasJson;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.application.Application;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class App extends Application {
    public MediaPlayer mediaPlayer;


    @Override
    public void start(Stage stage) throws Exception {
        LectorDePreguntasJson lectorDePreguntas = new LectorDePreguntasJson();
        List<Pregunta> preguntas = lectorDePreguntas.leerPreguntas("preguntas.json");
        ControladorPrincipal.inicializar(preguntas, stage);
        music();
    }

    public void music(){
        String song = new File("src/main/resources/music/Kahoot2Tension.mp3").toURI().toString();
        mediaPlayer = new MediaPlayer(new Media(song));
        mediaPlayer.play();
        mediaPlayer.setVolume(0.3);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public static void main(String[] args) {
        launch();
    }
}