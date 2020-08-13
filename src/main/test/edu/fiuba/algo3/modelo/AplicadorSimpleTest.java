package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.aplicador.AplicadorSimple;
import edu.fiuba.algo3.modelo.opciones.Correcta;
import edu.fiuba.algo3.modelo.opciones.Incorrecta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AplicadorSimpleTest {
    @Test
    public void unAplicadorSimpleSuma1PuntoSiSeRespondeBien() {
        AplicadorSimple aplicadorSimple = new AplicadorSimple();
        Jugador jugador = new Jugador("Juan");
        List<Opcion> opciones = new ArrayList<>();
        Correcta opcionCorrecta = new Correcta("Correcta");

        opciones.add(opcionCorrecta);

        List<Respuesta> respuestas = new ArrayList<>();
        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        respuestaBuilder.conSelecciones(opciones);
        Respuesta respuesta = respuestaBuilder.build();
        respuesta.definirPuntosAAgregar(1);

        respuestas.add(respuesta);

        aplicadorSimple.sumarPuntos(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void unAplicadorSimpleSeAnulaSiRespondeMal() {
        AplicadorSimple aplicadorSimple = new AplicadorSimple();
        Jugador jugador = new Jugador("Juan");
        List<Opcion> opciones = new ArrayList<>();
        Incorrecta opcionIncorrecta = new Incorrecta("Incorrecta");

        opciones.add(opcionIncorrecta);

        List<Respuesta> respuestas = new ArrayList<>();
        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        respuestaBuilder.conSelecciones(opciones);
        Respuesta respuesta = respuestaBuilder.build();
        respuesta.definirPuntosAAgregar(0);

        respuestas.add(respuesta);

        aplicadorSimple.sumarPuntos(respuestas);

        assertEquals(0, jugador.puntos());
    }
}
