package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.aplicador.AplicadorSimple;
import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.opciones.Correcta;
import edu.fiuba.algo3.modelo.opciones.Incorrecta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    @Test
    public void test01UnaPreguntaVerdaderoFalsoCompruebaUnaRespuestaCorrectamente() {
        String nombre = "España es un pais";

        List<Binaria> opciones = new ArrayList<>();
        opciones.add(new Correcta("Correcta"));
        opciones.add(new Incorrecta("Incorrecta"));

        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());
        Jugador jugador = new Jugador("Juan");


        opciones.get(0).seleccionar();
        List<Respuesta> respuestas = new ArrayList<>();
        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        respuestaBuilder.conSelecciones(List.copyOf(opciones));
        respuestaBuilder.conMultiplicador(new Multiplicador(1));
        Respuesta respuesta = respuestaBuilder.build();
        respuestas.add(respuesta);pregunta.comprobarRespuestas(respuestas,new AplicadorSimple());
        assertEquals(1, jugador.puntos());
    }
}
