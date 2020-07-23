package edu.fiuba.algo3.modelo;

public class Jugador{
    private int puntaje = 0;
    private String nombre;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public int puntos() {
        return puntaje;
    }

    public void sumarPuntos(int cantidadDePuntos){
        puntaje += cantidadDePuntos;
    }

    public String nombre() {
        return nombre;
    }
}
