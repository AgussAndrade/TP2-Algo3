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
        List<Opcion> selecciones = new ArrayList<>();
        List<Opcion> opcionesPosibles = new ArrayList<>();
        Opcion opcionCorrecta = new Correcta("Correcta");
        Opcion opcionIncorrecta = new Incorrecta("Incorrecta");

        opcionesPosibles.add(opcionCorrecta);
        opcionesPosibles.add(opcionIncorrecta);

        selecciones.add(opcionCorrecta);
        selecciones.add(opcionIncorrecta);

        Respuesta respuesta = new Respuesta(jugador,selecciones);

        puntajeParcial.sumarPuntos(respuesta,opcionesPosibles);

        assertEquals(1,jugador.puntos());
    }
}
