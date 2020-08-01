package edu.fiuba.algo3.modelo;

import java.security.PublicKey;
import java.util.List;

public class OpcionNeutra implements Opcion {
    String texto;
    public OpcionNeutra(String texto){
        this.texto = texto;
    }
    public String texto(){
        return texto;
    }
    public boolean esCorrecta(){
        return true;
    }
}
