package edu.fiuba.algo3.modelo.lectorDePreguntas;


import edu.fiuba.algo3.modelo.Errores.CantidadDEOpcionesErroneaException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class LectorDePreguntas {
     public ColeccionDePreguntas leerPreguntas(String direccionPreguntas) {
         List<String> tiposDePregunta = List.of("VerdaderoFalsoClasica", "VerdaderoFalsoPenalizable", "MultipleChoiceClasica", "MultipleChoicePenalizable", "MultipleChoicePuntajeParcial", "OrderedChoice", "GroupChoice");
         ColeccionDePreguntas coleccionDePreguntas = new ColeccionDePreguntas();
         try {
             JSONParser parser = new JSONParser();
             Object objetoParser = parser.parse(new FileReader(direccionPreguntas));
             JSONObject preguntasJson = (JSONObject) objetoParser;
             for (String tipoDePregunta : tiposDePregunta) {
                 if (tipoDePregunta.equals("VerdaderoFalsoClasica")) {
                     coleccionDePreguntas.guardarPreguntasVerdaderoFalsoClasica((JSONArray) preguntasJson.get(tipoDePregunta));
                 }
                 if (tipoDePregunta.equals("VerdaderoFalsoPenalizable")) {
                     coleccionDePreguntas.guardarPreguntasVerdaderoFalsoPenalizable((JSONArray) preguntasJson.get(tipoDePregunta));
                 }
                 if (tipoDePregunta.equals("MultipleChoiceClasica")) {
                     coleccionDePreguntas.guardarPreguntasMultipleChoiceClasica((JSONArray) preguntasJson.get(tipoDePregunta));
                 }
                 if (tipoDePregunta.equals("MultipleChoicePenalizable")) {
                     coleccionDePreguntas.guardarPreguntasMultipleChoicePenalizable((JSONArray) preguntasJson.get(tipoDePregunta));
                 }
                 if (tipoDePregunta.equals("MultipleChoicePuntajeParcial")) {
                     coleccionDePreguntas.guardarPreguntasMultipleChoicePuntajeParcial((JSONArray) preguntasJson.get(tipoDePregunta));
                 }
                 if (tipoDePregunta.equals("GroupChoice")) {
                     coleccionDePreguntas.guardarPreguntasGroupChoice((JSONArray) preguntasJson.get(tipoDePregunta));
                 }
                 if (tipoDePregunta.equals("OrderedChoice")) {
                     coleccionDePreguntas.guardarPreguntasOrderedChoice((JSONArray) preguntasJson.get(tipoDePregunta));
                 }
             }

         } catch (ParseException e) {
             e.printStackTrace();
         } catch (FileNotFoundException exception) {
             exception.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (CantidadDEOpcionesErroneaException e) {
             e.printStackTrace();
         }
         return coleccionDePreguntas;
     }

}
