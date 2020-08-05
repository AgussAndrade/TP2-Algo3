package edu.fiuba.algo3.modelo.opciones;

public interface Opcion {
    public Opcion copiarOpcion();
    public String texto();
    public boolean esCorrecta();
    public void seleccionar();
    public void seleccionar(int parametro);
    public boolean fueSeleccionadaCorrectamente();
}
