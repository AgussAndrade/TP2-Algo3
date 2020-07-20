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
/*    @Test
    public void test02UnaPreguntaDeVerdaderoFalsoClásicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){
        String nombre = "argensimia es un pais";
        Opcion opcionCorrecta = new Opcion("falso", new Correcta);
        Opcion opcionIncorrecta = new Opcion("verdadero", new IncorrectaClasica);
        Pregunta pregunta = new PreguntaVerdaderoFalso(nombre, opcionCorrecta, opcionIncorrecta);
        assertEquals("Argentina es un pais", pregunta.nombre());
    } */
}

