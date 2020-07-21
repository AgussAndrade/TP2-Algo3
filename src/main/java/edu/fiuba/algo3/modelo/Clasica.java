package edu.fiuba.algo3.modelo;

public class Clasica implements Estrategia {

    @Override
    public int puntosPorIncorrecta(){
        return 0;
    }

    @Override
    public int puntosPorCorrecta(){
        return 1;
    }
}
