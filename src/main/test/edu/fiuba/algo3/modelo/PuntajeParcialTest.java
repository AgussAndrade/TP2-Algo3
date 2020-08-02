package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {
    @Test
    public void test01UnJugadorRespondeCorrectamenteYPuntajeParcialSumaLosPuntosCorrectamente(){
        Estrategia puntajeParcial = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");
        List<Opcion> opciones = new ArrayList<>();
        Opcion opcionCorrecta = new Correcta("Correcta");
        Opcion opcionIncorrecta = new Incorrecta("Incorrecta");

        opcionCorrecta.seleccionar();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Respuesta respuesta = new Respuesta(jugador,opciones);

        puntajeParcial.sumarPuntos(respuesta);

        assertEquals(1,jugador.puntos());
    }
}
