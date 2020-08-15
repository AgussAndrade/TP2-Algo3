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
                                        "¿Cual de los siguientes nombres son capicua?", "¿Cual de les siguientes pibis juega fortnite?",
                                        "La capital de Austria es Amsterdam", "Ordenar de mayor a menor las superficies de los paises",
                                        "Un pulpo tiene 5 corazones", "¿Quien pinto el cuadro Las meninas?","Separar futbolistas de basquetbolistas",
                                        "¿Que ciudades pertenecen a Francia?", "¿Cual de estos sabores son primarios?", "Stephen Hawking rechazó el título de caballero de la Reina",
                                        "Ordenar de menor a mayor las superficies de los países", "La estatua de la libertad fue un regalo de Francia",
                                        "¿Cual de las siguientes personas ganaron un Nobel?", "Separar lenguajes de tipado estatico y dinamico",
                                        "¿En que continente se encuentra el pais Eritrea?", "¿Cual de estos son lenguajes compilados?" );
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
