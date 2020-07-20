package edu.fiuba.algo3.modelo;

public class Correcta implements Opcion {
    String nombre;
    int puntuacion;
    public Correcta(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 1;
    }
    public String texto(){
        return nombre;
    }
    public int obtenerPuntos(){
        return puntuacion;
    }
}
