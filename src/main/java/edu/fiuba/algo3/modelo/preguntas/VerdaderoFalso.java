package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalso extends Pregunta {
    private List<Binaria> opciones;
    public VerdaderoFalso(String enunciado, List<Binaria> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }
    public List<Binaria> obtenerOpciones(){
        List<Binaria> opcionesCopiadas = new ArrayList<>();
        for(Binaria opcionACopiar : opciones){
            opcionesCopiadas.add(opcionACopiar.copiarOpcion());
        }
        return opcionesCopiadas;
    }
}
