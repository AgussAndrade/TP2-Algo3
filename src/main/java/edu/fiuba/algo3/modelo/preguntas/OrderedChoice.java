package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opciones.Posicionables;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;

import java.util.ArrayList;
import java.util.List;

public class OrderedChoice extends Pregunta {
    private List<Posicionables> opciones;
    public OrderedChoice(String enunciado, List<Posicionables> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }
    public List<Posicionables> obtenerOpciones(){
        List<Posicionables> opcionesCopiadas = new ArrayList<>();
        for(Posicionables opcionACopiar : opciones){
            opcionesCopiadas.add(opcionACopiar.copiarOpcion());
        }
        return opcionesCopiadas;
    }
}
