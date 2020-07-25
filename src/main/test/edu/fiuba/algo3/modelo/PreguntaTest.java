package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {

    @Test
    public void test01UnaPreguntaDeVerdaderoYFalsoPuedeCrearseIndicandoleLaRespuestaCorrecta(){
        String nombre = "Argentina es un pais";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("falso"));
        opciones.add(new Incorrecta("verdadero"));

        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Clasica(1));

        assertEquals("Argentina es un pais", pregunta.nombre());
    }

    @Test
    public void test02UnaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){
        String nombre = "Argentina es un pais";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("falso"));
        opciones.add(new Incorrecta("verdadero"));
        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Clasica(1));

        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Opcion> opcionesElegidasJugador = new ArrayList<>();
        opcionesElegidasJugador.add( opciones.get(0));
        List<Opcion> opcionesElegidasJugadora = new ArrayList<>();
        opcionesElegidasJugadora.add( opciones.get(1));

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador));
        respuestas.add(new Respuesta(jugadora,opcionesElegidasJugadora));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
        assertEquals(0, jugadora.puntos());

    }
    @Test
    public void test03UnaPreguntaDeVerdaderoFalsoConPenalidadPuedeCrearseIndicándoleCualEsLaRespuestaCorrecta(){
        String nombre = "Argentina es un pais";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("falso"));
        opciones.add(new Incorrecta("verdadero"));

        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Penalizable());

        assertEquals("Argentina es un pais", pregunta.nombre());
    }
    @Test
    public void test04UnaPreguntaDeVerdaderoFalsoPenalizableRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Argentina es un pais";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("falso"));
        opciones.add(new Incorrecta("verdadero"));
        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Penalizable());

        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Opcion> opcionesElegidasJugador = new ArrayList<>();
        opcionesElegidasJugador.add(opciones.get(0));
        List<Opcion> opcionesElegidasJugadora = new ArrayList<>();
        opcionesElegidasJugadora.add(opciones.get(1));

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador));
        respuestas.add(new Respuesta(jugadora, opcionesElegidasJugadora));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
        assertEquals(-1, jugadora.puntos());
    }

    @Test
    public void test05UnaPreguntaDeMultipleChoiceClasicaPuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
        String nombre = "Cuales son provincias";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Clasica(1));

        assertEquals("Cuales son provincias", pregunta.nombre());
    }
    @Test
    public void test06UnaPreguntaDeMultipleChoiceClasicaRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Cuales son provincias";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Clasica(1));
        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Opcion> opcionesElegidasJugador = new ArrayList<>();
        opcionesElegidasJugador.add( opciones.get(0));
        List<Opcion> opcionesElegidasJugadora = new ArrayList<>();
        opcionesElegidasJugadora.add( opciones.get(1));
        opcionesElegidasJugadora.add( opciones.get(0));

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador));
        respuestas.add(new Respuesta(jugadora,opcionesElegidasJugadora));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
        assertEquals(0, jugadora.puntos());

    }
    @Test
    public void test07UnaPreguntaDeMultipleChoiceConPuntajeParcialPuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
        String nombre = "Cuales son provincias";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new PuntajeParcial());

        assertEquals("Cuales son provincias", pregunta.nombre());
    }
    @Test
    public void test08UnaPreguntaDeMultipleChoiceConPuntajeParcialRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Cuales son provincias";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new PuntajeParcial());
        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Opcion> opcionesElegidasJugador = new ArrayList<>();
        opcionesElegidasJugador.add( opciones.get(0));
        List<Opcion> opcionesElegidasJugadora = new ArrayList<>();
        opcionesElegidasJugadora.add( opciones.get(1));
        opcionesElegidasJugadora.add( opciones.get(0));

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador));
        respuestas.add(new Respuesta(jugadora,opcionesElegidasJugadora));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
        assertEquals(1, jugadora.puntos());

    }
    @Test
    public void test09UnaPreguntaDeMultipleChoiceConPenalidadPuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
        String nombre = "Cuales son provincias";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Penalizable());

        assertEquals("Cuales son provincias", pregunta.nombre());
    }
    @Test
    public void test10UnaPreguntaDeMultipleChoicePenalizableRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Cuales son provincias";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Penalizable());
        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Opcion> opcionesElegidasJugador = new ArrayList<>();
        opcionesElegidasJugador.add( opciones.get(0));
        List<Opcion> opcionesElegidasJugadora = new ArrayList<>();
        opcionesElegidasJugadora.add( opciones.get(1));
        opcionesElegidasJugadora.add( opciones.get(0));

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador));
        respuestas.add(new Respuesta(jugadora,opcionesElegidasJugadora));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
        assertEquals(0, jugadora.puntos());

    }
}


