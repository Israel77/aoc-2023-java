package com.adventofcode.dia1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ExtrairDigitosInicialEFinalTest {
    @Test
    void deve_retornar_o_primeiro_e_ultimo_digito_presente_numa_string() {
        String testString = "12aknlkd5";
        var parser = new CombinarPrimeiroEUltimoDigito();

        var esperado = 15;

        assertEquals(esperado, parser.parse(testString).get());
    }

    @Test
    void nao_deve_retornar_nada_se_a_string_nao_possuir_numeros() {
        String testString = "aknlkd";
        var parser = new CombinarPrimeiroEUltimoDigito();

        assertTrue(parser.parse(testString).isEmpty());
    }
}
