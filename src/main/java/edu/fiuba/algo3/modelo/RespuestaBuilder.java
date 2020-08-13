package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.List;

public class RespuestaBuilder implements IBuilder{
    private Jugador responsable;
    private List<Opcion> selecciones;
    private Multiplicador multiplicador;

    public RespuestaBuilder conResponsable(Jugador responsable){
        this.responsable = responsable;
        return this;
    }

    public RespuestaBuilder conSelecciones(List<Opcion> selecciones){
        this.selecciones = selecciones;
        return this;
    }

    public RespuestaBuilder conMultiplicador(Multiplicador multiplicador){
        this.multiplicador = multiplicador;
        return this;
    }


    @Override
    public Respuesta build(){
        Respuesta respuesta = new Respuesta();
        respuesta.setResponsable(this.responsable);
        respuesta.setSelecciones(this.selecciones);
        respuesta.setMultiplicador(this.multiplicador);
        return respuesta;
    }
}
