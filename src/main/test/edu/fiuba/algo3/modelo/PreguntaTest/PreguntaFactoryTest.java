package edu.fiuba.algo3.modelo.PreguntaTest;

import edu.fiuba.algo3.modelo.Errores.CantidadDeOpcionesErroneaException;
import edu.fiuba.algo3.modelo.opciones.*;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.PreguntaFactory.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PreguntaFactoryTest {

    @Test
    public void test01unaPreguntaFactoryVerdaderoFalsoClasicoRecibe3OpcionesLanzaExcepcion() throws CantidadDeOpcionesErroneaException {
        List<Binaria> opciones = new ArrayList<>();
        Correcta opcion1 = new Correcta("Correcta");
        Correcta opcion2 = new Correcta("Correcta");
        Incorrecta opcion3 = new Incorrecta("Incorrecta");

        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        assertThrows(CantidadDeOpcionesErroneaException.class, () -> crearVerdaderoFalsoClasica("enunciado", opciones));
    }

    @Test
    public void test02unaPreguntaFactoryMultipleChoiceClasicoRecibe1OpcionLanzaExcepcion(){
        List<Binaria> opciones = new ArrayList<>();
        Correcta opcion1 = new Correcta("Correcta");

        opciones.add(opcion1);

        assertThrows(CantidadDeOpcionesErroneaException.class, () -> crearMultipleChoiceClasica("enunciado", opciones));
    }

    @Test
    public void test03unaPreguntaFactoryOrderedChoiceRecibe7opcionesLanzaExcepcion(){
        List <Posicionable> opciones = new ArrayList<>();
        OpcionPosicion opcion1 = new OpcionPosicion("1",1);
        OpcionPosicion opcion2 = new OpcionPosicion("2",2);
        OpcionPosicion opcion3 = new OpcionPosicion("3",3);
        OpcionPosicion opcion4 = new OpcionPosicion("4",4);
        OpcionPosicion opcion5 = new OpcionPosicion("5",5);
        OpcionPosicion opcion6 = new OpcionPosicion("6",6);
        OpcionPosicion opcion7 = new OpcionPosicion("7",7);

        opciones.add(opcion1); opciones.add(opcion2);opciones.add(opcion3);opciones.add(opcion4);
        opciones.add(opcion5);opciones.add(opcion6);opciones.add(opcion7);

        assertThrows(CantidadDeOpcionesErroneaException.class, () -> crearOrderedChoice("enunciado", opciones));
    }

    @Test
    public void test04unaPreguntaFactoryGroupChoiceRecibe1opcionLanzaExcepcion(){
        List <Grupal> opciones = new ArrayList<>();
        OpcionDeGrupo opcion1 = new OpcionDeGrupo("1","A");

        opciones.add(opcion1);

        assertThrows(CantidadDeOpcionesErroneaException.class, () -> crearGroupChoice("enunciado", opciones));
    }

}
