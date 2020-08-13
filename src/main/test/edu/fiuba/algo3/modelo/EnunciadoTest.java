package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicadores.AplicadorConExclusividad;
import edu.fiuba.algo3.modelo.multiplicadores.AplicadorSimple;
import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.estrategias.Penalizable;
import edu.fiuba.algo3.modelo.estrategias.PuntajeParcial;
import edu.fiuba.algo3.modelo.opciones.*;
import edu.fiuba.algo3.modelo.preguntas.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnunciadoTest {

    @Test
    public void test01UnaPreguntaDeVerdaderoYFalsoPuedeCrearseIndicandoleLaRespuestaCorrecta(){
        String nombre = "Argentina es un pais";
        List<Binaria> opciones = new ArrayList<>();
        Correcta opcionCorrecta = new Correcta("True");
        Incorrecta opcionIncorrecta = new Incorrecta("False");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());

        assertEquals("Argentina es un pais", pregunta.enunciado());
    }

    @Test
    public void test02UnaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){
        String nombre = "Argentina es un pais";
        List<Binaria> opciones = new ArrayList<>();
        Correcta opcionCorrecta = new Correcta("True");
        Incorrecta opcionIncorrecta = new Incorrecta("False");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        VerdaderoFalso pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());

        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Binaria> opcionesElegidasJugador = pregunta.obtenerOpciones();
        opcionesElegidasJugador.get(0).seleccionar();
        List<Binaria> opcionesElegidasJugadora = pregunta.obtenerOpciones();
        opcionesElegidasJugadora.get(1).seleccionar();

        List<Respuesta> respuestas = new ArrayList<>();

        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        List<Opcion> opcionesAAgregarJugador = List.copyOf(opcionesElegidasJugador);
        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());

        RespuestaBuilder respuestaJugadoraBuilder = new RespuestaBuilder();
        respuestaJugadoraBuilder.conResponsable(jugadora);
        List<Opcion> opcionesAAgregarJugadora = List.copyOf(opcionesElegidasJugadora);
        respuestaJugadoraBuilder.conSelecciones(opcionesAAgregarJugadora);
        respuestaJugadoraBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaJugadoraBuilder.build());

        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());

        assertEquals(1, jugador.puntos());
        assertEquals(0, jugadora.puntos());

    }
    @Test
    public void test03UnaPreguntaDeVerdaderoFalsoConPenalidadPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
        String nombre = "Argentina es un pais";
        List<Binaria> opciones = new ArrayList<>();
        Correcta opcionCorrecta = new Correcta("True");
        Incorrecta opcionIncorrecta = new Incorrecta("False");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        opciones.get(1).seleccionar();
        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Penalizable());

        assertEquals("Argentina es un pais", pregunta.enunciado());

    }
    @Test
    public void test04UnaPreguntaDeVerdaderoFalsoPenalizableRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Argentina es un pais";
        List<Binaria> opciones = new ArrayList<>();
        Correcta opcionCorrecta = new Correcta("True");
        Incorrecta opcionIncorrecta = new Incorrecta("False");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        VerdaderoFalso pregunta = new VerdaderoFalso(nombre, opciones, new Penalizable());

        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Binaria> opcionesElegidasJugador = pregunta.obtenerOpciones();
        opcionesElegidasJugador.get(0).seleccionar();
        List<Binaria> opcionesElegidasJugadora = pregunta.obtenerOpciones();
        opcionesElegidasJugadora.get(1).seleccionar();

        List<Respuesta> respuestas = new ArrayList<>();

        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        List<Opcion> opcionesAAgregarJugador = List.copyOf(opcionesElegidasJugador);
        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());

        RespuestaBuilder respuestaJugadoraBuilder = new RespuestaBuilder();
        respuestaJugadoraBuilder.conResponsable(jugadora);
        List<Opcion> opcionesAAgregarJugadora = List.copyOf(opcionesElegidasJugadora);
        respuestaJugadoraBuilder.conSelecciones(opcionesAAgregarJugadora);
        respuestaJugadoraBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaJugadoraBuilder.build());

        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());

        assertEquals(1, jugador.puntos());
        assertEquals(-1, jugadora.puntos());
    }
    @Test
    public void test05UnaPreguntaVerdaderoFalsoConExclusividadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){
        String nombre = "Argentina es un pais";
        List<Binaria> opciones = new ArrayList<>();
        Correcta opcionCorrecta = new Correcta("True");
        Incorrecta opcionIncorrecta = new Incorrecta("False");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        VerdaderoFalso pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());

        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Binaria> opcionesElegidasJugador = pregunta.obtenerOpciones();
        opcionesElegidasJugador.get(0).seleccionar();
        List<Binaria> opcionesElegidasJugadora = pregunta.obtenerOpciones();
        opcionesElegidasJugadora.get(1).seleccionar();

        List<Respuesta> respuestas = new ArrayList<>();

        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        List<Opcion> opcionesAAgregarJugador = List.copyOf(opcionesElegidasJugador);
        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());

        RespuestaBuilder respuestaJugadoraBuilder = new RespuestaBuilder();
        respuestaJugadoraBuilder.conResponsable(jugadora);
        List<Opcion> opcionesAAgregarJugadora = List.copyOf(opcionesElegidasJugadora);
        respuestaJugadoraBuilder.conSelecciones(opcionesAAgregarJugadora);
        respuestaJugadoraBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaJugadoraBuilder.build());

        pregunta.comprobarRespuestas(respuestas, new AplicadorConExclusividad(1));


        assertEquals(2, jugador.puntos());
        assertEquals(0, jugadora.puntos());
    }

    @Test
    public void test06UnaPreguntaDeMultipleChoiceClasicaPuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
        String nombre = "Cuales son provincias";
        List<Binaria> opciones = new ArrayList<>();
        Correcta primerOpcion = new Correcta("Buenos Aires");
        Incorrecta segundaOpcion = new Incorrecta("La pampa");
        Incorrecta tercerOpcion = new Incorrecta("Lanus");
        opciones.add(primerOpcion);
        opciones.add(segundaOpcion);
        opciones.add(tercerOpcion);

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Clasica());

        assertEquals("Cuales son provincias", pregunta.enunciado());
    }

    @Test
    public void test07UnaPreguntaDeMultipleChoiceClasicaRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Cuales son provincias";

        List<Binaria> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        MultipleChoice pregunta = new MultipleChoice(nombre, opciones, new Clasica());
        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");
        List<Binaria> opcionesElegidasJugador = pregunta.obtenerOpciones();
        opcionesElegidasJugador.get(0).seleccionar();
        List<Binaria> opcionesElegidasJugadora = pregunta.obtenerOpciones();
        opcionesElegidasJugadora.get(1).seleccionar();

        List<Respuesta> respuestas = new ArrayList<>();

        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        List<Opcion> opcionesAAgregarJugador = List.copyOf(opcionesElegidasJugador);
        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());

        RespuestaBuilder respuestaJugadoraBuilder = new RespuestaBuilder();
        respuestaJugadoraBuilder.conResponsable(jugadora);
        List<Opcion> opcionesAAgregarJugadora = List.copyOf(opcionesElegidasJugadora);
        respuestaJugadoraBuilder.conSelecciones(opcionesAAgregarJugadora);
        respuestaJugadoraBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaJugadoraBuilder.build());

        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());

        assertEquals(1, jugador.puntos());
        assertEquals(0, jugadora.puntos());

    }
    @Test
    public void test08UnaPreguntaDeMultipleChoiceConPuntajeParcialPuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
        String nombre = "Cuales son provincias";

        List<Binaria> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new PuntajeParcial());

        assertEquals("Cuales son provincias", pregunta.enunciado());
    }
    @Test
    public void test09UnaPreguntaDeMultipleChoiceConPuntajeParcialRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Cuales son provincias";

        List<Binaria> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        MultipleChoice pregunta = new MultipleChoice(nombre, opciones, new PuntajeParcial());
        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Binaria> opcionesElegidasJugador = pregunta.obtenerOpciones();
        opcionesElegidasJugador.get(0).seleccionar();
        List<Binaria> opcionesElegidasJugadora = pregunta.obtenerOpciones();
        opcionesElegidasJugadora.get(1).seleccionar();

        List<Respuesta> respuestas = new ArrayList<>();

        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        List<Opcion> opcionesAAgregarJugador = List.copyOf(opcionesElegidasJugador);
        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());

        RespuestaBuilder respuestaJugadoraBuilder = new RespuestaBuilder();
        respuestaJugadoraBuilder.conResponsable(jugadora);
        List<Opcion> opcionesAAgregarJugadora = List.copyOf(opcionesElegidasJugadora);
        respuestaJugadoraBuilder.conSelecciones(opcionesAAgregarJugadora);
        respuestaJugadoraBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaJugadoraBuilder.build());

        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());

        assertEquals(1, jugador.puntos());
        assertEquals(0, jugadora.puntos());
    }
    @Test
    public void test10UnaPreguntaDeMultipleChoiceConPenalidadPuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
        String nombre = "Cuales son provincias";

        List<Binaria> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Penalizable());

        assertEquals("Cuales son provincias", pregunta.enunciado());
    }
    @Test
    public void test11UnaPreguntaDeMultipleChoicePenalizableRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Cuales son provincias";

        List<Binaria> opciones = new ArrayList<>();
        opciones.add(new Correcta("Buenos Aires"));
        opciones.add(new Incorrecta("La pampa"));
        opciones.add(new Incorrecta("Lanus"));

        MultipleChoice pregunta = new MultipleChoice(nombre, opciones, new Penalizable());
        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Binaria> opcionesElegidasJugador = pregunta.obtenerOpciones();
        opcionesElegidasJugador.get(0).seleccionar();
        List<Binaria> opcionesElegidasJugadora = pregunta.obtenerOpciones();
        opcionesElegidasJugadora.get(1).seleccionar();

        List<Respuesta> respuestas = new ArrayList<>();

        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        List<Opcion> opcionesAAgregarJugador = List.copyOf(opcionesElegidasJugador);
        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());

        RespuestaBuilder respuestaJugadoraBuilder = new RespuestaBuilder();
        respuestaJugadoraBuilder.conResponsable(jugadora);
        List<Opcion> opcionesAAgregarJugadora = List.copyOf(opcionesElegidasJugadora);
        respuestaJugadoraBuilder.conSelecciones(opcionesAAgregarJugadora);
        respuestaJugadoraBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaJugadoraBuilder.build());

        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());

        assertEquals(1, jugador.puntos());
        assertEquals(-1, jugadora.puntos());

    }
    @Test
    public void test12UnaPreguntaOrderedChoicePuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
        String nombre = "Jugadores de futbol más altos";
        List<Posicionable> opciones = new ArrayList<>();
        opciones.add(new OpcionPosicion("Ibrahimovic", 1));
        opciones.add(new OpcionPosicion("Aguero", 2));
        opciones.add(new OpcionPosicion("Messi", 3));
        Pregunta pregunta = new OrderedChoice(nombre, opciones, new Clasica());

        assertEquals("Jugadores de futbol más altos", pregunta.enunciado());
    }

    @Test
    public void test13UnaPreguntaOrderedChoiceRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Jugadores de futbol más altos";
        List<Posicionable> opciones = new ArrayList<>();
        opciones.add(new OpcionPosicion("Ibrahimovic", 1));
        opciones.add(new OpcionPosicion("Aguero", 2));
        opciones.add(new OpcionPosicion("Messi", 3));
        OrderedChoice pregunta = new OrderedChoice(nombre, opciones, new Clasica());
        List<Posicionable> seleccionJugador1 = pregunta.obtenerOpciones();
        List<Posicionable> seleccionJugador2 = pregunta.obtenerOpciones();

        seleccionJugador1.get(0).seleccionar(1);
        seleccionJugador1.get(1).seleccionar(2);
        seleccionJugador1.get(2).seleccionar(3);


        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        List<Posicionable> opcionesElegidasJugador = pregunta.obtenerOpciones();
        opcionesElegidasJugador.get(0).seleccionar(1);
        opcionesElegidasJugador.get(1).seleccionar(2);
        opcionesElegidasJugador.get(2).seleccionar(3);
        List<Posicionable> opcionesElegidasJugadora = pregunta.obtenerOpciones();
        opcionesElegidasJugadora.get(1).seleccionar(1);
        opcionesElegidasJugadora.get(0).seleccionar(2);
        opcionesElegidasJugadora.get(2).seleccionar(3);

        List<Respuesta> respuestas = new ArrayList<>();

        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);
        List<Opcion> opcionesAAgregarJugador = List.copyOf(opcionesElegidasJugador);
        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());

        RespuestaBuilder respuestaJugadoraBuilder = new RespuestaBuilder();
        respuestaJugadoraBuilder.conResponsable(jugadora);
        List<Opcion> opcionesAAgregarJugadora = List.copyOf(opcionesElegidasJugadora);
        respuestaJugadoraBuilder.conSelecciones(opcionesAAgregarJugadora);
        respuestaJugadoraBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaJugadoraBuilder.build());

        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());

        assertEquals(1, jugador.puntos());
        assertEquals(0, jugadora.puntos());

    }
    @Test
    public void test14UnaPreguntaGroupChoicePuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
        String nombre = "Distinguir paises de provincias";
        List<Grupal> opciones = new ArrayList<>();
        opciones.add(new OpcionDeGrupo("Cuba", "pais"));
        opciones.add(new OpcionDeGrupo("Venezuela", "pais"));
        opciones.add(new OpcionDeGrupo("Berlin", "provincia"));
        Pregunta pregunta = new GroupChoice(nombre, opciones, new Clasica());

        assertEquals("Distinguir paises de provincias", pregunta.enunciado());
    }

    @Test
    public void test15UnaPreguntaGroupChoicePuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
        String nombre = "Distinguir paises de provincias";
        List<Grupal> opciones = new ArrayList<>();
        opciones.add(new OpcionDeGrupo("Cuba", "pais"));
        opciones.add(new OpcionDeGrupo("Venezuela", "pais"));
        opciones.add(new OpcionDeGrupo("Berlin", "Provincia"));
        Pregunta pregunta = new GroupChoice(nombre, opciones, new Penalizable());

        assertEquals("Distinguir paises de provincias", pregunta.enunciado());
    }
    @Test
    public void test16UnaPreguntaGroupChoiceRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
        String nombre = "Distinguir paises de provincias";
        List<Grupal> opciones = new ArrayList<>();
        opciones.add(new OpcionDeGrupo("Cuba", "pais"));
        opciones.add(new OpcionDeGrupo("Venezuela", "pais"));
        opciones.add(new OpcionDeGrupo("Berlin", "provincia"));
        GroupChoice pregunta = new GroupChoice(nombre, opciones, new Clasica());
        List<Grupal> seleccionJugador = pregunta.obtenerOpciones();
        List<Grupal> seleccionJugadora = pregunta.obtenerOpciones();

        seleccionJugador.get(0).seleccionar("pais");
        seleccionJugador.get(1).seleccionar("pais");
        seleccionJugador.get(2).seleccionar("provincia");

        Jugador jugador = new Jugador("Juan");
        Jugador jugadora = new Jugador("Juana");

        seleccionJugadora.get(0).seleccionar("provincia");
        seleccionJugadora.get(1).seleccionar("provincia");
        seleccionJugadora.get(2).seleccionar("pais");

        List<Respuesta> respuestas = new ArrayList<>();
        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
        respuestaBuilder.conResponsable(jugador);

        List<Opcion> opcionesAAgregarJugador = List.copyOf(seleccionJugador);

        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
        respuestaBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaBuilder.build());

        RespuestaBuilder respuestaJugadoraBuilder = new RespuestaBuilder();
        respuestaJugadoraBuilder.conResponsable(jugadora);
        List<Opcion> opcionesAAgregarJugadora = List.copyOf(seleccionJugadora);
        respuestaJugadoraBuilder.conSelecciones(opcionesAAgregarJugadora);
        respuestaJugadoraBuilder.conMultiplicador(new Multiplicador(1));

        respuestas.add(respuestaJugadoraBuilder.build());

        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());


        assertEquals(1, jugador.puntos());
        assertEquals(0, jugadora.puntos());

    }


}


