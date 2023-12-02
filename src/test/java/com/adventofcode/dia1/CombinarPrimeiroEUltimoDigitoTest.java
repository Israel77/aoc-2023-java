package com.adventofcode.dia1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CombinarPrimeiroEUltimoDigitoTest {
    @Test
    void deve_retornar_vazio_se_nao_houverem_digitos() {
        var testString = "abcdefg";
        var parser = new CombinarPrimeiroEUltimoDigito();

        assertTrue(parser.parse(testString).isEmpty());
    }

    @Test
    void deve_retornar_o_primeiro_e_ultimo_digito_de_uma_string() {
        var testString = "123456";
        var parser = new CombinarPrimeiroEUltimoDigito();

        var resultado = parser.parse(testString);

        assertTrue(resultado.isPresent());
        assertEquals(16, resultado.get());
    }

    @Test
    void deve_ignorar_outros_caracteres_na_string() {
        var testString = "1lkmakldsmf9";
        var parser = new CombinarPrimeiroEUltimoDigito();

        var resultado = parser.parse(testString);

        assertTrue(resultado.isPresent());
        assertEquals(19, resultado.get());
    }

    @Test
    void deve_repetir_digito_se_apenas_um_presente() {
        var testString = "1";
        var parser = new CombinarPrimeiroEUltimoDigito();

        var resultado = parser.parse(testString);

        assertTrue(resultado.isPresent());
        assertEquals(11, resultado.get());
    }

}
