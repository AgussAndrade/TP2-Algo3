package edu.fiuba.algo3.modelo;

import java.util.List;

public class Respuesta {
    private Jugador responsable;
    private List<Opcion> selecciones;

    public Respuesta(Jugador responsable, List<Opcion> selecciones){
        this.responsable = responsable;
        this.selecciones = selecciones;

    }
    public void validar(Estrategia estrategia){

        estrategia.sumarPuntos(responsable,selecciones);
    }
}

