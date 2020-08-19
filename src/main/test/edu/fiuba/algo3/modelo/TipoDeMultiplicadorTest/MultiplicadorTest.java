package edu.fiuba.algo3.modelo.TipoDeMultiplicadorTest;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorTest {
    @Test
    public void test01Multiplicadorx3SeCreaYCalculaLosPuntosCorrectamente(){
        Multiplicador multiplicador = new Multiplicador(3);
        int puntos = 2 ;

        assertEquals(6,multiplicador.multiplicarPuntos(puntos));
    }
}
