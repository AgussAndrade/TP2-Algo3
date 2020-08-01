package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClasicaTest {

    @Test
    public void test01unJugadorTieneUnaRespuestaCorrectaEIncorrectaYSuma0puntos(){

        Estrategia clasica = new Clasica();
        Jugador jugador = new Jugador("Juan");
        List<Opcion> opcionesPosibles = new ArrayList<>();
        List<Opcion> selecciones = new ArrayList<>();

        Opcion opcionCorrecta = new Correcta("Correcta");
        Opcion opcionIncorrecta = new Incorrecta("Incorrecta");

        opcionesPosibles.add(opcionCorrecta);
        opcionesPosibles.add(opcionIncorrecta);

        selecciones.add(opcionCorrecta);
        selecciones.add(opcionIncorrecta);

        Respuesta respuesta = new Respuesta(jugador,selecciones);

        clasica.sumarPuntos(respuesta,opcionesPosibles);

        assertEquals(0,jugador.puntos());
    }

    @Test
    public void test02unJugadorTieneLaRespuestaCorrectaYSuma1punto(){

        Estrategia clasica = new Clasica();
        Jugador jugador = new Jugador("Juan");
        List<Opcion> opcionesPosibles = new ArrayList<>();
        List<Opcion> selecciones = new ArrayList<>();

        Opcion opcionCorrecta = new Correcta("Correcta");

        opcionesPosibles.add(opcionCorrecta);

        selecciones.add(opcionCorrecta);

        Respuesta respuesta = new Respuesta(jugador,selecciones);

        clasica.sumarPuntos(respuesta,opcionesPosibles);

        assertEquals(1,jugador.puntos());
    }
}
