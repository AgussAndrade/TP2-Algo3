//package edu.fiuba.algo3.modelo;
//
//import edu.fiuba.algo3.modelo.estrategias.Estrategia;
//import edu.fiuba.algo3.modelo.estrategias.Penalizable;
//import edu.fiuba.algo3.modelo.opciones.Correcta;
//import edu.fiuba.algo3.modelo.opciones.Incorrecta;
//import edu.fiuba.algo3.modelo.opciones.Opcion;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class PenalizableTest {
//
//    @Test
//    public void test01unJugadorSeleccionaUnaRespuestaCorrectaYUnaIncorrectaYSuma0puntos(){
//
//        Estrategia penalizable = new Penalizable();
//        Jugador jugador = new Jugador("Juan");
//
//        List<Opcion> opciones = new ArrayList<>();
//        Opcion opcionCorrecta = new Correcta("Correcta");
//        Opcion opcionIncorrecta = new Incorrecta("Incorrecta");
//
//        opcionCorrecta.seleccionar();
//        opcionIncorrecta.seleccionar();
//        opciones.add(opcionCorrecta);
//        opciones.add(opcionIncorrecta);
//        Respuesta respuesta = new Respuesta(jugador,opciones,new Multiplicador(1));
//        List<Respuesta> respuestas = new ArrayList<>();
//        respuestas.add(respuesta);
//        penalizable.validarRespuestas(respuestas);
//        assertEquals(0,respuesta.obtenerPuntos());
//    }
//}
