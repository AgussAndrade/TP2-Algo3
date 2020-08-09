//package edu.fiuba.algo3.modelo;
//
//import edu.fiuba.algo3.modelo.opciones.Binarias;
//import edu.fiuba.algo3.modelo.estrategias.Clasica;
//import edu.fiuba.algo3.modelo.estrategias.Penalizable;
//import edu.fiuba.algo3.modelo.estrategias.PuntajeParcial;
//import edu.fiuba.algo3.modelo.opciones.*;
//import edu.fiuba.algo3.modelo.preguntas.*;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class EnunciadoTest {
//
//    @Test
//    public void test01UnaPreguntaDeVerdaderoYFalsoPuedeCrearseIndicandoleLaRespuestaCorrecta(){
//        String nombre = "Argentina es un pais";
//        List<Binarias> opciones = new ArrayList<>();
//        Correcta opcionCorrecta = new Correcta("True");
//        Incorrecta opcionIncorrecta = new Incorrecta("False");
//        opciones.add(opcionCorrecta);
//        opciones.add(opcionIncorrecta);
//        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());
//
//        assertEquals("Argentina es un pais", pregunta.enunciado());
//    }
//
//    @Test
//    public void test02UnaPreguntaDeVerdaderoFalsoClasicoRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){
//        String nombre = "Argentina es un pais";
//        List<Binarias> opciones = new ArrayList<>();
//        Correcta opcionCorrecta = new Correcta("True");
//        Incorrecta opcionIncorrecta = new Incorrecta("False");
//        opciones.add(opcionCorrecta);
//        opciones.add(opcionIncorrecta);
//        VerdaderoFalso pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());
//
//        Jugador jugador = new Jugador("Juan");
//        Jugador jugadora = new Jugador("Juana");
//
//        List<Binarias> opcionesElegidasJugador = pregunta.obtenerOpciones();
//        opcionesElegidasJugador.get(0).seleccionar();
//        List<Binarias> opcionesElegidasJugadora = pregunta.obtenerOpciones();
//        opcionesElegidasJugadora.get(1).seleccionar();
//
//        List<Respuesta> respuestas = new ArrayList<>();
//        RespuestaBuilder respuestaBuilder = new RespuestaBuilder();
//        respuestaBuilder.conResponsable(jugador);
//        List<Opcion> opcionesAAgregarJugador = List.copyOf(opcionesElegidasJugador);
//        respuestaBuilder.conSelecciones(opcionesAAgregarJugador);
//        respuestaBuilder.conMultiplicador(new Multiplicador(1));
//
//        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());
//
//        assertEquals(1, jugador.puntos());
//        assertEquals(0, jugadora.puntos());
//
//    }
//    @Test
//    public void test03UnaPreguntaDeVerdaderoFalsoConPenalidadPuedeCrearseIndicandoleCualEsLaRespuestaCorrecta(){
//        String nombre = "Argentina es un pais";
//        List<Opcion> opciones = new ArrayList<>();
//        Opcion opcionCorrecta = new Correcta("True");
//        Opcion opcionIncorrecta = new Incorrecta("False");
//        opciones.add(opcionCorrecta);
//        opciones.add(opcionIncorrecta);
//        opciones.get(1).seleccionar();
//        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Penalizable());
//
//        assertEquals("Argentina es un pais", pregunta.enunciado());
//
//    }
//    @Test
//    public void test04UnaPreguntaDeVerdaderoFalsoPenalizableRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
//        String nombre = "Argentina es un pais";
//        List<Opcion> opciones = new ArrayList<>();
//        Opcion opcionCorrecta = new Correcta("True");
//        Opcion opcionIncorrecta = new Incorrecta("False");
//        opciones.add(opcionCorrecta);
//        opciones.add(opcionIncorrecta);
//        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Penalizable());
//
//        Jugador jugador = new Jugador("Juan");
//        Jugador jugadora = new Jugador("Juana");
//
//        List<Opcion> opcionesElegidasJugador = pregunta.obtenerOpciones();
//        opcionesElegidasJugador.get(0).seleccionar();
//        List<Opcion> opcionesElegidasJugadora = pregunta.obtenerOpciones();
//        opcionesElegidasJugadora.get(1).seleccionar();
//
//        List<Respuesta> respuestas = new ArrayList<>();
//        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador, new Multiplicador(1)));
//        respuestas.add(new Respuesta(jugadora,opcionesElegidasJugadora, new Multiplicador(1)));
//
//        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());
//
//        assertEquals(1, jugador.puntos());
//        assertEquals(-1, jugadora.puntos());
//    }
//    @Test
//    public void test05UnaPreguntaVerdaderoFalsoConExclusividadRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){
//        String nombre = "Argentina es un pais";
//        List<Opcion> opciones = new ArrayList<>();
//        Opcion opcionCorrecta = new Correcta("True");
//        Opcion opcionIncorrecta = new Incorrecta("False");
//        opciones.add(opcionCorrecta);
//        opciones.add(opcionIncorrecta);
//        Pregunta pregunta = new VerdaderoFalso(nombre, opciones, new Clasica());
//
//        Jugador jugador = new Jugador("Juan");
//        Jugador jugadora = new Jugador("Juana");
//
//        List<Opcion> opcionesElegidasJugador = pregunta.obtenerOpciones();
//        opcionesElegidasJugador.get(0).seleccionar();
//        List<Opcion> opcionesElegidasJugadora = pregunta.obtenerOpciones();
//        opcionesElegidasJugadora.get(1).seleccionar();
//
//        List<Respuesta> respuestas = new ArrayList<>();
//        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador, new Multiplicador(1)));
//        respuestas.add(new Respuesta(jugadora,opcionesElegidasJugadora, new Multiplicador(1)));
//
//        pregunta.comprobarRespuestas(respuestas, new AplicadorConExclusividad(1));
//
//        assertEquals(2, jugador.puntos());
//        assertEquals(0, jugadora.puntos());
//    }
//
//    @Test
//    public void test06UnaPreguntaDeMultipleChoiceClasicaPuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
//        String nombre = "Cuales son provincias";
//        List<Binarias> opciones = new ArrayList<>();
//        Correcta primerOpcion = new Correcta("Buenos Aires");
//        Incorrecta segundaOpcion = new Incorrecta("La pampa");
//        Incorrecta tercerOpcion = new Incorrecta("Lanus");
//        opciones.add(primerOpcion);
//        opciones.add(segundaOpcion);
//        opciones.add(tercerOpcion);
//
//        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Clasica());
//
//        assertEquals("Cuales son provincias", pregunta.enunciado());
//    }
//
//    @Test
//    public void test07UnaPreguntaDeMultipleChoiceClasicaRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
//        String nombre = "Cuales son provincias";
//
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new Correcta("Buenos Aires"));
//        opciones.add(new Incorrecta("La pampa"));
//        opciones.add(new Incorrecta("Lanus"));
//
//        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Clasica());
//        Jugador jugador = new Jugador("Juan");
//        Jugador jugadora = new Jugador("Juana");
//
//        List<Opcion> opcionesElegidasJugador = pregunta.obtenerOpciones();
//        opcionesElegidasJugador.get(0).seleccionar();
//        List<Opcion> opcionesElegidasJugadora = pregunta.obtenerOpciones();
//        opcionesElegidasJugadora.get(0).seleccionar();
//        opcionesElegidasJugadora.get(1).seleccionar();
//
//        List<Respuesta> respuestas = new ArrayList<>();
//        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador, new Multiplicador(1)));
//        respuestas.add(new Respuesta(jugadora,opcionesElegidasJugadora, new Multiplicador(1)));
//
//        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());
//
//        assertEquals(1, jugador.puntos());
//        assertEquals(0, jugadora.puntos());
//
//    }
//    @Test
//    public void test08UnaPreguntaDeMultipleChoiceConPuntajeParcialPuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
//        String nombre = "Cuales son provincias";
//
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new Correcta("Buenos Aires"));
//        opciones.add(new Incorrecta("La pampa"));
//        opciones.add(new Incorrecta("Lanus"));
//
//        Pregunta pregunta = new MultipleChoice(nombre, opciones, new PuntajeParcial());
//
//        assertEquals("Cuales son provincias", pregunta.enunciado());
//    }
//    @Test
//    public void test09UnaPreguntaDeMultipleChoiceConPuntajeParcialRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
//        String nombre = "Cuales son provincias";
//
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new Correcta("Buenos Aires"));
//        opciones.add(new Incorrecta("La pampa"));
//        opciones.add(new Incorrecta("Lanus"));
//
//        Pregunta pregunta = new MultipleChoice(nombre, opciones, new PuntajeParcial());
//        Jugador jugador = new Jugador("Juan");
//        Jugador jugadora = new Jugador("Juana");
//
//        List<Opcion> opcionesElegidasJugador = pregunta.obtenerOpciones();
//        opcionesElegidasJugador.get(0).seleccionar();
//        List<Opcion> opcionesElegidasJugadora = pregunta.obtenerOpciones();
//        opcionesElegidasJugadora.get(0).seleccionar();
//        opcionesElegidasJugadora.get(1).seleccionar();
//
//        List<Respuesta> respuestas = new ArrayList<>();
//        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador, new Multiplicador(1)));
//        respuestas.add(new Respuesta(jugadora,opcionesElegidasJugadora, new Multiplicador(1)));
//
//        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());
//
//        assertEquals(1, jugador.puntos());
//        assertEquals(0, jugadora.puntos());
//
//    }
//    @Test
//    public void test10UnaPreguntaDeMultipleChoiceConPenalidadPuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
//        String nombre = "Cuales son provincias";
//
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new Correcta("Buenos Aires"));
//        opciones.add(new Incorrecta("La pampa"));
//        opciones.add(new Incorrecta("Lanus"));
//
//        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Penalizable());
//
//        assertEquals("Cuales son provincias", pregunta.enunciado());
//    }
//    @Test
//    public void test11UnaPreguntaDeMultipleChoicePenalizableRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
//        String nombre = "Cuales son provincias";
//
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new Correcta("Buenos Aires"));
//        opciones.add(new Incorrecta("La pampa"));
//        opciones.add(new Incorrecta("Lanus"));
//
//        Pregunta pregunta = new MultipleChoice(nombre, opciones, new Penalizable());
//        Jugador jugador = new Jugador("Juan");
//        Jugador jugadora = new Jugador("Juana");
//
//        List<Opcion> opcionesElegidasJugador = pregunta.obtenerOpciones();
//        opcionesElegidasJugador.get(0).seleccionar();
//        List<Opcion> opcionesElegidasJugadora = pregunta.obtenerOpciones();
//        opcionesElegidasJugadora.get(0).seleccionar();
//        opcionesElegidasJugadora.get(1).seleccionar();
//
//        List<Respuesta> respuestas = new ArrayList<>();
//        respuestas.add(new Respuesta(jugador, opcionesElegidasJugador, new Multiplicador(1)));
//        respuestas.add(new Respuesta(jugadora,opcionesElegidasJugadora, new Multiplicador(1)));
//
//        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());
//
//        assertEquals(1, jugador.puntos());
//        assertEquals(0, jugadora.puntos());
//
//    }
//    @Test
//    public void test12UnaPreguntaOrderedChoicePuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
//        String nombre = "Jugadores de futbol más altos";
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new OpcionPosicion("Ibrahimovic", 1));
//        opciones.add(new OpcionPosicion("Aguero", 2));
//        opciones.add(new OpcionPosicion("Messi", 3));
//        Pregunta pregunta = new GroupChoice(nombre, opciones, new Clasica());
//
//        assertEquals("Jugadores de futbol más altos", pregunta.enunciado());
//    }
//
//    @Test
//    public void test13UnaPreguntaOrderedChoiceRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
//        String nombre = "Jugadores de futbol más altos";
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new OpcionPosicion("Ibrahimovic", 1));
//        opciones.add(new OpcionPosicion("Aguero", 2));
//        opciones.add(new OpcionPosicion("Messi", 3));
//        Pregunta pregunta = new OrderedChoice(nombre, opciones, new Clasica());
//        List<Opcion> seleccionJugador1 = pregunta.obtenerOpciones();
//        List<Opcion> seleccionJugador2 = pregunta.obtenerOpciones();
//
//        seleccionJugador1.get(0).seleccionar(1);
//        seleccionJugador1.get(1).seleccionar(2);
//        seleccionJugador1.get(2).seleccionar(3);
//
//
//        Jugador jugador1 = new Jugador("Juan");
//        Jugador jugador2 = new Jugador("Juana");
//
//        seleccionJugador2.get(0).seleccionar(3);
//        seleccionJugador2.get(1).seleccionar(1);
//        seleccionJugador2.get(2).seleccionar(2);
//
//
//
//        List<Respuesta> respuestas = new ArrayList<>();
//
//        respuestas.add(new Respuesta(jugador1, seleccionJugador1, new Multiplicador(1)));
//        respuestas.add(new Respuesta(jugador2, seleccionJugador2, new Multiplicador(1)));
//
//        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());
//
//        assertEquals(1, jugador1.puntos());
//        assertEquals(0, jugador2.puntos());
//
//    }
//    @Test
//    public void test14UnaPreguntaGroupChoicePuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
//        String nombre = "Distinguir paises de provincias";
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new OpcionDeGrupo("Cuba", 1));
//        opciones.add(new OpcionPosicion("Venezuela", 1));
//        opciones.add(new OpcionPosicion("Berlin", 2));
//        Pregunta pregunta = new GroupChoice(nombre, opciones, new Clasica());
//
//        assertEquals("Distinguir paises de provincias", pregunta.enunciado());
//    }
//
//    @Test
//    public void test15UnaPreguntaGroupChoicePuedeCrearseIndicandoleCualesSonSusRespuestasCorrectas(){
//        String nombre = "Distinguir paises de provincias";
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new OpcionDeGrupo("Cuba", 1));
//        opciones.add(new OpcionPosicion("Venezuela", 1));
//        opciones.add(new OpcionPosicion("Berlin", 2));
//        Pregunta pregunta = new GroupChoice(nombre, opciones, new Penalizable());
//
//        assertEquals("Distinguir paises de provincias", pregunta.enunciado());
//    }
//    @Test
//    public void test16UnaPreguntaGroupChoiceRecibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente() {
//        String nombre = "Distinguir paises de provincias";
//        List<Opcion> opciones = new ArrayList<>();
//        opciones.add(new OpcionDeGrupo("Cuba", 1));
//        opciones.add(new OpcionDeGrupo("Venezuela", 1));
//        opciones.add(new OpcionDeGrupo("Berlin", 2));
//        Pregunta pregunta = new GroupChoice(nombre, opciones, new Clasica());
//        List<Opcion> seleccionJugador1 = pregunta.obtenerOpciones();
//        List<Opcion> seleccionJugador2 = pregunta.obtenerOpciones();
//
//        seleccionJugador1.get(0).seleccionar(1);
//        seleccionJugador1.get(1).seleccionar(1);
//        seleccionJugador1.get(2).seleccionar(2);
//
//        Jugador jugador1 = new Jugador("Juan");
//        Jugador jugador2 = new Jugador("Juana");
//
//        seleccionJugador2.get(0).seleccionar(2);
//        seleccionJugador2.get(1).seleccionar(2);
//        seleccionJugador2.get(2).seleccionar(1);
//
//        List<Respuesta> respuestas = new ArrayList<>();
//
//        respuestas.add(new Respuesta(jugador1, seleccionJugador1, new Multiplicador(1)));
//        respuestas.add(new Respuesta(jugador2, seleccionJugador2, new Multiplicador(1)));
//
//        pregunta.comprobarRespuestas(respuestas, new AplicadorSimple());
//
//        assertEquals(1, jugador1.puntos());
//        assertEquals(0, jugador2.puntos());
//
//    }
//
//
//}
//
//
