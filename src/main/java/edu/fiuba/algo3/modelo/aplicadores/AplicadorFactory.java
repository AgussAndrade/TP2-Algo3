package edu.fiuba.algo3.modelo.aplicadores;

public class AplicadorFactory {
    public static AplicadorDePuntos creacAplicadorSegunLosLlamados(int llamados){
        if (llamados == 0){
            return new AplicadorSimple();
        }
        return new AplicadorConExclusividad(llamados);
    }
}
