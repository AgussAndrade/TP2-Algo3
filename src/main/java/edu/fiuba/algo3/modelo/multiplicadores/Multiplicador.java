package edu.fiuba.algo3.modelo.multiplicadores;

public class Multiplicador {
    int aMultiplicar;
    public Multiplicador(int aMultiplicar){
        this.aMultiplicar = aMultiplicar;
    }
    public int multiplicarPuntos ( int puntos){
        return (puntos * aMultiplicar);
    }

}
