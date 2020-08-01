package edu.fiuba.algo3.modelo;

import javafx.scene.control.skin.SliderSkin;

import java.util.List;

public interface Estrategia {
    void sumarPuntos(Respuesta respuesta , List<Opcion> opciones);

}
