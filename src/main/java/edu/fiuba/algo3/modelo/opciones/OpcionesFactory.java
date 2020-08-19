package edu.fiuba.algo3.modelo.opciones;


public class OpcionesFactory {

    public static Binaria crearOpcionCorrecta(String opcionCorrecta) {
        return new Correcta(opcionCorrecta);
    }

    public static Binaria crearOpcionIncorrecta(String opcionIncorrecta) {
        return new Incorrecta(opcionIncorrecta);
    }

    public static Posicionable crearOpcionConPosicion(String textoOpcion, Integer contador) {
        return new OpcionPosicion(textoOpcion, contador);
    }

    public static Grupal crearOpcionDeGrupo(String textoOpcion, String nombreGrupo) {
        return new OpcionDeGrupo(textoOpcion, nombreGrupo);
    }

}
