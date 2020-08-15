package edu.fiuba.algo3.lectorDePreguntas;


import edu.fiuba.algo3.modelo.Errores.CantidadDeOpcionesErroneaException;
import edu.fiuba.algo3.modelo.opciones.*;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LectorDePreguntas {
    public List<Pregunta> leerPreguntas(String direccionPreguntas) {
        List<Pregunta> listaDePreguntas = new ArrayList<>();
        try {
             JSONParser parser = new JSONParser();
             Object objetoParser = parser.parse(new FileReader(direccionPreguntas));
             JSONArray preguntasJson = (JSONArray) objetoParser;

             for (Object preguntaObject : preguntasJson) {
                 JSONObject pregunta = (JSONObject) preguntaObject;
                 String tipoDePregunta = (String) pregunta.get("tipoDePregunta");
                 String enunciado = (String) pregunta.get("enunciado");
                 JSONObject opciones = (JSONObject) pregunta.get("opciones");
                 if (tipoDePregunta.equals("verdaderoFalso")) {
                     String estrategia = (String) pregunta.get("estrategia");
                     listaDePreguntas.add(guardarPreguntasVerdaderoFalso(estrategia, enunciado, opciones));
                 }
                 if (tipoDePregunta.equals("multipleChoice")) {
                     String estrategia = (String) pregunta.get("estrategia");
                     listaDePreguntas.add(guardarPreguntasMultipleChoice(enunciado, estrategia, opciones));
                 }
                 if (tipoDePregunta.equals("groupChoice")) {
                     listaDePreguntas.add(guardarPreguntasGroupChoice(enunciado, opciones));
                 }
                 if (tipoDePregunta.equals("orderedChoice")) {
                     listaDePreguntas.add(guardarPreguntasOrderedChoice(enunciado, opciones));
                 }
             }

         } catch (ParseException | IOException | CantidadDeOpcionesErroneaException e) {
             e.printStackTrace();
         }
         return listaDePreguntas;
     }

    private Pregunta guardarPreguntasGroupChoice(String enunciado, JSONObject opciones) throws CantidadDeOpcionesErroneaException {
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
        return (PreguntaFactory.crearGroupChoice(enunciado, listaDeOpciones));
    }

    private Pregunta guardarPreguntasMultipleChoice(String enunciado, String estrategia, JSONObject opciones) throws CantidadDeOpcionesErroneaException {
        JSONArray listaDeOpcionesCorrectas = (JSONArray) opciones.get("correcta");
        JSONArray listaDeOpcionesIncorrectas = (JSONArray) opciones.get("incorrecta");
        List<Binaria> listaDeOpciones = new ArrayList<>();
        for(Object objetoOpcion : listaDeOpcionesCorrectas){
            String opcionCorrecta = (String) objetoOpcion;
            listaDeOpciones.add(OpcionesFactory.crearOpcionCorrecta(opcionCorrecta));
        }
        for(Object objetoOpcion : listaDeOpcionesIncorrectas){
            String opcionIncorrecta = (String) objetoOpcion;
            listaDeOpciones.add(OpcionesFactory.crearOpcionIncorrecta(opcionIncorrecta));
        }
        if(estrategia.equals("clasica")){
           return (PreguntaFactory.crearMultipleChoiceClasica(enunciado, listaDeOpciones));
        }
        else if(estrategia.equals("penalizable")) {
            return (PreguntaFactory.crearMultipleChoicePenalizable(enunciado, listaDeOpciones));
        }
        return (PreguntaFactory.crearMultipleChoicePuntajeParcial(enunciado, listaDeOpciones));
    }

    private Pregunta guardarPreguntasOrderedChoice(String enunciado, JSONObject opciones) throws CantidadDeOpcionesErroneaException {
        List<Posicionable> listaDeOpciones = new ArrayList<>();
        for (int contador = 0; contador <= opciones.keySet().size(); contador ++) {
            contador += 1;
            String textoOpcion = (String) opciones.get(((Integer) contador).toString());
            listaDeOpciones.add(OpcionesFactory.crearOpcionConPosicion(textoOpcion, contador));
        }
        return (PreguntaFactory.crearOrderedChoice(enunciado, listaDeOpciones));

    }

    private Pregunta guardarPreguntasVerdaderoFalso(String estrategia, String enunciado, JSONObject opciones) throws CantidadDeOpcionesErroneaException {
        Binaria opcionCorrecta = OpcionesFactory.crearOpcionCorrecta((String) opciones.get("correcta"));
        Binaria opcionIncorrecta = OpcionesFactory.crearOpcionIncorrecta((String) opciones.get("incorrecta"));
        if(estrategia.equals("clasica")){
           return (PreguntaFactory.crearVerdaderoFalsoClasica(enunciado, List.of(opcionCorrecta, opcionIncorrecta)));
        }
        return (PreguntaFactory.crearVerdaderoFalsoPenalizable(enunciado, List.of(opcionCorrecta, opcionIncorrecta)));
    }

}
