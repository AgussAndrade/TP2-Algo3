package edu.fiuba.algo3.Interfaz;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
public class ControladorInicio extends ControladorPrincipal {
    public AnchorPane anchorInicio;

    @FXML
    public void iniciarJuego() throws IOException {
        flujoDePrograma.siguienteEscena();
    }
}
//ControladorMenuDeInicio controladorPrincipal = (ControladorMenuDeInicio)loader.getController();