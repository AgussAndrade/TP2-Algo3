package edu.fiuba.algo3.modelo.lectorDePreguntas;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LectorDePreguntas {
     public LectorDePreguntas(String direccionPreguntas){
         PreguntaFactory fabricaDePreguntas = new PreguntaFactory();
         JSONParser parser = new JSONParser();
         try{
             Object objeto = parser.parse(new FileReader(direccionPreguntas));
             JSONObject objetoJson = (JSONObject) objeto;
             JSONArray PreguntasVerdaderoFalsoClasica = (JSONArray) objetoJson.get("VerdaderoFalsoClasica");
             for(Iterator iterador = objetoJson.keySet().iterator(); iterador.hasNext();){
                 List<Opcion> opcionesAAgregar = new ArrayList<>();
                 String enunciado = (iterador.get("enunciado"));
                 JSONObject opciones = (preguntaJSON.get("opciones"))



             }
     }
}
