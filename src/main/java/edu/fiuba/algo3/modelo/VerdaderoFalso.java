package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalso extends Pregunta {

    private VerdaderoFalso(String enunciado, List<Opcion> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }

    public static VerdaderoFalso verdadera(String enunciado, Estrategia estrategia){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Verdadero"));
        opciones.add(new Incorrecta("Falso"));
        return new VerdaderoFalso(enunciado, opciones, estrategia);
     }

     public static VerdaderoFalso falsa(String enunciado, Estrategia estrategia){
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(new Correcta("Falso"));
        opciones.add(new Incorrecta("Verdadero"));
        return new VerdaderoFalso(enunciado, opciones, estrategia);
    }

}
