package edu.fiuba.algo3.modelo;

public class  Respuesta {
    private Jugador responsable;
    private Opcion seleccion;

    public Respuesta(Jugador responsable, Opcion seleccion){
        this.responsable = responsable;
        this.seleccion = seleccion;
    }
    public void validar(Estrategia estrategia){
        responsable.sumarPuntos(seleccion.obtenerPuntos(estrategia));
    }
}
