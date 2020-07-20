package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {
    @Test
    public void test01UnaPreguntaDeVerdaderoYFalsoPuedeCrearseIndicandoleLaRespuestaCorrecta(){
        String nombre = "Argentina es un pais";
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("falso"));
        opciones.add(new Incorrecta("verdadero"));
        Pregunta pregunta = new PreguntaVerdaderoFalso(nombre, opciones);
        assertEquals("Argentina es un pais", pregunta.nombre());
    }
    @Test
    public void test02UnaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){
        String nombre = "Argentina es un pais";
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("falso"));
        opciones.add(new Incorrecta("verdadero"));
        Pregunta pregunta = new PreguntaVerdaderoFalso(nombre, opciones);
        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(jugador, opciones.get(0)));
        respuestas.add(new Respuesta(jugadora, opciones.get(1)));
        pregunta.comprobarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
        assertEquals(0, jugadora.puntos());

    }
}

