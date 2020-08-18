package edu.fiuba.algo3.modelo.opciones;

public interface Grupal extends Opcion {

    void seleccionar(String parametro);
    Grupal copiarOpcion();
    String grupoSeleccionado();
    String grupo();
}
