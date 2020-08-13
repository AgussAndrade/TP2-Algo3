package edu.fiuba.algo3.modelo.lectorDePreguntas;

import edu.fiuba.algo3.modelo.Errores.CantidadDEOpcionesErroneaException;
import edu.fiuba.algo3.modelo.OpcionesFactory;
import edu.fiuba.algo3.modelo.PreguntaFactory;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.opciones.Grupal;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.Posicionable;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
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
    public void guardarPreguntasVerdaderoFalsoClasica(JSONArray preguntasVerdaderoFalsoClasica) throws CantidadDEOpcionesErroneaException {
        for (Object preguntaJSON : preguntasVerdaderoFalsoClasica) {
            JSONObject pregunta = (JSONObject) preguntaJSON;
            String enunciado = (String) pregunta.get("enunciado");
            JSONObject opciones = (JSONObject) pregunta.get("opciones");
            Binaria OpcionCorrecta = OpcionesFactory.crearOpcionCorrecta((String) opciones.get("Correcta"));
            Binaria OpcionIncorrecta = OpcionesFactory.crearOpcionIncorrecta((String) opciones.get("Incorrecta"));
            List<Binaria> listaDeOpciones = List.of(OpcionCorrecta, OpcionIncorrecta);
            this.coleccionDePreguntasVerdaderoFalsoClasica.add(PreguntaFactory.crearVerdaderoFalsoClasica(enunciado, listaDeOpciones));
        }
    }
    public void guardarPreguntasVerdaderoFalsoPenalizable(JSONArray preguntasVerdaderoFalsoPenalizable) throws CantidadDEOpcionesErroneaException {
            for (Object preguntaJSON : coleccionDePreguntasVerdaderoFalsoPenalizable) {
                JSONObject pregunta = (JSONObject) preguntaJSON;
                String enunciado = (String) pregunta.get("enunciado");
                JSONObject opciones = (JSONObject) pregunta.get("opciones");
                Binaria OpcionCorrecta = OpcionesFactory.crearOpcionCorrecta((String) opciones.get("Correcta"));
                Binaria OpcionIncorrecta = OpcionesFactory.crearOpcionIncorrecta((String) opciones.get("Incorrecta"));
                List<Binaria> listaDeOpciones = List.of(OpcionCorrecta, OpcionIncorrecta);
                this.coleccionDePreguntasVerdaderoFalsoPenalizable.add(PreguntaFactory.crearVerdaderoFalsoPenalizable(enunciado, listaDeOpciones));
            }
    }

    public void guardarPreguntasMultipleChoiceClasica(JSONArray preguntasMultipleChoiceClasica) throws CantidadDEOpcionesErroneaException {

        for(Object preguntaJSON : preguntasMultipleChoiceClasica){
                JSONObject pregunta = (JSONObject) preguntaJSON;
                String enunciado = (String) pregunta.get("enunciado");
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
                this.coleccionDePreguntasMultipleChoiceClasica.add(PreguntaFactory.crearMultipleChoiceClasica(enunciado, listaDeOpciones));
            }

    }

    public void guardarPreguntasMultipleChoicePenalizable(JSONArray preguntasMultipleChoicePenalizable) throws CantidadDEOpcionesErroneaException {
        for(Object preguntaJSON : coleccionDePreguntasMultipleChoicePenalizable){
            JSONObject pregunta = (JSONObject) preguntaJSON;
            String enunciado = (String) pregunta.get("enunciado");
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
            this.coleccionDePreguntasMultipleChoicePenalizable.add(PreguntaFactory.crearMultipleChoicePenalizable(enunciado, listaDeOpciones));
        }
    }

    public void guardarPreguntasMultipleChoicePuntajeParcial(JSONArray preguntasMultipleChoicePuntajeParcial) throws CantidadDEOpcionesErroneaException {
        for(Object preguntaJSON : coleccionDePreguntasMultipleChoicePuntajeParcial){
            JSONObject pregunta = (JSONObject) preguntaJSON;
            String enunciado = (String) pregunta.get("enunciado");
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
            this.coleccionDePreguntasMultipleChoicePuntajeParcial.add(PreguntaFactory.crearMultipleChoicePuntajeParcial(enunciado, listaDeOpciones));
        }
    }

    public void guardarPreguntasGroupChoice(JSONArray preguntasGroupChoice) throws CantidadDEOpcionesErroneaException {
        for(Object preguntaJSON : preguntasGroupChoice){
            JSONObject pregunta = (JSONObject) preguntaJSON;
            String enunciado = (String) pregunta.get("enunciado");
            JSONObject opciones = (JSONObject) pregunta.get("opciones");
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

    public void guardarPreguntasOrderedChoice(JSONArray preguntasOrderedChoice) throws CantidadDEOpcionesErroneaException {
            for(Object preguntaJSON : preguntasOrderedChoice){
                    JSONObject pregunta = (JSONObject) preguntaJSON;
                    String enunciado = (String) pregunta.get("enunciado");
                    JSONObject opciones = (JSONObject) pregunta.get("opciones");
                    JSONArray listaDeOpcionesALeer = (JSONArray) opciones.get("opciones");
                    List<Posicionable> listaDeOpciones = new ArrayList<>();
                    int contador = 0;
                    for(Object objetoOpcion : listaDeOpcionesALeer){
                        JSONObject opcion = (JSONObject) objetoOpcion;
                        contador += 1;
                        String textoOpcion = (String)opcion.get(((Integer)contador).toString());
                        listaDeOpciones.add(OpcionesFactory.crearOpcionConPosicion(textoOpcion, contador));
                    }
                    this.coleccionDePreguntasOrderedChoice.add(PreguntaFactory.crearOrderedChoice(enunciado, listaDeOpciones));
        }
    }

    public VerdaderoFalso get(int i){
        return coleccionDePreguntasVerdaderoFalsoClasica.get(i);
    }
}
