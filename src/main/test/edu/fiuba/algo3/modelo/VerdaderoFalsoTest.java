package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    @Test
    public void test01UnaPreguntaVerdaderoFalsoCompruebaUnaRespuestaCorrectamente() {
        String nombre = "España es un pais";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Correcta"));
        opciones.add(new Incorrecta("Incorrecta"));

        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());
        Jugador jugador = new Jugador("Juan");

        List<Respuesta> respuestas = new ArrayList<>();
        opciones.get(0).seleccionar();
        respuestas.add(new Respuesta(jugador, opciones,new Multiplicador(1),false));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }
}
