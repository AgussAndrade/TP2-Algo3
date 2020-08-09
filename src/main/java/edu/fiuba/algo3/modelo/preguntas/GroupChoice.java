package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opciones.Grupales;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;

import java.util.ArrayList;
import java.util.List;

public class GroupChoice extends Pregunta {
    private List<Grupales> opciones;
    public GroupChoice(String enunciado, List<Grupales> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }
    public List<Grupales> obtenerOpciones(){
        List<Grupales> opcionesCopiadas = new ArrayList<>();
        for(Grupales opcionACopiar : opciones){
            opcionesCopiadas.add(opcionACopiar.copiarOpcion());
        }
        return opcionesCopiadas;
    }
}