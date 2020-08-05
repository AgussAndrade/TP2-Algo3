package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.List;

public class Respuesta {
    private Jugador responsable;
    private List<Opcion> selecciones;
    private Multiplicador multiplicador;
    private boolean exclusividadDelPuntaje;

    public Respuesta(Jugador responsable, List<Opcion> selecciones,Multiplicador multiplicador, boolean exclusividadDelPuntaje){
        this.responsable = responsable;
        this.selecciones = selecciones;
        this.multiplicador = multiplicador;
        this.exclusividadDelPuntaje = exclusividadDelPuntaje;
    }

    public boolean exclusividadDelPuntaje(){
        return exclusividadDelPuntaje;
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
}

