package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

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
}
