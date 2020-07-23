package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaTest {

    @Test
    public void test01UnaRespuestaRecibeUnJugadorYSeValidaCorrectamente(){
        Jugador jugador = new Jugador("Juan");
        Opcion opcion = new Correcta("falso");
        Estrategia clasica = new Clasica();

        Respuesta respuestaJugador = new Respuesta(jugador, opcion);
        respuestaJugador.validar(clasica);

        assertEquals(1, jugador.puntos());

    }

}
