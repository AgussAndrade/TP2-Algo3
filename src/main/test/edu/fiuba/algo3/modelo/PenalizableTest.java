package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PenalizableTest {
    @Test
    public void test01UnaEstrategiaPenalizableSumaPuntosPorRespuestaCorrecta(){
        Penalizable estrategia = new Penalizable();
        assertEquals(1, estrategia.puntosPorCorrecta());
    }

    @Test
    public void test02UnaEstrategiaPenalizableRestaPuntosPorRespuestaIncorrecta(){
        Penalizable estrategia = new Penalizable();
        assertEquals(-1, estrategia.puntosPorIncorrecta());
    }

    @Test
    public void test03unJugadorTieneUnaRespuestaCorrectaEIncorrectaYTiene0puntos(){

        Estrategia penalizable = new Penalizable();
        Jugador jugador = new Jugador("Juan");
        List<Opcion> selecciones = new ArrayList<>();

        selecciones.add(new Correcta("Correcta"));
        selecciones.add(new Incorrecta("Incorrecta"));

        Respuesta respuesta = new Respuesta(jugador,selecciones);

        penalizable.sumarPuntos(respuesta);

        assertEquals(0,jugador.puntos());
    }
}
