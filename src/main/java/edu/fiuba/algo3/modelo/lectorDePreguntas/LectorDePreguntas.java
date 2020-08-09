package edu.fiuba.algo3.modelo.lectorDePreguntas;

import edu.fiuba.algo3.modelo.OpcionesFactory;
import edu.fiuba.algo3.modelo.PreguntaFactory;
import edu.fiuba.algo3.modelo.opciones.*;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LectorDePreguntas {
     public List<Pregunta> LectorDePreguntas(String direccionPreguntas, String tipoDePregunta){
         List<Pregunta> preguntasCreadas = new ArrayList<>();
         PreguntaFactory fabricaDePreguntas = new PreguntaFactory();
         OpcionesFactory fabricaDeOpciones = new OpcionesFactory();
         JSONParser parser = new JSONParser();
         try{
             Object objeto = parser.parse(new FileReader(direccionPreguntas));
             JSONObject objetoJson = (JSONObject) objeto;
             JSONArray preguntasDeUnTipo = (JSONArray) objetoJson.get(tipoDePregunta);
             for (Object preguntaJSON : preguntasDeUnTipo) {
                 JSONObject pregunta = (JSONObject) preguntaJSON;
                 String enunciado = (String) pregunta.get("enunciado");
                 JSONObject opciones = (JSONObject) pregunta.get("opciones");
                 if(tipoDePregunta.contains("verdaderoFalso")){
                     List<Binaria> opcionesVerdaderoFalso = this.leerOpcionesVeraderoFalso(opciones, fabricaDeOpciones);
                     if(tipoDePregunta.contains("Clasica")){
                         fabricaDePreguntas.crearVerdaderoFalsoClasica(enunciado, opcionesVerdaderoFalso);
                     }
                     else{
                        fabricaDePreguntas.crearVerdaderoFalsoPenalizable(enunciado, opcionesVerdaderoFalso);
                     }
                 }
                 if(tipoDePregunta.contains("multipleChoice")){
                     List<Binaria> opcionesMultipleChoice = this.leerOpcionesMultipleChoice(opciones, fabricaDeOpciones);
                     if(tipoDePregunta.contains("Clasica")){
                         fabricaDePreguntas.crearMultipleChoiceClasica(enunciado, opcionesMultipleChoice);
                     }
                     else{
                         fabricaDePreguntas.crearMultipleChoicePenalizable(enunciado, opcionesMultipleChoice);
                     }
                 }
                 if(tipoDePregunta.contains("orderedChoice")){
                     List<Posicionable> opcionesOrderedChoice = this.leerOpcionesOrderedChoice(opciones, fabricaDeOpciones);
                     fabricaDePreguntas.crearOrderedChoice(enunciado, opcionesOrderedChoice);
                 }
                 if(tipoDePregunta.contains("groupChoice")){
                     List<Grupal> opcionesGroupChoice = this.leerOpcionesGroupChoice(opciones, fabricaDeOpciones);
                    fabricaDePreguntas.crearGroupChoice(enunciado, opcionesGroupChoice);
                 }

             }
             return fabricaDePreguntas.getPreguntas();
         }catch(){

         } catch (ParseException e) {
             e.printStackTrace();
         } catch (FileNotFoundException exception) {
             exception.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }


     }
     private List<Binaria> leerOpcionesVeraderoFalso(JSONObject opciones, OpcionesFactory fabricaDeOpciones) {
        List<Binaria> opcionesADevolver = new ArrayList<>();
        String opcionCorrecta = (String) opciones.get("correcta");
        String opcionIncorrecta = (String) opciones.get("incorrecta");
        opcionesADevolver.add(fabricaDeOpciones.crearOpcionCorrecta(opcionCorrecta));
        opcionesADevolver.add(fabricaDeOpciones.crearOpcionIncorrecta(opcionIncorrecta));
        return opcionesADevolver;
     }
     private List<Binaria> leerOpcionesMultipleChoice(JSONObject opciones, OpcionesFactory fabricaDeOpciones){
         List<Binaria> opcionesADevolver = new ArrayList<>();
         JSONArray opcionesCorrectas = (JSONArray) opciones.get("correcta");
         JSONArray opcionesIncorrectas = (JSONArray) opciones.get("incorrecta");
         for(Object opcionCorrecta : opcionesCorrectas){
             opcionesADevolver.add(fabricaDeOpciones.crearOpcionCorrecta((String)opcionCorrecta));
         }
         for(Object opcionIncorrecta : opcionesIncorrectas){
             opcionesADevolver.add(fabricaDeOpciones.crearOpcionIncorrecta((String) opcionIncorrecta);
         }
         return opcionesADevolver;
     }
     private List<Posicionable> leerOpcionesOrderedChoice(JSONObject opciones, OpcionesFactory fabricaDeOpciones){
         List<Posicionable> opcionesADevolver = new ArrayList<>();
         JSONArray opcionesConOrden = (JSONArray) opciones.get("opciones");
         Integer contador = 0;
         for(Object opcionPosicionable : opcionesConOrden){
             contador += 1;
             opcionesADevolver.add(fabricaDeOpciones.crearOpcionGrupalConPosicion(((JSONObject) opcionPosicionable).get(contador.toString()), contador));
         }
         return opcionesADevolver;

     }
     private List<Grupal> leerOpcionesGroupChoice(JSONObject opciones, OpcionesFactory fabricaDeOpciones){
        List<Grupal> opcionesADevolver = new ArrayList<>();
        JSONArray opcionesGrupoA = (JSONArray) opciones.get("A");
        JSONArray opcionesGrupoB = (JSONArray) opciones.get("B");
        for(Object opcionGrupoA : opcionesGrupoA){
            opcionesADevolver.add(fabricaDeOpciones.crearOpcionDeGupoA((String) opcionGrupoA));
        }
        for(Object opcionGrupoB : opcionesGrupoB){
            opcionesADevolver.add(fabricaDeOpciones.crearOpcionDeGrupoB((String) opcionGrupoB));
        }
        return opcionesADevolver;
     }
}
