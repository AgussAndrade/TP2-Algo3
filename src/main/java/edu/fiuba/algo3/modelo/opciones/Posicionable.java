package edu.fiuba.algo3.modelo.opciones;

public interface Posicionable extends Opcion {
     void seleccionar(int parametro);
     Posicionable copiarOpcion();
}
