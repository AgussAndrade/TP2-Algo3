package edu.fiuba.algo3.modelo;

public class Clasica implements Estrategia {
    int sumable = 1;

    private int cantidadDeRespuestasCorrectas;

    public Clasica(int cantidadDeRespuestasCorrectas){
        this.cantidadDeRespuestasCorrectas = cantidadDeRespuestasCorrectas;
    }

    @Override
    public int puntosPorIncorrecta() {
        sumable = 0;
        return 0;
    }

    @Override
    public int puntosPorCorrecta() {
        return 1;
    }

    @Override
    public void sumarPuntos(Respuesta respuesta){
        int respondido = 0;
        for(Opcion seleccion : respuesta.selecciones()) {
            respondido += seleccion.obtenerPuntos(this);
        }
        if(respondido != cantidadDeRespuestasCorrectas){
            sumable = 0;
        }
        respuesta.jugador().sumarPuntos(sumable);
        sumable = 1;
    }
}