package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {
    @Test
    public void test01UnaPreguntaDeVerdaderoYFalsoPuedeCrearseIndicandoleLaRespuestaCorrecta(){
        String nombre = "Argentina es un pais";
        Opcion opcionCorrecta = new Opcion("falso", new Correcta);
        Opcion opcionIncorrecta = new Opcion("verdadero", new IncorrectaClasica);
        Pregunta pregunta = new PreguntaVerdaderoFalso(nombre, opcionCorrecta, opcionIncorrecta);
        assertEquals("Argentina es un pais", pregunta.nombre());
    }
    @Test
    public void test02UnaPreguntaDeVerdaderoFalsoClásicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){
        String nombre = "argensimia es un pais";
        Opcion opcionCorrecta = new Opcion("falso", new Correcta);
        Opcion opcionIncorrecta = new Opcion("verdadero", new IncorrectaClasica);
        Pregunta pregunta = new PreguntaVerdaderoFalso(nombre, opcionCorrecta, opcionIncorrecta);
        assertEquals("Argentina es un pais", pregunta.nombre());

    }
}
/*     */