package edu.fiuba.algo3.modelo;

public interface Opcion {
    public String texto();
    public boolean esCorrecta();
    public void seleccionar();
    public void seleccionar(int parametro);
    public boolean fueSeleccionadaCorrectamente();
}
