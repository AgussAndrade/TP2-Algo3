package edu.fiuba.algo3.modelo.opciones;

public interface Posicionable extends Opcion {
    public void seleccionar(int parametro);
    public Posicionable copiarOpcion();
}
