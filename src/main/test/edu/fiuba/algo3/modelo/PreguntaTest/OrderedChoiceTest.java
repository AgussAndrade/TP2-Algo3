package edu.fiuba.algo3.modelo.PreguntaTest;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.aplicadores.AplicadorSimple;
import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionPosicion;
import edu.fiuba.algo3.modelo.opciones.Posicionable;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class OrderedChoiceTest {
    @Test
    public void test01UnaPreguntaOrderedChoiceCompruebaUnaRespuestaCorrectaYSumaPuntos() {
        String nombre = "Ordenar Alfabeticamente las siguientes provincias";

        List<Posicionable> opciones = new ArrayList<>();
        opciones.add(new OpcionPosicion("Buenos Aires", 1));
        opciones.add(new OpcionPosicion("La pampa",2));
        opciones.add(new OpcionPosicion("Salta",3));
        opciones.add(new OpcionPosicion("Tierra del Fuego",4));
        opciones.add(new OpcionPosicion("Tucuman",5));

        OrderedChoice pregunta = new OrderedChoice(nombre, opciones, new Clasica());

        Jugador jugador = new Jugador("Juan");

        opciones.get(0).seleccionar(1);
        opciones.get(1).seleccionar(2);
        opciones.get(2).seleccionar(3);
        opciones.get(3).seleccionar(4);
        opciones.get(4).seleccionar(5);


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
    public void test02UnaPreguntaOrderedChoiceCompruebaUnaRespuestaIncorrectaYNoSumaPuntos() {
        String nombre = "Ordenar Alfabeticamente las siguientes provincias";

        List<Posicionable> opciones = new ArrayList<>();
        opciones.add(new OpcionPosicion("Buenos Aires", 1));
        opciones.add(new OpcionPosicion("La pampa",2));
        opciones.add(new OpcionPosicion("Salta",3));
        opciones.add(new OpcionPosicion("Tierra del Fuego",4));
        opciones.add(new OpcionPosicion("Tucuman",5));

        OrderedChoice pregunta = new OrderedChoice(nombre, opciones, new Clasica());

        Jugador jugador = new Jugador("Juan");


        opciones.get(0).seleccionar(5);
        opciones.get(1).seleccionar(3);
        opciones.get(2).seleccionar(2);
        opciones.get(3).seleccionar(1);
        opciones.get(4).seleccionar(4);


        List<Respuesta> respuestas = new ArrayList<>();
        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        List<Opcion> opcionesAAgregarJugador = List.copyOf(opciones);
        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());
        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());


        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test03SiUnaPreguntaOrderedChoiceCompruebaUnaRespuestaConMenosOpcionesSeleccionadasNoDeberiaSumarPuntos() {
        String nombre = "Ordenar Alfabeticamente las siguientes provincias";

        List<Posicionable> opciones = new ArrayList<>();
        opciones.add(new OpcionPosicion("Buenos Aires", 1));
        opciones.add(new OpcionPosicion("La pampa",2));
        opciones.add(new OpcionPosicion("Salta",3));
        opciones.add(new OpcionPosicion("Tierra del Fuego",4));
        opciones.add(new OpcionPosicion("Tucuman",5));

        OrderedChoice pregunta = new OrderedChoice(nombre, opciones, new Clasica());

        Jugador jugador = new Jugador("Juan");


        opciones.get(0).seleccionar(1);
        opciones.get(1).seleccionar(2);
        opciones.get(3).seleccionar(4);


        List<Respuesta> respuestas = new ArrayList<>();
        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        List<Opcion> opcionesAAgregarJugador = List.copyOf(opciones);
        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());
        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());


        assertEquals(0, jugador.puntos());
    }

}
