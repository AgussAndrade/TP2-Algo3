package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.opciones.*;

public class OpcionesFactory {

    public Binaria crearOpcionCorrecta(String opcionCorrecta) {
        return new Correcta(opcionCorrecta);
    }

    public Binaria crearOpcionIncorrecta(String opcionIncorrecta) {
        return new Incorrecta(opcionIncorrecta);
    }

    public Posicionable crearOpcionConPosicion(String textoOpcion, Integer contador) {
        return new OpcionPosicion(textoOpcion, contador);
    }

    public Grupal crearOpcionDeGupoA(String opcionGrupoA) {
        return new OpcionDeGrupo(opcionGrupoA, "A");
    }

    public Grupal crearOpcionDeGrupoB(String opcionGrupoB) {
        return new OpcionDeGrupo(opcionGrupoB, "B");
    }
}
