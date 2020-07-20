package edu.fiuba.algo3.modelo;

public class Incorrecta implements Opcion {
    String nombre;
    int puntuacion;
    public Incorrecta(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
    }
    public String texto(){
        return nombre;
    }
    public int obtenerPuntos(){
        return puntuacion;
    }
}
