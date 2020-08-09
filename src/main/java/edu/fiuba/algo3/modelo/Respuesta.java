package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.List;

public class Respuesta {
    private Jugador responsable;
    private List<Opcion> selecciones;
    private Multiplicador multiplicador;
    private int puntosAAgregar;

    public Respuesta(Jugador responsable, List<Opcion> selecciones,Multiplicador multiplicador){
        this.responsable = responsable;
        this.selecciones = selecciones;
        this.multiplicador = multiplicador;
    }

    public Jugador jugador() {
        return responsable;
    }

    public List<Opcion> selecciones() {
        return selecciones;
    }

    public Multiplicador multiplicador() {
        return multiplicador;
    }

    public int cantidadDeOpcionesSeleccionadasCorrectamente(){
        int correctas = 0;
        for(Opcion opcion : selecciones){
            if(opcion.fueSeleccionadaCorrectamente()){
                correctas += 1;
            }
        }
        return correctas;
    }
    public int cantidadDeOpciones(){
        return selecciones.size();
    }
    public void definirPuntosAAgregar(int puntos){
        this.puntosAAgregar = puntos;
    }
    public int cantidadDeOpcionesCorrectasSeleccionadasCorrectamente(){
        int correctasSeleccionadasCorrectamente = 0;
        for(Opcion opcion : selecciones){
            if(opcion.fueSeleccionadaCorrectamente() && opcion.esCorrecta()){
                correctasSeleccionadasCorrectamente += 1;
            }
        }
        return correctasSeleccionadasCorrectamente;
    }
    public int obtenerPuntos(){
        return puntosAAgregar;
    }

    public int cantidadDeOpcionesIncorrectasSeleccionadasincorrectamente() {
        int incorrectasSeleccionadasIncorrectamente = 0;
        for(Opcion opcion : selecciones){
            if(!opcion.fueSeleccionadaCorrectamente() && !opcion.esCorrecta()){
                incorrectasSeleccionadasIncorrectamente += 1;
            }
        }
        return incorrectasSeleccionadasIncorrectamente;
    }
}

