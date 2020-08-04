package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {
    @Test
    public void test01UnaPreguntaDeGroupChoiceCorrectaSuma1Punto() {
        String nombre = "Separar futbolistas de basquetbolistas";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionDeGrupo("Messi", 1));
        opciones.add(new OpcionDeGrupo("C.Ronaldo", 1));
        opciones.add(new OpcionDeGrupo("Lebron James", 2));
        opciones.add(new OpcionDeGrupo("Stephen Curry", 2));

        Pregunta pregunta = new GroupChoice(nombre, opciones, new Clasica());
        Jugador jugador = new Jugador("Juan");

        opciones.get(0).seleccionar(1);
        opciones.get(1).seleccionar(1);
        opciones.get(2).seleccionar(2);
        opciones.get(3).seleccionar(2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(jugador, opciones, new Multiplicador(1), false));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test02UnaPreguntaDeGroupChoiceIncorrectaSuma0Puntos() {
        String nombre = "Separar futbolistas de basquetbolistas";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new OpcionDeGrupo("Messi", 1));
        opciones.add(new OpcionDeGrupo("C.Ronaldo", 1));
        opciones.add(new OpcionDeGrupo("Lebron James", 2));
        opciones.add(new OpcionDeGrupo("Stephen Curry", 2));

        Pregunta pregunta = new GroupChoice(nombre, opciones, new Clasica());
        Jugador jugador = new Jugador("Juan");

        opciones.get(0).seleccionar(2);
        opciones.get(1).seleccionar(1);
        opciones.get(2).seleccionar(2);
        opciones.get(3).seleccionar(2);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(jugador, opciones, new Multiplicador(1), false));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(0, jugador.puntos());
    }
}