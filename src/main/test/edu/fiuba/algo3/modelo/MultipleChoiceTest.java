package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
    @Test
    public void test01UnaPreguntaDeMultipleChoiceCompruebaUnaRespuestaCorrectamente() {
        String nombre = "Cuales son provincias";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Clasica());
        Jugador jugador = new Jugador("Juan");

        opciones.get(0).seleccionar();
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(jugador, opciones));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }
}
