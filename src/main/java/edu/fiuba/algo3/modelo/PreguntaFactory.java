package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estrategias.Clasica;
import edu.fiuba.algo3.modelo.estrategias.Penalizable;
import edu.fiuba.algo3.modelo.estrategias.PuntajeParcial;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.opciones.Grupal;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.Posicionable;
import edu.fiuba.algo3.modelo.preguntas.*;

import java.util.ArrayList;
import java.util.List;

public class PreguntaFactory {
    private List<Pregunta> preguntas;

    public static VerdaderoFalso crearVerdaderoFalsoClasica(String enunciado,List<Binaria> opciones){
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad,2,2))){
            //TIRAR EXCEPCION//
        }
        return new VerdaderoFalso(enunciado, opciones, new Clasica());
    }

    public static VerdaderoFalso crearVerdaderoFalsoPenalizable(String enunciado,List<Binaria> opciones){
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad,2,2))){
            //TIRAR EXCEPCION//
        }
        return (new VerdaderoFalso(enunciado, opciones, new Penalizable()));
    }

    public static MultipleChoice crearMultipleChoiceClasica(String enunciado,List<Binaria> opciones){
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad,2,5))){
            //TIRAR EXCEPCION//
        }
        return new MultipleChoice(enunciado, opciones, new Clasica());

    }

    public static MultipleChoice crearMultipleChoicePuntajeParcial(String enunciado,List<Binaria> opciones){
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad,2,5))){
            //TIRAR EXCEPCION//
        }
        return new MultipleChoice(enunciado, opciones, new PuntajeParcial());

    }

    public static MultipleChoice crearMultipleChoicePenalizable(String enunciado,List<Binaria> opciones){
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad,2,5))){
            //TIRAR EXCEPCION//
        }
        return new MultipleChoice(enunciado, opciones, new Penalizable());

    }

    public static GroupChoice crearGroupChoice(String enunciado, List<Grupal> opciones){
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad, 2,6))){
            //TIRAR EXCEPCION//
        }
        return new GroupChoice(enunciado, opciones, new Clasica());
    }

    public static OrderedChoice crearOrderedChoice(String enunciado, List<Posicionable> opciones){
        List<Opcion> opcionesAChequearCantidad = List.copyOf(opciones);
        if (!(comprobarCantidadDeOpciones(opcionesAChequearCantidad, 2, 5))){
            //TIRAR EXCEPCION//
        }
        return new OrderedChoice (enunciado, opciones, new Clasica());

    }

    private static boolean comprobarCantidadDeOpciones(List<Opcion> opciones, int desde, int hasta) {
        return (opciones.size() >= desde && opciones.size() <= hasta);

    }
}

