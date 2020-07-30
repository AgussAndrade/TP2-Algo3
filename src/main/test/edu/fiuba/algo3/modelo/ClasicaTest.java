package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClasicaTest {
    @Test
    public void test01unaEstrategiaClasicaDevuelve1PuntosPorRespuestaCorrecta(){
        Clasica estrategia = new Clasica(1);
        assertEquals(1, estrategia.puntosPorCorrecta());
    }

    @Test
    public void test02unaEstrategiaClasicaDevuelve0PuntosPorRespuestaIncorrecta(){
        Clasica estrategia = new Clasica(1);
        assertEquals(0, estrategia.puntosPorIncorrecta());
    }

    @Test
    public void test03unJugadorTieneUnaRespuestaCorrectaEIncorrectaYTiene0puntos(){

        Estrategia clasica = new Clasica(1);
        Jugador jugador = new Jugador("Juan");
        List<Opcion> selecciones = new ArrayList<>();

        selecciones.add(new Correcta("Correcta"));
        selecciones.add(new Incorrecta("Incorrecta"));

        Respuesta respuesta = new Respuesta(jugador,selecciones);

        clasica.sumarPuntos(respuesta);

        assertEquals(0,jugador.puntos());
    }

    @Test
    public void test03unJugadorTieneUnaRespuestaCorrectaYTiene1punto(){

        Estrategia clasica = new Clasica(1);
        Jugador jugador = new Jugador("Juan");
        List<Opcion> selecciones = new ArrayList<>();

        selecciones.add(new Correcta("Correcta"));

        Respuesta respuesta = new Respuesta(jugador,selecciones);

        clasica.sumarPuntos(respuesta);

        assertEquals(1,jugador.puntos());
    }
}
