package edu.fiuba.algo3.modelo;

import java.util.List;

public class Clasica implements Estrategia {


    public Clasica(){
    }


    @Override
    public void sumarPuntos(Respuesta respuesta, List<Opcion> opciones ){
        int cantidadRespuestasCorrectas = 0;
        int respondido = 0;

        for(Opcion opcion : opciones){
            if(opcion.esCorrecta()){
                cantidadRespuestasCorrectas+=1;
            }
        }
        for(Opcion seleccion : respuesta.selecciones()) {
            if(seleccion.esCorrecta()){
                respondido += 1;
            }
            else{
                return;
            }
        }
        if(respondido != cantidadRespuestasCorrectas){
            return;
        }
        respuesta.jugador().sumarPuntos(1);
    }
}