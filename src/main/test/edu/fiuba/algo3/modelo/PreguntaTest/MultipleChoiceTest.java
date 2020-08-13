package edu.fiuba.algo3.modelo.PreguntaTest;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.multiplicadores.AplicadorSimple;
import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.opciones.Correcta;
import edu.fiuba.algo3.modelo.opciones.Incorrecta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {
    @Test
    public void test01UnaPreguntaDeMultipleChoiceCompruebaUnaRespuestaCorrectamente() {
        String nombre = "Cuales son provincias";

        List<Binaria> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Clasica());
        Jugador jugador = new Jugador("Juan");

        opciones.get(0).seleccionar();
        List<Respuesta> respuestas = new ArrayList<>();
        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        List<Opcion> opcionesAAgregarJugador = List.copyOf(opciones);
        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());
        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test02UnaPreguntaDeMultipleChoiceRecibeOpcionesYLasDevuelve() {
        String nombre = "Cuales son provincias";

        List<Binaria> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));

        MultipleChoice pregunta = new MultipleChoice(nombre, opciones, new Clasica());

        List<Binaria> opcionesDevueltas = pregunta.obtenerOpciones();

        assertEquals(opciones.get(0).texto(), opcionesDevueltas.get(0).texto());
        assertEquals(opciones.get(0).getClass(), opcionesDevueltas.get(0).getClass());
        assertEquals(opciones.get(1).texto(), opcionesDevueltas.get(1).texto());
        assertEquals(opciones.get(1).getClass(), opcionesDevueltas.get(1).getClass());
    }
}
