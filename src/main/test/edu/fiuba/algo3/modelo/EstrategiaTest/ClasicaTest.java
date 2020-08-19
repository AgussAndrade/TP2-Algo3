
package edu.fiuba.algo3.modelo.EstrategiaTest;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaBuilder;
import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;
import edu.fiuba.algo3.modelo.opciones.Correcta;
import edu.fiuba.algo3.modelo.opciones.Incorrecta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
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

        Correcta opcionCorrecta = new Correcta("Correcta");
        Incorrecta opcionIncorrecta = new Incorrecta("Incorrecta");

        opcionIncorrecta.seleccionar();
        opcionesPosibles.add(opcionCorrecta);
        opcionesPosibles.add(opcionIncorrecta);

        selecciones.add( opcionCorrecta);
        selecciones.add( opcionIncorrecta);

        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        respuestaBuilder.conSelecciones(selecciones);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));
        Respuesta respuesta = respuestaBuilder.build();
        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        clasica.validarRespuestas(respuestas);

        assertEquals(0,respuesta.obtenerPuntos());
    }

    @Test
    public void test02unJugadorTieneLaRespuestaCorrectaYSuma1punto(){

        Estrategia clasica = new Clasica();
        Jugador jugador = new Jugador("Juan");
        List<Opcion> opcionesPosibles = new ArrayList<>();
        List<Opcion> selecciones = new ArrayList<>();

        Correcta opcionCorrecta = new Correcta("Correcta");

        opcionCorrecta.seleccionar();

        opcionesPosibles.add(opcionCorrecta);

        selecciones.add(opcionCorrecta);

        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        respuestaBuilder.conSelecciones(selecciones);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));
        Respuesta respuesta = respuestaBuilder.build();List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        clasica.validarRespuestas(respuestas);

        assertEquals(1,respuesta.obtenerPuntos());
    }
}

