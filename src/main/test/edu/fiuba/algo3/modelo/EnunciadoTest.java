package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnunciadoTest {

    @Test
    public void test01UnaPreguntaDeVerdaderoYFalsoPuedeCrearseIndicandoleLaRespuestaCorrecta(){
        String nombre = "Argentina es un pais";
        List<Opcion> opciones = new ArrayList<>();
        Opcion opcionCorrecta = new Correcta("True");
        Opcion opcionIncorrecta = new Incorrecta("False");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());

        assertEquals("Argentina es un pais", pregunta.enunciado());
    }

    @Test
    public void test02UnaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){
        String nombre = "Argentina es un pais";
        List<Opcion> opciones = new ArrayList<>();
        Opcion opcionCorrecta = new Correcta("True");
        Opcion opcionIncorrecta = new Incorrecta("False");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());

        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Opcion> opcionesElegidasJugador = new ArrayList<>(opciones);
        opcionesElegidasJugador.get(0).seleccionar();
        List<Opcion> opcionesElegidasJugadora = new ArrayList<>(opciones);
        opcionesElegidasJugadora.get(0).seleccionar();

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador));
        respuestas.add(new Respuesta(jugadora,opcionesElegidasJugadora));

        pregunta.comprobarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
        assertEquals(0, jugadora.puntos());

    }
    @Test
    public void test03UnaPreguntaDeVerdaderoFalsoConPenalidadPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        String nombre = "Argentina es un pais";
        List<Opcion> opciones = new ArrayList<>();
        Opcion opcionCorrecta = new Correcta("True");
        Opcion opcionIncorrecta = new Incorrecta("False");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Penalizable());

        assertEquals("Argentina es un pais", pregunta.enunciado());

    }
    @Test
    public void test04UnaPreguntaDeVerdaderoFalsoPenalizableRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Argentina es un pais";
        List<Opcion> opciones = new ArrayList<>();
        Opcion opcionCorrecta = new Correcta("True");
        Opcion opcionIncorrecta = new Incorrecta("False");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Penalizable());

        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Opcion> opcionesElegidasJugador = new ArrayList<>();
        opcionesElegidasJugador.add(new Correcta("falso"));
        List<Opcion> opcionesElegidasJugadora = new ArrayList<>();
        opcionesElegidasJugadora.add(new Incorrecta("verdadero"));


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
        Opcion primerOpcion = new Correcta("Buenos Aires");
        Opcion segundaOpcion = new Incorrecta("La pampa");
        Opcion tercerOpcion = new Incorrecta("Lanus");
        opciones.add(primerOpcion);
        opciones.add(segundaOpcion);
        opciones.add(tercerOpcion);

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Clasica());

        assertEquals("Cuales son provincias", pregunta.enunciado());
    }

    @Test
    public void test06UnaPreguntaDeMultipleChoiceClasicaRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Cuales son provincias";

        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Clasica());
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

        assertEquals("Cuales son provincias", pregunta.enunciado());
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

        assertEquals("Cuales son provincias", pregunta.enunciado());
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


