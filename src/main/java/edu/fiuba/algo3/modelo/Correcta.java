package edu.fiuba.algo3.modelo;

public class Correcta implements Opcion {
    String nombre;
    public Correcta(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String texto(){
        return nombre;
    }

    @Override
    public int obtenerPuntos(Estrategia estrategia) {
        return estrategia.puntosPorCorrecta();
    }
}
