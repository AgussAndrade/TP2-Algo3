package edu.fiuba.algo3.modelo;

import java.util.List;

public interface Estrategia {

    //void asignarPuntos(Respuesta respuesta);

    int puntosPorIncorrecta();

    int puntosPorCorrecta();

    void sumarPuntos(Jugador responsable, List<Opcion> selecciones);
}
