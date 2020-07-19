package edu.fiuba.algo3.modelo;

public class PreguntaVerdaderoFalso implements Pregunta {
    String enunciado;
    Opcion correcta;
    Opcion incorrecta;
    public PreguntaVerdaderoFalso(String enunciado, Opcion opcionCorrecta, Opcion opcionIncorrecta) {
        this.enunciado = enunciado;
        correcta = opcionCorrecta;
        incorrecta = opcionIncorrecta;
    }
    public String nombre(){
        return enunciado;
    }
    public String opcionCorrecta(){
        return correcta.texto();
    }
}
