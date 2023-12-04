package com.adventofcode.dia3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class NumbersParserTest {
    @Test
    void deve_conseguir_extrair_um_numero() {
        var testString = "..123..";
        var parser = new NumbersParser();

        Set<NumberToken> esperado = Set.of(new NumberToken(123, 0, 2, 4));

        var resultado = parser.parse(testString);

        assertTrue(esperado.containsAll(resultado)
                && resultado.containsAll(esperado));
    }

    @Test
    void deve_conseguir_extrair_multiplos_numeros() {
        var testString = "..123.4";
        var parser = new NumbersParser();

        var esperado = Set.of(
                new NumberToken(123, 0, 2, 4),
                new NumberToken(4, 0, 6, 6));

        var resultado = parser.parse(testString);

        assertTrue(esperado.containsAll(resultado)
                && resultado.containsAll(esperado));
    }

    @Test
    void deve_conseguir_processar_multiplas_linhas() {
        var testString = """
                ..123.4
                .1...35
                """;
        var parser = new NumbersParser();

        var esperado = Set.of(
                new NumberToken(123, 0, 2, 4),
                new NumberToken(4, 0, 6, 6),
                new NumberToken(1, 1, 1, 1),
                new NumberToken(35, 1, 5, 6));

        var resultado = parser.parse(testString);

        assertTrue(esperado.containsAll(resultado)
                && resultado.containsAll(esperado));
    }
}
