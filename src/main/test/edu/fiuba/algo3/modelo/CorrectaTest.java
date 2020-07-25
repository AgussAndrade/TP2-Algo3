package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CorrectaTest {
    @Test
    public void test01UnaOpcionCorrectaSabeCuantosPuntosConsigueSegunUnaEstrategia(){
        Estrategia estrategia = new Clasica(1);
        Opcion correcta = new Correcta("Argentina es un Pais");
        assertEquals(1, correcta.obtenerPuntos(estrategia));
    }
}
