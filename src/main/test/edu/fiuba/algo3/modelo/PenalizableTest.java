package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PenalizableTest {

    @Test
    public void test01unJugadorSeleccionaUnaRespuestaCorrectaYUnaIncorrectaYSuma0puntos(){

        Estrategia penalizable = new Penalizable();
        Jugador jugador = new Jugador("Juan");

        List<Opcion> opciones = new ArrayList<>();
        Opcion opcionCorrecta = new Correcta("Correcta");
        Opcion opcionIncorrecta = new Incorrecta("Incorrecta");

        opcionCorrecta.seleccionar();
        opcionIncorrecta.seleccionar();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        Respuesta respuesta = new Respuesta(jugador,opciones,new Multiplicador(1),false);


        penalizable.sumarPuntos(respuesta);

        assertEquals(0,jugador.puntos());
    }
}