package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opciones.Grupal;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;

import java.util.ArrayList;
import java.util.List;

public class GroupChoice extends Pregunta {
    private List<Grupal> opciones;
    public GroupChoice(String enunciado, List<Grupal> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }
    public List<Grupal> obtenerOpciones(){
        List<Grupal> opcionesCopiadas = new ArrayList<>();
        for(Grupal opcionACopiar : opciones){
            opcionesCopiadas.add(opcionACopiar.copiarOpcion());
        }
        return opcionesCopiadas;
    }
}