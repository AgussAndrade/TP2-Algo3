package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {
    @Test
    public void test01UnaEstrategiaPuntajeParcialDevuelve1PuntosPorRespuestaCorrecta(){
        PuntajeParcial estrategia = new PuntajeParcial();
        assertEquals(1, estrategia.puntosPorCorrecta());
    }

    @Test
    public void test02UnaEstrategiaPuntajeParcialDevuelve0PuntosPorRespuestaIncorrecta(){
        PuntajeParcial estrategia = new PuntajeParcial();
        assertEquals(0, estrategia.puntosPorIncorrecta());
    }

    @Test
    public void test03UnJugadorRespondeCorrectamenteYPuntajeParcialSumaLosPuntosCorrectamente(){
        Estrategia puntajeParcial = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");
        List<Opcion> selecciones = new ArrayList<>();

        selecciones.add(new Correcta("Correcta"));
        selecciones.add(new Incorrecta("Incorrecta"));

        Respuesta respuesta = new Respuesta(jugador,selecciones);

        puntajeParcial.sumarPuntos(respuesta);

        assertEquals(1,jugador.puntos());
    }
}
