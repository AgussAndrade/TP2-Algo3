package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionPosicion;
import edu.fiuba.algo3.modelo.preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class OrderedChoiceTest {
    @Test
    public void test01UnaPreguntaOrderedChoiceCompruebaUnaRespuestaCorrectaYSumaPuntos() {
        String nombre = "Ordenar Alfabeticamente las siguientes provincias";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionPosicion("Buenos Aires", 1));
        opciones.add(new OpcionPosicion("La pampa",2));
        opciones.add(new OpcionPosicion("Salta",3));
        opciones.add(new OpcionPosicion("Tierra del Fuego",4));
        opciones.add(new OpcionPosicion("Tucuman",5));

        Pregunta pregunta = new OrderedChoice(nombre, opciones, new Clasica());

        Jugador jugador = new Jugador("Juan");

        opciones.get(0).seleccionar(1);
        opciones.get(1).seleccionar(2);
        opciones.get(2).seleccionar(3);
        opciones.get(3).seleccionar(4);
        opciones.get(4).seleccionar(5);


        List<Respuesta> respuestas = new ArrayList<>();

        respuestas.add(new Respuesta(jugador, opciones,new Multiplicador(1),false));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test02UnaPreguntaOrderedChoiceCompruebaUnaRespuestaIncorrectaYNoSumaPuntos() {
        String nombre = "Ordenar Alfabeticamente las siguientes provincias";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionPosicion("Buenos Aires", 1));
        opciones.add(new OpcionPosicion("La pampa",2));
        opciones.add(new OpcionPosicion("Salta",3));
        opciones.add(new OpcionPosicion("Tierra del Fuego",4));
        opciones.add(new OpcionPosicion("Tucuman",5));

        Pregunta pregunta = new OrderedChoice(nombre, opciones, new Clasica());

        Jugador jugador = new Jugador("Juan");


        opciones.get(0).seleccionar(5);
        opciones.get(1).seleccionar(3);
        opciones.get(2).seleccionar(2);
        opciones.get(3).seleccionar(1);
        opciones.get(4).seleccionar(4);


        List<Respuesta> respuestas = new ArrayList<>();

        respuestas.add(new Respuesta(jugador, opciones,new Multiplicador(1),false));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(0, jugador.puntos());
    }
}
