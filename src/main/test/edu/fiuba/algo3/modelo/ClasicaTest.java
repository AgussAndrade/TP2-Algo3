package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClasicaTest {
    @Test
    public void test01UnaEstrategiaClasicaDevuelve1PuntosPorRespuestaCorrecta(){
        Clasica estrategia = new Clasica();
        assertEquals(1, estrategia.puntosPorCorrecta());
    }

    @Test
    public void test02UnaEstrategiaClasicaDevuelve0PuntosPorRespuestaIncorrecta(){
        Clasica estrategia = new Clasica();
        assertEquals(0, estrategia.puntosPorIncorrecta());
    }
}
