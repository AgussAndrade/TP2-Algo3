package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.FlujoDePrograma;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ControladorPrincipal {
    static public List<Pregunta> preguntas;
    static public List<Jugador> jugadores;
    static FlujoDePrograma flujoDePrograma;
    private final double MAX_TEXT_WIDTH = 650;
    private final double defaultFontSize = 55;
    private final Font defaultFont = Font.font(defaultFontSize);


    public static void inicializar(List<Pregunta> _preguntas, Stage stage) throws IOException {
        jugadores = new ArrayList<>();
        preguntas = _preguntas;
        flujoDePrograma = new FlujoDePrograma(stage);
        flujoDePrograma.siguienteEscena();
    }

    public void ajustarLabel(Label label){
        Text tempText = new Text(label.getText());
        tempText.setFont(defaultFont);
        double textWidth = tempText.getLayoutBounds().getWidth();

        if (textWidth <= MAX_TEXT_WIDTH){
            label.setFont(defaultFont);
            label.setStyle("-fx-font-weight: bold");
        }else{
            double newFontSize = defaultFontSize * MAX_TEXT_WIDTH / textWidth;
            label.setFont(Font.font(defaultFont.getFamily(), newFontSize));
            label.setStyle("-fx-font-weight: bold");
        }
    }
}
