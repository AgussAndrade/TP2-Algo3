package edu.fiuba.algo3.modelo;

import java.util.List;

public interface Estrategia {

    int puntosPorIncorrecta();

    int puntosPorCorrecta();

    void sumarPuntos(Respuesta respuesta);

}
