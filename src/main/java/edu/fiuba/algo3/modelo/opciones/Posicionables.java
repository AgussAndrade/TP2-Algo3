package edu.fiuba.algo3.modelo.opciones;

public interface Posicionables extends Opcion {
    public void seleccionar(int parametro);
    public Posicionables copiarOpcion();
}
