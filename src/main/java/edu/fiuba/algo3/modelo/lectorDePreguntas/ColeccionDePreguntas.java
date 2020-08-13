package edu.fiuba.algo3.modelo.lectorDePreguntas;

import edu.fiuba.algo3.modelo.Errores.CantidadDeOpcionesErroneaException;
import edu.fiuba.algo3.modelo.OpcionesFactory;
import edu.fiuba.algo3.modelo.PreguntaFactory;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.opciones.Grupal;
import edu.fiuba.algo3.modelo.opciones.Posicionable;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ColeccionDePreguntas {
    private final List<VerdaderoFalso> coleccionDePreguntasVerdaderoFalsoClasica = new ArrayList<>();
    private final List<VerdaderoFalso> coleccionDePreguntasVerdaderoFalsoPenalizable = new ArrayList<>();
    private final List<MultipleChoice> coleccionDePreguntasMultipleChoiceClasica = new ArrayList<>();
    private final List<MultipleChoice> coleccionDePreguntasMultipleChoicePenalizable = new ArrayList<>();
    private final List<MultipleChoice> coleccionDePreguntasMultipleChoicePuntajeParcial = new ArrayList<>();
    private final List<OrderedChoice> coleccionDePreguntasOrderedChoice = new ArrayList<>();
    private final List<GroupChoice> coleccionDePreguntasGroupChoice = new ArrayList<>();


    public ColeccionDePreguntas(){

    }
    public void guardarPreguntasVerdaderoFalsoClasica(JSONArray preguntasVerdaderoFalsoClasica) throws CantidadDeOpcionesErroneaException {
        for (Object preguntaJSON : preguntasVerdaderoFalsoClasica) {
            String enunciado = this.leerEnunciado((JSONObject) preguntaJSON);
            List<Binaria> opciones = this.leerOpcionesVerdaderoFalso((JSONObject) preguntaJSON);
            this.coleccionDePreguntasVerdaderoFalsoClasica.add(PreguntaFactory.crearVerdaderoFalsoClasica(enunciado, opciones));
        }
    }


    public void guardarPreguntasVerdaderoFalsoPenalizable(JSONArray preguntasVerdaderoFalsoPenalizable) throws CantidadDeOpcionesErroneaException {
        for (Object preguntaJSON : preguntasVerdaderoFalsoPenalizable) {
            String enunciado = this.leerEnunciado((JSONObject) preguntaJSON);
            List<Binaria> opciones = this.leerOpcionesVerdaderoFalso((JSONObject) preguntaJSON);
            this.coleccionDePreguntasVerdaderoFalsoPenalizable.add(PreguntaFactory.crearVerdaderoFalsoPenalizable(enunciado, opciones));
        }
    }

    public void guardarPreguntasMultipleChoiceClasica(JSONArray preguntasMultipleChoiceClasica) throws CantidadDeOpcionesErroneaException {

        for(Object preguntaJSON : preguntasMultipleChoiceClasica){
            String enunciado = this.leerEnunciado((JSONObject) preguntaJSON);
            List<Binaria> opciones = this.leerOpcionesMultipleChoice((JSONObject) preguntaJSON);
            this.coleccionDePreguntasMultipleChoiceClasica.add(PreguntaFactory.crearMultipleChoiceClasica(enunciado, opciones));
        }
    }

    public void guardarPreguntasMultipleChoicePenalizable(JSONArray preguntasMultipleChoicePenalizable) throws CantidadDeOpcionesErroneaException {
        for(Object preguntaJSON : preguntasMultipleChoicePenalizable){
            String enunciado = this.leerEnunciado((JSONObject) preguntaJSON);
            List<Binaria> opciones = this.leerOpcionesMultipleChoice((JSONObject) preguntaJSON);
            this.coleccionDePreguntasMultipleChoiceClasica.add(PreguntaFactory.crearMultipleChoiceClasica(enunciado, opciones));
            this.coleccionDePreguntasMultipleChoicePenalizable.add(PreguntaFactory.crearMultipleChoicePenalizable(enunciado, opciones));
        }
    }

    public void guardarPreguntasMultipleChoicePuntajeParcial(JSONArray preguntasMultipleChoicePuntajeParcial) throws CantidadDeOpcionesErroneaException {
        for(Object preguntaJSON : preguntasMultipleChoicePuntajeParcial){
            String enunciado = this.leerEnunciado((JSONObject) preguntaJSON);
            List<Binaria> opciones = this.leerOpcionesMultipleChoice((JSONObject) preguntaJSON);
            this.coleccionDePreguntasMultipleChoiceClasica.add(PreguntaFactory.crearMultipleChoiceClasica(enunciado, opciones));
            this.coleccionDePreguntasMultipleChoicePuntajeParcial.add(PreguntaFactory.crearMultipleChoicePuntajeParcial(enunciado, opciones));
        }
    }

    public void guardarPreguntasGroupChoice(JSONArray preguntasGroupChoice) throws CantidadDeOpcionesErroneaException {
        for(Object preguntaJSON : preguntasGroupChoice){
            String enunciado = this.leerEnunciado((JSONObject) preguntaJSON);
            JSONObject opciones = (JSONObject) ((JSONObject) preguntaJSON).get("opciones");
            JSONArray listaDeOpcionesGrupoA = (JSONArray) opciones.get("A");
            JSONArray listaDeOpcionesGrupoB = (JSONArray) opciones.get("B");
            List<Grupal> listaDeOpciones = new ArrayList<>();
            for(Object objetoOpcion : listaDeOpcionesGrupoA){
                String opcionGrupoA = (String) objetoOpcion;
                listaDeOpciones.add(OpcionesFactory.crearOpcionDeGupoA(opcionGrupoA));
            }
            for(Object objetoOpcion : listaDeOpcionesGrupoB){
                String opcionGrupoB = (String) objetoOpcion;
                listaDeOpciones.add(OpcionesFactory.crearOpcionDeGrupoB(opcionGrupoB));
            }
            this.coleccionDePreguntasGroupChoice.add(PreguntaFactory.crearGroupChoice(enunciado, listaDeOpciones));
        }
    }

    public void guardarPreguntasOrderedChoice(JSONArray preguntasOrderedChoice) throws CantidadDeOpcionesErroneaException {
        for(Object preguntaJSON : preguntasOrderedChoice) {
            JSONObject pregunta = (JSONObject) preguntaJSON;
            String enunciado = this.leerEnunciado((JSONObject) preguntaJSON);
            JSONObject opciones = (JSONObject) pregunta.get("opciones");
            JSONArray listaDeOpcionesALeer = (JSONArray) opciones.get("opciones");
            List<Posicionable> listaDeOpciones = new ArrayList<>();
            int contador = 0;
            for (Object objetoOpcion : listaDeOpcionesALeer) {
                JSONObject opcion = (JSONObject) objetoOpcion;
                contador += 1;
                String textoOpcion = (String) opcion.get(((Integer) contador).toString());
                listaDeOpciones.add(OpcionesFactory.crearOpcionConPosicion(textoOpcion, contador));
            }
            this.coleccionDePreguntasOrderedChoice.add(PreguntaFactory.crearOrderedChoice(enunciado, listaDeOpciones));
        }
    }
    private String leerEnunciado(JSONObject preguntaALeer){
        return (String) preguntaALeer.get("enunciado");
    }
    private List<Binaria> leerOpcionesVerdaderoFalso(JSONObject pregunta) {
        JSONObject opciones = (JSONObject) pregunta.get("opciones");
        Binaria OpcionCorrecta = OpcionesFactory.crearOpcionCorrecta((String) opciones.get("Correcta"));
        Binaria OpcionIncorrecta = OpcionesFactory.crearOpcionIncorrecta((String) opciones.get("Incorrecta"));
        return List.of(OpcionCorrecta, OpcionIncorrecta);
    }
    private List<Binaria> leerOpcionesMultipleChoice(JSONObject pregunta) {
        JSONObject opciones = (JSONObject) pregunta.get("opciones");
        JSONArray listaDeOpcionesCorrectas = (JSONArray) opciones.get("Correcta");
        JSONArray listaDeOpcionesIncorrectas = (JSONArray) opciones.get("Incorrecta");
        List<Binaria> listaDeOpciones = new ArrayList<>();
        for(Object objetoOpcion : listaDeOpcionesCorrectas){
            String opcionCorrecta = (String) objetoOpcion;
            listaDeOpciones.add(OpcionesFactory.crearOpcionCorrecta(opcionCorrecta));
        }
        for(Object objetoOpcion : listaDeOpcionesIncorrectas){
            String opcionIncorrecta = (String) objetoOpcion;
            listaDeOpciones.add(OpcionesFactory.crearOpcionIncorrecta(opcionIncorrecta));
        }
        return listaDeOpciones;
    }

    public VerdaderoFalso get(int i){
        return coleccionDePreguntasVerdaderoFalsoClasica.get(i);
    }
}
