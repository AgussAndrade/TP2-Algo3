package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opciones.Binarias;
import edu.fiuba.algo3.modelo.estrategias.Estrategia;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalso extends Pregunta {
    private List<Binarias> opciones;
    public VerdaderoFalso(String enunciado, List<Binarias> opciones, Estrategia estrategia) {
        this.enunciado = enunciado;
        this.opciones = List.copyOf(opciones);
        this.estrategia = estrategia;
    }
    public List<Binarias> obtenerOpciones(){
        List<Binarias> opcionesCopiadas = new ArrayList<>();
        for(Binarias opcionACopiar : opciones){
            opcionesCopiadas.add(opcionACopiar.copiarOpcion());
        }
        return opcionesCopiadas;
    }
}
