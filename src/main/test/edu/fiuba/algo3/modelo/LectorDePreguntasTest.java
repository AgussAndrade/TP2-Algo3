package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.lectorDePreguntas.LectorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorDePreguntasTest {
    @Test
    public void test01LectorDePreguntasLeeCorrectamenteUnArchivoEspecificado(){
        LectorDePreguntas lector = new LectorDePreguntas();
        List<String> enunciados = List.of(
                                        "Argentina es un país", "Ordenar de menor a mayor poblacion de paises", "¿Argentina es una construccion social?",
                                        "¿Cual de los siguientes jugadores de futbol tiene mas asistencias?", "Separar paises de ciudades",
                                        "¿Cual de los siguientes nombres son capicua?", "¿Cual de les siguientes pibis juega fortnite?");
        List<Pregunta> preguntas = lector.leerPreguntas("preguntas.json");
        int contador = 0;
        boolean elTestPasa = preguntas.size() == enunciados.size();

        for(Pregunta pregunta : preguntas){
            if(!elTestPasa){
                break;
            }
            else if(!pregunta.enunciado().equals(enunciados.get(contador))){
                elTestPasa = false;
            }
            contador += 1;
        }
        assertEquals(true, elTestPasa);
    }
}
