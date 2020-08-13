package edu.fiuba.algo3.modelo.TipoDePreguntaTest;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.multiplicadores.AplicadorSimple;
import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Grupal;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionDeGrupo;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {
    @Test
    public void test01UnaPreguntaDeGroupChoiceCorrectaSuma1Punto() {
        String nombre = "Separar futbolistas de basquetbolistas";

        List<Grupal> opciones = new ArrayList<>();
        opciones.add(new OpcionDeGrupo("Messi", "futbolista"));
        opciones.add(new OpcionDeGrupo("C.Ronaldo", "futbolista"));
        opciones.add(new OpcionDeGrupo("Lebron James", "Basquetbolista"));
        opciones.add(new OpcionDeGrupo("Stephen Curry", "Basquetbolista"));

        GroupChoice pregunta = new GroupChoice(nombre, opciones, new Clasica());
        Jugador jugador = new Jugador("Juan");

        opciones.get(0).seleccionar("futbolista");
        opciones.get(1).seleccionar("futbolista");
        opciones.get(2).seleccionar("Basquetbolista");
        opciones.get(3).seleccionar("Basquetbolista");

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
    public void test02UnaPreguntaDeGroupChoiceIncorrectaSuma0Puntos() {
        String nombre = "Separar futbolistas de basquetbolistas";

        List<Grupal> opciones = new ArrayList<>();
        opciones.add(new OpcionDeGrupo("Messi", "futbolista"));
        opciones.add(new OpcionDeGrupo("C.Ronaldo", "futbolista"));
        opciones.add(new OpcionDeGrupo("Lebron James", "Basquetbolista"));
        opciones.add(new OpcionDeGrupo("Stephen Curry", "Basquetbolista"));

        GroupChoice pregunta = new GroupChoice(nombre, opciones, new Clasica());
        Jugador jugador = new Jugador("Juan");

        opciones.get(0).seleccionar("fubtolista");
        opciones.get(1).seleccionar("fubtolista");
        opciones.get(2).seleccionar("Basquetbolista");
        opciones.get(3).seleccionar("Basquetbolista");
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
