package edu.fiuba.algo3.modelo;

public class Clasica implements Estrategia {
    int multiplicable = 1;

    private int cantidadDeRespuestasCorrectas;

    public Clasica(int cantidadDeRespuestasCorrectas){
        this.cantidadDeRespuestasCorrectas = cantidadDeRespuestasCorrectas;
    }

    @Override
    public int puntosPorIncorrecta() {
        multiplicable = 0;
        return 0;
    }

    @Override
    public int puntosPorCorrecta() {
        return 1;
    }

    @Override
    public void sumarPuntos(Respuesta respuesta){
        int puntosASumar = 0;
        for(Opcion seleccion : respuesta.selecciones()) {
            puntosASumar += seleccion.obtenerPuntos(this);
        }
        if(puntosASumar != cantidadDeRespuestasCorrectas){
            multiplicable = 0;
        }
        respuesta.jugador().sumarPuntos( multiplicable);
        multiplicable = 1;
    }
}