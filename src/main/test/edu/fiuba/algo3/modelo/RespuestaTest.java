package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaTest {

    @Test
    public void test01UnaRespuestaRecibeUnJugadorYSeValidaCorrectamente(){
        Jugador jugador = new Jugador("Juan");
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("verdadero"));
        Estrategia clasica = new Clasica(1);

        Respuesta respuestaJugador = new Respuesta(jugador,opciones );
        respuestaJugador.validar(clasica);

        assertEquals(1, jugador.puntos());

    }

}
