package edu.fiuba.algo3.Interfaz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
public class ControladorInicio extends ControladorPrincipal {
    public AnchorPane anchorInicio;

    @FXML
    public void iniciarJuego() throws IOException {
        AnchorPane nuevoAnchorPane = FXMLLoader.load(getClass().getResource("/InterfazRegistroJugadores.fxml"));
        anchorInicio.getChildren().setAll(nuevoAnchorPane);
    }
}
//ControladorMenuDeInicio controladorPrincipal = (ControladorMenuDeInicio)loader.getController();
