package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaTest {

   @Test
    public void test01ElJugadorResponsableDeLaRespuestaEsElCorrecto(){

       Jugador jugador = new Jugador("Juan");
       List<Opcion> selecciones = new ArrayList<>();

       Respuesta respuesta = new Respuesta(jugador,selecciones,new Multiplicador(1),false);

       assertEquals(jugador,respuesta.jugador());
    }

    @Test
    public void test02LasSeleccionesDelJugadorResponsableDeLaRespuestaSonLasCorrectas(){

       Jugador jugador = new Jugador("Juan");
       List<Opcion> selecciones = new ArrayList<>();

       selecciones.add(new Correcta("Correcta"));
       selecciones.add(new Incorrecta("Incorrecta"));
       Respuesta respuesta = new Respuesta (jugador,selecciones,new Multiplicador(1),false);

       assertEquals(selecciones,respuesta.selecciones());

    }

}
