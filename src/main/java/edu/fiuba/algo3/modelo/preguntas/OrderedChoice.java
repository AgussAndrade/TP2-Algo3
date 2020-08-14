package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opciones.Posicionable;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;

import java.util.ArrayList;
import java.util.List;

public class OrderedChoice extends Pregunta {
    private List<Posicionable> opciones;
    public OrderedChoice(String enunciado, List<Posicionable> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }
    public List<Posicionable> obtenerOpciones(){
        List<Posicionable> opcionesCopiadas = new ArrayList<>();
        for(Posicionable opcionACopiar : opciones){
            opcionesCopiadas.add(opcionACopiar.copiarOpcion());
        }
        return opcionesCopiadas;
    }

    @Override
    public String nombreDeLaEstrategia() {
        return estrategia.nombreDeLaClase();
    }
}
