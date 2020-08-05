package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estrategias.Estrategia;
import edu.fiuba.algo3.modelo.estrategias.PuntajeParcial;
import edu.fiuba.algo3.modelo.opciones.Correcta;
import edu.fiuba.algo3.modelo.opciones.Incorrecta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {
    @Test
    public void test01UnJugadorRespondeCorrectamenteYPuntajeParcialSumaLosPuntosCorrectamente(){
        Estrategia puntajeParcial = new PuntajeParcial();
        Jugador jugador = new Jugador("Juan");
        List<Opcion> opciones = new ArrayList<>();
        Opcion opcionCorrecta = new Correcta("Correcta");
        Opcion opcionIncorrecta = new Incorrecta("Incorrecta");

        opcionCorrecta.seleccionar();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Respuesta respuesta = new Respuesta(jugador,opciones,new Multiplicador(1),false);


        assertEquals(1,puntajeParcial.devolverSumaDePuntos(respuesta));
    }
}
