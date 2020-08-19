package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Errores.CantidadDeOpcionesErroneaException;
import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.estrategias.Penalizable;
import edu.fiuba.algo3.modelo.estrategias.PuntajeParcial;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.opciones.Grupal;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.Posicionable;

import java.util.List;

public class PreguntaFactory {

    public static VerdaderoFalso crearVerdaderoFalsoClasica(String enunciado,List<Binaria> opciones) throws CantidadDeOpcionesErroneaException {
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad,2,2))){
            throw new CantidadDeOpcionesErroneaException();
        }
        return new VerdaderoFalso(enunciado, opciones, new Clasica());
    }

    public static VerdaderoFalso crearVerdaderoFalsoPenalizable(String enunciado,List<Binaria> opciones)throws CantidadDeOpcionesErroneaException {
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad,2,2))){
            throw new CantidadDeOpcionesErroneaException();
        }
        return (new VerdaderoFalso(enunciado, opciones, new Penalizable()));
    }

    public static MultipleChoice crearMultipleChoiceClasica(String enunciado,List<Binaria> opciones) throws CantidadDeOpcionesErroneaException {
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad,2,5))){
            throw new CantidadDeOpcionesErroneaException();
        }
        return new MultipleChoice(enunciado, opciones, new Clasica());

    }

    public static MultipleChoice crearMultipleChoicePuntajeParcial(String enunciado,List<Binaria> opciones) throws CantidadDeOpcionesErroneaException {
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad,2,5))){
            throw new CantidadDeOpcionesErroneaException();
        }
        return new MultipleChoice(enunciado, opciones, new PuntajeParcial());

    }

    public static MultipleChoice crearMultipleChoicePenalizable(String enunciado,List<Binaria> opciones) throws CantidadDeOpcionesErroneaException {
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad,2,5))){
            throw new CantidadDeOpcionesErroneaException();
        }
        return new MultipleChoice(enunciado, opciones, new Penalizable());

    }

    public static GroupChoice crearGroupChoice(String enunciado, List<Grupal> opciones) throws CantidadDeOpcionesErroneaException {
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad, 2,6))){
            throw new CantidadDeOpcionesErroneaException();
        }
        return new GroupChoice(enunciado, opciones, new Clasica());
    }

    public static OrderedChoice crearOrderedChoice(String enunciado, List<Posicionable> opciones) throws CantidadDeOpcionesErroneaException {
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad, 2, 5))){
            throw new CantidadDeOpcionesErroneaException();
        }
        return new OrderedChoice (enunciado, opciones, new Clasica());

    }

    private static boolean comprobarCantidadDeOpciones(List<Opcion> opciones, int desde, int hasta) {
        return (opciones.size() >= desde && opciones.size() <= hasta);

    }
}

