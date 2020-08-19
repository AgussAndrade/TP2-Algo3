package edu.fiuba.algo3.modelo.EstrategiaTest;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaBuilder;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;
import edu.fiuba.algo3.modelo.estrategias.PuntajeParcial;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.opciones.Correcta;
import edu.fiuba.algo3.modelo.opciones.Incorrecta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {
    @Test
    public void test01UnJugadorRespondeCorrectamenteYPuntajeParcialSumaLosPuntosCorrectamente(){
        Estrategia puntajeParcial = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");
        List<Binaria> opciones = new ArrayList<>();
        Correcta opcionCorrecta = new Correcta("Correcta");
        Incorrecta opcionIncorrecta = new Incorrecta("Incorrecta");

        opcionCorrecta.seleccionar();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        List<Respuesta> respuestas = new ArrayList<>();
        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        respuestaBuilder.conSelecciones(List.copyOf(opciones));
        respuestaBuilder.conMultiplicador(new Multiplicador(1));
        Respuesta respuesta = respuestaBuilder.build();
        respuestas.add(respuesta);
        puntajeParcial.validarRespuestas(respuestas);

        assertEquals(1,respuesta.obtenerPuntos());
    }
}
