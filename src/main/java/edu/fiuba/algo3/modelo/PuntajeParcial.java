package edu.fiuba.algo3.modelo;

import java.util.List;

public class PuntajeParcial implements Estrategia {

    @Override
    public int devolverSumaDePuntos(Respuesta respuesta){
        int puntosASumar = 0;
        for(Opcion seleccion : respuesta.selecciones()) {
            if(!seleccion.fueSeleccionadaCorrectamente() && !seleccion.esCorrecta()){
                return 0;
            }
            else if (seleccion.fueSeleccionadaCorrectamente() && seleccion.esCorrecta()) {
                puntosASumar+=1;
            }
        }
        return (puntosASumar);
    }
}