package edu.fiuba.algo3.modelo;

import javafx.scene.control.TableRow;

import java.util.List;

public class EstrategiaOrderedChoice implements Estrategia{
    public EstrategiaOrderedChoice(){}
    private boolean compararListasDeOpciones(List<Opcion> respuestas, List<Opcion> opciones){
        int i = 0;
        while(i < respuestas.size()){
            if(!((respuestas.get(i)).equals(opciones.get(i))) ) {
                return false;
            }
            i+=1;
        }
        return true;
    }
    public void sumarPuntos(Respuesta respuesta, List<Opcion> opciones){
        List<Opcion> respuestas = respuesta.selecciones();
        Jugador jugador = respuesta.jugador();

        if( compararListasDeOpciones(respuestas,opciones)){
            jugador.sumarPuntos(1);
        }

    }
}
