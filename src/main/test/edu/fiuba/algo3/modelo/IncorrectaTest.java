package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IncorrectaTest {
    @Test
    public void test01UnaOpcionIncorrectaSabeCuantosPuntosConsigueSegunUnaEstrategia(){
        Estrategia estrategia = new Clasica(1);
        Opcion incorrecta = new Incorrecta("Argentina es un Pais");
        assertEquals(0, incorrecta.obtenerPuntos(estrategia));
    }
}